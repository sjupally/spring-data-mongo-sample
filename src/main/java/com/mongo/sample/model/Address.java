package com.mongo.sample.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.common.Billable;
import com.mongo.sample.common.ITokenDataOverridable;
import com.mongo.sample.common.ResourcePojo;

/**
 * © Copyright 2012 Snapfish LLC
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Address extends AbstractResourcePojo 
implements ResourcePojo, ITokenDataOverridable, Billable {
    private String firstname;
    private String lastname;
    private String street1;
    private String street2;
    private String street3;
    private String city;
    private String county;
    private String state;
    private String country;
    private String postalcode;
    private String website; // TODO: This needs to go away.
    Date lastupdate;
    boolean isdefault;
    Date created;
    String _id;
    private String oid;
    private String accountoid;
    private String email;
    private String phone;
    private String addresstype;
    private String context;
    private final String typeName = "shippingType";

    public static Address getInstance(Billable billable) {
        StackTraceElement stack = new Exception().getStackTrace()[0];
        throw new RuntimeException("Method not Implemented:  " + stack.getClassName() + "." + stack.getMethodName()
            + "()");
    }

    public Address() {
    }

    @Override
    public String get_id() {
        return _id;
    }

    @Override
    public void set_id(Object _id) {
        this._id = (String) _id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getWebsite() {
        // TODO: cleanup the website hack
        if (website == null || "".equals(website))
            return "1000000";
        else
            return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public boolean isIsdefault() {
        return isdefault;
    }

    public void setIsdefault(boolean isdefault) {
        this.isdefault = isdefault;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getAccountoid() {
        return accountoid;
    }

    public void setAccountoid(String accountoid) {
        this.accountoid = accountoid;
    }

    public void setAccountId(String accountoid) {
        this.accountoid = accountoid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getAddresstype() {
        return addresstype;
    }

    public void setAddresstype(String addresstype) {
        this.addresstype = addresstype;
    }

    @Override
    public String toString() {
        return "Address [firstname=" + firstname + ", lastname=" + lastname + ", street1=" + street1 + ", street2="
            + street2 + ", street3=" + street3 + ", city=" + city + ", county=" + county + ", state=" + state
            + ", country=" + country + ", postalcode=" + postalcode + ", website=" + website + ", lastupdate="
            + lastupdate + ", isdefault=" + isdefault + ", created=" + created + ", _id=" + _id + ", oid=" + oid
            + ", accountoid=" + accountoid + ", email=" + email + ", phone=" + phone + ", addresstype=" + addresstype
            + ", typeName=" + typeName + "]";
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String getAccountId() {
        return accountoid;
    }
}
