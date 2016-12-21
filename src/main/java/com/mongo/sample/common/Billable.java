package com.mongo.sample.common;

/**
 * Implementors provide a billing address
 * 
 * © Copyright 2015 Snapfish LLC
 */
public interface Billable {

    String getFirstname();

    String getLastname();

    String getStreet1();

    String getStreet2();

    String getCity();

    String getState();

    String getCountry();

    String getPostalcode();
}
