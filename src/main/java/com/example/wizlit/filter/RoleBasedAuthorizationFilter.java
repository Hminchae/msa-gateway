//package com.example.wizlit.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.context.ReactiveSecurityContextHolder;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class RoleBasedAuthorizationFilter implements GlobalFilter, Ordered {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        return ReactiveSecurityContextHolder.getContext()
//            .map(ctx -> ctx.getAuthentication())
//            .filter(auth -> auth != null)
//            .flatMap(auth -> {
//                Jwt jwt = (Jwt) auth.getPrincipal();
//
//                // realm_access.roles 추출
//                Map<String, Object> realmAccess = jwt.getClaimAsMap("realm_access");
//                List<String> roles = realmAccess != null ? (List<String>) realmAccess.get("roles") : List.of();
//
//                String path = exchange.getRequest().getPath().value();
//
//                // 경로별 권한 체크 로직
//                if (path.startsWith("/api/admin") && !roles.contains("admin")) {
//                    exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
//                    return exchange.getResponse().setComplete();
//                }
//
//                if (path.startsWith("/api/service-one") && !roles.contains("service-one-user")) {
//                    exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
//                    return exchange.getResponse().setComplete();
//                }
//
//                if (path.startsWith("/api/service-two") && !roles.contains("service-two-user")) {
//                    exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
//                    return exchange.getResponse().setComplete();
//                }
//
//                return chain.filter(exchange);
//            })
//            .defaultIfEmpty(exchange)
//            .flatMap(chain::filter);
//    }
//
//    @Override
//    public int getOrder() {
//        // JwtAuthorizationFilter 이후에 실행되어야 함
//        return 1;
//    }
//}
