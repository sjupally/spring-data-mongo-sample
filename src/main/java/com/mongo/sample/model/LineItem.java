package com.mongo.sample.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * © Copyright 2012 Snapfish LLC
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "skuTitle", "status", "trackingId", "shipper", "vendor", "fulfillmentLocation", "manifestId",
        "skuId", "skuInfo", "deliveryEstimate", "projectId", "quantity", "vendor", "lineItemId", "subscriptionId" , "sourceGroup"})
public class LineItem extends Refundable {
    protected long lineItemId;
    protected String skuId;
    protected String projectId;
    protected int quantity;
    protected String vendor;
    protected Long subscriptionId = 0L;
    protected int priceLevel;
    protected List<LineItemOption> lineItemOptions = new ArrayList<LineItemOption>();
    protected List<RefundPojo> refunds = new ArrayList<RefundPojo>();
    protected TaxInfo taxInfo = new TaxInfo();

    // Line item status/detail info
    private Object status;
    private String trackingId;
    private String shipper;
    private String fulfillmentLocation;
    private String manifestId;
    private String workOrderId;
    private String skuTitle;
    private Failure lastFailure;
    private String sourceGroup ;
    private Integer retryCount = 0;
    private Integer failureCount = 0;
    private Collection<Metadata> metadata = new ArrayList<>();
    
    // For composite cart service only, defaulting them to null values as they should not come in non composite services  
    public ShippingPriceGroup deliveryEstimate = null;

    public LineItem() {
    }

    public LineItem(long lineItemId, String sku) {
        this.lineItemId = lineItemId;
        this.skuId = sku;
    }

    // this is only used during testing
    public LineItem(long id) {
        lineItemId = id;
    }

    // this is only used during testing
    public LineItem(long id, List<LineItemOption> options) {
        lineItemId = id;
        this.lineItemOptions = options;
    }

    public LineItem(long lineItemId, String skuId, String projectId, int quantity, String vendor) {
        super();
        init(lineItemId, skuId, projectId, quantity, vendor);
    }

    public LineItem(Priceable priceable, long lineItemId, String skuId, String projectId, int quantity, String vendor) {
        super(priceable);
        init(lineItemId, skuId, projectId, quantity, vendor);
    }

    protected void copyPricingData(LineItem lineItem) {
        this.setProductDiscount(lineItem.getProductDiscount());
        this.setProductTax(lineItem.getProductTax());
        this.setProductTotal(lineItem.getProductTotal());
        this.setShippingDiscount(lineItem.getShippingDiscount());
        this.setShippingTax(lineItem.getShippingTax());
        this.setShippingTotal(lineItem.getShippingTotal());
        this.setTotalRefund(lineItem.getTotalRefund());
    }

    private void init(long lineItemId, String skuId, String projectId, int quantity, String vendor) {
        this.lineItemId = lineItemId;
        this.skuId = skuId;
        this.projectId = projectId;
        this.quantity = quantity;
        this.vendor = vendor;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(long lineItemId) {
        this.lineItemId = lineItemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public int getPriceLevel() {
        return priceLevel;
    }

    /**
     * An int 0-n (usually 0=good, 1=better, 2=best, 3=bestplus
     */
    public void setPriceLevel(int priceLevel) {
        this.priceLevel = priceLevel;
    }

    public List<LineItemOption> getLineItemOptions() {
        return this.lineItemOptions;
    }

    public void setLineItemOptions(List<LineItemOption> lineItemOptions) {
        if (lineItemOptions != null) {
            this.lineItemOptions = new ArrayList<LineItemOption>(lineItemOptions);
        } else {
            this.lineItemOptions = new ArrayList<LineItemOption>();
        }
    }

    public void addLineItemOption(LineItemOption newOption) {
        if (lineItemOptions == null) {
            lineItemOptions = new ArrayList<LineItemOption>();
        }
        lineItemOptions.add(newOption);
    }

    @JsonIgnore
    public List<RefundPojo> getRefunds() {
        return refunds == null ? new ArrayList<RefundPojo>() : refunds;
    }

    /**
     * I had to do this because jackson doesn't know how to deserialize the supertype (RefundPojo)
     */
    @SuppressWarnings("unchecked")
    @JsonProperty("refunds")
    public List<LineItemRefundPojo> getLineItemRefunds() {
        return (List<LineItemRefundPojo>) (refunds == null ? new ArrayList<LineItemRefundPojo>() : refunds);
    }

    public void setRefunds(List<RefundPojo> refunds) {
        if (refunds != null) {
            this.refunds = new ArrayList<RefundPojo>(refunds);
        } else {
            this.refunds = new ArrayList<RefundPojo>();
        }
    }

    public void addRefund(LineItemRefundPojo refund) {

        if (this.refunds == null) {
            this.refunds = new ArrayList<RefundPojo>();
        }
        this.refunds.add(refund);
    }

    public TaxInfo getTaxInfo() {
        return taxInfo;
    }

    public void setTaxInfo(TaxInfo taxInfo) {
        if (taxInfo != null)
            this.taxInfo = taxInfo;
        else
            this.taxInfo = new TaxInfo();
    }
    

    public ShippingPriceGroup getDeliveryEstimate() {
		return deliveryEstimate;
	}

	public void setDeliveryEstimate(ShippingPriceGroup deliveryEstimate) {
		this.deliveryEstimate = deliveryEstimate;
	}

	public LineItemOption findLineItemOption(long id) {
        for (LineItemOption option : lineItemOptions) {
            if (option.getLineItemOptionId() == id)
                return option;
        }
        return null;
    }

    public void initInternalIds(RequestSettings settings) {
        //setLineItemId(CartServiceOidDispenser.sGetNextOid(settings, "lineItem"));
        List<LineItemOption> options = getLineItemOptions();
        if (options != null) {
            for (LineItemOption option : options) {
                //option.initInternalIds(settings);
            }
        }
    }

    public void initInternalIds(RequestSettings settings, LineItem prev) {
        List<LineItemOption> lineItemOptions = getLineItemOptions();
        if (lineItemOptions != null) {
            Set<Long> ids = new HashSet<Long>();
            for (LineItemOption option : lineItemOptions) {
                long id = option.getLineItemOptionId();
                LineItemOption prevOption = prev.findLineItemOption(id);
                if (prevOption == null || ids.contains(id)) {
                    // no matching lineItemOption in this lineItem... give a new id
                    //option.initInternalIds(settings);
                } else {
                    ids.add(id);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "LineItem [lineItemId=" + lineItemId + ", skuId=" + skuId + ", projectId=" + projectId + ", quantity="
                + quantity + ", vendor=" + vendor + ", subscriptionId=" + subscriptionId + ", priceLevel=" + priceLevel
                + ", refunds=" + refunds + ", taxInfo=" + taxInfo + ", status=" + status + ", metadata=" + metadata
                + " " + super.toString() + ", lineItemOptions=" + lineItemOptions + ", sourceGroup="+ sourceGroup+"]";
    }

    public void setSourceGroup(String s){
        sourceGroup = s ;
    }
    public String getSourceGroup() {
        return sourceGroup ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (int) (lineItemId ^ (lineItemId >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        LineItem other = (LineItem) obj;
        if (lineItemId != other.lineItemId)
            return false;
        return true;
    }

    @Override
    @JsonIgnore
    public Long getItemId() {
        return getLineItemId();
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getFulfillmentLocation() {
        return fulfillmentLocation;
    }

    public void setFulfillmentLocation(String fulfillmentLocation) {
        this.fulfillmentLocation = fulfillmentLocation;
    }

    public String getManifestId() {
        return manifestId;
    }

    public void setManifestId(String manifestId) {
        this.manifestId = manifestId;
    }

    public String getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getSkuTitle() {
        return skuTitle;
    }

    public void setSkuTitle(String skuTitle) {
        this.skuTitle = skuTitle;
    }

    public Failure getLastFailure() {
        return lastFailure;
    }

    public void setLastFailure(Failure lastFailure) {
        this.lastFailure = lastFailure;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public Integer getFailureCount() {
        return failureCount;
    }

    public void setFailureCount(Integer failureCount) {
        this.failureCount = failureCount;
    }

    public Collection<Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(Collection<Metadata> metadata) {
        this.metadata = metadata;
    }

}
