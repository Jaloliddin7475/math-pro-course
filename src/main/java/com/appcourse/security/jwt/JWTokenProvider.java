package com.appcourse.security.jwt;


import com.appcourse.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JWTokenProvider.class);

    @Value("${jwt.secret.key.access}")
    private String jwtAccessSecret;

    @Value("${jwt.secret.key.refresh}")
    private String jwtRefreshSecret;

    @Value("${jwt.secret.expiration.access}")
    private int accessTokenExpiration;

    @Value("${jwt.secret.expiration.refresh}")
    private long refreshTokenExpiration;

    public String[] generateJwtToken (User user) {
        return new String[] {
                generateAccessToken(user),
                generateRefreshToken(user)
        };
    }

    public String generateAccessToken (User user) {
        return "Bearer " + Jwts.builder().setSubject(user.getUsername()).claim("role",user.getRoles()).setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + accessTokenExpiration)).signWith(SignatureAlgorithm.ES512,jwtAccessSecret)
                .compact();
    }

    public String generateRefreshToken (User user) {
        return "Bearer " + Jwts.builder().setSubject(user.getUsername()).claim("role",user.getRoles()).setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + accessTokenExpiration)).signWith(SignatureAlgorithm.ES512,jwtRefreshSecret)
                .compact();
    }

    public Jws<Claims> validateJwtAccessToken (String authToken) {
        try {
            return Jwts.parser().setSigningKey(jwtAccessSecret).parseClaimsJws(authToken);
        }catch (SignatureException e) {
            logger.error("Invalid JWT signature : {}" + e.getMessage());
        }catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}" + e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}" + e.getMessage());
        }catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}" + e.getMessage());
        }catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}" + e.getMessage());
        }
        return null;
    }

    public Jws<Claims> validateJwtRefreshToken(String authToken) {
        try {
            return Jwts.parser().setSigningKey(jwtRefreshSecret).parseClaimsJws(authToken);
        } catch (io.jsonwebtoken.SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return null;
    }

}
