package com.example.wizlit.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        
        logger.debug("Request URI: {}", request.getURI());
        logger.debug("Request Method: {}", request.getMethod());
        logger.debug("Request Headers: {}", request.getHeaders());
        
        return chain.filter(exchange)
            .then(Mono.fromRunnable(() -> {
                logger.debug("Response Status: {}", exchange.getResponse().getStatusCode());
                logger.debug("Response Headers: {}", exchange.getResponse().getHeaders());
            }));
    }

    @Override
    public int getOrder() {
        // 가장 먼저 실행되도록 높은 우선순위 설정
        return -1;
    }
}
