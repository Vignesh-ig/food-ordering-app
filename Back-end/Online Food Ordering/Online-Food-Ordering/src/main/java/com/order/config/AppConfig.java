package com.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
public class AppConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/admin/**").hasAnyRole("ADMIN", "RESTAURANT_OWNER")
//                        .requestMatchers("/api/**").authenticated()
                        .anyRequest().authenticated()
                ).addFilterBefore(new JwtTokenValidator(), UsernamePasswordAuthenticationFilter.class)
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .build();
    }

    private final List<String> allowedURL = List.of("https://wander-foods.vercel.app", "http://localhost:3000");
    private final List<String> headers = List.of("Authorization");
    private final List<String> allowAll = Collections.singletonList("*");

    private CorsConfigurationSource corsConfigurationSource() {

        return request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(allowedURL);
            config.setAllowedMethods(allowAll);
            config.setAllowCredentials(true);
            config.setAllowedHeaders(allowAll);
            config.setExposedHeaders(headers);
            config.setMaxAge(3600L);
            return config;
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
