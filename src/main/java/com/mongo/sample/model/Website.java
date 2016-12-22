package com.mongo.sample.model;

import com.mongo.sample.common.ResourcePojo;
import org.bson.types.ObjectId;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "websites")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Website extends AbstractResourcePojo
implements ResourcePojo {

    private String name;
    private List<CobrandDispersionRules> cobrandDispersionRules;
    ObjectId _id;

    public Website() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CobrandDispersionRules> getCobrandDispersionRules() {
        return cobrandDispersionRules;
    }

    public CobrandDispersionRules getCobrandDispersionRules(String cobrand) {
        CobrandDispersionRules defaultRules = null;
        for (CobrandDispersionRules cbRules : cobrandDispersionRules) {
            String name = cbRules.getCobrand();
            if (name.equals("default")) {
                defaultRules = cbRules;
            } else if (name.equals(cobrand)) {
                return cbRules;
            }
        }
        return defaultRules;
    }

    public void setCobrandDispersionRules(
            List<CobrandDispersionRules> cobrandRules) {
        this.cobrandDispersionRules = cobrandRules;
    }

    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Website other = (Website) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    
	@Override
	public ObjectId get_id() {
		return _id;
	}

	@Override
	public void set_id(Object id) {
	   _id = (ObjectId) id;	
	}
}
