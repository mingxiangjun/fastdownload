package org.ming.download.commonmodult.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * 结果集类
 *
 * @author MingXiangjun
 * @create 2018-09-18 21:04
 */
public class ResultJsonUtil extends HashMap {
    private static final String CODE_KEY = "code";
    private static final String DATA_KEY = "data";
    private static final String MESSAGE_KEY = "message";

    public static ResultJsonUtil success() {
        ResultJsonUtil result = new ResultJsonUtil();
        result.put(CODE_KEY, 0);
        result.put(MESSAGE_KEY, "success");
        return result;
    }

    public static ResultJsonUtil success(String message) {
        ResultJsonUtil result = new ResultJsonUtil();
        result.put(CODE_KEY, 0);
        result.put(MESSAGE_KEY, message);
        return result;
    }

    public static ResultJsonUtil failed() {
        ResultJsonUtil result = new ResultJsonUtil();
        result.put(CODE_KEY, -1);
        result.put(MESSAGE_KEY, "failed");
        return result;
    }

    public static ResultJsonUtil failed(String message) {
        ResultJsonUtil result = new ResultJsonUtil();
        result.put(CODE_KEY, -1);
        result.put(MESSAGE_KEY, message);
        return result;
    }

    public ResultJsonUtil message(String message) {
        this.set(MESSAGE_KEY, message);
        return this;
    }

    public ResultJsonUtil data(Object data) {
        this.set(DATA_KEY, data);
        return this;
    }

    public ResultJsonUtil set(String key, Object value) {
        this.put(key, value);
        return this;
    }

    public boolean isSuccess() {
        return (Integer.parseInt(get(CODE_KEY).toString())) == 0;
    }

    public boolean isFailed() {
        return !isSuccess();
    }

    public JSONObject toJson(){
        return JSONObject.parseObject(this.toString());
    }
}
