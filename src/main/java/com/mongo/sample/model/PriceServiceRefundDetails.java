package com.mongo.sample.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"promotionId", "quantity"})
public class PriceServiceRefundDetails {

    private Long promotionId;

    private Integer quantity;

    public PriceServiceRefundDetails () {}

    public PriceServiceRefundDetails(Long promotionId, Integer quantity) {
        this.promotionId = promotionId;
        this.quantity = quantity;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PriceServiceRefundDetails))
            return false;
        PriceServiceRefundDetails that = (PriceServiceRefundDetails) o;
        return (this.promotionId.equals(that.promotionId) && this.quantity.equals(that.quantity)) ? true : false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + promotionId.hashCode();
        result = 31 * result + quantity.hashCode();
        return result;
    }

}
