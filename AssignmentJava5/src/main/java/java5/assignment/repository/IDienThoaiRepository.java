package java5.assignment.repository;

import java5.assignment.ViewModel.DienThoaiThongKe;
import java5.assignment.ViewModel.Top10BanChay;
import java5.assignment.ViewModel.Top10Ton;
import java5.assignment.model.DienThoai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IDienThoaiRepository extends JpaRepository<DienThoai, Integer> {
    Page<DienThoai> findByTenDienThoaiContains(String key, Pageable pageable);
    Page<DienThoai> findByDonGiaBetween(BigDecimal min, BigDecimal max, Pageable pageable);
    Page<DienThoai> findDienThoaiByRamIs(int ram, Pageable pageable);
    Page<DienThoai> findDienThoaiByRamIsAndTenDienThoaiContains(int ram, String ten,Pageable pageable);
    @Query(value = """
    select dt.tenDienThoai, count(hdct.soLuong) from HoaDonChiTiet hdct join DienThoai dt on hdct.hoaDonCTID.maSanPham = dt.maDienThoai group by dt.tenDienThoai order by count(hdct.soLuong) desc limit 10
""")
    List<Object> top10BanChay();
    @Query("""
    select new java5.assignment.ViewModel.Top10Ton(n.tenDienThoai,n.soLuong)  from  DienThoai n left join  HoaDonChiTiet hd  on hd.hoaDonCTID.maSanPham =n.maDienThoai
                where hd.hoaDonCTID.maHoaDon is null
                group by  n.tenDienThoai, n.donGia,n.soLuong,n.anh
                order by n.soLuong desc
""")
    List<Top10Ton> top10Ton();
}
