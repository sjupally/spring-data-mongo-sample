package com.mongo.sample.common;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * © Copyright 2012 Snapfish LLC
 */
public class JsonMongoIdSerializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
            JsonProcessingException {
        if (value == null) {
            return;
        }
        if (value instanceof ObjectId) {
            ObjectId objectId = (ObjectId) value;
            jgen.writeString(objectId.toString());
            return;
        }
        if (value instanceof String) {
        	jgen.writeString(value.toString());
        	return;
        }
        if (isNumeric(value)) {
            jgen.writeNumber(Long.parseLong(value.toString()));
            return;
        }
        jgen.writeString(value.toString());
    }

    private static boolean isNumeric(Object str) {
        return str.toString().matches("-?\\d+(\\.\\d+)?");
    }
}
