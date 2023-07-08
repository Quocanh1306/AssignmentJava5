package java5.assignment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CartDetailID implements Serializable {
    @Column(name = "magiohang")
    private int maGioHang;
    @Column(name = "masanpham")
    private int maSanPham;

    public CartDetailID() {
    }

    public CartDetailID(int maGioHang, int maSanPham) {
        this.maGioHang = maGioHang;
        this.maSanPham = maSanPham;
    }

    public int getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(int maGioHang) {
        this.maGioHang = maGioHang;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }
}
