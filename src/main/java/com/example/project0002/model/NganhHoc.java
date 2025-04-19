package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "NGANHHOC")
public class NganhHoc {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "khoa_id", referencedColumnName = "id")
    private Khoa khoa;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mo_ta")
    private String moTa;

    public NganhHoc() {}

    public NganhHoc(String id, Khoa khoa, String ten, String moTa) {
        this.id = id;
        this.khoa = khoa;
        this.ten = ten;
        this.moTa = moTa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}