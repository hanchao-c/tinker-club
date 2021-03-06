## 演示地址

[tinker后台管理系统](http://139.199.107.128:8080/tinker-web/login "")  账号：admin 密码：admin123

---

## 技术选型

### 前端框架
 - jquery 1.9
 - [bootstrap3 模板Color admin 3.0](https://pan.baidu.com/s/1N-3-J3qUZot1B9QS1Tl80g "前端模板") （百度云盘 提取码vr87）

### 后台基础框架
 -  springboot 2.1.4
 -  spring 5  
 -  springMVC 5 
 -  shiro  
 -  mybatis + tkmapper
 -  apache-dubbo

## 运行环境

 - jdk8  
 - mysql5
 - redis4
 - zookeeper3
 ---
 
## 环境安装及配置

 - 安装jdk8
 - 安装并启动mysql5，建立数据库，系统所需所有脚本在`tinker-club`的`document/sql`下（需先建立数据库，数据库名称可以与脚本名称一致，如tinker-auth, tinker-order）
 - 安装并启动redis3，建议设置密码 （设置密码 ： 启动redis服务并进入redis客户端 执行 config set requirepass "123456"）
 - 安装并启动zookeeper3

 ---
 
## 项目启动

 - **这是一个由zookeeper + dubbo作为rpc开发的分布式项目**
 - 项目运行前请确保项目的配置信息是正确可用的，如各组件连接地址、mysql账号密码、redis密码、zookeeper端口等
 - 运行`tinker-order-server`的`org.tinker.order.server.Application`的**main**函数以启动订单服务
 - 运行`tinker-payment-server`的`org.tinker.payment.server.Application`的**main**函数以启动支付服务
 - 使用**tomcat**启动`tinker-web`
 - 访问http://localhost:8080/tinker-web 账号 ：admin 密码 ：admin123

注 ：本地环境相关配置文件存放在各项目`src/main/resources`下的`config-local`文件夹

 ---

## 开发必读

### 项目结构

* tinker-club 
    * tinker-asset `工具、支持`
    * tinker-order `订单模块`
        * tinker-order-provider `订单服务dubbo接口`
        * tinker-order-server `订单服务`
    * tinker-payment `支付模块`
        * tinker-payment-provider `支付服务dubbo接口`
        * tinker-payment-server `支付服务`
    * tinker-web `后台管理入口（页面）`



 ---

### mybatis代码生成

使用Mybatis官方提供的代码生成插件 mybatis-generator-maven-plugin （见pom.xml plugins）
maven运行 `mybatis-generator:generate`进行myabtis相关代码生成
注：tinker-web下，如果需要重新生成auth_user， auth_role， auth_permission，需要在生成之前maven执行`assembly:single`，确保tinker-web-shiro-model.jar存在


### 环境切换
 
 环境        | 打包命令  |  配置文件  |  备注  
 -------------   | -------------  | -------------  | -------------
 本地        | clean package -Plocal  | resources/config-local/* | 本地环境clean package即可 
 测试        | clean package -Ptest   | resources/config-test/* |
 生产        | clean package -Pprod   | resources/config-prod/* |
 
根据pom.xml中profiles实现不同环境不同配置文件的打包方式，如果打包不加入参数-P，比如在本地启动项目时，会读取`config-local`下的配置文件
 
### 日志 

test、prod环境日志不会输出在`catalina.out`中，具体存放位置请见配置 

 - `logger.info.path`
 - `logger.error.path`
 
  ---  
### shiro问题

在tinker-web中使用到shiro，为了简化开发，项目中未在控制层中使用到shiro鉴权相关注解，同样没有在jsp中使用shiro tags进行按钮级别的权限，而是以页面作为权限控制

 ---

    当前项目`订单模块`、`支付模块`不存在任何逻辑，主要通过例子将整个请求的生命周期体现出来
    如存在项目上的问题，请与作者交流沟通 qq 1585439743


**该项目仅供学习交流使用！**


