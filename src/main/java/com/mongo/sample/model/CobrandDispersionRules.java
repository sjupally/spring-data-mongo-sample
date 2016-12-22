package com.mongo.sample.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "cobrand", "vendors", "distributionPreference",
        "couponRules", "shippingAddressRules", "categoryDefaultRules",
        "skuRules", "advRules" })
public class CobrandDispersionRules {
    public enum DistributionPreference {
        random, regional, closestVendor
    }
    
    private String cobrand;
    private List<String> vendors;
    private DistributionPreference distributionPreference = DistributionPreference.random;
    private List<CouponRule> couponRules;
    private List<ShippingAddressRule> shippingAddressRules;
    private List<ProductCategoryDefaultRule> productCategoryDefaultRules;
    private List<SkuRule> skuRules;
    private List<AdvanceRule> advRules;

    public String getCobrand() {
        return cobrand;
    }

    public void setCobrand(String cobrand) {
        this.cobrand = cobrand;
    }

    public List<String> getVendors() {
        return vendors;
    }

    public void setVendors(List<String> vendors) {
        this.vendors = vendors;
    }

    public DistributionPreference getDistributionPreference() {
        return distributionPreference;
    }

    public void setDistributionPreference(DistributionPreference distributionPreference) {
        this.distributionPreference = distributionPreference;
    }

    public List<CouponRule> getCouponRules() {
        return couponRules;
    }

    public void setCouponRules(List<CouponRule> couponRules) {
        this.couponRules = couponRules;
    }

    public List<ShippingAddressRule> getShippingAddressRules() {
        return shippingAddressRules;
    }

    public void setShippingAddressRules(
            List<ShippingAddressRule> shippingAddressRules) {
        this.shippingAddressRules = shippingAddressRules;
    }

    public List<ProductCategoryDefaultRule> getProductCategoryDefaultRules() {
        return productCategoryDefaultRules;
    }

    public void setProductCategoryDefaultRules(
            List<ProductCategoryDefaultRule> categoryDefaultRules) {
        this.productCategoryDefaultRules = categoryDefaultRules;
    }

    public List<SkuRule> getSkuRules() {
        return skuRules;
    }

    public void setSkuRules(List<SkuRule> skuRules) {
        this.skuRules = skuRules;
    }

    public List<AdvanceRule> getAdvRules() {
		return advRules;
	}

	public void setAdvRules(List<AdvanceRule> advRules) {
		this.advRules = advRules;
	}

	public CobrandDispersionRules() {
    }

    public CobrandDispersionRules(String cobrand,
            DistributionPreference distributionPreference, List<CouponRule> couponRules,
            List<ShippingAddressRule> shippingAddressRules,
            List<ProductCategoryDefaultRule> categoryDefaultRules,
            List<SkuRule> skuRules, List<AdvanceRule> advRules) {
        this.cobrand = cobrand;
        this.distributionPreference = distributionPreference;
        this.couponRules = couponRules;
        this.shippingAddressRules = shippingAddressRules;
        this.productCategoryDefaultRules = categoryDefaultRules;
        this.skuRules = skuRules;
        this.advRules = advRules;
    }

    public SkuRule getMatchingSkuRule(String sku) {
        for (SkuRule rule : skuRules) {
            if (rule.getSku().equals(sku)) {
                return rule;
            }
        }
        return null;
    }

    public ProductCategoryDefaultRule getMatchingProductCategoryDefaultRule(
            String category) {
        for (ProductCategoryDefaultRule rule : productCategoryDefaultRules) {
            if (rule.getProductCategory().equals(category)) {
                return rule;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "CobrandDispersionRules [cobrand=" + cobrand
                + ", distributionPreference=" + distributionPreference
                + ", couponRules=" + couponRules + ", shippingAddressRules="
                + shippingAddressRules + ", productCategoryDefaultRules="
                + productCategoryDefaultRules + ", skuRules=" + skuRules + ", advanceRules="+ advRules +"]";
    }

    public boolean regionalPreference() {
        return distributionPreference == DistributionPreference.regional;
    }

}
