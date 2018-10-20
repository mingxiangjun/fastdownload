package org.ming.download.servicemodule.enums;

import lombok.Getter;

/**
 * CacheNames.java CacheName枚举
 * @author MingXiangjun
 * @create 2018/10/20-17:08
 */
@Getter
public enum CacheNames {
    /**
     *  账号信息Cache
     */
    ACCOUNT("ACCOUNT"),
    /**
     * 用户信息Cache
     */
    USER_INFO("USER_INFO");
    String cacheName;
    CacheNames(String cacheName){
        this.cacheName=cacheName;
    }
}
