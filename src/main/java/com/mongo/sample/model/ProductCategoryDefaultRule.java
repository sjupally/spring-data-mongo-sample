package com.mongo.sample.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "productCategory" })
public class ProductCategoryDefaultRule {
    private String productCategory;
    private List<DispersionTarget> targets;

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public List<DispersionTarget> getTargets() {
        return targets;
    }

    public void setRules(List<DispersionTarget> targets) {
        this.targets = targets;
    }

    public ProductCategoryDefaultRule() {
    }

    @Override
    public String toString() {
        return "ProductCategoryDefaultRule [productCategory=" + productCategory
                + ", targets=" + targets + "]";
    }
}
