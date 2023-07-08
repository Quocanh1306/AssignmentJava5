package java5.assignment.service;

import java5.assignment.model.GioHang;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GioHangService {

    private final GioHang gioHang = new GioHang();

    public void themSanPham(int sanPhamId, Integer soLuong) {
        Map<Integer, Integer> dsSanPham = gioHang.getDanhSachSanPham();
        // neu danh sach san pham da co hang
        if(dsSanPham.containsKey(sanPhamId)) {
            //1. Lay so luong hien tai
            Integer soLuongHienTai = dsSanPham.get(sanPhamId);
            //2. COng don
            Integer soLuongMoi = soLuongHienTai + soLuong;
            //3. Cap nhat lai danh sach
            dsSanPham.put(sanPhamId, soLuongMoi);
        }else {
            dsSanPham.put(sanPhamId, soLuong);
        }
    }
    public Map<Integer, Integer> xemSanPham() {

        return gioHang.getDanhSachSanPham();
    }

}
