package com.example.demo8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo8.repository.UserRepository;
import com.example.demo8.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {
    private UserRepository userRepository;
    
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http ) throws Exception{
        http.headers().frameOptions().disable();
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/register/**").permitAll()
        .antMatchers("/index").permitAll()
        .antMatchers("/users").hasRole("ADMIN")
        .antMatchers("/list").hasRole("ADMIN")
        .and()
        .formLogin(
            form -> form
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/users")
                    .permitAll()
        ).logout(
            logout->logout
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .permitAll()
        );
        return http.build();
    }

    
}
