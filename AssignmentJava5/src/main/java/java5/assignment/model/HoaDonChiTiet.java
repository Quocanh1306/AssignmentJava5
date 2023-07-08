package java5.assignment.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "hoadonchitiet")

public class HoaDonChiTiet {
    @EmbeddedId
    private HoaDonCTID hoaDonCTID;
    @Column(name = "soluong")
    private int soLuong;

    @Column(name = "dongia")
    private BigDecimal donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(HoaDonCTID hoaDonCTID, int soLuong, BigDecimal donGia) {
        this.hoaDonCTID = hoaDonCTID;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public HoaDonCTID getHoaDonCTID() {
        return hoaDonCTID;
    }

    public void setHoaDonCTID(HoaDonCTID hoaDonCTID) {
        this.hoaDonCTID = hoaDonCTID;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
