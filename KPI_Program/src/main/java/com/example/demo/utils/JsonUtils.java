package com.example.demo.utils;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

/**
 * Created by WZB on 2017/7/13.
 *
 * 操作Json格式的数据
 */
public class JsonUtils {

    /**
     * 将对象转换为JSON字符串
     *
     * @param bean 可以是基本的 object 或 数组
     * @return JSON字符串
     */
    public static String getJsonData(Object bean) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(bean);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将json格式的字符串转化为Bean对象
     */
    public static <T> T jsonStringToBean(String jsonStr, Class<T> clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonStr, clazz);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将json格式的字符串（数组形式）的转化为List对象
     * @param <T>
     * @param jsonArrStr
     * @param clazz	List中对象类型
     * @return
     */
    public static <T> List<T> jsonStringToList(String jsonArrStr, Class<T> clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, clazz);
            return mapper.readValue(jsonArrStr, javaType);
        } catch (Exception e) {
            return null;
        }
    }
}
