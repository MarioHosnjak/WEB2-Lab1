package com.WEB2.backend;

import  com.WEB2.backend.LogoutHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final LogoutHandler logoutHandler;

    public SecurityConfig(LogoutHandler logoutHandler) {
        this.logoutHandler = logoutHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*return http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/").permitAll();
            auth.requestMatchers("/home").permitAll();
            auth.requestMatchers("/profile").authenticated();
        }).build();*/
        return http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/").permitAll();
            try {
                auth.requestMatchers("/mytournaments").authenticated().and().oauth2Login()
                        .and().logout()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .addLogoutHandler(logoutHandler);
                auth.anyRequest().permitAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).build();

    }
}
