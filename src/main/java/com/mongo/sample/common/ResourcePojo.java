package com.mongo.sample.common;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;


/**
 * © Copyright 2012 Snapfish LLC
 */
public interface ResourcePojo {

    @JsonSerialize(using = JsonMongoIdSerializer.class)
    Object get_id();

    @JsonDeserialize(using = JsonMongoIdDeserializer.class)
    void set_id(Object id);
    
    String getPartner() ;
    void setPartner(String partner);
    
}
