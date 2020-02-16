package ds.web.practice.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtils {
    private final static String USER_NAME = "name";
    private final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public static String createToken(String userName) {
        return Jwts.builder().claim(USER_NAME, userName).signWith(key).compact();
    }

    public static String getUserNameFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().get(USER_NAME, String.class);
    }
}
