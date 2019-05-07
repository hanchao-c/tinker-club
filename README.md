## 演示地址
http://139.199.107.128:8008/tinker-web/login 
账号：admin，密码：admin123

---

## 技术选型

### 前端框架
 - Jquery 1.9
 - Bootstrap模板Color admin 3.0

### 后台基础框架
 -  Spring 5  
 -  SpringMVC 5 
 -  Shiro  
 -  Mybatis + tkmapper
 -  apache dubbo

## 运行环境

 - jdk8  
 - mysql5
 - redis4
 - zookeeper3
 ---
 
## 环境安装及配置

 - 安装jdk8
 - 安装并启动mysql5，建立数据库，系统所需所有脚本在tinker-club的document/sql下（需先建立数据库，数据库名称可以与脚本名称一致，如tinker-auth, tinker-order）
 - 安装并启动redis3，建议设置密码 （设置密码 ： 启动redis服务并进入redis客户端 执行 config set requirepass "123456"）
 - 安装并启动zookeeper3

 ---
 
## 项目启动

 - 项目运行前请确保项目的配置信息是正确可用的，如各组件连接地址、mysql账号密码、redis密码、zookeeper端口等
 - 运行tinker-order-server的org.tinker.order.server.Application的main函数以启动订单服务
 - 运行tinker-payment-server的org.tinker.payment.server.Application的main函数以启动支付服务
 - 使用tomcat启动tinker-web
 - 访问http://localhost:8080/tinker-web 账号 ：admin 密码 ：admin123

注 ：本地环境相关配置文件存放在各项目src/main/resources下的config-local文件夹

 ---

## 开发必读



 