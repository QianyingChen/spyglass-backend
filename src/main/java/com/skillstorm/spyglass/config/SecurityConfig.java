package com.skillstorm.spyglass.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

	@Bean

	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                .anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .oauth2Login(withDefaults());
        http.cors(cors -> cors.configurationSource(request -> {
            CorsConfiguration corsConfig = new CorsConfiguration();
            corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
            corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
            corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
            corsConfig.setAllowCredentials(true);
            corsConfig.setMaxAge(3600L); // For an hour, cache the preflight cors request 
            
            
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", corsConfig);

            return corsConfig;
        }));
		
		return http.build();
	}
	
	
}
