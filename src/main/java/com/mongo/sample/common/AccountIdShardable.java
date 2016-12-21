package com.mongo.sample.common;


public interface AccountIdShardable extends Shardable {

    String getAccountId();

    void setAccountId(String accountId);
}
