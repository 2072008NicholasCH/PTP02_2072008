package com.example.ptp02_2072008.model;

public class Student {
    private int nrp;
    private String nama;
    private float ipa;
    private float ips;

    public Student(int nrp, String nama, float ipa, float ips) {
        this.nrp = nrp;
        this.nama = nama;
        this.ipa = ipa;
        this.ips = ips;
    }

    public int getNrp() {
        return nrp;
    }

    public void setNrp(int nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public float getIpa() {
        return ipa;
    }

    public void setIpa(float ipa) {
        this.ipa = ipa;
    }

    public float getIps() {
        return ips;
    }

    public void setIps(float ips) {
        this.ips = ips;
    }
}
