package com.api.ppp.back.security;

import com.api.ppp.back.filter.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;


@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:58697"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setExposedHeaders(Arrays.asList("Authorization"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                }).and().csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/register", "/usuariofenix/**", "/fenix/**", "/carrera/**")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                    .requestMatchers("/accion/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/accionConvoca/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/anexos/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/aspecto/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/aspectoPractica/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/calificacion/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/convenio/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/convocatoria/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/empresa/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/estudiante/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/materia/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/objetivoMateria/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/resultado/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/resultadoMateria/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/semanaActividad/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/solicitudEmpresa/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/solicitudEstudiante/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/sucursal/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/tutorEmpresa/**").hasAnyRole("TEMP", "TEMP", "TISTA")
                    .requestMatchers("/tutorInstituto/**").hasAnyRole("TIST", "TEMP", "TISTA")
                    .requestMatchers("/usuario/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/visitaActividad/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/visita/**").hasAnyRole("ESTUD", "TEMP", "TISTA")
                    .requestMatchers("/ingresar").authenticated()
                    // Letting Access of fenix to ALL by the moment
                    .requestMatchers("/register", "/usuariofenix/**", "/fenix/**", "/carrera/**").permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
