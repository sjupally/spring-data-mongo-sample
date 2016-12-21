package com.mongo.sample.model;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.common.ITokenDataOverridable;
import com.mongo.sample.constants.VoidReasonCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class VoidData implements ITokenDataOverridable {
    private Long orderId = 0L;
    private String accountId;
    private String context;
    private VoidReasonCode reasonCode;
    private String reasonDetails;
    private List<Long> shipBinIds;
    private Date timeStamp;
    private String agentId;
    private String voidSource;
    private boolean asyncCapture;
    private boolean performRefund = true;
    private boolean sendNotification = true;

    public VoidData() {
    }
    
    public VoidData(Long id, String accountId) {
        this.orderId = id;
        this.accountId = accountId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<Long> getShipBinIds() {
        return shipBinIds;
    }

    public void setShipBinIds(List<Long> shipBinIds) {
        this.shipBinIds = shipBinIds;
    }

    public String getReasonDetails() {
        return reasonDetails;
    }

    public void setReasonDetails(String reasonDetails) {
        this.reasonDetails = reasonDetails;
    }

    public void setReasonCode(VoidReasonCode reasonCode) {
        this.reasonCode = reasonCode;
    }

    public VoidReasonCode getReasonCode() {
        return reasonCode;
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
    
    public String getVoidSource() {
    	return voidSource;
    }

    public void setVoidSource(String voidSource) {
    	this.voidSource = voidSource;
    }
    
    @Override
    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String getContext() {
        return this.context;
    }

	public boolean isAsyncCapture() {
		return asyncCapture;
	}

	public void setAsyncCapture(boolean asyncCapture) {
		this.asyncCapture = asyncCapture;
	}

	public boolean isPerformRefund() {
		return performRefund;
	}

	public void setPerformRefund(boolean performRefund) {
		this.performRefund = performRefund;
	}

	public boolean isSendNotification() {
		return sendNotification;
	}

	public void setSendNotification(boolean sendNotification) {
		this.sendNotification = sendNotification;
	}
}
