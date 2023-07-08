package java5.assignment.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.EnableMBeanExport;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hoadon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mahoadon")
    private int maHoaDon;
    @Column(name = "ngaythanhtoan")
    private Date ngayThanhToan;
    @Column(name = "nguoimua")
    private int nguoiMua;

    public HoaDon() {
    }

    public HoaDon(int maHoaDon, Date ngayThanhToan, int nguoiMua) {
        this.maHoaDon = maHoaDon;
        this.ngayThanhToan = ngayThanhToan;
        this.nguoiMua = nguoiMua;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getNguoiMua() {
        return nguoiMua;
    }

    public void setNguoiMua(int nguoiMua) {
        this.nguoiMua = nguoiMua;
    }
}
