//package com.example.wizlit.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http
//            .authorizeExchange(exchanges -> exchanges
//                .pathMatchers("/actuator/**", "/public/**").permitAll()
////                .anyExchange().authenticated()
//            );
////            .oauth2ResourceServer(oauth2 -> oauth2
////                .jwt(jwt -> jwt.jwtAuthenticationConverter(
////                    new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter())
////                ))
////            );
//
//        return http.build();
//    }
//
//    private JwtAuthenticationConverter jwtAuthenticationConverter() {
//        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
//        // 여기에 필요한 경우 사용자 정의 변환기 설정을 추가할 수 있습니다
//        return converter;
//    }
//}
