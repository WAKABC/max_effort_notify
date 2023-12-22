package com.wak.utils;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * @author wuankang
 * @version 1.0.0
 * @date 2023/11/05
 * @description TODO json工具类
 */
public class JsonUtil {

    /**
     * 获取指定key的json字符串
     *
     * @param srcJsonStr  源json
     * @param expectedKey 目标json的key
     * @return {@link String}
     */
    public static String getSpecifiedJsonStr(String srcJsonStr, String expectedKey) {
        // Parse the JSON string into a JSON object
        JSONObject jsonObject = JSONUtil.parseObj(srcJsonStr);
        // Get the value of the specified key
        String expectedValue = jsonObject.getStr(expectedKey);
        // Return the value if it is not empty, otherwise return an empty string
        return StrUtil.isBlank(expectedValue) ? expectedValue : "";
    }

    /**
     * Get the value of the specified key
     *
     * @param srcJsonStr  源json字符串
     * @param expectedKey 目标json的key
     * @param t           需要转换的Class
     * @return {@link T}
     */
    public static <T> T getSpecifiedObj(String srcJsonStr, String expectedKey, Class<T> t) {
        if (!StrUtil.isBlank(srcJsonStr) || !StrUtil.isBlank(expectedKey) || ObjUtil.isEmpty(t)) {
            throw new IllegalArgumentException("params has empty value, please check it");
        }
        // Parse the JSON string into a JSON object
        JSONObject jsonObject = JSONUtil.parseObj(srcJsonStr);
        // Get the value of the specified key
        String expectedValue = jsonObject.getStr(expectedKey);
        if (StrUtil.isEmpty(expectedValue)) {
            return null;
        }
        // Parse the JSON string into the specified type
        return JSONUtil.toBean(expectedValue, t);
    }
}
