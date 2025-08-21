package com.inventra.inventra.config;

import com.inventra.inventra.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ConfigSecurity {


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserServiceImpl userServices) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userServices);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests(configurer -> configurer

                    .requestMatchers(HttpMethod.POST, "/api/user/register-user").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/user/login-user").permitAll()

                    .requestMatchers(HttpMethod.POST, "/api/items/add-new-item").hasAnyRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/api/items/add-new-item").hasAnyRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/api/items/update-item").hasAnyRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/items/delete-item").hasAnyRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/items/delete-all-item").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/api/items/report-an-item").hasAnyRole("ADMIN")

                    .requestMatchers(HttpMethod.POST, "/api/inventory/assign-items").hasAnyRole("ADMIN", "COLLECTOR")
                    .requestMatchers(HttpMethod.POST, "/api/inventory/track-status").hasAnyRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/api/inventory/generate-report").hasAnyRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/api/inventory/generate-inventory-report").hasRole("ADMIN")

                    .requestMatchers(HttpMethod.POST, "/api/reminder/auto-Reminder").hasAnyRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/api/reminder/manual-Reminder").hasAnyRole("ADMIN")

                    .anyRequest().authenticated()
            );

            http.httpBasic(Customizer.withDefaults());
            http.csrf(csrf -> csrf.disable());

            return http.build();
        }
    }

