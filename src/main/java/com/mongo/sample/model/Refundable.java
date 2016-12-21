package com.mongo.sample.model;

import java.math.BigDecimal;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public abstract class Refundable extends Priceable {
    private BigDecimal totalRefund = BigDecimal.ZERO;
    private Integer totalRefundQuantity = null;
    private Integer totalRefundShippingQuantity = null;
    
    public Refundable() {
        super();
    }

    public Refundable(Priceable priceable) {
        super(priceable);
        this.totalRefund = totalRefund.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(BigDecimal totalRefund) {
        this.totalRefund = totalRefund.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    
    public Integer getTotalRefundQuantity() {
        return totalRefundQuantity;
    }

    public void setTotalRefundQuantity(Integer totalRefundQuantity) {
        this.totalRefundQuantity = totalRefundQuantity;
    }
    
    public Integer getTotalRefundShippingQuantity() {
        return totalRefundShippingQuantity;
    }

    public void setTotalRefundShippingQuantity(Integer totalRefundShippingQuantity) {
        this.totalRefundShippingQuantity = totalRefundShippingQuantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((totalRefund == null) ? 0 : totalRefund.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Refundable other = (Refundable) obj;
        if (totalRefund == null) {
            if (other.totalRefund != null) return false;
        } else if (!totalRefund.equals(other.totalRefund)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Refundable [" + super.toString() + " totalRefund=" + totalRefund + "]";
    }

    @JsonIgnore
    public abstract Long getItemId();

    public abstract List<RefundPojo> getRefunds();
}
