package com.chason.blog.util;

import com.chason.blog.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Json Web Token 工具类
 *
 * @author cang
 * @date 2017-10-08
 */
@Component
public class JwtTokenUtil {

    // 用户登录超时时间，秒为单位
    @Value("${jwt.expiration}")
    private Long expiration;

    // 加密key值
    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return generateToken(claims, username);
    }

    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration * 1000);
    }

    private String generateToken(Map<String, Object> claims, String subject) {

        final Date createdDate = DateUtil.now();

        String compactJwt = Jwts.builder()
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(calculateExpirationDate(createdDate))
//                .setAudience()
//                .setClaims(claims)
                .compact();

//        Jwts.builder().signWith(SignatureAlgorithm.HS256,
//                "61c5fd4007060fd9ed41fc6f2a155a3a47629b9e9b83d75d1c0d97ebb177fa83").compact();

        return compactJwt;
    }

    /**
     * 验证用户Token是否有效
     *
     * @param token
     * @param user
     * @return
     */
    public boolean validateToken(String token, User user) {

        final String username = getUsernameFromToken(token);
        final Date created = getIssuedAtDateFromToken(token);

        //final Date expiration = getExpirationDateFromToken(token);
        return (
                username.equals(user.getUserName())
                        && !isTokenExpired(token)
                        && !isCreatedBeforeLastPasswordReset(created, user.getModifyTime())
        );
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(DateUtil.now());
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
