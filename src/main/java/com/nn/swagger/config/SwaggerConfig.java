package com.nn.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @ClassName SwaggerConfig
 * @Author nn
 * @Date 2020/8/4 20:33
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    /**
     *  协同开发时，可以配置多个 docket 对象
     */
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("user2").enable(true);
    }


    @Bean
    public Docket docket(Environment environment) {
        // 在开发 与 测试 环境 开启 swagger
        boolean flag = environment.acceptsProfiles(Profiles.of("dev", "test"));

        return new Docket(DocumentationType.SWAGGER_2).groupName("user1")
                .apiInfo(apiInfo())
                // 是否启用 swagger：true,false
                .enable(flag)
                .select()
                // RequestHandlerSelectors 配置要扫描接口的方式
                // basePackage() 指定要扫描的包
                // any() 扫描全部
                // none(); 不扫描
                // withClassAnnotation()：扫描类上的注解
                // withMethodAnnotation()：扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.nn.swagger.controller"))
                //paths() 过滤的路径
//                .paths(PathSelectors.ant("/swagger/**"))
                .build();
    }

    public ApiInfo apiInfo() {
        Contact default_contact = new Contact("张三", "http://www.aiai2.com", "754005849@qq.com");
        return new ApiInfo(
                "这是文档标题",
                "这是文档描述",
                "v1.0",
                "http://www.baidu.com",
                default_contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
