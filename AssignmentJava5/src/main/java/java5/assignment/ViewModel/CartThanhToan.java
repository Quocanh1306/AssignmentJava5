package java5.assignment.ViewModel;

import java.math.BigDecimal;

public class CartThanhToan {
    private int maGioHang;
    private int maSanPham;
    private int soLuong;
    private BigDecimal donGia;

    public CartThanhToan() {
    }

    public CartThanhToan(int maGioHang, int maSanPham, int soLuong, BigDecimal donGia) {
        this.maGioHang = maGioHang;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }
}
