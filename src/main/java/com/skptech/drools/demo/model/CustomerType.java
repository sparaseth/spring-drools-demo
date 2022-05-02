package com.skptech.drools.demo.model;

public enum CustomerType {

    LOYAL, NEW, DISSATISFIED;

    public String getValue() {
        return this.toString();
    }

}
