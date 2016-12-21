package com.mongo.sample.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * © Copyright 2013 Snapfish LLC
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItemOptionRefundPojo extends RefundPojo {

    Long lineItemOptionId;

    public LineItemOptionRefundPojo() {
        super();
    }

    public Long getLineItemOptionId() {
        return lineItemOptionId;
    }

    public void setLineItemOptionId(Long lineItemOptionId) {
        this.lineItemOptionId = lineItemOptionId;
    }

}
