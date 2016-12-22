package com.mongo.sample.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.mongo.sample.constants.RefundReasonCode;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipBinRefundPojo extends RefundPojo {
    Long shipBinId;

    public ShipBinRefundPojo() {
        super();
    }

    public ShipBinRefundPojo(Priceable priceable, String agentId, RefundReasonCode reasonCode, String reasonDetails) {
        super(priceable, agentId, reasonCode, reasonDetails);
    }

    public Long getShipBinId() {
        return shipBinId;
    }

    public void setShipBinId(Long shipBinId) {
        this.shipBinId = shipBinId;
    }
}
