package com.iraqsofit.speedoo.security;


import com.iraqsofit.speedoo.user.UserDateilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private Token token;
    @Autowired
    private UserDateilsService service;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = {"","/"})
    public String signIn(@RequestBody SignInRequest signInRequest){
       final Authentication authentication=authenticationManager.authenticate(
         new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),signInRequest.getPassword())
       );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails=service.loadUserByUsername(signInRequest.getUsername());
        String tokenSign=token.generateToken(userDetails);
        return tokenSign;
    }

}
