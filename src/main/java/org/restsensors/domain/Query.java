package org.restsensors.domain;

/**
 * Created by azygm on 21.04.2017.
 */
public class Query {
    private String operation;
    private int value;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

