package com.example.myapplication;

public class User {
    private String staffID;
    private String staffName;

    public User(String staffID, String staffName) {
        this.staffID = staffID;
        this.staffName = staffName;
    }

    public User() {}

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
