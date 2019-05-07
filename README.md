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
## 项目结构

tinker-club 
tinker-asset 工具、支持
tinker-order 订单模块
tinker-order-provider 订单服务dubbo接口
tinker-order-server 订单服务
tinker-payment 支付模块
tinker-payment-provider 支付服务dubbo接口
tinker-payment-server 支付服务
tinker-web 后台页面展示

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


### mybatis代码生成

使用Mybatis官方提供的代码生成插件 mybatis-generator-maven-plugin （见pom.xml plugins）
maven运行 mybatis-generator:generate进行myabtis相关代码生成
注：tinker-web下，如果需要重新生成auth_user， auth_role， auth_permission，需要在生成之前maven执行assembly:single，确保tinker-web-shiro-model.jar存在


### 环境切换
 
 环境        | 打包命令  |  配置文件  |  备注  
 -------------   | -------------  | -------------  | -------------
 本地        | clean package -Plocal  | resources/config-local/* | 本地环境clean package即可 
 测试        | clean package -Ptest   | resources/config-test/* |
 生产        | clean package -Pprod   | resources/config-prod/* |
 
根据pom.xml中profiles实现不同环境不同配置文件的打包方式，如果打包不加入参数-P，比如在本地启动项目时，会读取config-local下的配置文件
 
### 日志 

test、prod环境日志不会输出在catalina.out中，具体存放位置请见配置 

 - logger.info.path
 - logger.error.path


 