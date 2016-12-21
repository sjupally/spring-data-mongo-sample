package com.mongo.sample.constants;


public enum FailureReasonCode {
    InvalidFulfillableData(10),
    CorruptedImageFile(20),
    UnsupportedFileType(30),
    DuplicateOrder(40),
    ImageRetrievalFailed(50),
    MissingImage(60),
    Busy(70),
    ProjectError(80),
    MissingVendor(90),
    OrderError(100),
    UnknownError(666);
    

    private final Integer code;

    private FailureReasonCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
