package com.mongo.sample.common;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Things that implement this interface can be sharded by mongo.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public interface Shardable {
    long getShardKey();

    void setShardKey(long shardKey);
    
    String getDataCenter() ;
    void setDataCenter(String dc);
    
    String getEnvironment() ;
    void setEnvironment(String env);

    int getAccountHash();

    void setAccountHash(int accountHash);
    
}
