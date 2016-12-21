package com.mongo.sample.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.common.ITokenDataOverridable;
import com.mongo.sample.common.ResourcePojo;

/**
 * @author (c) 2013 Copyright Hewlett-Packard Development Company, L.P.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class AmazonPay extends AbstractResourcePojo implements ResourcePojo, ITokenDataOverridable {
    private Long _id = 0L;
    private String orderReferenceId;
    private String status;
    private String context;
    private String accountId;
    private String paymentId;
    private String addressConsentToken;

    public AmazonPay(AmazonPay that) {
        this.orderReferenceId = that.orderReferenceId;
        this.status = that.status;
        this.context = that.context;
        this.accountId = that.accountId;
        this.paymentId = that.paymentId;
        this.addressConsentToken = that.addressConsentToken;
    }

    public AmazonPay() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Long get_id() {
        return _id;
    }

    @Override
    public void set_id(Object id) {
        this._id = (Long) id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getAddressConsentToken() {
        return addressConsentToken;
    }

    public void setAddressConsentToken(String addressConsentToken) {
        this.addressConsentToken = addressConsentToken;
    }

    public String getOrderReferenceId() {
        return orderReferenceId;
    }

    public void setOrderReferenceId(String orderReferenceId) {
        this.orderReferenceId = orderReferenceId;
    }

    @Override
    public String toString() {
        return "AmazonPay [_id=" + _id + ", orderReferenceId=" + orderReferenceId + ", status=" + status + ", context="
            + context + ", accountId=" + accountId + ", paymentId=" + paymentId + ", addressConsentToken="
            + addressConsentToken + "]";
    }
}
