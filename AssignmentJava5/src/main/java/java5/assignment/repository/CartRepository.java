package java5.assignment.repository;

import java5.assignment.model.GioHangDomainModel;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Map;
@Repository
@SessionScope
public class CartRepository {
    private GioHangDomainModel gioHang = new GioHangDomainModel();
    public void themSanPhamVaoGio(Integer maSanPham, Integer soLuong) {
        Map<Integer, Integer> sanPhamTrongGio = gioHang.getDanhSachSanPham();
        sanPhamTrongGio.put(maSanPham, soLuong);
    }
    public Integer laySoLuongSanPhamTrongGio(Integer maSanPham) {
        return gioHang.getDanhSachSanPham().get(maSanPham);
    }
    public void suaSoLuongSanPhamTrongGio(Integer maSanPham, Integer soLuongCapNhat) {
        Map<Integer, Integer> sanPhamTrongGio = gioHang.getDanhSachSanPham();
        Integer soLuongHienCo = sanPhamTrongGio.get(maSanPham);
        sanPhamTrongGio.put(maSanPham, soLuongHienCo + soLuongCapNhat);
    }
    public void boSanPhamKhoiGio(Integer maSanPham) {
        Map<Integer, Integer> sanPhamTrongGio = gioHang.getDanhSachSanPham();
        sanPhamTrongGio.remove(maSanPham);
    }
    public GioHangDomainModel xemGioHang() {
        return gioHang;
    }
    public boolean sanPhamDaCoTrongGio(Integer maSanPham) {
        return gioHang.getDanhSachSanPham().containsKey(maSanPham);
    }
    public GioHangDomainModel layGioHang() {
        return gioHang;
    }
}
