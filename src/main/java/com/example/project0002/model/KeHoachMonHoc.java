package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "KEHOACHMONHOC")
public class KeHoachMonHoc {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "hoc_phan_id", referencedColumnName = "id")
    private HocPhan hocPhan;

    @Column(name = "nam_hoc")
    private int namHoc;

    @Column(name = "so_luong")
    private String soLuong;

    @Column(name = "thoi_gian_bat_dau_thuc")
    private String thoiGianBatDauThuc;

    @Column(name = "thoi_gian_ket_thuc")
    private String thoiGianKetThuc;

    public KeHoachMonHoc() {}

    public KeHoachMonHoc(String id, HocPhan hocPhan, int namHoc, String soLuong, String thoiGianBatDauThuc, String thoiGianKetThuc) {
        this.id = id;
        this.hocPhan = hocPhan;
        this.namHoc = namHoc;
        this.soLuong = soLuong;
        this.thoiGianBatDauThuc = thoiGianBatDauThuc;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HocPhan getHocPhan() {
        return hocPhan;
    }

    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getThoiGianBatDauThuc() {
        return thoiGianBatDauThuc;
    }

    public void setThoiGianBatDauThuc(String thoiGianBatDauThuc) {
        this.thoiGianBatDauThuc = thoiGianBatDauThuc;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }
}