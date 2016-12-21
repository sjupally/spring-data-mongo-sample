package com.mongo.sample.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.common.ITokenDataOverridable;
import com.mongo.sample.constants.ResubmitReasonCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResubmitData implements ITokenDataOverridable {
    private Long orderId = 0L;
    private String accountId;
    private String context;
    private Long shipBinId;
    private ResubmitReasonCode reasonCode;
    private String reasonDetails;
    private Date timeStamp;
    private String agentId;
    private String vendorId;

    public ResubmitData() {
    }
    
    public ResubmitData(Long orderId, Long shipBinId, String accountId) {
        this.orderId = orderId;
        this.shipBinId = shipBinId;
        this.accountId = accountId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String getAccountId() {
        return accountId;
    }

    @Override
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getShipBinId() {
        return shipBinId;
    }

    public void setShipBinId(Long shipBinId) {
        this.shipBinId = shipBinId;
    }

    public ResubmitReasonCode getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(ResubmitReasonCode reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getReasonDetails() {
        return reasonDetails;
    }

    public void setReasonDetails(String reasonDetails) {
        this.reasonDetails = reasonDetails;
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
    

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
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
