package com.mongo.sample.model;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscountDetail {
    private String promotionName;
    private Long promotionId;
    private Long accountPromotionId;
    private Integer discountQty = 0;
    private BigDecimal discountAmount = BigDecimal.ZERO;
    
    public DiscountDetail() {}
    
    public DiscountDetail(DiscountDetail that) {
        this.promotionName = that.promotionName;
        this.promotionId = that.promotionId;
        this.accountPromotionId = that.accountPromotionId;
        this.discountAmount = that.discountAmount;
        this.discountQty = that.discountQty;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public Integer getDiscountQty() {
        return discountQty;
    }

    public void setDiscountQty(Integer qty) {
        if (qty == null)
            this.discountQty = 0;
        else
            this.discountQty = qty;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal amount) {
        if (amount == null)
            this.discountAmount = BigDecimal.ZERO;
        else
            this.discountAmount = amount;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Long getAccountPromotionId() {
        return accountPromotionId;
    }

    public void setAccountPromotionId(Long accountPromotionId) {
        this.accountPromotionId = accountPromotionId;
    }

    @Override
    public String toString() {
        return "DiscountDetail [promotionName=" + promotionName + ", promotionId=" + promotionId
                + ", accountPromotionId=" + accountPromotionId + ", discountAmount=" + discountAmount
                + ", discountAmount=" + discountAmount + "]";
    }

}
