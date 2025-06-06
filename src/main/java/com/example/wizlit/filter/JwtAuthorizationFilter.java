//package com.example.wizlit.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.ReactiveSecurityContextHolder;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//@Component
//public class JwtAuthorizationFilter implements GlobalFilter {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        return ReactiveSecurityContextHolder.getContext()
//            .map(SecurityContext::getAuthentication)
//            .filter(Objects::nonNull)
//            .map(auth -> {
//                // JWT 토큰에서 사용자 정보 추출
//                Jwt jwt = (Jwt) auth.getPrincipal();
//
//                // 필요한 클레임 추출
//                String username = jwt.getClaimAsString("preferred_username");
//                String userId = jwt.getClaimAsString("sub");
//                String email = jwt.getClaimAsString("email");
//
//                // 역할 정보 추출 (realm_access.roles)
//                Map<String, Object> realmAccess = jwt.getClaimAsMap("realm_access");
//                List<String> roles = realmAccess != null ? (List<String>) realmAccess.get("roles") : List.of();
//
//                // 요청 헤더에 사용자 정보 추가
//                ServerHttpRequest request = exchange.getRequest().mutate()
//                    .header("X-User-Id", userId)
//                    .header("X-User-Name", username)
//                    .header("X-User-Email", email)
//                    .header("X-User-Roles", String.join(",", roles))
//                    .build();
//
//                return exchange.mutate().request(request).build();
//            })
//            .defaultIfEmpty(exchange)
//            .flatMap(chain::filter);
//    }
//}
