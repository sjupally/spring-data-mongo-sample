package com.mongo.sample.model;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.constants.RefundReasonCode;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"timeStamp", "details"})
public class DiscountRefundData {

    private Date date;
    private List<PriceServiceRefundDetails> details;
    private String reasonDetails;
    private RefundReasonCode reasonCode;
    private String agentId;

    public DiscountRefundData() {}

    public DiscountRefundData(Date date, List<PriceServiceRefundDetails> details) {
        this.date = date;
        this.details = details;
    }

    public DiscountRefundData(Date date, List<PriceServiceRefundDetails> details, String reasonDetails,
                              RefundReasonCode reasonCode, String agentId) {
        this.date = date;
        this.details = details;
        this.reasonDetails = reasonDetails;
        this.reasonCode = reasonCode;
        this.agentId = agentId;
    }

    public List<PriceServiceRefundDetails> getDetails() {
        return details;
    }

    public void setDetails(List<PriceServiceRefundDetails> details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

}
