package java5.assignment.controller;

import jakarta.servlet.http.HttpSession;
import java5.assignment.ViewModel.DienThoaiCart;
import java5.assignment.model.*;
import java5.assignment.repository.IDienThoaiRepository;
import java5.assignment.repository.IGioHangChiTietRepository;
import java5.assignment.repository.IGioHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/gio-hang")
public class GioHangController {
    @Autowired
    private IGioHangRepository repository;
    @Autowired
    private IDienThoaiRepository dienThoaiRepository;
    @Autowired
    private IGioHangChiTietRepository gioHangChiTietRepository;

    @Autowired
    private IGioHangRepository gioHangRepository;
    @GetMapping
    public String view(Model model, HttpSession session) {
        User u = (User) session.getAttribute("u");
        List<DienThoaiCart> list = repository.hienThi(u.getId());
        BigDecimal thanhTien = BigDecimal.valueOf(1);
        BigDecimal tongTien = BigDecimal.valueOf(1);
        for (DienThoaiCart dt: list) {
            thanhTien = dt.getDonGia();
            thanhTien = thanhTien.multiply(BigDecimal.valueOf(dt.getSoLuong()));
        }
        model.addAttribute("tongTien", thanhTien);
        model.addAttribute("cart", list);
        return "cart";
    }
    @RequestMapping("/add/{maDienThoai}")
    public String view(Model model, HttpSession session,@PathVariable(name = "maDienThoai") int maDienThoai) {
        User u =(User) session.getAttribute("u");
        Cart gh = gioHangRepository.findByNguoiSoHuuIs(u.getId());
        CartDetailID cartDetailID = new CartDetailID();
        cartDetailID.setMaGioHang(gh.getMaGioHang());
        cartDetailID.setMaSanPham(maDienThoai);
        CartDetail cartDetail = new CartDetail();
        cartDetail.setCartDetailID(cartDetailID);
        cartDetail.setSoLuong(1);
        gioHangChiTietRepository.save(cartDetail);
        return "redirect:/gio-hang";
    }

    @RequestMapping("/add1/{maDienThoai}")
    public String add1(HttpSession session, @PathVariable(name = "maDienThoai") int maDienThoai) {
        User u = (User) session.getAttribute("u");
        Cart gioHang = repository.findByNguoiSoHuuIs(u.getId());
        CartDetailID cartDetailID = new CartDetailID();
        cartDetailID.setMaGioHang(gioHang.getMaGioHang());
        cartDetailID.setMaSanPham(maDienThoai);
        Optional<CartDetail> gioHangCTOpt = gioHangChiTietRepository.findById(cartDetailID);
        CartDetail gioHangCT = gioHangCTOpt.get();
        int soLuong = gioHangCT.getSoLuong();
        gioHangCT.setSoLuong(soLuong + 1);
        gioHangChiTietRepository.save(gioHangCT);
        return "redirect:/gio-hang";
    }

    @RequestMapping("/delete1/{maDienThoai}")
    public String delete1(HttpSession session, @PathVariable(name = "maDienThoai") int maDienThoai) {
        User u = (User) session.getAttribute("u");
        Cart gioHang = repository.findByNguoiSoHuuIs(u.getId());
        CartDetailID cartDetailID = new CartDetailID();
        cartDetailID.setMaGioHang(gioHang.getMaGioHang());
        cartDetailID.setMaSanPham(maDienThoai);
        Optional<CartDetail> gioHangCTOpt = gioHangChiTietRepository.findById(cartDetailID);
        CartDetail gioHangCT = gioHangCTOpt.get();
        int soLuong = gioHangCT.getSoLuong();
        gioHangCT.setSoLuong(soLuong - 1);
        gioHangChiTietRepository.save(gioHangCT);
        return "redirect:/gio-hang";
    }

    @GetMapping("/delete/{maSanPham}")
    public String delete(@PathVariable(name = "maSanPham") int maSanPham, HttpSession session) {
       User u = (User) session.getAttribute("u");
       Cart gioHang = repository.findByNguoiSoHuuIs(u.getId());
       CartDetailID cartDetailID = new CartDetailID();
       cartDetailID.setMaGioHang(gioHang.getMaGioHang());
       cartDetailID.setMaSanPham(maSanPham);
       gioHangChiTietRepository.deleteById(cartDetailID);
       return "redirect:/gio-hang";
    }
}
