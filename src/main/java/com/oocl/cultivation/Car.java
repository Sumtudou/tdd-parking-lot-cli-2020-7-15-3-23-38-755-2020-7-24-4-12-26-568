package com.oocl.cultivation;

public class Car {
    private String id = null;
    private String errorMsg = null;

    public Car(String id){
        this.id = id;
    }
    public Car(){}

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getId() {
        return id;
    }
}
