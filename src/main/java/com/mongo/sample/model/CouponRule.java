package com.mongo.sample.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "coupon" })
public class CouponRule {
    private String coupon;
    private List<DispersionTarget> targets;

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public List<DispersionTarget> getTargets() {
        return targets;
    }

    public void setTargets(List<DispersionTarget> targets) {
        this.targets = targets;
    }

    public CouponRule() {
    }

    @Override
    public String toString() {
        return "CouponRule [coupon=" + coupon + ", targets=" + targets + "]";
    }
}
