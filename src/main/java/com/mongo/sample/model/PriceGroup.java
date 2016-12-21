package com.mongo.sample.model;

import java.util.Date;
import java.util.List;
import java.util.SortedSet;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PriceGroup implements Comparable<PriceGroup> {
    
    private Date effectiveDate;
    private Date endEffectiveDate;
    private String priceModel;
    private String deliveryMethod;
    private List<String> sourceGroup;
    private Boolean salePrice;
    private Integer shippingTimeMin;
    private Integer shippingTimeMax;
    private String soldAs;
    private Integer minimumPurchaseQuantity;
    private Integer maximumDisplayQuantity;
    private Boolean defaultDeliveryOption;
    private SortedSet<Tier> tiers;
    
    public PriceGroup() {
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getEndEffectiveDate() {
        return endEffectiveDate;
    }

    public void setEndEffectiveDate(Date endEffectiveDate) {
        this.endEffectiveDate = endEffectiveDate;
    }

    public String getPriceModel() {
        return priceModel;
    }

    public void setPriceModel(String priceModel) {
        this.priceModel = priceModel;
    }

    public Boolean getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Boolean salePrice) {
        this.salePrice = salePrice;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public List<String> getSourceGroup() {
        return sourceGroup;
    }

    public void setSourceGroup(List<String> sourceGroup) {
        this.sourceGroup = sourceGroup;
    }

    public Integer getShippingTimeMin() {
        return shippingTimeMin;
    }

    public void setShippingTimeMin(Integer shippingTimeMin) {
        this.shippingTimeMin = shippingTimeMin;
    }

    public Integer getShippingTimeMax() {
        return shippingTimeMax;
    }

    public void setShippingTimeMax(Integer shippingTimeMax) {
        this.shippingTimeMax = shippingTimeMax;
    }

    public String getSoldAs() {
        return soldAs;
    }

    public void setSoldAs(String soldAs) {
        this.soldAs = soldAs;
    }

    public Integer getMinimumPurchaseQuantity() {
        return minimumPurchaseQuantity;
    }

    public void setMinimumPurchaseQuantity(Integer minimumPurchaseQuantity) {
        this.minimumPurchaseQuantity = minimumPurchaseQuantity;
    }

    public Integer getMaximumDisplayQuantity() {
        return maximumDisplayQuantity;
    }

    public void setMaximumDisplayQuantity(Integer maximumDisplayQuantity) {
        this.maximumDisplayQuantity = maximumDisplayQuantity;
    }

    public Boolean getDefaultDeliveryOption() {
		return defaultDeliveryOption;
	}

	public void setDefaultDeliveryOption(Boolean defaultDeliveryOption) {
		this.defaultDeliveryOption = defaultDeliveryOption;
	}

	public SortedSet<Tier> getTiers() {
        return tiers;
    }

    public void setTiers(SortedSet<Tier> tiers) {
        this.tiers = tiers;
    }
   
    @Override
    public int compareTo(PriceGroup group2) {   
        //sort price groups by sourceGroup first, then latest date; if effectiveDates are the same, sort by
        //endEffectiveDate.  A null endEffectiveDate is later than a non-null endEffectiveDate.
        if (((group2.getSourceGroup() == null) && (this.getSourceGroup() == null)) || //both source groups are null or both are non-null and equal
            ((group2.getSourceGroup() != null) && (this.getSourceGroup() != null) && (group2.getSourceGroup().hashCode() == this.getSourceGroup().hashCode()))) {
            if (group2.getEffectiveDate().equals(this.effectiveDate)) {
                if ((group2.getEndEffectiveDate() == null) && (this.endEffectiveDate == null)) {
                    return 0;
                }
                if ((group2.getEndEffectiveDate() == null) && (this.endEffectiveDate != null)) {
                    return 1;
                }
                if ((group2.getEndEffectiveDate() != null) && (this.endEffectiveDate == null)) {
                    return -1;
                }
                return group2.getEndEffectiveDate().compareTo(this.endEffectiveDate);
            }
        } else {    //one of the source groups is non-null or the source groups are not equal
            if (group2.getSourceGroup() == null) {
                return 1;
            }
            if (this.getSourceGroup() == null) {
                return -1;
            }
            return group2.getSourceGroup().hashCode() - this.getSourceGroup().hashCode();
        }
                
        return group2.getEffectiveDate().compareTo(this.effectiveDate);
    }

}
