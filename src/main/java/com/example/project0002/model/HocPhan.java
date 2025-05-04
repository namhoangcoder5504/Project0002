package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "HOCPHAN")
public class HocPhan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "nganh_hoc_id", referencedColumnName = "id")
    private NganhHoc nganhHoc;

    @Column(name = "ten")
    private String ten;

    @Column(name = "tin_chi")
    private String tinChi;

    @Column(name = "tiet_ly_thuyet")
    private int tietLyThuyet;

    @Column(name = "tiet_thuc_hanh")
    private int tietThucHanh;

    public HocPhan() {}

    public HocPhan(String id, NganhHoc nganhHoc, String ten, String tinChi, int tietLyThuyet, int tietThucHanh) {
        this.id = id;
        this.nganhHoc = nganhHoc;
        this.ten = ten;
        this.tinChi = tinChi;
        this.tietLyThuyet = tietLyThuyet;
        this.tietThucHanh = tietThucHanh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NganhHoc getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(NganhHoc nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTinChi() {
        return tinChi;
    }

    public void setTinChi(String tinChi) {
        this.tinChi = tinChi;
    }

    public int getTietLyThuyet() {
        return tietLyThuyet;
    }

    public void setTietLyThuyet(int tietLyThuyet) {
        this.tietLyThuyet = tietLyThuyet;
    }

    public int getTietThucHanh() {
        return tietThucHanh;
    }

    public void setTietThucHanh(int tietThucHanh) {
        this.tietThucHanh = tietThucHanh;
    }
}