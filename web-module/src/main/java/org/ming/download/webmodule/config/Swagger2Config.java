package org.ming.download.webmodule.config;

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
 * 接口Api配置工具
 *
 * @author MingXiangjun
 * @create 2018-10-20 17:22
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .groupName("lcmj.online").select().apis(RequestHandlerSelectors.basePackage("org.ming.download"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * Api附加信息
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().contact(new Contact("MingXiangjun","",""))
                .description("SpringBoot 异步任务DemoProject").title("RestInterface API Page")
                .version("1.0.0").termsOfServiceUrl("https://github.com/mingxiangjun").build();
    }
}
