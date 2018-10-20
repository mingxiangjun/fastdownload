package org.ming.download.servicemodule.annotations;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义Cache存入
 * @author Mingxiangjun
 * @date 14点35分
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomCacheable {
    @AliasFor(value = "cacheNames")
    String[] value() default "account";
    @AliasFor(value = "values")
    String[] cacheNames() default "account";

    String key() default "";

    String cacheManager() default "";
}
