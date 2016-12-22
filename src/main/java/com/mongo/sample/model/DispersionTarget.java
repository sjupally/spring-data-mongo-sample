package com.mongo.sample.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "vendor", "volume" })
public class DispersionTarget {
    public static final String UNASSIGNED_VENDOR = "*";
    private String vendor;
    private String volume;
    
    public DispersionTarget() {
    }

    public DispersionTarget(String vendor, String volume) {
        this.vendor = vendor;
        this.volume = volume;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "DispersionRule [vendor=" + vendor + ", volume=" + volume + "]";
    }
}
