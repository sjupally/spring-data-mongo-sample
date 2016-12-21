package com.mongo.sample.model;

import com.mongo.sample.common.ResourcePojo;

public abstract class AbstractResourcePojo implements ResourcePojo {

    protected String partner;

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }
}
