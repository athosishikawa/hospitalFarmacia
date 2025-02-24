package edu.ifpr.projeto.hospitalfarmacia.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    SecurityFilter securityFilter;

    private static final String[] AUTH_WHITELIST = {
        "/auth/*",
        "/v3/api-docs/**",
        "/swagger-ui/**",
        "/auth/login",
        "/pessoa/listarPessoas",
        "/medicamento/listarMedicamentos",
        "/plano/listarPlanos",
        "/receita/listarReceitas",
        "/pessoa/cadastrarPessoa",
        "/paciente/cadastrarPacientes",
        "/medicos/findMedico",
        "/receita/cadastrarReceita",
        "/itemReceita/cadastrarItemReceita"
    };

    @Bean
    protected SecurityFilterChain filterChain(
        HttpSecurity http
    ) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(requests -> {
                    requests.requestMatchers(AUTH_WHITELIST).permitAll();
                    requests.requestMatchers(HttpMethod.POST, "/pessoa")
                    .hasRole("ADMIN")
                    .anyRequest()
                    .authenticated();
                }
            )
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
        AuthenticationConfiguration authenticationConfiguration
    )throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
