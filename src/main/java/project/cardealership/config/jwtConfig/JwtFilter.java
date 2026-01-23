package project.cardealership.config.jwtConfig;

import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import project.cardealership.entity.User;
import project.cardealership.repository.UserRepository;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public JwtFilter(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            @Nonnull HttpServletRequest request,
            @Nonnull HttpServletResponse response,
            @Nonnull FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        // Если заголовка нет или он не Bearer → просто пропускаем (важно для /api/auth/**)
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        // Пустой токен → тоже пропускаем
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String email = jwtService.verifyToken(token);

            // Пользователь найден → устанавливаем аутентификацию
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new NoSuchElementException("User not found: " + email));

            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(),
                            null,
                            user.getAuthorities()
                    );

            SecurityContextHolder.getContext().setAuthentication(authToken);

        } catch (JWTVerificationException e) {
            // ← Самое важное изменение
            // НЕ прерываем цепочку! Просто НЕ аутентифицируем → запрос идёт дальше
            // Для защищённых эндпоинтов Security сам вернёт 401/403
            // Для публичных — дойдёт до контроллера
        } catch (NoSuchElementException e) {
            // Аналогично — пользователь не найден → не аутентифицируем
        }

        // В любом случае продолжаем цепочку
        filterChain.doFilter(request, response);
    }
}
