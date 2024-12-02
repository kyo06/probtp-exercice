package com.probtp.projet1.config;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

	//  generate with https://jwtsecret.com/generate
    private String jwtSecret = "b5fdf2acc66e566624fc3448b7153946b687578b5f0b2c89a3d145e1eb5c6437ed177b90a7ca539bc5f21b55f3d8f8f971c1cb3705d0757e04d7a487edeafea48c5f2810daa5746954fa101e1f1e4a3569b04ec36c465d696d2f0b97388b0c62e6e9a4625e5e21786316274544501f702f655fa0fd48e6509ab60b6af13e11c941aff0d055c8dced2851815e71bc6f666a07d99f3948165a73df8ad12d33b465cec1de65073113cd737e32d95bf134e6a3f0a774089383c2aeb4b7842c1ae80fc11bfa893dcd955b053719c070100762be022c5b23c0d9be93e0a8eb0e62788268908ab00ed27125f84a5d3ec235a58f316e703c2b2a188e72b7fefb76a528b2";
    private long jwtExpirationDate = 3600000; //1h = 3600s and 3600*1000 = 3600000 milliseconds

    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        // Get user roles from authentication
        String[] roles = authentication.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .toArray(String[]::new);

        String token = Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(expireDate)
                .claim("roles", roles) // Add roles to token claims
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    // extract username from JWT token
    public String getUsername(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    // Get roles from JWT token
    public String[] getRoles(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("roles", String[].class);
    }

    // validate JWT token
    public boolean validateToken(String token){
        Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parse(token);
        return true;
    }
}