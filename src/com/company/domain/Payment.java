package com.company.domain;

public class Payment {
    private final String type;
    private final String status;

    public Payment(String type, String status) {
        this.type = type;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment {" +
                "type = '" + type + '\'' +
                ", status = '" + status + '\'' +
                '}';
    }
}