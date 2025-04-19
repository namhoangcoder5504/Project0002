package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "COTDIEM")
public class CotDiem {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "de_cuong_id", referencedColumnName = "id")
    private DeCuongChiTiet deCuongChiTiet;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mo_ta")
    private String moTa;

    public CotDiem() {}

    public CotDiem(String id, DeCuongChiTiet deCuongChiTiet, String ten, String moTa) {
        this.id = id;
        this.deCuongChiTiet = deCuongChiTiet;
        this.ten = ten;
        this.moTa = moTa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DeCuongChiTiet getDeCuongChiTiet() {
        return deCuongChiTiet;
    }

    public void setDeCuongChiTiet(DeCuongChiTiet deCuongChiTiet) {
        this.deCuongChiTiet = deCuongChiTiet;
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
