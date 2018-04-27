package com.dsplat;
/**   
 * 
 * @Title: SpringBootStartApplication.java 
 * @Prject: springboot-web
 * @Package: com.bimmon.springboot.web 
 * @author: Lmz
 * @date: 2017年12月6日 上午10:23:40 
 * @version: V1.0   
 */

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/** 
 * springboot启动配置类
 * @ClassName: SpringBootStartApplication 
 * @author: Lmz
 * @date: 2017年12月6日 上午10:23:40  
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class, MybatisAutoConfiguration.class})
public class SpringBootStartApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	  // 注意这里要指向原先用main方法执行的Application启动类
	  return builder.sources(SpringBootStartApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartApplication.class, args);
	}
}
