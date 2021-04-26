package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.example.mapper")
@SpringBootApplication(scanBasePackages = "com.example")
//springBootApplication   只会扫描主类同级的包


//exclude，排除此类的AutoConfig，
// 即禁止 SpringBoot 自动注入数据源配置
//DataSourceAutoConfiguration.class
// 会自动查找 application.yml 或者 properties 文件里的 spring.datasource.* 相关属性并自动配置单数据源

//@ServletComponentScan
//Servlet可以直接通过@WebServlet注解自动注册
//Filter可以直接通过@WebFilter注解自动注册
//Listener可以直接通过@WebListener 注解自动注册

public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
