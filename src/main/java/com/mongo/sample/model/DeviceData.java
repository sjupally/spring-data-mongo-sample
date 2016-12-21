package com.mongo.sample.model;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.common.CustomJson;

/**
 * © Copyright 2013 Snapfish LLC
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DeviceData implements CustomJson {
    private Map<String, Object> jsonMap = new HashMap<String, Object>();
    private String device_session_id;
    private String fraud_merchant_id;
    private String correlation_id;

    @Override
    public Map<String, Object> getProperties() {
        return this.jsonMap;
    }

    @Override
    public void setProperty(String key, Object value) {
        getProperties().put(key, value);
    }

    public String getDevice_session_id() {
        return device_session_id;
    }

    public void setDevice_session_id(String device_session_id) {
        this.device_session_id = device_session_id;
    }

    public String getFraud_merchant_id() {
        return fraud_merchant_id;
    }

    public void setFraud_merchant_id(String fraud_merchant_id) {
        this.fraud_merchant_id = fraud_merchant_id;
    }

    public String getCorrelation_id() {
        return correlation_id;
    }

    public void setCorrelation_id(String correlation_id) {
        this.correlation_id = correlation_id;
    }

}
