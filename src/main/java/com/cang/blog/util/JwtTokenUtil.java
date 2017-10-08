package com.cang.blog.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
                .setClaims(claims)
                .compact();

        return compactJwt;
    }
}
