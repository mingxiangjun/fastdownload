package org.ming.download.commonmodult;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;

/**
 * 系统常用配置
 *
 * @author MingXiangjun
 * @create 2018-09-18 21:45
 */
@ConditionalOnProperty(prefix = "common",havingValue = "true")
@ConfigurationProperties(prefix = "common")
public class CommonConfig extends HashMap{
}
