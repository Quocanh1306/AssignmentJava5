package java5.assignment.controller;

import jakarta.servlet.http.HttpSession;
import java5.assignment.ViewModel.CartThanhToan;
import java5.assignment.ViewModel.DienThoaiCart;
import java5.assignment.model.*;
import java5.assignment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/hoa-don")
public class HoaDonController {
    @Autowired
    private IDienThoaiRepository dienThoaiRepository;
    @Autowired
    private IHoaDonRepository hoaDonRepository;
    @Autowired
    private IHoaDonChiTietRepository hoaDonChiTietRepository;
    @Autowired
    private IGioHangRepository gioHangRepository;
    @Autowired
    private IGioHangChiTietRepository gioHangChiTietRepository;
    @PostMapping("/pay")
    public String pay(Model model, HttpSession session) {
        HoaDon hoaDon = new HoaDon();
        User u = (User) session.getAttribute("u");
        hoaDon.setNguoiMua(u.getId());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngay = new Date();
        hoaDon.setNgayThanhToan(ngay);
        hoaDonRepository.save(hoaDon);
        Cart gioHang = gioHangRepository.findByNguoiSoHuuIs(u.getId());
        List<CartThanhToan> list = gioHangChiTietRepository.timHet();
        CartDetailID idCart = new CartDetailID();
        idCart.setMaGioHang(gioHang.getMaGioHang());
        HoaDonCTID HDCTID = new HoaDonCTID();
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        for (CartThanhToan gh: list) {
            Optional<DienThoai> dtOpt = dienThoaiRepository.findById(gh.getMaSanPham());
            DienThoai dienThoai = dtOpt.get();
            int soLuongGH = gh.getSoLuong();
            int soLuongKho = dienThoai.getSoLuong();
            dienThoai.setSoLuong(soLuongKho-soLuongGH);
            dienThoaiRepository.save(dienThoai);
            if(gh.getMaGioHang() == gioHang.getMaGioHang()) {
                idCart.setMaSanPham(gh.getMaSanPham());
                HDCTID.setMaHoaDon(hoaDon.getMaHoaDon());
                HDCTID.setMaSanPham(gh.getMaSanPham());
                hoaDonChiTiet.setHoaDonCTID(HDCTID);
                hoaDonChiTiet.setSoLuong(gh.getSoLuong());
                hoaDonChiTiet.setDonGia(gh.getDonGia().multiply(BigDecimal.valueOf(gh.getSoLuong())));
                hoaDonChiTietRepository.save(hoaDonChiTiet);
            }
        }
        return "redirect:/gio-hang";
    }
}
