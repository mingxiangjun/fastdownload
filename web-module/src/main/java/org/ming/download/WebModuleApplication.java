package org.ming.download;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author MingXiangjun
 * @create 2018-09-16 11:11
 */
@EnableAsync
@EnableDubboConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebModuleApplication.class,args);
    }
}
