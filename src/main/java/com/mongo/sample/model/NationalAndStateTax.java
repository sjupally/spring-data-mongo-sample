package com.mongo.sample.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "product", "shipping" })
public class NationalAndStateTax {
    private TaxData national;
    private TaxData state;

    public TaxData getNational() {
        return national;
    }

    public void setNational(TaxData national) {
        this.national = national;
    }

    public TaxData getState() {
        return state;
    }

    public void setState(TaxData state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "NationalAndStateTax{" +
                "national=" + national +
                ", state=" + state +
                '}';
    }

}
