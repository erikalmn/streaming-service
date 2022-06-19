package com.company.domain;

public class User {
    private String name;
    private String document;
    private String phone;
    private String email;

    public User(String name, String document, String phone, String email) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User {" +
                "name = '" + name + '\'' +
                ", document = '" + document + '\'' +
                ", phone = '" + phone + '\'' +
                '}';
    }
}