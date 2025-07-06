package com.csh.oms.gateway.route;

import org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class RouteConfig {

    @Bean
    public RouterFunction<ServerResponse> routeProductService() {
            return GatewayRouterFunctions.route("product-service").
                    route(RequestPredicates.path("/api/product"), HandlerFunctions.http())
                    .before(BeforeFilterFunctions.uri("http://localhost:8080"))
                    .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeOrderService() {
        return GatewayRouterFunctions.route("order-service").
                route(RequestPredicates.path("/api/order"), HandlerFunctions.http())
                .before(BeforeFilterFunctions.uri("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeInventoryService() {
        return GatewayRouterFunctions.route("inventory-service").
                route(RequestPredicates.path("/api/inventory"), HandlerFunctions.http())
                .before(BeforeFilterFunctions.uri("http://localhost:8082"))
                .build();
    }
}

