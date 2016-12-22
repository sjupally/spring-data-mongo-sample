package com.mongo.sample.model;

import java.util.Collection;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;



@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class StoreAddress {
    Collection<Store> stores;
    Integer storesCount;
    
    
    public Collection<Store> getStores() {
		return stores;
	}

	public void setStores(Collection<Store> stores) {
		this.stores = stores;
	}

	public Integer getStoresCount() {
		return storesCount;
	}

	public void setStoresCount(Integer storesCount) {
		this.storesCount = storesCount;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public static class Store {
    	String storeId;
    	String status;
    	String retailer;
    	String name;
    	Address addr;
    	List<PickupDetails> pickupDetails = null;
    	StoreHours storeHours = null;
    	boolean is24HrsOpenStore;
    	String timeZone = null;
    	List<String> phoneNumbers = null;
    	String vendorId = null;
    	String geoLat = null;
    	String geoLong = null;
    	List<String> storeTimings = null;
    	String wmPONumber = null;
    	List<String> wmDistributorIds = null;
    	String distance = null;
    	List<String> displayDate = null;
    	List<String> products = null;
    	String productGroup = null;
    	String taxRate = null;
    	boolean timeCheckFlag;
    	boolean expressPickupAvailable;
    	boolean standardPickupAvailable;
    	
		public String getStoreId() {
			return storeId;
		}
		public void setStoreId(String storeId) {
			this.storeId = storeId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getRetailer() {
			return retailer;
		}
		public void setRetailer(String retailer) {
			this.retailer = retailer;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Address getAddr() {
			return addr;
		}
		public void setAddr(Address addr) {
			this.addr = addr;
		}
		public List<PickupDetails> getPickupDetails() {
			return pickupDetails;
		}
		public void setPickupDetails(List<PickupDetails> pickupDetails) {
			this.pickupDetails = pickupDetails;
		}
		public StoreHours getStoreHours() {
			return storeHours;
		}
		public void setStoreHours(StoreHours storeHours) {
			this.storeHours = storeHours;
		}
		public boolean isIs24HrsOpenStore() {
			return is24HrsOpenStore;
		}
		public void setIs24HrsOpenStore(boolean is24HrsOpenStore) {
			this.is24HrsOpenStore = is24HrsOpenStore;
		}
		public String getTimeZone() {
			return timeZone;
		}
		public void setTimeZone(String timeZone) {
			this.timeZone = timeZone;
		}
		public List<String> getPhoneNumbers() {
			return phoneNumbers;
		}
		public void setPhoneNumbers(List<String> phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		}
		public String getVendorId() {
			return vendorId;
		}
		public void setVendorId(String vendorId) {
			this.vendorId = vendorId;
		}
		public String getGeoLat() {
			return geoLat;
		}
		public void setGeoLat(String geoLat) {
			this.geoLat = geoLat;
		}
		public String getGeoLong() {
			return geoLong;
		}
		public void setGeoLong(String geoLong) {
			this.geoLong = geoLong;
		}
		public List<String> getStoreTimings() {
			return storeTimings;
		}
		public void setStoreTimings(List<String> storeTimings) {
			this.storeTimings = storeTimings;
		}
		public String getWmPONumber() {
			return wmPONumber;
		}
		public void setWmPONumber(String wmPONumber) {
			this.wmPONumber = wmPONumber;
		}
		public List<String> getWmDistributorIds() {
			return wmDistributorIds;
		}
		public void setWmDistributorIds(List<String> wmDistributorIds) {
			this.wmDistributorIds = wmDistributorIds;
		}
		public String getDistance() {
			return distance;
		}
		public void setDistance(String distance) {
			this.distance = distance;
		}
		public List<String> getDisplayDate() {
			return displayDate;
		}
		public void setDisplayDate(List<String> displayDate) {
			this.displayDate = displayDate;
		}
		public List<String> getProducts() {
			return products;
		}
		public void setProducts(List<String> products) {
			this.products = products;
		}
		public String getProductGroup() {
			return productGroup;
		}
		public void setProductGroup(String productGroup) {
			this.productGroup = productGroup;
		}
		public String getTaxRate() {
			return taxRate;
		}
		public void setTaxRate(String taxRate) {
			this.taxRate = taxRate;
		}
		public boolean isTimeCheckFlag() {
			return timeCheckFlag;
		}
		public void setTimeCheckFlag(boolean timeCheckFlag) {
			this.timeCheckFlag = timeCheckFlag;
		}
		public boolean isExpressPickupAvailable() {
			return expressPickupAvailable;
		}
		public void setExpressPickupAvailable(boolean expressPickupAvailable) {
			this.expressPickupAvailable = expressPickupAvailable;
		}
		public boolean isStandardPickupAvailable() {
			return standardPickupAvailable;
		}
		public void setStandardPickupAvailable(boolean standardPickupAvailable) {
			this.standardPickupAvailable = standardPickupAvailable;
		}

    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public static class Address {
    	String street;
    	String city;
    	String province;
    	String zip;
    	String countryCode;
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getZip() {
			return zip;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}
		public String getCountryCode() {
			return countryCode;
		}
		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}
    }
    
    public static class PickupDetails {
    	String pickupTime, pickupType;

		public String getPickupTime() {
			return pickupTime;
		}

		public void setPickupTime(String pickupTime) {
			this.pickupTime = pickupTime;
		}

		public String getPickupType() {
			return pickupType;
		}

		public void setPickupType(String pickupType) {
			this.pickupType = pickupType;
		}
    	
    }
    
    public static class StoreHours {
    	String monOpen, monClose, tueOpen, tueClose, wedOpen, wedClose, thuOpen, thuClose, friOpen, friClose, satOpen, satClose, sunOpen, sunClose;

		public String getMonOpen() {
			return monOpen;
		}

		public void setMonOpen(String monOpen) {
			this.monOpen = monOpen;
		}

		public String getMonClose() {
			return monClose;
		}

		public void setMonClose(String monClose) {
			this.monClose = monClose;
		}

		public String getTueOpen() {
			return tueOpen;
		}

		public void setTueOpen(String tueOpen) {
			this.tueOpen = tueOpen;
		}

		public String getTueClose() {
			return tueClose;
		}

		public void setTueClose(String tueClose) {
			this.tueClose = tueClose;
		}

		public String getWedOpen() {
			return wedOpen;
		}

		public void setWedOpen(String wedOpen) {
			this.wedOpen = wedOpen;
		}

		public String getWedClose() {
			return wedClose;
		}

		public void setWedClose(String wedClose) {
			this.wedClose = wedClose;
		}

		public String getThuOpen() {
			return thuOpen;
		}

		public void setThuOpen(String thuOpen) {
			this.thuOpen = thuOpen;
		}

		public String getThuClose() {
			return thuClose;
		}

		public void setThuClose(String thuClose) {
			this.thuClose = thuClose;
		}

		public String getFriOpen() {
			return friOpen;
		}

		public void setFriOpen(String friOpen) {
			this.friOpen = friOpen;
		}

		public String getFriClose() {
			return friClose;
		}

		public void setFriClose(String friClose) {
			this.friClose = friClose;
		}

		public String getSatOpen() {
			return satOpen;
		}

		public void setSatOpen(String satOpen) {
			this.satOpen = satOpen;
		}

		public String getSatClose() {
			return satClose;
		}

		public void setSatClose(String satClose) {
			this.satClose = satClose;
		}

		public String getSunOpen() {
			return sunOpen;
		}

		public void setSunOpen(String sunOpen) {
			this.sunOpen = sunOpen;
		}

		public String getSunClose() {
			return sunClose;
		}

		public void setSunClose(String sunClose) {
			this.sunClose = sunClose;
		}
    	
    	
    }
    
    
}