package com.mongo.sample.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.mongo.sample.constants.RefundReasonCode;

/**
 * © Copyright 2013 Snapfish LLC
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItemRefundPojo extends RefundPojo {
    Long lineItemId;

    public LineItemRefundPojo() {
    }

    public LineItemRefundPojo(Priceable priceable, String agentId, RefundReasonCode reasonCode, String reasonDetails) {
        super(priceable, agentId, reasonCode, reasonDetails);

    }

    public Long getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(Long lineItemId) {
        this.lineItemId = lineItemId;
    }

}
