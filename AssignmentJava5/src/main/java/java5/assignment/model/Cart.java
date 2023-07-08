package java5.assignment.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "giohang")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "magiohang")
    private int maGioHang;

    @Column(name = "nguoisohuu")
    private int nguoiSoHuu;

    public Cart() {
    }

    public Cart(int maGioHang, int nguoiSoHuu) {
        this.maGioHang = maGioHang;
        this.nguoiSoHuu = nguoiSoHuu;
    }

    public int getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(int maGioHang) {
        this.maGioHang = maGioHang;
    }

    public int getNguoiSoHuu() {
        return nguoiSoHuu;
    }

    public void setNguoiSoHuu(int nguoiSoHuu) {
        this.nguoiSoHuu = nguoiSoHuu;
    }
}
