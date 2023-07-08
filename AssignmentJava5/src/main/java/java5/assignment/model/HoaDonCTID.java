package java5.assignment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class HoaDonCTID implements Serializable {
    @Column(name = "mahoadon")
    private int maHoaDon;
    @Column(name = "masanpham")
    private int maSanPham;

    public HoaDonCTID() {
    }

    public HoaDonCTID(int maHoaDon, int maSanPham) {
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }
}
