package com.mongo.sample.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.constants.DeliveryMethod;
import com.mongo.sample.constants.DeliveryOption;
import com.mongo.sample.model.StoreAddress.Store;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "status", "trackingId", "shipper", "vendorId", "fulfillmentLocation", "deliveryMethod",
    "deliveryOption", "shippingAddressId","shippingAddress", "storeId", "store", "shipBinId", "paymentStatus" })
public class ShipBin extends Refundable {
    long shipBinId;
    DeliveryOption deliveryOption = null;
    DeliveryMethod deliveryMethod = null;
    String shippingAddressId;
    ResubmitData resubmitData = null;
    ReorderData reorderData = null;
    VoidData voidData = null;
    

    Object status = null;
    Date stateChange = null;
    Date completeDate = null;
    String trackingId = null;
    String trackingUrl = null;
    String shipper = null;
    String fulfillmentLocation = null;
    String vendorId = null;
    String retailer = null;
    String storeId = null;
    String manifestId = null;
    String workOrderId = null;
    Failure lastFailure = null;
    Integer retryCount = null;
    Integer failureCount = null;
    Collection<Metadata> metadata = new ArrayList<>();
    List<LineItem> lineItems = new ArrayList<LineItem>();
    protected List<RefundPojo> refunds = new ArrayList<RefundPojo>();
    List<TaxInfo> taxInfo = new ArrayList<>();
    String invoiceRef;
    String paymentStatus = null;
    // for composite cart service
    Address shippingAddress = null;
    Store store = null;
    Date minEstimatedDeliveryDate = null;
    Date maxEstimatedDeliveryDate = null;
    Date deliveryDate = null;
    Collection<StatusHistoryEvent> statusHistory;
       
	public ShipBin() {
    }

    // this should only be used during testing
    public ShipBin(Long id) {
        shipBinId = id;
    }

    // this should only be used during testing
    public ShipBin(Long id, List<LineItem> lineItems) {
        init(id, lineItems, null, "");
    }

    public ShipBin(Long shipBinId, List<LineItem> lineItems, DeliveryMethod deliveryMethod, String shippingAddressId) {
        init(shipBinId, lineItems, deliveryMethod, shippingAddressId);
    }

    public ShipBin(Priceable priceable, Long shipBinId, List<LineItem> lineItems, DeliveryMethod deliveryMethod,
            String shippingAddressId) {
        super(priceable);
        init(shipBinId, lineItems, deliveryMethod, shippingAddressId);
    }

    public ShipBin(ShipBin that) {
        this.shipBinId = that.shipBinId;
        this.deliveryMethod = that.deliveryMethod;
        this.deliveryOption = that.deliveryOption;
        this.shippingAddressId = that.shippingAddressId;
        this.storeId = that.storeId;
        this.lineItems = that.lineItems;
        this.resubmitData = that.resubmitData;
        this.reorderData = that.reorderData;
        this.voidData = that.voidData;
        this.retailer = that.retailer;
        this.metadata = that.metadata;
        this.invoiceRef = that.invoiceRef;
        this.shippingAddress = that.shippingAddress;
        this.store = that.store;
        this.paymentStatus = that.paymentStatus;
        copyPricingData(that);
    }

    protected void copyPricingData(ShipBin shipBin) {
        this.setProductDiscount(shipBin.getProductDiscount());
        this.setProductTax(shipBin.getProductTax());
        this.setProductTotal(shipBin.getProductTotal());
        this.setShippingDiscount(shipBin.getShippingDiscount());
        this.setShippingTax(shipBin.getShippingTax());
        this.setShippingTotal(shipBin.getShippingTotal());
        this.setTotalRefund(shipBin.getTotalRefund());
        this.setTaxInfo(shipBin.getTaxInfo());
    }

    private void init(Long shipBinId, List<LineItem> lineItems, DeliveryMethod deliveryMethod, String shippingAddressId) {
        this.shipBinId = shipBinId;
        if (lineItems != null) {
            this.lineItems.addAll(lineItems);
        }
        this.deliveryMethod = deliveryMethod;
        this.shippingAddressId = shippingAddressId;
    }

    public String getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(String shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public DeliveryOption getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(DeliveryOption deliveryOption) {
        this.deliveryOption = deliveryOption;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        if (lineItems != null) {
            this.lineItems = new ArrayList<LineItem>(lineItems);
        } else {
            this.lineItems = new ArrayList<LineItem>();
        }
    }

    public void addLineItem(LineItem newItem) {
        if (lineItems == null) {
            lineItems = new ArrayList<LineItem>();
        }
        lineItems.add(newItem);
    }

    public Long getShipBinId() {
        return shipBinId;
    }

    public void setShipBinId(Long shipBinId) {
        this.shipBinId = shipBinId;
    }

    public void initInternalIds(RequestSettings settings) {
        setInternalShipBinId(settings);

        List<LineItem> lineItems = getLineItems();
        if (lineItems != null) {
            for (LineItem lineItem : lineItems) {
                lineItem.initInternalIds(settings);
            }
        }
    }

    public void setInternalShipBinId(RequestSettings settings) {
        //setShipBinId(CartServiceOidDispenser.sGetNextOid(settings, "shipBin"));
    }

    public void initInternalIds(RequestSettings settings, 
            ShipBin prev) {
        List<LineItem> lineItems = getLineItems();
        if (lineItems != null) {
            Set<Long> ids = new HashSet<Long>();
            for (LineItem lineItem : lineItems) {
                Long id = lineItem.getLineItemId();
                LineItem prevItem = prev.findLineItem(id);
                if (prevItem == null || ids.contains(id)) {
                    // no matching lineItem in this shipBin... give everything
                    // new ids
                    lineItem.initInternalIds(settings);
                } else {
                    ids.add(id);
                    lineItem.initInternalIds(settings,prevItem);
                }
            }
        }
    }

    public boolean hasLineItems() {
        return lineItems != null && lineItems.size() > 0;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    @Override
    public String toString() {
        return "ShipBin [shipBinId=" + shipBinId + ", status=" + status + ", deliveryOption=" + deliveryOption
            + ", deliveryMethod=" + deliveryMethod + ", shippingAddressId=" + shippingAddressId + ", resubmitData="
            + resubmitData + ", reorderData=" + reorderData + ", voidData=" + voidData + ", stateChange=" + stateChange
            + ", completeDate=" + completeDate + ", trackingId=" + trackingId + ", shipper=" + shipper
            + ", fulfillmentLocation=" + fulfillmentLocation + ", vendorId=" + vendorId + ", retailer=" + retailer
            + ", storeId=" + storeId + ", metadata=" + metadata + " " + super.toString() + ", openInvoiceData=" + "" + ", taxInfo=" + taxInfo
            + ", lineItems=" + lineItems + "]";
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public LineItem findLineItem(Long id) {
        for (LineItem lineItem : lineItems) {
            if (lineItem.getLineItemId() == id) return lineItem;
        }
        return null;
    }

    @Override
    public Long getItemId() {
        return getShipBinId();
    }

    @JsonIgnore
    public List<RefundPojo> getRefunds() {
        return refunds == null ? new ArrayList<RefundPojo>() : refunds;
    }
    
    public void setRefunds(List<RefundPojo> refunds) {
        if (refunds != null) {
            this.refunds = new ArrayList<RefundPojo>(refunds);
        } else {
            this.refunds = new ArrayList<RefundPojo>();
        }
    }

    /**
     * I had to do this because jackson doesn't know how to deserialize the
     * supertype (RefundPojo)
     */
    @SuppressWarnings("unchecked")
    @JsonProperty("refunds")
    public List<ShipBinRefundPojo> getShipBinRefunds() {
        return (List<ShipBinRefundPojo>) (refunds == null ? new ArrayList<ShipBinRefundPojo>() : refunds);
    }
    
    public void addRefund(LineItemRefundPojo refund) {

        if (this.refunds == null) {
            this.refunds = new ArrayList<RefundPojo>();
        }
        this.refunds.add(refund);
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Date getStateChange() {
        return stateChange;
    }

    public void setStateChange(Date stateChange) {
        this.stateChange = stateChange;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getTrackingUrl() {
        return trackingUrl;
    }

    public void setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
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

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
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

    public ResubmitData getResubmitData() {
        return resubmitData;
    }

    public void setResubmitData(ResubmitData resubmitData) {
        this.resubmitData = resubmitData;
    }

    public ReorderData getReorderData() {
        return reorderData;
    }

    public void setReorderData(ReorderData reorderData) {
        this.reorderData = reorderData;
    }

    public VoidData getVoidData() {
        return voidData;
    }

    public void setVoidData(VoidData voidData) {
        this.voidData = voidData;
    }

    public Collection<Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(Collection<Metadata> metadata) {
        this.metadata = metadata;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public List<TaxInfo> getTaxInfo() {
        return taxInfo;
    }

    public void setTaxInfo(List<TaxInfo> taxInfo) {
        this.taxInfo = taxInfo;
    }

    public String getInvoiceRef() {
        return invoiceRef;
    }

    public void setInvoiceRef(String invoiceRef) {
        this.invoiceRef = invoiceRef;
    }

 
    /*public OpenInvoiceData getOpenInvoiceData() {
        return openInvoiceData;
    }

    public void setOpenInvoiceData(OpenInvoiceData openInvoiceData) {
        this.openInvoiceData = openInvoiceData;
    }*/
  
	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	public String getPaymentStatus() {
		return paymentStatus;
	}	
	
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	public Date getMinEstimatedDeliveryDate() {
		return minEstimatedDeliveryDate;
	}

	public void setMinEstimatedDeliveryDate(Date minEstimatedDeliveryDate) {
		this.minEstimatedDeliveryDate = minEstimatedDeliveryDate;
	}

	public Date getMaxEstimatedDeliveryDate() {
		return maxEstimatedDeliveryDate;
	}

	public void setMaxEstimatedDeliveryDate(Date maxEstimatedDeliveryDate) {
		this.maxEstimatedDeliveryDate = maxEstimatedDeliveryDate;
	}
	
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
    public Collection<StatusHistoryEvent> getStatusHistory() {
		return statusHistory;
	}

	public void setStatusHistory(Collection<StatusHistoryEvent> statusHistory) {
		this.statusHistory = statusHistory;
	}


	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public static class StatusHistoryEvent {
        Date updateDate;
        Object status;

        public StatusHistoryEvent() {
        }

		public Date getUpdateDate() {
			return updateDate;
		}

		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}

		public Object getStatus() {
			return status;
		}

		public void setStatus(Object status) {
			this.status = status;
		}
        
    }
}
 
