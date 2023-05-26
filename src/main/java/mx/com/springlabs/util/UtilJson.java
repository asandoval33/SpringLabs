package mx.com.springlabs.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class UtilJson {

    public static void main(String[] args) {

    }

    public static String modeltoJson(Object valueType, boolean aceptNulls) {
        try {
            if (aceptNulls) {
                return new JsonMapper().writeValueAsString(valueType);
            } else {
                return new JsonMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)
                        //.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(valueType);
            }
        } catch (JsonProcessingException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public static <T> T jsonToModel(String content, Class<T> valueType) {
        try {
            return new JsonMapper().readValue(content, valueType);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}
