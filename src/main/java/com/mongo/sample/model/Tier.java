package com.mongo.sample.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Tier implements Comparable<Tier> {
    private Integer quantityLow;
    private Integer quantityHigh;
    private Integer units;
    private Integer setSize;
    private Boolean topTierIsBracket;
    private List<Double> priceLevel;
    
    public Tier() {
        priceLevel = new ArrayList<Double>(4);
    }
    
    public Integer getQuantityLow() {
        return quantityLow;
    }

    public void setQuantityLow(Integer quantityLow) {
        this.quantityLow = quantityLow;
    }

    public Integer getQuantityHigh() {
        return quantityHigh;
    }

    public void setQuantityHigh(Integer quantityHigh) {
        this.quantityHigh = quantityHigh;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Integer getSetSize() {
        return setSize;
    }

    public void setSetSize(Integer setSize) {
        this.setSize = setSize;
    }

    public Boolean getTopTierIsBracket() {
        return topTierIsBracket;
    }

    public void setTopTierIsBracket(Boolean topTierIsBracket) {
        this.topTierIsBracket = topTierIsBracket;
    }

    public List<Double> getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(List<Double> priceLevel) {
        this.priceLevel = priceLevel;
    }

    @Override
    public int compareTo(Tier tier2) {
        return this.quantityLow.compareTo(tier2.getQuantityLow());
    }
    
}
