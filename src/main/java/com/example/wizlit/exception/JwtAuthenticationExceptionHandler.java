//package com.example.wizlit.exception;
//
//import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
//import org.springframework.core.annotation.Order;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Map;
//
//@Component
//@Order(-2) // 우선 순위를 높게 설정하여 다른 핸들러보다 먼저 실행되도록 함
//public class JwtAuthenticationExceptionHandler implements ErrorWebExceptionHandler {
//
//    @Override
//    //Flux와 비교해서 학습
//    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
//        if (ex instanceof InvalidBearerTokenException) {
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
//
//            Map<String, Object> errorDetails = Map.of(
//                "error", "invalid_token",
//                "error_description", "The token is invalid or expired",
//                "status", HttpStatus.UNAUTHORIZED.value()
//            );
//
//            String errorJson = String.format(
//                "{\"error\":\"%s\",\"error_description\":\"%s\",\"status\":%d}",
//                errorDetails.get("error"),
//                errorDetails.get("error_description"),
//                errorDetails.get("status")
//            );
//
//            byte[] bytes = errorJson.getBytes(StandardCharsets.UTF_8);
//            DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
//
//            return exchange.getResponse().writeWith(Mono.just(buffer));
//        }
//
//        // 다른 예외는 기본 핸들러로 위임
//        return Mono.error(ex);
//    }
//}
