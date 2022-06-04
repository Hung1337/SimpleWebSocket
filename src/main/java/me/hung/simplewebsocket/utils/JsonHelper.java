package me.hung.simplewebsocket.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Danila Avdeyenko
 * @date 04.06.2022 | 13:08
 */
public class JsonHelper {

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public static <T> String toJson(T object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

    public static <T> Object toObject(String json, T clazz) throws IOException {
        return objectMapper.reader().readValue(json, (Class) clazz);
    }


}
