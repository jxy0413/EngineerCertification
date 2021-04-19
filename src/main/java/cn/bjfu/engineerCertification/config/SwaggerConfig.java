package cn.bjfu.engineerCertification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by jxy on 2021/4/19 0019 16:54
 */
@Configuration
//注解开启 swagger2 功能
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否开启 (true 开启  false隐藏。生产环境建议隐藏)
                .select()
                //扫描的路径包,设置basePackage会将包下的所有被@Api标记类的所有方法作为api
                //指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("cn.bjfu.engineerCertification.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description(
                        "header中的token(key:Authorization)" +
                                "(value:Bearer eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MDY2MjU4MDZ9." +
                                "kugXe-9g0Beqq8GEuZjALJCPCN9-iDcy2Fyy_LcNHnxRRJ_mlrx1DHsdTE4Ux2V5yY6kGYL4X-PPjiLqxQF_ig)")
                .contact(new Contact("yf、xy、cb、hy", "bjfu1022", "bjfu1022email.com"))
                .version("1.0")
                .build();
    }
}