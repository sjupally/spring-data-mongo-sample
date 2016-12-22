package com.mongo.sample.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "countries", "provinces", "cities", "zips" })
public class ShippingAddressRule {
    /***
     * If more than one of country, provinces, cities, zips are specified then
     * all must match the shipping address of the ShipBin for this rule to
     * apply.
     * 
     * Within countries, provinces, or cities, or zips, then the list is an OR.
     * 
     * Thus, it would not typically make sense to specify multiple provinces
     * along with multiple cities or zips (unless the city/zip crosses the state
     * border).
     * 
     * The zips may be specified as an individual postal code (e.g. 80526) or an
     * inclusive range (e.g. 10701:10710). Ranges work with non-numeric using
     * natural ordering of the strings... note this may not actually be
     * meaningful in the jurisdiction.
     */
    private String description;
    private List<String> countries;
    private List<String> provinces;
    private List<String> cities;
    private List<String> postalCodes;
    private List<DispersionTarget> targets;

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<String> provinces) {
        this.provinces = provinces;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<String> getPostalCodes() {
        return postalCodes;
    }

    public void setPostalCodes(List<String> postalCodes) {
        this.postalCodes = postalCodes;
    }

    public List<DispersionTarget> getTargets() {
        return targets;
    }

    public void setTargets(List<DispersionTarget> targets) {
        this.targets = targets;
    }

    public ShippingAddressRule() {
    }

    // just a helper for testing
    public ShippingAddressRule(String country, String province, String city,
            String postalCode) {
        if (country != null) {
            countries = new ArrayList<String>();
            countries.add(country);
        }
        if (province != null) {
            provinces = new ArrayList<String>();
            provinces.add(province);
        }
        if (city != null) {
            cities = new ArrayList<String>();
            cities.add(city);
        }
        if (postalCode != null) {
            postalCodes = new ArrayList<String>();
            postalCodes.add(postalCode);
        }
    }

    public boolean hasCountries() {
        return countries != null && countries.size() > 0;
    }

    public boolean hasProvinces() {
        return provinces != null && provinces.size() > 0;
    }

    public boolean hasCities() {
        return cities != null && cities.size() > 0;
    }

    public boolean hasPostalCodes() {
        return postalCodes != null && postalCodes.size() > 0;
    }

    @Override
    public String toString() {
        return "ShippingAddressRule [desc=" + description + ", countries="
                + countries + ", provinces=" + provinces + ", cities=" + cities
                + ", postalCodes=" + postalCodes + ", targets=" + targets + "]";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
