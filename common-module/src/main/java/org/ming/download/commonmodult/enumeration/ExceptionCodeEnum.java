package org.ming.download.commonmodult.enumeration;

/**
 * 异常信息枚举
 *
 * @author MingXiangjun
 * @create 2018-09-18 21:08
 */
public enum ExceptionCodeEnum {
    PARAMETER_EMPTY("1001","空参数"),
    PARAMETER_HUGE("1002","大参数异常");
    String code;
    String message;
    ExceptionCodeEnum(String code,String message){
        this.code = code;
        this.message = message;
    }
}
