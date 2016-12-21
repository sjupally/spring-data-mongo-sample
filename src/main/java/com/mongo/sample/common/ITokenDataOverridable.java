package com.mongo.sample.common;

public interface ITokenDataOverridable {
    public void setAccountId(String accountId);

    public void setContext(String context);

    public String getAccountId();

    public String getContext();
}
