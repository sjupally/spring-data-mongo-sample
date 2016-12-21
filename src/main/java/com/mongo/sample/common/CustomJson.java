package com.mongo.sample.common;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;

/**
 * © Copyright 2013 Snapfish LLC
 */
public interface CustomJson {

    @JsonAnyGetter
    Map<String, Object> getProperties();

    @JsonAnySetter
    void setProperty(String name, Object value);

}
