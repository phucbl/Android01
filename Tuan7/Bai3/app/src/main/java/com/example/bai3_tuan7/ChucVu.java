package com.example.bai3_tuan7;


public enum ChucVu {

    TruongPhong("Trưởng Phòng"),
    PhoPhong("Phó Phòng"),
    NhanVien("Nhân Viên");
    private String cv;
    ChucVu(String cv)
    {
        this.cv=cv;
    }
    public String getChucVu()
    {
        return this.cv;
    }
}
