# 组件支持
```bash
#RABBITMQ
docker run -d -p 5672:5672 -p 15672:15672 -v /home/techco/docker/rabbitmq/data:/var/lib/rabbitmq rabbitmq:management
#EUREKA
docker run -d -p 1001:1001 -e EUREKA_SERVER=http://192.168.2.250:1001/eureka registry.cn-hangzhou.aliyuncs.com/tangly/cloud-eureka
#CONFIG_CENTER
docker run -d -p 1002:1002 -e EUREKA_SERVER=http://192.168.2.250:1001/eureka -e RABBIT_HOST=192.168.2.250 registry.cn-hangzhou.aliyuncs.com/tangly/cloud-config
#API_GATEWAY
docker run -d -p 8080:8080 -e EUREKA_SERVER=http://192.168.2.250:1001/eureka registry.cn-hangzhou.aliyuncs.com/tangly/api-gateway

```

# 应用
```bash
docker run -d -p 8081:8081 -e EUREKA_SERVER=http://192.168.2.250:1001/eureka registry.cn-hangzhou.aliyuncs.com/tangly/service-biz-demo

```
