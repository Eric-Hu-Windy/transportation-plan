# 服务器的部署（windows7以上）

## 环境搭建

### 前端（transportation-plan-frontend）

1. 安装nodejs & npm
```
https://nodejs.org/en/download/
```

### 后端（transportation-plan-backend）
1. 安装jdk
```
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
```

2. 安装mysql
```
https://dev.mysql.com/downloads/mysql/
```

备注：
- 设置用户名/密码为root/admin
- 如果没有设置成上述密码需要修改`transportation-plan-backend\src\main\resources\application.yml`
```
spring:
  datasource:
    url: jdbc:mysql://{host}:{port}/transportation-plan?useUnicode=true&characterEncoding=utf8
    username: {username}
    password: {password}
```

### 其他
1. 安装git（可选）
```
https://git-scm.com/downloads
```

## 启动项目
1. 将项目下载到本地
```
git clone https://github.com/Eric-Hu-Windy/transportation-plan.git
```
2. 将release的jar包下载到项目文件夹下，和`start.bat`同级，改名为`transportation-plan.jar`
3. 双击`start.bat`启动
