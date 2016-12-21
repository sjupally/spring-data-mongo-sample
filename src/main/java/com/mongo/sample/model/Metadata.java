package com.mongo.sample.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.constants.AttributeType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Metadata {
    String name;
    AttributeType metadataType;
    String value;

    public Metadata() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AttributeType getMetadataType() {
        return metadataType;
    }

    public void setMetadataType(AttributeType attributeType) {
        this.metadataType = attributeType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Metadata [name=" + name + ", metadataType=" + metadataType + ", value=" + value + "]";
    }
    
}