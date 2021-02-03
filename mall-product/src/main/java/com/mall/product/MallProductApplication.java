package com.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 一、整合 MyBatis-plus
 * 1.导入依赖
 * <dependency>
 *       <groupId>com.baomidou</groupId>
 *       <artifactId>mybatis-plus-boot-starter</artifactId>
 *       <version>3.2.0</version>
 *</dependency>
 * 2.配置
 *   1）配置数据源
 *   	① 导入数据库驱动(mall-common的pom)
 *   	② 配置数据源(application.yml)
 *   2）配置 Mybatis-plus
 *   	① 使用 @MapperScan
 *   	② 告诉 MyBatis-plus sql映射文件的位置
 *
 * 二、使用 MyBatis-plus 逻辑删除
 *   1. 配置全局的逻辑删除规则（可省略）
 *   2. 配置逻辑删除的组件Bean（可省略）
 *   3. 在Entity添加逻辑删除注解 @TableLogic
 *
 * 三、后端参数校验 JSR303
 * 	 1. 在Bean中添加注解（javax.validation.constraints.*）
 * 	 2. 在Controller中开启校验功能
 * 	 3. 待校验的bean后紧跟一个BindingResult来自定义检验回显信息
 * 	 4. 分组校验
 * 	 	1）@NotBlank(message = "品牌名必须提交",groups = {AddGroup.class,UpdateGroup.class})
 * 	 	  给校验注解标注什么情况需要进行校验，有的字段在修改/新增时校验规则是不同的
 * 	 	2）@Validated({AddGroup.class})
 * 	 5. 自定义校验
 * 	    1）编写一个自定义校验注解 @ListValue
 * 	    2）编写一个自定义校验器 ListValueConstraintValidator
 * 	    3）关联 自定义校验注解 和 自定义校验器
 *
 * 四、异常统一拦截处理 @ControllerAdvice
 *   1. 编写统一异常处理类 ExceptionControllerAdvice
 *   2. 使用 @ExceptionHandler 标注方法可以处理的异常类型
 *
 * 五、引入 thymeleaf 模板引擎
 *   1. application.xml 配置文件中关闭缓存
 *   2. 所有的静态资源都放在 static 目录下
 *   3. index页面放在 templates 目录下（SpringBoot访问时会默认寻找 index.html）
 *   4. 实现热加载（修改页面不用重启服务就可以实时更新）
 *      1）引入 dev-tools
 *      2）修改完后，Build -> ReCompile (快捷键 ctrl+shift+F9)，再刷新页面
 *
 * 六、整合 Redis
 * 	 1.引入 spring-boot-starter-data-redis
 * 	 2.配置 application.yml 中 redis 相关配置（host、port）
 * 	 3.使用 SpringBoot 自动配置好的 StringRedisTemplate 来操作 Redis
 * 	   redis => map<key, value>
 *
 * 七、整合 redisson 作为分布式锁等功能框架
 * 	 1.引入 redisson
 * 	 2.config 目录下新增配置文件 MyRedissonConfig
 * 	 3.参照官方文档使用
 *
 * 八、整合 SpringCache 简化缓存开发
 * 	 1.引入 spring-boot-starter-cache
 * 	 2.配置application.properties，使用 redis 作为缓存
 * 	 3.在启动类中开启缓存功能（@EnableCaching）
 * */
@EnableCaching
@EnableFeignClients(basePackages = "com.mall.product.feign")
@MapperScan("com.mall.product.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class MallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallProductApplication.class, args);
	}

}
