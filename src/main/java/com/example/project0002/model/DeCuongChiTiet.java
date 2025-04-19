package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DECUONGCHITIET")
public class DeCuongChiTiet {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "hoc_phan_id", referencedColumnName = "id")
    private HocPhan hocPhan;

    @Column(name = "muc_tieu")
    private String mucTieu;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "phuong_phap_danh_gia")
    private String phuongPhapDanhGia;

    @Column(name = "tai_lieu_tham_khao")
    private String taiLieuThamKhao;

    public DeCuongChiTiet() {}

    public DeCuongChiTiet(String id, HocPhan hocPhan, String mucTieu, String noiDung, String phuongPhapDanhGia, String taiLieuThamKhao) {
        this.id = id;
        this.hocPhan = hocPhan;
        this.mucTieu = mucTieu;
        this.noiDung = noiDung;
        this.phuongPhapDanhGia = phuongPhapDanhGia;
        this.taiLieuThamKhao = taiLieuThamKhao;
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

    public String getMucTieu() {
        return mucTieu;
    }

    public void setMucTieu(String mucTieu) {
        this.mucTieu = mucTieu;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getPhuongPhapDanhGia() {
        return phuongPhapDanhGia;
    }

    public void setPhuongPhapDanhGia(String phuongPhapDanhGia) {
        this.phuongPhapDanhGia = phuongPhapDanhGia;
    }

    public String getTaiLieuThamKhao() {
        return taiLieuThamKhao;
    }

    public void setTaiLieuThamKhao(String taiLieuThamKhao) {
        this.taiLieuThamKhao = taiLieuThamKhao;
    }
}