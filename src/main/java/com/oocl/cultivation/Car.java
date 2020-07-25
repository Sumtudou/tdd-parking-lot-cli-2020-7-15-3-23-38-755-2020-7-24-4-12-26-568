package com.oocl.cultivation;

public class Car extends Message{
    private String id = null;

    public Car(String id){
        this.id = id;
    }
    public Car(){}


    public String getId() {
        return id;
    }
}
