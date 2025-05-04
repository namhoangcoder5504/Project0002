package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "NHOMKIENTHUC")
public class NhomKienThuc {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "kcl_id", referencedColumnName = "id")
    private ChuongTrinhDaoTao chuongTrinhDaoTao;

    @Column(name = "ten")
    private String ten;

    @Column(name = "tin_chi_bat_buoc")
    private int tinChiBatBuoc;

    @Column(name = "tin_chi_tu_chon")
    private int tinChiTuChon;

    public NhomKienThuc() {}

    public NhomKienThuc(String id, ChuongTrinhDaoTao chuongTrinhDaoTao, String ten, int tinChiBatBuoc, int tinChiTuChon) {
        this.id = id;
        this.chuongTrinhDaoTao = chuongTrinhDaoTao;
        this.ten = ten;
        this.tinChiBatBuoc = tinChiBatBuoc;
        this.tinChiTuChon = tinChiTuChon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChuongTrinhDaoTao getChuongTrinhDaoTao() {
        return chuongTrinhDaoTao;
    }

    public void setChuongTrinhDaoTao(ChuongTrinhDaoTao chuongTrinhDaoTao) {
        this.chuongTrinhDaoTao = chuongTrinhDaoTao;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTinChiBatBuoc() {
        return tinChiBatBuoc;
    }

    public void setTinChiBatBuoc(int tinChiBatBuoc) {
        this.tinChiBatBuoc = tinChiBatBuoc;
    }

    public int getTinChiTuChon() {
        return tinChiTuChon;
    }

    public void setTinChiTuChon(int tinChiTuChon) {
        this.tinChiTuChon = tinChiTuChon;
    }
}