package org.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@Configuration
public class ApiGatewayApplication {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("textgeneration-service", r -> r.path("/tgs/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://TEXTGENERATION-SERVICE"))
                .route("translate-service", r -> r.path("/ts/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://TRANSLATE-SERVICE"))
                .route("voice-service", r -> r.path("/vs/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://VOICE-SERVICE"))
                .route("english-service", r -> r.path("/es/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://ENGLISH-SERVICE"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}
