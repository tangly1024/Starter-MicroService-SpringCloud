package com.tangly.apigateway.ao;

import lombok.Data;
import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * View Model that stores a route managed by the Gateway.
 */
@Data
public class RoutAO {

    private String path;

    private String serviceId;

    private List<ServiceInstance> serviceInstances;
}
