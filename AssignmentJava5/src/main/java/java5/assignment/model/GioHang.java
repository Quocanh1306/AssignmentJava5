package java5.assignment.model;

import java.util.HashMap;
import java.util.Map;

public class GioHang {
    //Long <-> ma san pham
    // Integer <-> so luong san pham
    private Map<Integer, Integer> danhSachSanPham = new HashMap<>();


    public Map<Integer, Integer> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(Map<Integer, Integer> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }
}
