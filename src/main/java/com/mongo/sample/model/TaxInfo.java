package com.mongo.sample.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "taxed", "source", "countryCode", "stateCode", "inclusive", "shipping", "taxes" })
public class TaxInfo {
    private boolean taxed = false;
    private String source = "NotTaxed";
    private String countryCode;
    private String stateCode;
    private boolean inclusive = false;
    private boolean shipping = false;
    private NationalAndStateTax productTax;
    private NationalAndStateTax shippingTax;
    private BigDecimal rate = BigDecimal.ZERO;
    private BigDecimal shippingRate = BigDecimal.ZERO;

    private List<Object> productDetails = new ArrayList<>();
    private List<Object> shippingDetails = new ArrayList<>();

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        if (rate != null)
            this.rate = rate;
        else
            this.rate = BigDecimal.ZERO;
    }

    public boolean isInclusive() {
        return inclusive;
    }

    public void setInclusive(boolean inclusive) {
        this.inclusive = inclusive;
    }

    public boolean isShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    public boolean isTaxed() {
        return taxed;
    }

    public void setTaxed(boolean taxed) {
        this.taxed = taxed;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public BigDecimal getShippingRate() {
        return shippingRate;
    }

    public void setShippingRate(BigDecimal shippingRate) {
        if (shippingRate != null)
            this.shippingRate = shippingRate;
        else
            this.shippingRate = BigDecimal.ZERO;
    }

    public NationalAndStateTax getProductTax() {
        return productTax;
    }

    public void setProductTax(NationalAndStateTax productTax) {
        this.productTax = productTax;
    }

    public NationalAndStateTax getShippingTax() {
        return shippingTax;
    }

    public void setShippingTax(NationalAndStateTax shippingTax) {
        this.shippingTax = shippingTax;
    }

    public List<Object> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<Object> productDetails) {
        if (productDetails == null)
            this.productDetails = new ArrayList<>();
        else
            this.productDetails = productDetails;
    }

    public List<Object> getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(List<Object> shippingDetails) {
        if (shippingDetails == null)
            this.shippingDetails = new ArrayList<>();
        else
            this.shippingDetails = shippingDetails;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public String toString() {
        return "TaxInfo{" +
                "taxed=" + taxed +
                ", source='" + source + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", inclusive=" + inclusive +
                ", shipping=" + shipping +
                ", productTax=" + productTax +
                ", shippingTax=" + shippingTax +
                ", rate=" + rate +
                ", shippingRate=" + shippingRate +
                ", productDetails=" + productDetails +
                ", shippingDetails=" + shippingDetails +
                '}';
    }
}
