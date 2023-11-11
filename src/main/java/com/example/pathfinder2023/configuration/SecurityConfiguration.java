package com.example.pathfinder2023.configuration;


import com.example.pathfinder2023.domain.entity.enums.RoleNameEnum;
import com.example.pathfinder2023.repository.UserRepository;
import com.example.pathfinder2023.service.PathUserDetailService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
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
                        .requestMatchers("/", "/users/register", "/users/login", "/users/login?error=true").permitAll()
                        .requestMatchers("/about").permitAll()
                        //                 .requestMatchers("/pages/moderators").hasRole(RoleNameEnum.MODERATOR.name())
                        //                    .requestMatchers("/pages/admin").hasRole(RoleNameEnum.ADMIN.name())
                        .anyRequest().authenticated())
                .formLogin(formLogin -> {
                    formLogin.loginPage("/users/login")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/")
                            .failureForwardUrl("/users/login?error=true");
                }).logout(logout -> {
                            logout.logoutUrl("/users/logout")
                                    .logoutSuccessUrl("/")
                                    .invalidateHttpSession(true)
                                    .deleteCookies("JSESSIONID");
                        }
                );
        return http.build();
    }


@Bean
   public PasswordEncoder passwordEncoder(){
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
}

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new PathUserDetailService(userRepository);
    }


}
