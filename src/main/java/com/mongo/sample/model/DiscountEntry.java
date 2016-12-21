package com.mongo.sample.model;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscountEntry {
    private BigDecimal totalDiscount = BigDecimal.ZERO;
    private List<DiscountDetail> details = Collections.emptyList();

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(BigDecimal totalDiscount) {
        if (totalDiscount == null)
            this.totalDiscount = BigDecimal.ZERO;
        else
            this.totalDiscount = totalDiscount;
    }

    public void addToDiscount(BigDecimal amount) {
        this.totalDiscount = totalDiscount.add(amount);
    }

    public List<DiscountDetail> getDetails() {
        return details;
    }

    public void setDetails(List<DiscountDetail> details) {
        if (details == null)
            this.details = Collections.emptyList();
        else
            this.details = new ArrayList<DiscountDetail>(details);
    }

    public void addDetail(DiscountDetail detail)  {
        if (this.details.isEmpty()) {
            this.details = new ArrayList<DiscountDetail>();
        }
        this.details.add(detail);
    }

    @Override
    public String toString() {
        return "DiscountEntry [totalDiscount=" + totalDiscount + "]";
    }
}