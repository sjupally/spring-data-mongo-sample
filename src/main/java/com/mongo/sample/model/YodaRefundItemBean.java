package com.mongo.sample.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.common.CustomJson;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class YodaRefundItemBean  implements CustomJson  {
    private BigDecimal cityTaxAmount;
    private BigDecimal cityTaxRate;
    private BigDecimal countyTaxAmount;
    private BigDecimal countyTaxRate;
    private BigDecimal districtTaxAmount;
    private BigDecimal districtTaxRate;
    private BigDecimal productDiscountAmount;
    private BigDecimal productPriceBeforeDiscount;
    private Integer productQuantity;
    private BigDecimal secCityTaxAmount;
    private BigDecimal secCityTaxRate;
    private BigDecimal stateTaxAmount;
    private BigDecimal stateTaxRate;
    private BigDecimal taxCode;
    private BigDecimal transitTaxAmount;
    private BigDecimal transitTaxRate;
    private Long vendorProductID;
    private Integer quantity;
    private BigDecimal taxableGross;
    private BigDecimal productAmount;
    private String productID;
    private BigDecimal taxAmt;
    private BigDecimal grossSales;
    private Map<String, Object> jsonMap = new HashMap<String, Object>();

    public YodaRefundItemBean() {

    }
    @Override
    public Map<String, Object> getProperties() {
        return this.jsonMap;
    }

    @Override
    public void setProperty(String key, Object value) {
        getProperties().put(key, value);
    }
    public BigDecimal getCityTaxAmount() {
        return cityTaxAmount;
    }

    public void setCityTaxAmount(BigDecimal cityTaxAmount) {
        this.cityTaxAmount = cityTaxAmount;
    }

    public BigDecimal getCityTaxRate() {
        return cityTaxRate;
    }

    public void setCityTaxRate(BigDecimal cityTaxRate) {
        this.cityTaxRate = cityTaxRate;
    }

    public BigDecimal getCountyTaxAmount() {
        return countyTaxAmount;
    }

    public void setCountyTaxAmount(BigDecimal countyTaxAmount) {
        this.countyTaxAmount = countyTaxAmount;
    }

    public BigDecimal getCountyTaxRate() {
        return countyTaxRate;
    }

    public void setCountyTaxRate(BigDecimal countyTaxRate) {
        this.countyTaxRate = countyTaxRate ;
    }

    public BigDecimal getDistrictTaxAmount() {
        return districtTaxAmount;
    }

    public void setDistrictTaxAmount(BigDecimal districtTaxAmount) {
        this.districtTaxAmount = districtTaxAmount ;
    }

    public BigDecimal getDistrictTaxRate() {
        return districtTaxRate;
    }

    public void setDistrictTaxRate(BigDecimal districtTaxRate) {
        this.districtTaxRate = districtTaxRate;
    }

    public BigDecimal getProductDiscountAmount() {
        return productDiscountAmount;
    }

    public void setProductDiscountAmount(BigDecimal productDiscountAmount) {
        this.productDiscountAmount = productDiscountAmount ;
    }

    public BigDecimal getProductPriceBeforeDiscount() {
        return productPriceBeforeDiscount;
    }

    public void setProductPriceBeforeDiscount(BigDecimal productPriceBeforeDiscount) {
        this.productPriceBeforeDiscount =
            productPriceBeforeDiscount;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BigDecimal getSecCityTaxAmount() {
        return secCityTaxAmount ;
    }

    public void setSecCityTaxAmount(BigDecimal secCityTaxAmount) {
        this.secCityTaxAmount = secCityTaxAmount;
    }

    public BigDecimal getSecCityTaxRate() {
        return secCityTaxRate;
    }

    public void setSecCityTaxRate(BigDecimal secCityTaxRate) {
        this.secCityTaxRate = secCityTaxRate;
    }

    public BigDecimal getStateTaxAmount() {
        return stateTaxAmount;
    }

    public void setStateTaxAmount(BigDecimal stateTaxAmount) {
        this.stateTaxAmount = stateTaxAmount ;
    }

    public BigDecimal getStateTaxRate() {
        return stateTaxRate ;
    }

    public void setStateTaxRate(BigDecimal stateTaxRate) {
        this.stateTaxRate = stateTaxRate;
    }

    public BigDecimal getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(BigDecimal taxCode) {
        this.taxCode = taxCode ;
    }

    public BigDecimal getTransitTaxAmount() {
        return transitTaxAmount ;
    }

    public void setTransitTaxAmount(BigDecimal transitTaxAmount) {
        this.transitTaxAmount = transitTaxAmount ;
    }

    public BigDecimal getTransitTaxRate() {
        return transitTaxRate;
    }

    public void setTransitTaxRate(BigDecimal transitTaxRate) {
        this.transitTaxRate = transitTaxRate;
    }

    public Long getVendorProductID() {
        return vendorProductID;
    }

    public void setVendorProductID(Long vendorProductID) {
        this.vendorProductID = vendorProductID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTaxableGross() {
        return taxableGross;
    }

    public void setTaxableGross(BigDecimal taxableGross) {
        this.taxableGross = taxableGross;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public BigDecimal getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(BigDecimal taxAmt) {
        this.taxAmt = taxAmt;
    }

    public BigDecimal getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(BigDecimal grossSales) {
        this.grossSales = grossSales;
    }

    @Override
    public String toString() {
        return "YodaRefundItemBean [cityTaxAmount=" + cityTaxAmount + ", cityTaxRate=" + cityTaxRate
            + ", countyTaxAmount=" + countyTaxAmount + ", countyTaxRate=" + countyTaxRate + ", districtTaxAmount="
            + districtTaxAmount + ", districtTaxRate=" + districtTaxRate + ", productDiscountAmount="
            + productDiscountAmount + ", productPriceBeforeDiscount=" + productPriceBeforeDiscount
            + ", productQuantity=" + productQuantity + ", secCityTaxAmount=" + secCityTaxAmount + ", secCityTaxRate="
            + secCityTaxRate + ", stateTaxAmount=" + stateTaxAmount + ", stateTaxRate=" + stateTaxRate + ", taxCode="
            + taxCode + ", transitTaxAmount=" + transitTaxAmount + ", transitTaxRate=" + transitTaxRate
            + ", vendorProductID=" + vendorProductID + ", quantity=" + quantity + ", taxableGross=" + taxableGross
            + ", productAmount=" + productAmount + ", productID=" + productID + ", taxAmt=" + taxAmt + ", grossSales="
            + grossSales + "]";
    }
}
