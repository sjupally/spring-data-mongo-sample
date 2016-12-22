package com.mongo.sample.model;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.common.Billable;
import com.mongo.sample.common.CustomJson;
import com.mongo.sample.common.ITokenDataOverridable;
import com.mongo.sample.common.ResourcePojo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CreditCard extends AbstractResourcePojo 
implements ResourcePojo, ITokenDataOverridable, Billable,  CustomJson{
    private Map<String, Object> jsonMap = new HashMap<String, Object>();
    private String oid;
    private String expmonth;
    private String expyear;
    private String fullname;
    private String ipaddress;
    private String emailAddress;
    private String websiteRef;
    private String cardtype;
    private String accountoid;
    private String created;
    private String lastupdate;
    private String phone;
    private final String typeName = "paymentType";
    private String firstname;
    private String lastname;
    private String street1;
    private String street2;
    private String street3;
    private String city;
    private String state;
    private String country;
    private String postalcode;
    private String _id;
    private String context;

    private String cardnumber;
    private String securitynumber;
    
    // 2.0 specific fields
    private String displayNumber;
    private String expireMonth;
    private String expireYear;
    private String nameOnCard;
    private String pan;
    private String panFirst6;
    private String panLast4;
    private String panLength;
    private String securityCode;
    private String startMonth;
    private String startYear;
    private String type;
    private String issueNum;
    


    @Override
    public String get_id() {
        return _id;
    }

    @Override
    public void set_id(Object id) {
        this._id = (String) id;
    }

    public CreditCard() {
    }

    public CreditCard(CreditCard that) {
        this.cardnumber = that.cardnumber;
        this.expmonth = that.expmonth;
        this.expyear = that.expyear;
        this.fullname = that.fullname;
        this.ipaddress = that.ipaddress;
        this.emailAddress = that.emailAddress;
        this.securitynumber = that.securitynumber;
        this.websiteRef = that.websiteRef;
        this.cardtype = that.cardtype;
        this._id = that._id;
        this.oid = that.oid;
        this.accountoid = that.accountoid;
        this.created = that.created;
        this.lastupdate = that.lastupdate;
        this.phone = that.phone;
        this.firstname = that.firstname;
        this.lastname = that.lastname;
        this.street1 = that.street1;
        this.street2 = that.street2;
        this.street3 = that.street3;
        this.city = that.city;
        this.state = that.state;
        this.country = that.country;
        this.postalcode = that.postalcode;
        
        this.displayNumber = that.displayNumber;
        this.expireMonth = that.expireMonth;
        this.expireYear = that.expireYear;
        this.nameOnCard = that.nameOnCard;
        this.pan = that.pan;
        this.panFirst6 = that.panFirst6;
        this.panLast4 = that.panLast4;
        this.panLength = that.panLength;
        this.securityCode = that.securityCode;
        this.startMonth = that.startMonth;
        this.startYear = that.startYear;
        this.type = that.type;
        this.issueNum = that.issueNum;
        this.jsonMap = that.jsonMap;
    }


    public String getExpmonth() {
        return expmonth;
    }
    
    @Override
    public Map<String, Object> getProperties() {
        return this.jsonMap;
    }

    @Override
    public void setProperty(String key, Object value) {
        getProperties().put(key, value);
    }

    public void setExpmonth(String expmonth) {
        this.expmonth = expmonth;
    }

    public String getExpyear() {
        return expyear;
    }

    public void setExpyear(String expyear) {
        this.expyear = expyear;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public void setSecuritynumber(String securitynumber) {
        this.securitynumber = securitynumber;
    }

    public void setWebsiteRef(String websiteRef) {
        this.websiteRef = websiteRef;
    }

    public String getSecuritynumber() {
        return securitynumber;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public String getFullname() {
        return fullname;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public String getWebsiteRef() {
        return websiteRef;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public static String privatize(String acctNumber) {
        if (acctNumber == null || acctNumber.length() < 5) {
            return "xxxx";
        } else {
            return "..." + acctNumber.substring(acctNumber.length() - 4);
        }
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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    // Don't log the cardnumber or securitynumber
    @Override
    public String toString() {
        return "CreditCard [oid=" + oid + ", expmonth=" + expmonth + ", expyear=" + expyear + ", fullname=" + fullname
            + ", ipaddress=" + ipaddress + ", emailAddress=" + emailAddress + ", websiteRef=" + websiteRef
            + ", cardtype=" + cardtype + ", accountoid=" + accountoid + ", created=" + created + ", lastupdate="
            + lastupdate + ", phone=" + phone + ", typeName=" + typeName + ", firstname=" + firstname + ", lastname="
            + lastname + ", street1=" + street1 + ", street2=" + street2 +", street3=" + street3 + ", city=" + city + ", state=" + state
            + ", country=" + country + ", postalcode=" + postalcode + ", _id=" + _id + "]";
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public void setAccountId(String accountId) {
        this.accountoid = accountId;
    }

    @Override
    public String getAccountId() {
        return this.accountoid;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getDisplayNumber() {
        return displayNumber;
    }

    public void setDisplayNumber(String displayNumber) {
        this.displayNumber = displayNumber;
    }

    public String getExpireMonth() {
        return expireMonth;
    }

    public void setExpireMonth(String expireMonth) {
        this.expireMonth = expireMonth;
    }

    public String getExpireYear() {
        return expireYear;
    }

    public void setExpireYear(String expireYear) {
        this.expireYear = expireYear;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPanFirst6() {
        return panFirst6;
    }

    public void setPanFirst6(String panFirst6) {
        this.panFirst6 = panFirst6;
    }
    
    public String getPanLast4() {
        return panLast4;
    }

    public void setPanLast4(String panLast4) {
        this.panLast4 = panLast4;
    }

    public String getPanLength() {
        return panLength;
    }

    public void setPanLength(String panLength) {
        this.panLength = panLength;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIssueNum() {
        return issueNum;
    }

    public void setIssueNum(String issueNum) {
        this.issueNum = issueNum;
    }

}
