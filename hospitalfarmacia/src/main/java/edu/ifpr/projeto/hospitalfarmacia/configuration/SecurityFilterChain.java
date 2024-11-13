// package edu.ifpr.projeto.hospitalfarmacia.configuration;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;

// @Configuration
// @EnableWebSecurity
// public class SecurityFilterChain {
    
//     @Bean
//     public SecurityFilterChain filterChain(
//         HttpSecurity http
//     )throws Exception{
//         return http.authorizeHttpRequests(
//             request -> {
//                 request.requestMatchers(HttpMethod.GET, "/")
//             }).sessionManagement(
//                 session -> {
//                     session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                 }).build();
//     }
// }
