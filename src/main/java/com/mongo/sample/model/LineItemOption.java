package com.mongo.sample.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "optionId", "quantity", "lineItemOptionId" })
public class LineItemOption extends Refundable {
    private long lineItemOptionId;
    private String optionId;
    private int quantity;
    private String sourceGroup;
    private List<RefundPojo> refunds = new ArrayList<RefundPojo>();
    private TaxInfo taxInfo = new TaxInfo();

    public LineItemOption() {
    }

    // this is only used during testing
    public LineItemOption(long id) {
        lineItemOptionId = id;
    }

    public LineItemOption(long lineItemOptionId, String optionId, int quantity) {
        super();
        this.lineItemOptionId = lineItemOptionId;
        this.setOptionId(optionId);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
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

    public long getLineItemOptionId() {
        return lineItemOptionId;
    }

    public void setLineItemOptionId(long lineItemOptionId) {
        this.lineItemOptionId = lineItemOptionId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    /*public void initInternalIds(RequestSettings settings) {
        setLineItemOptionId(CartServiceOidDispenser.sGetNextOid(settings, "lineItemOption"));
    }*/

    public String getSourceGroup() { return sourceGroup; }

    public void setSourceGroup(String sourceGroup) { this.sourceGroup = sourceGroup; }

    @JsonIgnore
    public List<RefundPojo> getRefunds() {
        return refunds == null ? new ArrayList<RefundPojo>() : refunds;
    }

    /**
     * I had to do this because jackson doesn't know how to deserialize the
     * supertype (RefundPojo)
     */
    @SuppressWarnings("unchecked")
    @JsonProperty("refunds")
    public List<LineItemOptionRefundPojo> getLineItemRefunds() {
        return (List<LineItemOptionRefundPojo>) (refunds == null ? new ArrayList<LineItemOptionRefundPojo>() : refunds);
    }

    public void setRefunds(List<RefundPojo> refunds) {
        if (refunds != null) {
            this.refunds = new ArrayList<RefundPojo>(refunds);
        } else {
            this.refunds = new ArrayList<RefundPojo>();
        }
    }
    
    public void addRefund(LineItemOptionRefundPojo refund) {

        if (this.refunds == null) {
            this.refunds = new ArrayList<RefundPojo>();
        }
        this.refunds.add(refund);
    }

    @Override
    public Long getItemId() {
        return getLineItemOptionId();
    }

    @Override
    public String toString() {
        return "LineItemOption [lineItemOptionId=" + lineItemOptionId + ", optionId=" + optionId + ", quantity="
                + quantity + ", refunds=" + refunds + ", taxInfo=" + taxInfo + " " + super.toString() + "]";
    }
    
}
