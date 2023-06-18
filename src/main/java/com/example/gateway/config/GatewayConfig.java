package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("backend", r -> r.path("/api/description/**")
                        .uri("http://description-cud:8081"))
                .route("backend", r -> r.path("/api/descriptions/**")
                        .uri("http://description-r:8082"))
                .route("backend", r -> r.path("/api/users/**")
                        .uri("http://user-service:8083"))
                .build();

//        return builder.routes()
//                .route("backend", r -> r.path("/api/description/**")
//                        .uri("http://localhost:8081"))
//                .route("backend", r -> r.path("/api/descriptions/**")
//                        .uri("http://localhost:8082"))
//                .route("backend", r -> r.path("/api/users/**")
//                        .uri("http://localhost:8083"))
//                .build();

    }
}
