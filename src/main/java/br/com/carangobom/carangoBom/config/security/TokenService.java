package br.com.carangobom.carangoBom.config.security;

import br.com.carangobom.carangoBom.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${carango.jwt.expiration}")
    private String expiration;

    @Value("${carango.jwt.secret}")
    private String secret;

    public String tokenGenerate(Authentication authentication) {
        Usuario userLogged = (Usuario) authentication.getPrincipal();
        Date today = new Date();
        Date expireIn = new Date(today.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("Carango-Bom")
                .setSubject(userLogged.getId().toString())
                .setIssuedAt(today)
                .setExpiration(expireIn)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public Long getUserById(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
