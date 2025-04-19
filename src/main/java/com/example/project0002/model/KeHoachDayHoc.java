package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "KEHOACHDAYHOC")
public class KeHoachDayHoc {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "hoc_phan_id", referencedColumnName = "id")
    private HocPhan hocPhan;

    @Column(name = "hoc_ky")
    private int hocKy;

    @Column(name = "nam_hoc")
    private int namHoc;

    public KeHoachDayHoc() {}

    public KeHoachDayHoc(String id, HocPhan hocPhan, int hocKy, int namHoc) {
        this.id = id;
        this.hocPhan = hocPhan;
        this.hocKy = hocKy;
        this.namHoc = namHoc;
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

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }
}