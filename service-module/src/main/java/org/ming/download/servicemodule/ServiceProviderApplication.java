package org.ming.download.servicemodule;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 服务提供方启动类
 *
 * @author MingXiangjun
 * @create 2018-09-15 23:19
 */
@SpringBootApplication
@EnableDubboConfiguration
public class ServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication.class,args);
    }
}
