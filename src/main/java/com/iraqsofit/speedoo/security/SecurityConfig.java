package com.iraqsofit.speedoo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String[] PUBLIC_ENDPOINT = {
            "/api/gemstone/v1/signIn",
            "/api/gemstone/v1/signIn/",
            "/api/gemstone/v1/signUp",
            "/api/gemstone/v1/signUp/",
            "/api/gemstone/v1/otp/",
            "/api/gemstone/v1/otp",
            "/api/gemstone/v1/about",
            "/api/gemstone/v1/privacy",
            "/api/gemstone/v1/category",
            "/api/gemstone/v1/banners",
    };

    @Bean
    public Filter getFilter() {
        return new Filter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(PUBLIC_ENDPOINT).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(getFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
