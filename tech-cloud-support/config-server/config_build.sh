#!/usr/bin/env bash
# 将配置中心打包成镜像
mvn clean package -Dmaven.test.skip=true
docker build --rm -t registry.cn-hangzhou.aliyuncs.com/tangly/cloud-config .
docker push registry.cn-hangzhou.aliyuncs.com/tangly/cloud-config
# 默认清除一下旧的镜像
docker rmi $(docker images -f "dangling=true" -q)
