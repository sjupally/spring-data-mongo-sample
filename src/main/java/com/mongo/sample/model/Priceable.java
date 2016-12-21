package com.mongo.sample.model;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({ "productTotal", "productTax", "productDiscount", "productDetails", "shippingTotal", "shippingTax",
    "shippingDiscount", "shippingDetails" })
public abstract class Priceable {
    protected BigDecimal productTotal = BigDecimal.ZERO;
    protected BigDecimal productTax = BigDecimal.ZERO;
    private DiscountEntry productDiscount = new DiscountEntry();
    private YodaRefundItemBean productDetails;
    protected BigDecimal shippingTotal = BigDecimal.ZERO;
    protected BigDecimal shippingTax = BigDecimal.ZERO;
    private DiscountEntry shippingDiscount = new DiscountEntry();
    private YodaRefundItemBean shippingDetails;

    public Priceable() {
        super();
    }

    public Priceable(BigDecimal productTotal, BigDecimal productTax, BigDecimal productDiscount,
            YodaRefundItemBean productDetails, BigDecimal shippingTotal, BigDecimal shippingTax,
            BigDecimal shippingDiscount, YodaRefundItemBean shippingDetails) {
        super();
        this.productTotal = productTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.productTax = productTax.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.productDiscount.setTotalDiscount(productDiscount.setScale(2, BigDecimal.ROUND_HALF_UP));
        this.productDetails = productDetails;
        this.shippingTotal = shippingTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.shippingTax = shippingTax.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.shippingDiscount.setTotalDiscount(shippingDiscount.setScale(2, BigDecimal.ROUND_HALF_UP));
        this.shippingDetails = shippingDetails;
    }

    public Priceable(Priceable that) {
        super();
        this.productTotal = that.productTotal;
        this.productTax = that.productTax;
        this.productDiscount = that.productDiscount;
        this.productDetails = that.productDetails;
        this.shippingTotal = that.shippingTotal;
        this.shippingTax = that.shippingTax;
        this.shippingDiscount = that.shippingDiscount;
        this.shippingDetails = that.shippingDetails;
    }

    public BigDecimal getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(BigDecimal productTotal) {
        this.productTotal = productTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getProductTax() {
        return productTax;
    }

    public void setProductTax(BigDecimal productTax) {
        this.productTax = productTax.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public DiscountEntry getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(DiscountEntry productDiscount) {
        if (productDiscount == null)
            this.productDiscount = new DiscountEntry();
        else
            this.productDiscount = productDiscount;
    }

    public BigDecimal getShippingTotal() {
        return shippingTotal;
    }

    public void setShippingTotal(BigDecimal shippingTotal) {
        this.shippingTotal = shippingTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getShippingTax() {
        return shippingTax;
    }

    public void setShippingTax(BigDecimal shippingTax) {
        this.shippingTax = shippingTax.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public DiscountEntry getShippingDiscount() {
        return shippingDiscount;
    }

    public void setShippingDiscount(DiscountEntry shippingDiscount) {
        this.shippingDiscount = shippingDiscount == null ? new DiscountEntry() : shippingDiscount;
    }

    public BigDecimal totalCharges() {
        return productTotal.add(productTax).add(shippingTotal).add(shippingTax);
    }

    public BigDecimal totalDiscounts() {
        return productDiscount.getTotalDiscount().add(shippingDiscount.getTotalDiscount());
    }

    public BigDecimal totalTax() {
        return productTax.add(shippingTax);
    }

    public BigDecimal discountedTotal() {
        return totalCharges().subtract(totalDiscounts());
    }

    public YodaRefundItemBean getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(YodaRefundItemBean productDetails) {
        this.productDetails = productDetails;
    }

    public YodaRefundItemBean getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(YodaRefundItemBean shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productDiscount == null) ? 0 : productDiscount.hashCode());
        result = prime * result + ((productTax == null) ? 0 : productTax.hashCode());
        result = prime * result + ((productTotal == null) ? 0 : productTotal.hashCode());
        result = prime * result + ((shippingDiscount == null) ? 0 : shippingDiscount.hashCode());
        result = prime * result + ((shippingTax == null) ? 0 : shippingTax.hashCode());
        result = prime * result + ((shippingTotal == null) ? 0 : shippingTotal.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Priceable other = (Priceable) obj;
        if (productDiscount == null) {
            if (other.productDiscount != null) return false;
        } else if (!productDiscount.getTotalDiscount().equals(other.productDiscount.getTotalDiscount())) return false;
        if (productTax == null) {
            if (other.productTax != null) return false;
        } else if (!productTax.equals(other.productTax)) return false;
        if (productTotal == null) {
            if (other.productTotal != null) return false;
        } else if (!productTotal.equals(other.productTotal)) return false;
        if (shippingDiscount == null) {
            if (other.shippingDiscount != null) return false;
        } else if (!shippingDiscount.getTotalDiscount().equals(other.shippingDiscount.getTotalDiscount()))
            return false;
        if (shippingTax == null) {
            if (other.shippingTax != null) return false;
        } else if (!shippingTax.equals(other.shippingTax)) return false;
        if (shippingTotal == null) {
            if (other.shippingTotal != null) return false;
        } else if (!shippingTotal.equals(other.shippingTotal)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Priceable [productTotal=" + productTotal + ", productTax=" + productTax + ", productDiscount="
            + productDiscount + ", productDetails=" + productDetails + ", shippingTotal=" + shippingTotal
            + ", shippingTax=" + shippingTax + ", shippingDiscount=" + shippingDiscount + ", shippingDetails="
            + shippingDetails + "]";
    };
}
