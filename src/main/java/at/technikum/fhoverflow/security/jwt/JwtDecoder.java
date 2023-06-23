package at.technikum.fhoverflow.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class JwtDecoder {

    private final JwtProperties jwtProperties;

    public JwtDecoder(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public DecodedJWT decode(String token) {
        return JWT
                .require(Algorithm.HMAC256(jwtProperties.getSecret()))
                .build()
                .verify(token);
    }
}
