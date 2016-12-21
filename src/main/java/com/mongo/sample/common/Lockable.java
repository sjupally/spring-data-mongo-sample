package com.mongo.sample.common;

/**
 * © Copyright 2013 Snapfish LLC
 */
public interface Lockable {

    String RECORD_SEQ = "recordSeq";

    long getRecordSeq();

    void setRecordSeq(long recordSeq);
}
