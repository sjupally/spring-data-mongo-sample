package com.mongo.sample.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongo.sample.common.AccountIdShardable;
import com.mongo.sample.common.ITokenDataOverridable;
import com.mongo.sample.common.Lockable;
import com.mongo.sample.common.ResourcePojo;
import com.mongo.sample.constants.OrderStatus;
import com.mongo.sample.constants.ReportingStatus;

@Document(collection = "orders")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "_id", "accountId", "label", "paymentId", "paymentMethod", "payment", "status", "createDate",
		"updateDate", "shippingDeliveryOptionPrices", "shipBins" })
public class Order extends Refundable implements AccountIdShardable, ResourcePojo, ITokenDataOverridable, Lockable {

	@Id
	Long _id;
	String accountId;
	String label;
	String paymentId;
	OrderStatus status;
	Date createDate = new Date();
	Date updateDate = createDate;
	Date invoicedDate;
	List<ShipBin> shipBins;
	List<PromotionEntry> promotionCodes;
	String context;
	ReportingStatus reportingStatus;
	String lockState;
	long shardKey;
	int accountHash = 0;
	long recordSeq;
	OrderPlaceData orderPlaceData;
	VoidData voidData;
	DiscountRefundData discountRefundData;
	Collection<Metadata> metadata;
	String appId;

	// for composite cart or order
	String shippingAddress;
	String paymentMethod;
	CreditCard payment = null;
	Map<String, Address> shippingAddrMap = null;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getInvoicedDate() {
		return invoicedDate;
	}

	public void setInvoicedDate(Date invoicedDate) {
		this.invoicedDate = invoicedDate;
	}

	public List<PromotionEntry> getPromotionCodes() {
		return promotionCodes;
	}

	public List<ShipBin> getShipBins() {
		return shipBins;
	}

	public void setPromotionCodes(List<PromotionEntry> promotionCodes) {
		this.promotionCodes = promotionCodes == null ? new ArrayList<PromotionEntry>()
				: new ArrayList<PromotionEntry>(promotionCodes);
	}

	public void setShipBins(List<ShipBin> shipBins) {
		this.shipBins = shipBins == null ? new ArrayList<ShipBin>() : new ArrayList<ShipBin>(shipBins);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String getContext() {
		return context;
	}

	@Override
	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String getAccountId() {
		return accountId;
	}

	@Override
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public ReportingStatus getReportingStatus() {
		return reportingStatus;
	}

	public void setReportingStatus(ReportingStatus reportingStatus) {
		this.reportingStatus = reportingStatus;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	@Override
	public void setShardKey(long shardKey) {
		this.shardKey = shardKey;
		this.accountHash = (int) shardKey;
	}

	@Override
	public long getShardKey() {
		return shardKey;
	}

	public String getLockState() {
		return lockState;
	}

	public void setLockState(String lockState) {
		this.lockState = lockState;
	}

	public ShipBin findShipBin(long id) {
		for (ShipBin shipBin : shipBins) {
			if (shipBin.getShipBinId() == id)
				return shipBin;
		}
		return null;
	}

	@Override
	public long getRecordSeq() {
		return recordSeq;
	}

	@Override
	public void setRecordSeq(long recordSeq) {
		this.recordSeq = recordSeq;
	}

	@Override
	public Long get_id() {
		return _id;
	}

	@Override
	public void set_id(Object id) {
		_id = (Long) id;
	}

	@Override
	public Long getItemId() {
		return get_id();
	}

	public OrderPlaceData getOrderPlaceData() {
		return orderPlaceData;
	}

	public void setOrderPlaceData(OrderPlaceData orderPlaceData) {
		if (orderPlaceData == null)
			return;
		this.orderPlaceData = new OrderPlaceData(orderPlaceData);
		// Only save fields that are not already duplicated in the order and do
		// not need to be stored again.
		this.orderPlaceData.setAccountId(null);
		this.orderPlaceData.setContext(null);
		this.orderPlaceData.setPaymentId(null);
		this.orderPlaceData.setCreditCard(null);
		this.orderPlaceData.setOrderId(null);
		this.orderPlaceData.setSecurityNumber(null);
		this.orderPlaceData.setSleep(null);
	}

	public VoidData getVoidData() {
		return voidData;
	}

	public void setVoidData(VoidData voidData) {
		this.voidData = voidData;
	}

	public DiscountRefundData getDiscountRefundData() {
		return discountRefundData;
	}

	public void setDiscountRefundData(DiscountRefundData discountRefundData) {
		this.discountRefundData = discountRefundData;
	}

	@Override
	public List<RefundPojo> getRefunds() {
		return null;
	}

	public Collection<Metadata> getMetadata() {
		return metadata;
	}

	public void setMetadata(Collection<Metadata> metadata) {
		this.metadata = metadata;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		if (this.appId != null)
			return;
		this.appId = appId;
	}

	String dataCenter;
	String environment;
	String partner;

	public String getDataCenter() {
		return dataCenter;
	}

	public void setDataCenter(String dataCenter) {
		this.dataCenter = dataCenter;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public CreditCard getPayment() {
		return payment;
	}

	public void setPayment(CreditCard payment) {
		this.payment = payment;
	}

	public Map<String, Address> getShippingAddrMap() {
		return shippingAddrMap;
	}

	public void setShippingAddrMap(Map<String, Address> shippingAddrMap) {
		this.shippingAddrMap = shippingAddrMap;
	}

	@Override
	public String toString() {
		return "Order [createDate=" + createDate + ", updateDate=" + updateDate + ", invoicedDate=" + invoicedDate
				+ ", shipBins=" + shipBins + ", promotionCodes=" + promotionCodes + ", context=" + context
				+ ", accountId=" + accountId + ", label=" + label + ", paymentId=" + paymentId + ", status=" + status
				+ ", reportingStatus=" + reportingStatus + ", lockState=" + lockState + ", _id=" + _id + ", shardKey="
				+ shardKey + ", recordSeq=" + recordSeq + ", orderPlaceData=" + orderPlaceData + ", openInvoiceData="
				+ "" + ", voidData=" + voidData + ", metadata=" + metadata + ", appId=" + appId + ", dataCenter="
				+ dataCenter + ", environment=" + environment + ", partner=" + partner + "]";
	}

	@Override
	public int getAccountHash() {
		return this.accountHash;
	}

	@Override
	public void setAccountHash(int accountHash) {
		this.accountHash = accountHash;
	}

}
