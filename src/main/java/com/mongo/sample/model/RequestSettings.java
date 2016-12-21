package com.mongo.sample.model;

public class RequestSettings {

    @Override
    public String toString() {
        return "RequestSettings [environment=" + environment + ", partner=" + partner + ", context=" + context
                + ", datacenter=" + datacenter + ", sourceGroup=" + sourceGroup + "]";
    }

    private String environment;
    private String partner;
    private String context;
    private String datacenter;
    private String sourceGroup;
    private String accessToken ;
    private boolean decorateQuery = true;
    public boolean decorateQuery() {
        return decorateQuery;
    }
    public void setDecorateQuery(boolean b){
        decorateQuery = b;
    }
    
    public RequestSettings(
            String at,
            String environment, String partner, String context, String datacenter, String sourceGroup) {
        this(environment, partner, context, datacenter, sourceGroup);

        accessToken = at;
    }
    public RequestSettings(String environment, String partner, String context, String datacenter, String sourceGroup) {
        this(environment, partner, context, datacenter);
        this.sourceGroup = sourceGroup;
    }

    public RequestSettings(String environment, String partner, String context, String datacenter) {
        this.environment = environment;
        this.partner = partner;
        this.context = context;
        this.datacenter = datacenter;
    }

    public RequestSettings() {
    }

    /*public RequestSettings getInstance(OAuth2TokenData tokenData, String context, RequestMap queryParams) {
        final String ENVIRONMENT = "environment";
        final String PARTNER = "partner";
        final String DATACENTER = "datacenter";
        final String SOURCE_GROUP = "sourceGroup";

        String environment = null;
        String partner = null;
        String datacenter = null;
        String sourceGroup = null;
        String accessToken = null ;

        RequestSettings env;

        if (tokenData != null) {
            accessToken = tokenData.getAccess_token();
            environment = tokenData.getEnvironment();
            partner = tokenData.getPartnerId();
            datacenter = tokenData.getDataCenter();
            sourceGroup = tokenData.getSourceGroup();

            if ((tokenData.getUserId() == null || tokenData.getUserId() == "")
                    && tokenContainsRole(tokenData, Role.CSR, Role.COM)) {

                if (queryParams.contains(ENVIRONMENT)) {
                    environment = queryParams.get(ENVIRONMENT);
                }
                if (queryParams.contains(PARTNER)) {
                    partner = queryParams.get(PARTNER);
                }
                if (queryParams.contains(DATACENTER)) {
                    datacenter = queryParams.get(DATACENTER);
                }
                if (queryParams.contains(SOURCE_GROUP)) {
                    sourceGroup = queryParams.get(SOURCE_GROUP);
                }

            }
            env = new RequestSettings(accessToken, environment, partner, context, datacenter, sourceGroup);
        } else {
            if (context != null) {
//               / env = DBUtils.getConfigSettings(context);
            } else {
                env = new RequestSettings();
            }
        }
        
        if (env.getEnvironment() == null && CommonConfig.useLegacy()) {
            env.setEnvironment(Environment.DEV.getEnv());
        }
        
        SPLUNK.log("getRequestSettings", pair("env", environment), pair("partner", partner),
                pair("sourceGroup", sourceGroup), pair("context", context), pair("datacenter", datacenter));
        return env;
    }*/

    public String getEnvironment() {
        return environment;
    }

    public String getPartner() {
        return partner;
    }

    public String getContext() {
        return context;
    }
    
    /**
     * This not ideal!. this class should be immutable. But there are cases where context will be overridden!
     * @param s
     */
    @Deprecated
    public void setPartner(String s) {
        partner = s;
    }
    
    /**
     * This not ideal!. this class should be immutable. But there are cases where context will be overridden!
     * @param s
     */
    @Deprecated
    public void setDataCenter(String dc) {
        datacenter = dc;
    }
    
    /**
     * This not ideal!. this class should be immutable. But there are cases where context will be overridden!
     * @param s
     */
    @Deprecated
    public void setEnvironment(String e) {
        environment = e;
    }
    
    /**
     * This not ideal!. this class should be immutable. But there are cases where context will be overridden!
     * @param s
     */
    @Deprecated
    public void setContext(String s) {
        context = s;
    }

    public String getDataCenter() {
        return datacenter;
    }

    public String getSourceGroup() {
        return this.sourceGroup;
    }
    
    public String getAccessToken() {
        return this.accessToken;
    }

    /*private boolean tokenContainsRole(OAuth2TokenData tokenData, Role... roles) {
        if (tokenData == null)
            return false;
        if (tokenData.getRoles() == null)
            return false;
        for (Role role : roles) {
            if (tokenData.getRoles().contains(role.name()))
                return true;
            if (tokenData.getRoles().contains("[" + role.name() + "]"))
                return true;
        }
        return false;
    }*/
}
