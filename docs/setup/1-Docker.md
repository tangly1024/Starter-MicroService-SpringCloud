# 安装服务器

- ##更新服务器内核
```bash
yum update
```
- ##卸载旧版本docker（可选）
```bash
yum list installed|grep docker 
yum -y remove docker-ce.x86_64 
rm -rf /var/lib/docker
```

- ## 下载安装包

用国内中科大镜像

```bash
wget https://mirrors.ustc.edu.cn/docker-ce/linux/centos/7/x86_64/stable/Packages/docker-ce-selinux-17.03.2.ce-1.el7.centos.noarch.rpm
yum -y localinstall docker-ce-selinux-17.03.2.ce-1.el7.centos.noarch.rpm

wget https://mirrors.ustc.edu.cn/docker-ce/linux/centos/7/x86_64/stable/Packages/docker-ce-17.03.2.ce-1.el7.centos.x86_64.rpm
yum -y localinstall docker-ce-17.03.2.ce-1.el7.centos.x86_64.rpm
```

### 官网下载
访问网址：https://download.docker.com/linux/centos/7/x86_64/stable/Packages/ 这里面有各个版本的安装文件。下载你所需要的版本。
推荐直接在使用wget命令，例如，要下载的版本是17.03.2.ce。在上面的网址中右键点击复制链接地址，然后直接用下列命令下载：
```bash
wget https://download.docker.com/linux/centos/7/x86_64/stable/Packages/docker-ce-17.03.2.ce-1.el7.centos.x86_64.rpm
```

### 官网安装
执行如下命令：./ 右侧跟文件表示当前下载的文件名。
```bash
yum install -y  ./docker-ce-17.03.2.ce-1.el7.centos.x86_64.rpm
```


这个时候 Docker 已经安装，但是还没有启动。Docker CE 还会为系统添加一个名为“docker”的用户组。使用 
```bash
cat /etc/group
```
就可以看到docker用户组：

```text
docker:x:998:
```

# 启动Docker CE

执行下面的命令：

```bash
systemctl start docker
```
执行以下命令让docker开机自动启动
```bash
systemctl enable docker
```

你可以执行 docker images 命令来验证docker有没有正常启动。

```bash
docker version
docker images
```

防火墙与docker冲突比较麻烦，直接关闭
```bash
systemctl stop firewalld.service #停止firewall
systemctl disable firewalld.service #禁止firewall开机启动
```

- ## 添加阿里镜像源
阿里容器服务后台提供添加镜像源的脚本
```bash
sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://qywl6chq.mirror.aliyuncs.com"]
}
EOF
sudo systemctl daemon-reload
sudo systemctl restart docker
```

- ## 启动一个Rancher
```bash
 sudo docker run -d \
  --restart=unless-stopped \
  --name=rancher-server \
  -p 9000:8080 \
  rancher/server:v1.6.8
```


- 登陆docker镜像仓库
```bash
docker login --username=573865178@qq.com registry.cn-hangzhou.aliyuncs.com
```
镜像库Custom ：菜单拦->基础架构->镜像库->添加镜像库 ； 添加上述地址的仓库
