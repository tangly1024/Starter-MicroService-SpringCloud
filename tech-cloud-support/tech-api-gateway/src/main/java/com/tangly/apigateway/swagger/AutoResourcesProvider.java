package com.tangly.apigateway.swagger;

import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * 自动装配接口文档资源
 */
@Component
@Primary
public class AutoResourcesProvider implements SwaggerResourcesProvider {

    /**
     * 配置API汇总
     *
     * @return 需要汇总的接口文档资源
     */
    @Override
    public List<SwaggerResource> get() {
        return autoConfig();
    }

    /**
     * 自动扫描
     *
     * @return 自动扫描所有路由、并生成资源
     */
    private List<SwaggerResource> autoConfig() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<Route> routes = routeLocator.getRoutes();

        for (Route route : routes) {
            if (!needRemove(route)) {
                resources.add(swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs"), "2.0"));
            }
        }
        return resources;
    }

    private List<String> excludes = new ArrayList<String>() {{
        add("external-");
        add("config-server");
    }};

    /**
     * 检查是否需要排除的路径
     *
     * @param route
     * @return 如果返回true表示排除路径
     */
    private boolean needRemove(Route route) {

        for (String exclude : excludes) {
            if (route.getId().startsWith(exclude)) {
                return true;
            }
        }
        return false;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

    private final RouteLocator routeLocator;

    public AutoResourcesProvider(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }


}
