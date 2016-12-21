package com.mongo.sample.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "promotionId", "ignore" })
public class PromotionEntry {
    private Long promotionId = null;
    private Long accountPromotionId = null;
    private String promotionName = null;
    private List<String> errors = Collections.emptyList();

    public PromotionEntry() {
    }

    public PromotionEntry(String promotionName) {
        super();
        this.promotionName = promotionName;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public Long getAccountPromotionId() {
        return accountPromotionId;
    }

    public void setAccountPromotionId(Long accountPromotionId) {
        this.accountPromotionId = accountPromotionId;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        if (errors == null) {
            this.errors = Collections.emptyList();
        } else {
            this.errors = new ArrayList<String>(errors);
        }
    }

    @Override
    public String toString() {
        return "PromotionEntry [promotionId=" + promotionId + ", accountPromotionId=" + accountPromotionId
                + ", promotionName=" + promotionName + ", errors=" + errors + "]";
    }
}
