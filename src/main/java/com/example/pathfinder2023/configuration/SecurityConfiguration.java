package com.example.pathfinder2023.configuration;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/users/register", "/users/login").permitAll()
                        .anyRequest().authenticated())
                .formLogin(formLogin -> {
                    formLogin.loginPage("/users/login")
                            .usernameParameter("text")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/")
                            .failureForwardUrl("/users/login");
                }).logout(logout -> {
                            logout.logoutUrl("/users/logout")
                                    .logoutSuccessUrl("/")
                                    .invalidateHttpSession(true);
                        }
                );


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

}
