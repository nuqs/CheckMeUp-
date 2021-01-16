package com.example.myapplication;

public class PatientVital {
    String date, time, bp1, bp2, pulse, pain, medication, remarks;

    public PatientVital(String date, String time, String bp1, String bp2, String pulse, String pain, String medication, String remarks) {
        this.date = date;
        this.time = time;
        this.bp1 = bp1;
        this.bp2 = bp2;
        this.pulse = pulse;
        this.pain = pain;
        this.medication = medication;
        this.remarks = remarks;
    }

    public PatientVital() {}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBp1() {
        return bp1;
    }

    public void setBp1(String bp1) {
        this.bp1 = bp1;
    }

    public String getBp2() {
        return bp2;
    }

    public void setBp2(String bp2) {
        this.bp2 = bp2;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getPain() {
        return pain;
    }

    public void setPain(String pain) {
        this.pain = pain;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
