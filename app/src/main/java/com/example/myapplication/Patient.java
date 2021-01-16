package com.example.myapplication;

public class Patient {
    private String ptID;
    private String roomNo;
    private String ptName;

    public Patient(String ptID, String roomNo, String ptName) {
        this.ptID = ptID;
        this.roomNo = roomNo;
        this.ptName = ptName;
    }

    public Patient() {}

    public String getPtID() {
        return ptID;
    }

    public void setPtID(String ptID) {
        this.ptID = ptID;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getPtName() {
        return ptName;
    }

    public void setPtName(String ptName) {
        this.ptName = ptName;
    }
}
