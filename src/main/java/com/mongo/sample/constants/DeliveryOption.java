package com.mongo.sample.constants;

public enum DeliveryOption {
    
    Standard("UFC"),
    Overnight("AOE"),
    TwoDay("ASD"),
    ThreeDay("ATD"),
    International("UIN"),
    Canada("CDN"),
    CashOnDelivery("COD"),
    FedExStandard("FFC"),
    FedExTwoDay("F2D"),
    FedExOvernight("FON"),
    FedExCanada("FXC"),
    FedExInternational("FXI"),
    Tracked("TRK"),
    ExpressTracked("TRE"),
    EU("EU"),
    Economy("ECO"),
    NoShipping("NOS");
 
    private final String legacyDeliveryOption;

    private DeliveryOption(String legacyOption) {
        this.legacyDeliveryOption = legacyOption;
        
    }
    
    public String getLegacyDeliveryOption() {
        return this.legacyDeliveryOption;
    }

}
