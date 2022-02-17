package com.cloud.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>创建日期: 2020/8/7 11:32</p>
 * <p>创建作者：wzk</p>
 * <p>功能：json工具类</p>
 */
public class JsonUtils {

    private static final ObjectMapper objectMapper;


    static {
        objectMapper = new ObjectMapper();
        // 属性为Null的不进行序列化，只对pojo起作用，对map和list不起作用
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //反序列化的时候如果多了其他属性,不抛出异常
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 将json转为jsonNode
     *
     * @param jsonStr 需要转换的json字符串
     * @return 转换后的JsonNode
     */
    public static JsonNode toJsonNode(String jsonStr) {
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(jsonStr);
        } catch (Exception e) {
            throw new RuntimeException("json 解析异常");
        }
        return jsonNode;
    }


    /**
     * 将对象转为json字符串
     *
     * @param o 需要转换的对象
     * @return 转换后的json字符串
     */
    public static String objectToJsonStr(Object o) {
        String jsonStr;
        try {
            jsonStr = objectMapper.writeValueAsString(o);
        } catch (Exception e) {
            throw new RuntimeException("json 解析异常");
        }
        return jsonStr;
    }

    /**
     * 将对象转为json字符串
     *
     * @param jsonNode 需要转换的jsonNode
     * @return 转换后的json字符串
     */
    public static String jsonNodeToJsonStr(JsonNode jsonNode) {
        String jsonStr;
        try {
            jsonStr = objectMapper.writeValueAsString(jsonNode);
        } catch (Exception e) {
            throw new RuntimeException("json 解析异常");
        }
        return jsonStr;
    }


    /**
     * 将json字符串转为对象
     *
     * @param jsonStr json 字符串
     * @param <T>     需要转换的类型
     * @return 转换后的对象
     */
    public static <T> T strToObject(String jsonStr, TypeReference<T> valueTypeRef) {
        T o;
        try {
            o = objectMapper.readValue(jsonStr, valueTypeRef);
        } catch (Exception e) {
            throw new RuntimeException("json 解析异常");
        }
        return o;
    }

    /**
     * 将jsonNode转为对象
     *
     * @param jsonNode  需要转换的jsonNode
     * @param valueType 需要转换的类
     * @param <T>       需要转换的类型
     * @return 转换后的对象
     */
    public static <T> T jsonNodeToObject(JsonNode jsonNode, Class<T> valueType) {
        T o;
        try {
            o = objectMapper.treeToValue(jsonNode, valueType);
        } catch (Exception e) {
            throw new RuntimeException("json 解析异常");
        }
        return o;
    }
}
