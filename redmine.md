# ssm框架 #
## springboot 3.3.2 ##
## java 17 ##
## mysql 8.0 ##
## springboot集成扩展： ##
### 1.swagger-doc ###
### 2.CorsFilter:跨域请求过滤器 ###
### 3.GlobalExceptionHandler:全局异常过滤器: ###
api依赖service，service添加exception处理异常包，包含业务异常，IO异常，数据异常，api异常等等
### 4.统一返回类RespInfo:依赖lombok支持序列化data: ###
### 5.统一日志记录： ###
slf4j此依赖在spring-boot-starter包下，可以不单独包含slf4j依赖 
### 6.引入hutool工具类： SM4国密算法###



