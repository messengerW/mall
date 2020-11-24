package com.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
 * */
@EnableFeignClients(basePackages = "com.mall.product.feign")
@MapperScan("com.mall.product.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class MallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallProductApplication.class, args);
	}

}
