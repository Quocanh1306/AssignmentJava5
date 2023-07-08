package java5.assignment.model;

import java.util.HashMap;
import java.util.Map;

public class GioHangDomainModel {
    private final Map<Integer, Integer> DANH_SACH_SAN_PHAM = new HashMap<>();
    public Map<Integer, Integer> getDanhSachSanPham() {
        return DANH_SACH_SAN_PHAM;
    }
}
