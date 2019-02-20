#!/usr/bin/env bash
# 将eureka注册中心打包成docker镜像
mvn clean package -Dmaven.test.skip=true
docker build -t registry.cn-hangzhou.aliyuncs.com/tangly/service-biz-demo .
docker push registry.cn-hangzhou.aliyuncs.com/tangly/service-biz-demo
# 默认清除一下旧的镜像
docker rmi $(docker images -f "dangling=true" -q)
