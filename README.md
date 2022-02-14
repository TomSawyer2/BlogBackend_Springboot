# BlogBackend_Springboot

博客后端重构，启动项目需要在`/resources`文件夹内手动添加`application.yml`，示例如下：

```xml
server:
  port: 8082

spring:
  application:
    name: blog
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    name: Blog
    url: jdbc:mysql://ip:port/database?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true
    username: root
    password: "password"

mybatis-plus:
  mapper-locations: classpath:/mapper/**/*.xml
  global-config:
    db-config:
      id-type: auto
  configuration:
    auto-mapping-behavior: partial
    map-underscore-to-camel-case: true
  type-enums-package: com.hkx

jwt:
  tokenHeader: Authorization
  secret: blog-secret
```

