package com.example.roommanage;

import java.io.Serializable;

public class Room implements Serializable {
    private String MaPhong;
    private String LoaiPhong;
    private String Tang;
    private String GiaPhong;

    public Room(String maPhong, String loaiPhong, String tang, String giaPhong) {
        MaPhong = maPhong;
        LoaiPhong = loaiPhong;
        Tang = tang;
        GiaPhong = giaPhong;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String maPhong) {
        MaPhong = maPhong;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        LoaiPhong = loaiPhong;
    }

    public String getTang() {
        return Tang;
    }

    public void setTang(String tang) {
        Tang = tang;
    }

    public String getGiaPhong() {
        return GiaPhong;
    }

    public void setGiaPhong(String giaPhong) {
        GiaPhong = giaPhong;
    }
}
