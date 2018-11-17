package org.ming.download.servicemodule;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * 服务提供方启动类
 *
 * @author MingXiangjun
 * @create 2018-09-15 23:19
 */
@SpringBootApplication
//    @Configuration
//    @EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
//    @ComponentScan(value = "org.ming.download")
@EnableDubboConfiguration
public class ServiceProviderApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(ServiceProviderApplication.class,args);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceProviderApplication.class);
//        context.start();
//        System.in.read();
    }
}
