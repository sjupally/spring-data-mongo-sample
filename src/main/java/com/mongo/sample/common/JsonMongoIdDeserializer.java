package com.mongo.sample.common;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

/**
 * © Copyright 2012 Snapfish LLC
 */
public class JsonMongoIdDeserializer extends JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException,
            JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        if (node.isObject()) {
            if (node.get("$oid") != null) {
                Object asText = node.get("$oid").asText();
                String oidString = asText.toString();
                ObjectId objectId = new ObjectId(oidString);
                return objectId;
            } else {
                throw new JsonParseException("Missing $oid in ObjectId object", jsonParser.getCurrentLocation());
            }
        }
        String value = node.asText();
        if (value == null) {
            return null;
        }
        if (value != null && ObjectId.isValid(value)) {
            return new ObjectId(value);
        }
        if (node.isTextual()) {
        	return value;
        }
        if (node.isLong()) {
            return new Long(value);
        }
        if (isNumeric(value)) {
        	return new Long(value);
        }
        return value;
    }

    private static boolean isNumeric(Object str) {
        return str.toString().matches("-?\\d+(\\.\\d+)?");
    }
}
