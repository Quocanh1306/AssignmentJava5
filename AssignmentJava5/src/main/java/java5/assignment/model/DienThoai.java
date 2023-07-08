package java5.assignment.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "dienthoai")
public class DienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "madienthoai")
    private int maDienThoai;

    @Column(name = "ten")
    private String tenDienThoai;

    @Column(name = "dongia")
    private BigDecimal donGia;

    @Column(name = "dungluong")
    private int dungLuong;

    @Column(name = "hang")
    private String hangDienThoai;

    @Column(name = "ram")
    private int ram;

    @Column(name = "anh")
    private String anh;

    @Column(name = "giasaukm")
    private BigDecimal giaSauKM;

    @Column(name = "khuyen_mai")
    private String khuyenMai;

    @Column(name = "soluong")
    private int soLuong;
    public DienThoai() {
    }

    public DienThoai(int maDienThoai, String tenDienThoai, BigDecimal donGia, int dungLuong, String hangDienThoai, int ram, String anh, BigDecimal giaSauKM, String khuyenMai, int soLuong) {
        this.maDienThoai = maDienThoai;
        this.tenDienThoai = tenDienThoai;
        this.donGia = donGia;
        this.dungLuong = dungLuong;
        this.hangDienThoai = hangDienThoai;
        this.ram = ram;
        this.anh = anh;
        this.giaSauKM = giaSauKM;
        this.khuyenMai = khuyenMai;
        this.soLuong = soLuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaSauKM() {
        return giaSauKM;
    }

    public void setGiaSauKM(BigDecimal giaSauKM) {
        this.giaSauKM = giaSauKM;
    }

    public String getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public int getMaDienThoai() {
        return maDienThoai;
    }

    public void setMaDienThoai(int maDienThoai) {
        this.maDienThoai = maDienThoai;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public int getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(int dungLuong) {
        this.dungLuong = dungLuong;
    }

    public String getHangDienThoai() {
        return hangDienThoai;
    }

    public void setHangDienThoai(String hangDienThoai) {
        this.hangDienThoai = hangDienThoai;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
}
