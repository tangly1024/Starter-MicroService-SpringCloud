package com.tangly.apigateway.swagger;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * 手动配置接口文档目录
 */
public class ManualResourcesProvider implements SwaggerResourcesProvider {

    /**
     * 配置API汇总
     *
     * @return 需要汇总的接口文档资源
     */
    @Override
    public List<SwaggerResource> get() {
        return manualConfig();
    }

    /**
     * 手动设置
     *
     * @return 手动设置资源
     */
    private List<SwaggerResource> manualConfig() {
        List<SwaggerResource> resources = new ArrayList<>();
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

}
