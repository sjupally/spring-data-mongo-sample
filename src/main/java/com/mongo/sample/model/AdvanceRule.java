package com.mongo.sample.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "deliveryMethod", "deliveryOption", "state", "skus", "targets" })
public class AdvanceRule {
    private String deliveryMethod;
    private String deliveryOption;
    private String state;
    private List<String> skus;
    private List<DispersionTarget> targets;

    public AdvanceRule() {
    }
    
    public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getDeliveryOption() {
		return deliveryOption;
	}

	public void setDeliveryOption(String deliveryOption) {
		this.deliveryOption = deliveryOption;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<String> getSkus() {
		return skus;
	}

	public void setSkus(List<String> skus) {
		this.skus = skus;
	}

	public List<DispersionTarget> getTargets() {
		return targets;
	}

	public void setTargets(List<DispersionTarget> targets) {
		this.targets = targets;
	}

	@Override
    public String toString() {
        return "AdvanceRule [deliveryMethod=" + deliveryMethod + ",deliveryOption="+ deliveryOption +", skus="+ skus.toString() +" state="+ state +", targets=" + targets + "]";
    }
}
