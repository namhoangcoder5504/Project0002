package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "GIANGVIEN")
public class GiangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "khoa_id", referencedColumnName = "id")
    private Khoa khoa;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "trinh_do")
    private String trinhDo;

    @Column(name = "chuyen_mon")
    private String chuyenMon;

    public GiangVien() {}

    public GiangVien(String id, Khoa khoa, User user, String hoTen, String trinhDo, String chuyenMon) {
        this.id = id;
        this.khoa = khoa;
        this.user = user;
        this.hoTen = hoTen;
        this.trinhDo = trinhDo;
        this.chuyenMon = chuyenMon;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }
}