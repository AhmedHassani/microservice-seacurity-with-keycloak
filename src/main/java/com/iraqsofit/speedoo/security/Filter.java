package com.iraqsofit.speedoo.security;

import com.iraqsofit.speedoo.service.UserDateilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Filter extends OncePerRequestFilter {
    @Autowired
    private Token token;
    @Autowired
    private UserDateilsService service;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filter) throws ServletException, IOException {
        final  String header = request.getHeader("Authorization");
        final SecurityContext securityContext= SecurityContextHolder.getContext();
        if (header!=null&&securityContext.getAuthentication()==null){
            String tokenRequest = header.substring("Bearer".length());
            String username=token.getUsernameFromToken(tokenRequest);
            if (username!=null){
               UserDetails userDetails= service.loadUserByUsername(username);
               if (token.isVaild(tokenRequest,userDetails)){
                   UsernamePasswordAuthenticationToken authenticationToken =
                           new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                   authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                   securityContext.setAuthentication(authenticationToken);
               }
            }

        }

        filter.doFilter(request,response);
    }
}
