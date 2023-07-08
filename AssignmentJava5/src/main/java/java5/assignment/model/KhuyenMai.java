package java5.assignment.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "phieugiamgia")
public class KhuyenMai {
    @Id
    @Column(name = "maphieu")
    private int maPhieu;

    @Column(name = "tenphieu")
    private String tenPhieu;


    @Column(name = "giatrigiam")
    private int giaTriGiam;
    @Column(name = "madienthoai")
    private int maDienThoai;
    public KhuyenMai() {
    }

    public KhuyenMai(int maPhieu, String tenPhieu, int giaTriGiam, int maDienThoai) {
        this.maPhieu = maPhieu;
        this.tenPhieu = tenPhieu;
        this.giaTriGiam = giaTriGiam;
        this.maDienThoai = maDienThoai;
    }

    public int getMaDienThoai() {
        return maDienThoai;
    }

    public void setMaDienThoai(int maDienThoai) {
        this.maDienThoai = maDienThoai;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getTenPhieu() {
        return tenPhieu;
    }

    public void setTenPhieu(String tenPhieu) {
        this.tenPhieu = tenPhieu;
    }


    public int getGiaTriGiam() {
        return giaTriGiam;
    }

    public void setGiaTriGiam(int giaTriGiam) {
        this.giaTriGiam = giaTriGiam;
    }
}
