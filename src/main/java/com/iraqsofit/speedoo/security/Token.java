package com.iraqsofit.speedoo.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Token {

    private final String CLAIMS_SUBJECT="sub";
    private final String CLAIMS_CREATED="created";
    private String TOKEN_SECRET="GDDDQWYUIOPPLLLVBBNMYYTTTTAXXSEEEYOOBCCXAQWEVBNMLPOJKRFFSSZXWERY";
    private long TOKEN_VALIDITY =604800L;


    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims =new HashMap<>();
        System.out.println(userDetails.getUsername());
        claims.put(CLAIMS_SUBJECT,userDetails.getUsername());
        claims.put(CLAIMS_CREATED,new Date());
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,TOKEN_SECRET)
                .compact();
    }

    private Date generateExpirationDate() {
      return new Date(System.currentTimeMillis()+ TOKEN_VALIDITY *1000);
    }

    public String getUsernameFromToken(String token){
        try {
           return getClaims(token).getSubject();
        }catch (Exception e){
            return null;
        }
    }

    public  Claims getClaims(String token){
        return Jwts.parser().setSigningKey(TOKEN_SECRET)
                .parseClaimsJws(token)
                .getBody();
    }


    public boolean isVaild(String token, UserDetails userDetails) {
        String username=getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Date ex=getClaims(token).getExpiration();
        return ex.before(new Date());
    }
}
