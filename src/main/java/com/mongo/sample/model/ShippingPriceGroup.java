package com.mongo.sample.model;

import java.util.Date;
import java.util.SortedSet;
import java.util.TreeMap;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.common.ResourcePojo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ShippingPriceGroup extends AbstractResourcePojo 
implements ResourcePojo {
    private String _id;
    private String name;
    private String cobrand;
    private String retailer;
    private String retailerId;
    private String context;
    private Date updateDate;
    private String timeZone;
    private Integer processingTimeMin;
    private Integer processingTimeMax;
    private TreeMap<String, SortedSet<PriceGroup>> deliveryOptions;
    
    public ShippingPriceGroup() {
        
    }

    @Override
    public String get_id() {
        return _id;
    }

    @Override
    public void set_id(Object id) {
        this._id = (String) id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCobrand() {
        return cobrand;
    }

    public void setCobrand(String cobrand) {
        this.cobrand = cobrand;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public String getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Integer getProcessingTimeMin() {
        return processingTimeMin;
    }

    public void setProcessingTimeMin(Integer processingTimeMin) {
        this.processingTimeMin = processingTimeMin;
    }

    public Integer getProcessingTimeMax() {
        return processingTimeMax;
    }

    public void setProcessingTimeMax(Integer processingTimeMax) {
        this.processingTimeMax = processingTimeMax;
    }

    public TreeMap<String, SortedSet<PriceGroup>> getDeliveryOptions() {
        return deliveryOptions;
    }

    public void setDeliveryOptions(
            TreeMap<String, SortedSet<PriceGroup>> deliveryOptions) {
        this.deliveryOptions = deliveryOptions;
    }
    

}
