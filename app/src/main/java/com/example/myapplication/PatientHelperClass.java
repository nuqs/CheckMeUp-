package com.example.myapplication;

public class PatientHelperClass {
    private String ptID, name, gender, race, age, roomNo, date, injury;

    public PatientHelperClass(String ptID, String name, String roomNo) {
        this.ptID = ptID;
        this.name = name;
        this.roomNo = roomNo;
    }

    public PatientHelperClass() {}

    public String getPtID() {
        return ptID;
    }

    public void setPtID(String ptID) {
        this.ptID = ptID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
}
