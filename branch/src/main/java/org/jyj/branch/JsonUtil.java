package org.jyj.branch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private final static ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object object, boolean pretty) {
        String json;
        try {
            if (pretty) {
                json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            } else {
                json = mapper.writeValueAsString(object);
            }
        } catch (JsonProcessingException e) {
            json = "{}";
        }

        return json;

    }
}
