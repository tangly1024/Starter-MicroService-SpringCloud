FROM openjdk:8-jdk-alpine
#FROM java

MAINTAINER tangly tlyong1992@hotmail.com

# 设置时区 亚太/上海
RUN echo "Asia/Shanghai" > /etc/timezone
ENV TZ "Asia/Shanghai"

# 挂卷
VOLUME ["/tmp","/attach"]

# 添加代码
ADD ./target/*.jar app.jar
#RUN sh -c 'touch /app.jar' 修改时间戳

#HEALTHCHECK --interval=60s --timeout=5s --retries=3 CMD curl http://localhost:8088/monitor/health

# 默认环境变量设置 该变量可以使用docker启动脚本覆盖 docker run -e SPRING_PROFILES_ACTIVE=sit
ENV SPRING_PROFILES_ACTIVE default
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}","/app.jar"]
EXPOSE 8080
