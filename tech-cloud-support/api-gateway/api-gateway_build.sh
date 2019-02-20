#!/usr/bin/env bash
# 将eureka注册中心打包成docker镜像
mvn clean package -Dmaven.test.skip=true
docker build -t registry.cn-hangzhou.aliyuncs.com/tangly/api-gateway .
docker push registry.cn-hangzhou.aliyuncs.com/tangly/api-gateway
# 默认清除一下旧的镜像
docker rmi $(docker images -f "dangling=true" -q)
