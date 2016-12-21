package com.mongo.sample.model;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.constants.RefundReasonCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public abstract class RefundPojo extends Priceable {
    private Date date;
    private String agentId;
    private String paymentTransaction;
    private String reasonDetails;
    private RefundReasonCode reasonCode;
    private BigDecimal quantity = BigDecimal.ZERO;
    private Long paymentLogId;

    public RefundPojo() {
    }

    public RefundPojo(Priceable priceable, String agentId, RefundReasonCode reasonCode, String reasonDetails) {
        super(priceable);
        this.reasonCode = reasonCode;
        this.reasonDetails = reasonDetails;
        this.date = new Date();
        this.agentId = agentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getPaymentTransaction() {
        return paymentTransaction;
    }

    public void setPaymentTransaction(String paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
    }

    public String getReasonDetails() {
        return reasonDetails;
    }

    public void setReasonDetails(String reasonDetails) {
        this.reasonDetails = reasonDetails;
    }

    public RefundReasonCode getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(RefundReasonCode reasonCode) {
        this.reasonCode = reasonCode;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Long getPaymentLogId() {
        return paymentLogId;
    }

    public void setPaymentLogId(Long paymentLogId) {
        this.paymentLogId = paymentLogId;
    }

    @Override
    public String toString() {
        return "RefundPojo [date=" + date + ", agentId=" + agentId + ", paymentTransaction=" + paymentTransaction
                + ", reasonDetails=" + reasonDetails + ", reasonCode=" + reasonCode + ", quantity=" + quantity
                + ", paymentLogId=" + paymentLogId + "]";
    }
}
