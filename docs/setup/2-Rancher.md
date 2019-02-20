# 组件
- ## RABBITMQ
从应用商店添加，
端口另开lb 15672:15672,5672:5672

- ## EUREKA
镜像名 registry.cn-hangzhou.aliyuncs.com/tangly/cloud-eureka
环境变量 EUREKA_SERVER=http://192.168.2.250:1001/eureka
端口另开lb 1001:1001

- ## CONFIG
镜像名 registry.cn-hangzhou.aliyuncs.com/tangly/cloud-config
环境变量 EUREKA_SERVER=http://192.168.2.250:1001/eureka
        RABBIT_HOST=192.168.2.250
端口另开lb 1001:1002

- ## API-GATEWAY
镜像名 registry.cn-hangzhou.aliyuncs.com/tangly/api-gateway
环境变量 EUREKA_SERVER=http://192.168.2.250:1001/eureka
        RABBIT_HOST=192.168.2.250
端口另开lb 8080:8080

- ## ZIPKIN-SLEUTH
镜像名 registry.cn-hangzhou.aliyuncs.com/tangly/monitor-zipkin
环境变量 EUREKA_SERVER=http://192.168.2.250:1001/eureka
        RABBIT_HOST=192.168.2.250
端口另开lb 1003:1003

- ## HYSTRIX-DASHBOARD
镜像名 registry.cn-hangzhou.aliyuncs.com/tangly/monitor-hystrix
环境变量 EUREKA_SERVER=http://192.168.2.250:1001/eureka
端口另开lb 1000:1000

# 应用服务
- ## DEMO
镜像名 registry.cn-hangzhou.aliyuncs.com/tangly/service-biz-demo
环境变量 EUREKA_SERVER=http://192.168.2.250:1001/eureka
        RABBIT_HOST=192.168.2.250
端口另开lb 8081：8081

- ## DEMO2
镜像名 registry.cn-hangzhou.aliyuncs.com/tangly/service-biz-demo2
环境变量 EUREKA_SERVER=http://192.168.2.250:1001/eureka
        RABBIT_HOST=192.168.2.250
端口不直接lb，由api统一调用 8082
