package org.ming.download.commonmodule.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * 系统常用配置
 *
 * @author MingXiangjun
 * @create 2018-09-18 21:45
 */
@Configuration
@ConfigurationProperties(prefix = "common")
public class CommonConfig extends HashMap{
}
