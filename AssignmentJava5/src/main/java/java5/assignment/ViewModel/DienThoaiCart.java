package java5.assignment.ViewModel;

import java.math.BigDecimal;

public class DienThoaiCart {
    private int maSanPham;
    private String ten;
    private String anh;
    private BigDecimal donGia;
    private int soLuong;
    private int ram;
    private int dungLuong;

    public DienThoaiCart() {
    }

    public DienThoaiCart(int maSanPham, String ten, String anh, BigDecimal donGia, int soLuong, int ram, int dungLuong) {
        this.maSanPham = maSanPham;
        this.ten = ten;
        this.anh = anh;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.ram = ram;
        this.dungLuong = dungLuong;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }


    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(int dungLuong) {
        this.dungLuong = dungLuong;
    }
}
