package top.pymrma.boot.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtil {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expriation}")
    private Long expriation;

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    //生成token
    public String generateToken(String email) {
        return Jwts.builder()
                //用户信息
                .setSubject(email)
                //创建时间
                .setIssuedAt(new Date())
                //过期时间
                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + expriation))
                .signWith(
                        getKey(),
                        SignatureAlgorithm.HS256)
                .compact();
    }

    //解析用户信息
    public String getEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    //判断token是否有效
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
