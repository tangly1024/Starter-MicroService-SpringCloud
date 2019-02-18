package com.tangly.apigateway.controller;

import com.tangly.apigateway.ao.RoutAO;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * REST controller for managing Gateway configuration.
 */
@RestController
@Slf4j
public class GatewayResourceController {


    private final RouteLocator routeLocator;

    private final DiscoveryClient discoveryClient;

    public GatewayResourceController(RouteLocator routeLocator, DiscoveryClient discoveryClient) {
        this.routeLocator = routeLocator;
        this.discoveryClient = discoveryClient;
    }

    /**
     * GET  /routes : get the active routes.
     *
     * @return the ResponseEntity with status 200 (OK) and with body the list of routes
     */
    @GetMapping("/")
    @Timed
    public List<RoutAO> activeRoutes() {
        List<Route> routes = routeLocator.getRoutes();
        List<RoutAO> routeVMs = new ArrayList<>();
        routes.forEach(route -> {
            RoutAO routAO = new RoutAO();
            routAO.setPath(route.getFullPath());
            routAO.setServiceId(route.getId());
            routAO.setServiceInstances(discoveryClient.getInstances(route.getLocation()));
            routeVMs.add(routAO);
        });
        return routeVMs;
    }
}
