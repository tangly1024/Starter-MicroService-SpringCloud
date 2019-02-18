使用Docker启动一个rabbitmq容器。
```bash
docker run -d --hostname localhost --name myrabbit -p 15672:15672 -p 5672:5672 rabbitmq:3.6.15-management
```
