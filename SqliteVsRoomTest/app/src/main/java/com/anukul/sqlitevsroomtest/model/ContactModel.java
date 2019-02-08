package com.anukul.sqlitevsroomtest.model;

public class ContactModel {
    private int id;
    private String name;
    private String lastName;
    private String phoneNo;
    private String email;

    public ContactModel(int id, String name, String lastName, String phoneNo, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public ContactModel() {

    }

    public ContactModel(String name, String lastName, String phoneNo, String email) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
