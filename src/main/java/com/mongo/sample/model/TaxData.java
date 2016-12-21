package com.mongo.sample.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "taxRate", "taxAmount", "taxDescription" })
public class TaxData {
    private BigDecimal taxRate = BigDecimal.ZERO;
    private BigDecimal taxAmount = BigDecimal.ZERO;
    private String taxDescription = null;

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getTaxDescription() {
        return taxDescription;
    }

    public void setTaxDescription(String taxDescription) {
        this.taxDescription = taxDescription;
    }

    @Override
    public String toString() {
        return "TaxData{" +
                "taxRate=" + taxRate +
                ", taxAmount=" + taxAmount +
                ", taxDescription='" + taxDescription + '\'' +
                '}';
    }
}
