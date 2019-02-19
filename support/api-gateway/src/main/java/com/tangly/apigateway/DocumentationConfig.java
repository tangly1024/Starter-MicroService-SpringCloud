package com.tangly.apigateway;

import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {

    /**
     * 配置API汇总
     * @return 需要汇总的接口文档资源
     */
    @Override
    public List<SwaggerResource> get() {
//        return autoConfig();
        return manualConfig();
    }

    /**
     * 自动扫描
     * @return 自动扫描所有路由、并生成资源
     */
    private List<SwaggerResource> autoConfig(){
        List<SwaggerResource> resources = new ArrayList<>();
        List<Route> routes = routeLocator.getRoutes();
        System.out.println(Arrays.toString(routes.toArray()));
        routes.forEach(route -> resources.add(swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs"),"2.0")));
        return resources;
    }

    /**
     * 手动设置
     * @return 手动设置资源
     */
    private List<SwaggerResource> manualConfig() {
        List<SwaggerResource> resources =new ArrayList<>();
        resources.add(swaggerResource("演示系统-biz-demo", "/biz-demo/v2/api-docs", "1.0"));
        resources.add(swaggerResource("演示系统-biz-demo2", "/biz-demo2/v2/api-docs", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

    private final RouteLocator routeLocator;

    public DocumentationConfig(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }


}
