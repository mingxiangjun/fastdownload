package org.ming.download.servicemodule.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.Getter;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 缓存配置项
 *
 * @author MingXiangjun
 * @create 2018-10-20 12:50
 */
@Configuration
@EnableCaching
public class CustomCacheConfig {
    /**
     * 默认缓存大小
     */
    public final static int DEFAULT_SIZE = 50000;
    /**
     * 默认过期时间
     */
    public final static int DEFAULT_TIME_TO_LIVE = 100;
    @Getter
    public enum Caches{
        /**
         * 账号缓存
         */
        ACCOUNT(DEFAULT_TIME_TO_LIVE),
        /**
         * 用户信息缓存
         */
        USER_INFO(DEFAULT_TIME_TO_LIVE,DEFAULT_SIZE);
        /**
         * 设置默认值
         */
        private int ttl = DEFAULT_TIME_TO_LIVE;
        private int cacheSize = DEFAULT_SIZE;

        /**
         * 默认构造器
         */
        Caches(){

        }
        Caches(int ttl){
            this.ttl = ttl;
        }

        Caches(int ttl,int cacheSize){
            this.ttl = ttl;
            this.cacheSize = cacheSize;
        }
    }

    @Bean
    @Primary
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<CaffeineCache> caches = new ArrayList<>();
        for (Caches cache : Caches.values()) {
            caches.add(new CaffeineCache(cache.name(), Caffeine.newBuilder()
                    .recordStats().expireAfterWrite(cache.ttl, TimeUnit.SECONDS)
                    .maximumSize(cache.cacheSize).build()));
        }
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
