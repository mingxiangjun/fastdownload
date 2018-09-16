package org.ming.download.webmodule;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author MingXiangjun
 * @create 2018-09-16 11:11
 */
@SpringBootApplication
@EnableDubboConfiguration
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class WebModultApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebModultApplication.class,args);
    }
}
