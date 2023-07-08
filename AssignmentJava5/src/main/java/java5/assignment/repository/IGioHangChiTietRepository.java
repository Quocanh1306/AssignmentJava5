package java5.assignment.repository;

import java5.assignment.ViewModel.CartThanhToan;
import java5.assignment.ViewModel.DienThoaiCart;
import java5.assignment.model.Cart;
import java5.assignment.model.CartDetail;
import java5.assignment.model.CartDetailID;
import java5.assignment.model.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IGioHangChiTietRepository extends JpaRepository<CartDetail, CartDetailID> {
    @Query("""
    select gh.maGioHang from Cart gh join CartDetail ghct on gh.maGioHang = ghct.cartDetailID.maGioHang where gh.nguoiSoHuu = :nguoiSoHuu group by gh.maGioHang
""")
    Integer timMaGioHang(@Param("nguoiSoHuu") int nguoiSoHuu);
    @Query("""
select ghct from CartDetail ghct where ghct.cartDetailID.maGioHang = :maGioHang and ghct.cartDetailID.maSanPham = :maSanPham 
""")
    CartDetail timGHCT(@Param("maGioHang") int maGioHang, @Param("maSanPham") int maSanPham);

    @Query("""
select new java5.assignment.ViewModel.CartThanhToan(gh.cartDetailID.maGioHang, gh.cartDetailID.maSanPham, gh.soLuong, dt.donGia) from CartDetail gh join DienThoai dt on gh.cartDetailID.maSanPham = dt.maDienThoai

""")
    List<CartThanhToan> timHet();
    @Query("""
    select c from CartDetail c where c.cartDetailID.maGioHang = : maGioHang
""")
    List<CartDetail> listGHCT(@Param("maGioHang") int maGioHang);

}
