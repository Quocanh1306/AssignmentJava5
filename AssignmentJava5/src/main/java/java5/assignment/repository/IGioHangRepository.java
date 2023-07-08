package java5.assignment.repository;

import java5.assignment.ViewModel.DienThoaiCart;
import java5.assignment.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IGioHangRepository extends JpaRepository<Cart, Integer> {
    @Query("""
    select new java5.assignment.ViewModel.DienThoaiCart(dt.maDienThoai ,dt.tenDienThoai, dt.anh, dt.donGia, ghct.soLuong, dt.ram, dt.dungLuong) from User u join Cart g on u.id = g.nguoiSoHuu join CartDetail ghct on g.maGioHang = ghct.cartDetailID.maGioHang join DienThoai dt on dt.maDienThoai = ghct.cartDetailID.maSanPham
    where g.nguoiSoHuu = :nguoiSoHuu
""")
    List<DienThoaiCart> hienThi(@Param("nguoiSoHuu") int nguoiSoHuu);
    Cart findByNguoiSoHuuIs(int id);
}
