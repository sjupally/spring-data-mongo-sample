package com.mongo.sample.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.common.ITokenDataOverridable;
import com.mongo.sample.constants.PaymentMethod;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class OrderPlaceData implements ITokenDataOverridable {
    Long orderId = 0L;
    String accountId;
    String context;
    String paymentId;
    String customerIpAddress;
    String paymentIgnoreResults;
    String securityNumber;
    Integer sleep;
    boolean recurringPayment;
    Long paymentLogId;
    PaymentMethod paymentMethod;
    String hostedFieldsEnabled;
    String isAmazonLive;
    DeviceData deviceData;

    // For testing only
    private CreditCard creditCard;
    private AmazonPay amazonPay;

    public OrderPlaceData() {
    }

    public OrderPlaceData(OrderPlaceData that) {
        this.orderId = that.orderId;
        this.accountId = that.accountId;
        this.context = that.context;
        this.paymentId = that.paymentId;
        this.customerIpAddress = that.customerIpAddress;
        this.paymentIgnoreResults = that.paymentIgnoreResults;
        this.recurringPayment = that.recurringPayment;
        this.securityNumber = that.securityNumber;
        this.sleep = that.sleep;
        this.creditCard = that.creditCard;
        this.amazonPay = that.amazonPay;
        this.paymentLogId = that.paymentLogId;
        this.paymentMethod = that.paymentMethod;
        this.hostedFieldsEnabled = that.hostedFieldsEnabled;
        this.isAmazonLive = that.isAmazonLive;
        this.deviceData = that.deviceData;
    }

    public OrderPlaceData(Long id) {
        this.orderId = id;
    }

    public OrderPlaceData(Long id, String accountId) {
        this.orderId = id;
        this.accountId = accountId;
    }

    public boolean isRecurringPayment() {
        return recurringPayment;
    }

    public void setRecurringPayment(boolean recurringPayment) {
        this.recurringPayment = recurringPayment;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentIgnoreResults() {
        return paymentIgnoreResults;
    }

    public void setPaymentIgnoreResults(String paymentIgnoreResults) {
        this.paymentIgnoreResults = paymentIgnoreResults;
    }

    public String getCustomerIpAddress() {
        return customerIpAddress;
    }

    public void setCustomerIpAddress(String customerIpAddress) {
        this.customerIpAddress = customerIpAddress;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getSleep() {
        return sleep;
    }

    public void setSleep(Integer sleep) {
        this.sleep = sleep;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    public Long getPaymentLogId() {
        return paymentLogId;
    }

    public void setPaymentLogId(Long paymentLogId) {
        this.paymentLogId = paymentLogId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public String getHostedFieldsEnabled() {
        return hostedFieldsEnabled;
    }

    public void setHostedFieldsEnabled(String tokenEnabled) {
        this.hostedFieldsEnabled = tokenEnabled;
    }
    
    public DeviceData getDeviceData() {
        return deviceData;
    }

    public void setDeviceData(DeviceData deviceData) {
        this.deviceData = deviceData;
    }
       

    public AmazonPay getAmazonPay() {
        return amazonPay;
    }

    public void setAmazonPay(AmazonPay amazonPay) {
        this.amazonPay = amazonPay;
    }
    
    public String getIsAmazonLive() {
        return isAmazonLive;
    }

    public void setIsAmazonLive(String isAmazonLive) {
        this.isAmazonLive = isAmazonLive;
    }

    @Override
    public String toString() {
        return "OrderPlaceData [orderId=" + orderId + ", accountId=" + accountId + ", context=" + context
            + ", paymentId=" + paymentId + ", customerIpAddress=" + customerIpAddress + ", paymentIgnoreResults="
            + paymentIgnoreResults + ", securityNumber=" + securityNumber + ", sleep=" + sleep + ", recurringPayment="
            + recurringPayment + ", paymentLogId=" + paymentLogId + ", paymentMethod=" + paymentMethod
            + ", hostedFieldsEnabled=" + hostedFieldsEnabled + ", deviceData=" + deviceData + ", creditCard="
            + creditCard + ", amazonPay=" + amazonPay + "]";
    }
    
    
     
}
