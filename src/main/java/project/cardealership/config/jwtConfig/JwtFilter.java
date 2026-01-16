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
    private JwtService jwtService;

    public JwtFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest request,
                                    @Nonnull HttpServletResponse response,
                                    @Nonnull FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (authorization!= null&& authorization.startsWith("Bearer ")){
            String token = authorization.substring(7);
            try{
                if (StringUtils.hasText(token)){
                    String email = jwtService.verifyToken(token);
                    User user = userRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("Not found user with this email"));
                    SecurityContextHolder.getContext().setAuthentication(
                            new UsernamePasswordAuthenticationToken(
                                    user.getEmail(),
                                    null,
                                    user.getAuthorities()
                            )
                    );
                }
            }catch (JWTVerificationException e){
                response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Invalid");
            }
        }
        filterChain.doFilter(request,response);

    }
}
