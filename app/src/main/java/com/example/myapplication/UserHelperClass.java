package com.example.myapplication;

public class UserHelperClass {
    String staffName, staffID, password;

    public UserHelperClass() {}

    public UserHelperClass(String staffName, String staffID, String password) {
        this.staffName = staffName;
        this.staffID = staffID;
        this.password = password;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
