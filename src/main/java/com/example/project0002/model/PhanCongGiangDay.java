package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PHANCONGGIANGDAY")
public class PhanCongGiangDay {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "giang_vien_id", referencedColumnName = "id")
    private GiangVien giangVien;

    @Column(name = "so_tiet")
    private String soTiet;

    public PhanCongGiangDay() {}

    public PhanCongGiangDay(String id, GiangVien giangVien, String soTiet) {
        this.id = id;
        this.giangVien = giangVien;
        this.soTiet = soTiet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public String getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(String soTiet) {
        this.soTiet = soTiet;
    }
}