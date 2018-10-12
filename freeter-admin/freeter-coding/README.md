**项目说明** 

- 采用SpringBoot、MyBatis、Shiro、mybaits-plus黄金搭档。
- 有单独的后台，还有单独的接口框架，可以实现前后端分离协作开发，还有火爆的商场功能模块，jwt
- 支持MySQL、Oracle、SQL Server等主流数据库
- 支持j2cache 二级缓存
- 灵活的权限控制，可控制到页面或按钮，满足绝大部分的权限需求
- 完善的部门管理及数据权限，通过注解实现数据权限的控制
- 完善的XSS防范及脚本过滤，支持白名单过滤,彻底杜绝XSS攻击
- 引入swagger文档支持，方便编写API接口文档

<br>

 **项目结构** 

freeter-coding

|--freeter-admin 后台管理 <br>
|--freeter-common 公共模块<br>

<br>

 **技术选型：** 
- 核心框架：Spring Boot
- 安全框架：Apache Shiro
- 视图框架：Spring MVC
- 持久层框架：MyBatis
- 定时器：Quartz 2.3
- 数据库连接池：Druid
- 日志管理：logback
- 页面交互：layui
- 下拉框：bootstrap-select
- 文件上传：Bootstrap File Input
- 验证框架 hibernate-validator
- mybatis加强工具 mybatis-plus  文档 http://mp.baomidou.com/#/?id=%E7%AE%80%E4%BB%8B
- 通用工具类 hutool 文档 http://hutool.mydoc.io/
- j2cache  https://gitee.com/ld/J2Cache
<br> 

 **软件需求** 
- JDK1.8
- MySQL5.5+
- Tomcat8+
- Maven3.0+

<br>

 **本地部署**

1.git下载https://gitee.com/xcOschina/freeter-admin.git项目,完成后导入到ide中 <br>
2.eclipse File import... Maven Existing Projects into Workspace 选择项目的根路径。<br>
3.IDE会下载maven依赖包，自动编译 如果有报错 请update project... jdk环境配置。<br>
4.执行doc/mysql-test.sql文件，初始化数据【按需导入表结构及数据】<br>
5.最后修改数据库连接参数,配置文件在src/main/resources/application.yml<br>
6.j2cache:
    config-location: /cache/j2cache-no.properties     
    open-spring-cache: true  

j2cache-no.properties    就是不用缓存
j2cache-redis.properties redis 包括二级缓存
j2cache-caffeine.properties 一级缓存

7.在freeter-coding目录下，执行mvn clean install
<br>

- Eclipse、IDEA运行AdminApplication.java，则可启动项目【freeter-admin】
- freeter-admin访问路径：http://localhost:8080/freeter-admin/index.html
- 账号密码：admin/admin

<br>
