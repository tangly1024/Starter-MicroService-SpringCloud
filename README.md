# Micro-Service-SpringCloud
基于SpringCloud的微服务架构

## 自己搭建的微服务架构
- 服务注册与发现（使用Eureka）
- 服务消费者（使用Feign）
- 分布式配置中心（消息总线刷新配置）
- 服务容错保护(Hystrix服务降级)
- Hystrix监控数据聚合
- 服务网关（ZUUL）
- API文档汇总（Zuul+Swagger）
- 服务依赖、跟踪（zipkin + rabbitmq）
- [待解决]消息驱动的微服务（通过AMQP调用任务）
- [待解决]分布式服务跟踪（logstash）

## 部署方案
- 所有组件服务采用Docker 
- 容器调度平台 Rancher + Cattle
