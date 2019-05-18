package com.example.roommanage;

public class KhachHang {
    private String MaKH;
    private String TenKH;
    private String QuocTich;

    public KhachHang(String maKH, String tenKH, String quocTich) {
        MaKH = maKH;
        TenKH = tenKH;
        QuocTich = quocTich;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getQuocTich() {
        return QuocTich;
    }

    public void setQuocTich(String quocTich) {
        QuocTich = quocTich;
    }
}
