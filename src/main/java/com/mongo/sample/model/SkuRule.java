package com.mongo.sample.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "sku" })
public class SkuRule {
    private String sku;
    private List<DispersionTarget> targets;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<DispersionTarget> getTargets() {
        return targets;
    }

    public void setRules(List<DispersionTarget> targets) {
        this.targets = targets;
    }

    public SkuRule() {
    }

    @Override
    public String toString() {
        return "SkuRule [sku=" + sku + ", targets=" + targets + "]";
    }
}
