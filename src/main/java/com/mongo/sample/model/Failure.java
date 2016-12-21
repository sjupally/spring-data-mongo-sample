package com.mongo.sample.model;

import java.util.List;
import java.util.UUID;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mongo.sample.constants.FailureReasonCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Failure {
    private String projectId;
    private UUID trackerId = null;
    private String errorId;
    private FailureReasonCode reasonCode;
    private String client;
    private Object reasonDetail;
    private List<String> imageList;
    
    public Failure() {
        init();
    }
    
    public Failure(Exception e) {
        init();
        setReasonDetail(e);
    }
    
    private void init() {
        generateErrorId();
        setReasonCode(FailureReasonCode.UnknownError);
        setReasonDetail("Reason detail not given.");
    }
    
    private void generateErrorId() {
        setErrorId("error");
    }

    public UUID getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(UUID trackerId) {
        this.trackerId = trackerId;
    }

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public Object getReasonDetail() {
        return reasonDetail;
    }

    public void setReasonDetail(Object reasonDetail) {
        this.reasonDetail = reasonDetail;
    }

    public FailureReasonCode getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(FailureReasonCode reasonCode) {
        this.reasonCode = reasonCode;
    }
    
    public String getClient() {
        return client;
    }
    
    public void setClient(String client) {
        this.client = client;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

	@Override
	public String toString() {
		return "Failure [projectId=" + projectId + ", trackerId=" + trackerId + ", errorId=" + errorId
				+ ", reasonCode=" + reasonCode + ", client=" + client + ", reasonDetail=" + reasonDetail
				+ ", imageList=" + imageList + "]";
	}

}
