package project.cardealership.config.jwtConfig;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import project.cardealership.entity.User;

import java.time.ZonedDateTime;
import java.util.Date;
@Component
public class JwtService {
    @Value("${jwt-secret-key}")
    private String secretKey;

    public String generateToken  (User user){
        return JWT.create()
                .withClaim("email",user.getEmail())
                .withIssuedAt(new Date())
                .withExpiresAt(Date.from(ZonedDateTime.now().plusDays(10).toInstant()))
                .sign(Algorithm.HMAC256(secretKey));

    }

    public String verifyToken(String token){
        JWTVerifier verify = JWT
                .require(Algorithm.HMAC256(secretKey))
                .build();
        DecodedJWT verify1 = verify.verify(token);
        return verify1.getClaim("email").asString();
    }
}
