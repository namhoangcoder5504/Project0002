package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CHUONGTRINHDAOTAO")
public class ChuongTrinhDaoTao {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "nganh_hoc_id", referencedColumnName = "id")
    private NganhHoc nganhHoc;

    @Column(name = "ten")
    private String ten;

    @Column(name = "he_dao_tao")
    private String heDaoTao;

    @Column(name = "trinh_do")
    private String trinhDo;

    @Column(name = "tong_tin_chi")
    private int tongTinChi;

    @Column(name = "thoi_gian_dao_tao")
    private int thoiGianDaoTao;

    public ChuongTrinhDaoTao() {}

    public ChuongTrinhDaoTao(String id, NganhHoc nganhHoc, String ten, String heDaoTao, String trinhDo, int tongTinChi, int thoiGianDaoTao) {
        this.id = id;
        this.nganhHoc = nganhHoc;
        this.ten = ten;
        this.heDaoTao = heDaoTao;
        this.trinhDo = trinhDo;
        this.tongTinChi = tongTinChi;
        this.thoiGianDaoTao = thoiGianDaoTao;
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

    public String getHeDaoTao() {
        return heDaoTao;
    }

    public void setHeDaoTao(String heDaoTao) {
        this.heDaoTao = heDaoTao;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public int getTongTinChi() {
        return tongTinChi;
    }

    public void setTongTinChi(int tongTinChi) {
        this.tongTinChi = tongTinChi;
    }

    public int getThoiGianDaoTao() {
        return thoiGianDaoTao;
    }

    public void setThoiGianDaoTao(int thoiGianDaoTao) {
        this.thoiGianDaoTao = thoiGianDaoTao;
    }
}