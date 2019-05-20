package com.example.roommanage;

import java.io.Serializable;

public class Phieu implements Serializable {
    private String TenKh;
    private String NgayDat;
    private String SoNgayO;
    private String MaPhong;
    private String LoaiPhong;
    private String Tang;
    private String GiaPhong;

    public Phieu(String tenKh, String ngayDat, String soNgayO, String maPhong, String loaiPhong, String tang, String giaPhong) {
        TenKh = tenKh;
        NgayDat = ngayDat;
        SoNgayO = soNgayO;
        MaPhong = maPhong;
        LoaiPhong = loaiPhong;
        Tang = tang;
        GiaPhong = giaPhong;
    }

    public String getTenKh() {
        return TenKh;
    }

    public void setTenKh(String tenKh) {
        TenKh = tenKh;
    }

    public String getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(String ngayDat) {
        NgayDat = ngayDat;
    }

    public String getSoNgayO() {
        return SoNgayO;
    }

    public void setSoNgayO(String soNgayO) {
        SoNgayO = soNgayO;
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
