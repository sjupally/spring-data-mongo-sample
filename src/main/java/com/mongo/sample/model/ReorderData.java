package com.mongo.sample.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.common.ITokenDataOverridable;
import com.mongo.sample.constants.ResubmitReasonCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ReorderData implements ITokenDataOverridable {
    private Long originalOrderId = 0L;
    private String accountId;
    private String context;
    private ShipBin shipBin;
    private ResubmitReasonCode reasonCode;
    private String reasonDetails;
    private Date timeStamp;
    private String agentId;

    public ReorderData() {
    }
    
    public ReorderData(Long id, ShipBin shipBin, String accountId) {
        this.originalOrderId = id;
        this.accountId = accountId;
        this.shipBin = shipBin;
    }

    public Long getOriginalOrderId() {
        return originalOrderId;
    }

    public void setOriginalOrderId(Long originalOrderId) {
        this.originalOrderId = originalOrderId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public ShipBin getShipBin() {
        return shipBin;
    }

    public void setShipBin(ShipBin shipBin) {
        this.shipBin = shipBin;
    }

    public String getReasonDetails() {
        return reasonDetails;
    }

    public void setReasonDetails(String reasonDetails) {
        this.reasonDetails = reasonDetails;
    }

    public ResubmitReasonCode getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(ResubmitReasonCode reasonCode) {
        this.reasonCode = reasonCode;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    @Override
    public void setContext(String context) {
       this.context = context; 
    }

    @Override
    public String getContext() {
        return this.context;
    }
    
}
