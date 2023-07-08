package java5.assignment.controller;

import jakarta.servlet.http.HttpSession;
import java5.assignment.model.Cart;
import java5.assignment.model.CartDetail;
import java5.assignment.model.GioHangViewModel;
import java5.assignment.model.User;
import java5.assignment.repository.IGioHangChiTietRepository;
import java5.assignment.repository.IGioHangRepository;
import java5.assignment.service.CartService;
import java5.assignment.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService service;
    @Autowired
    private IGioHangChiTietRepository gioHangChiTietRepository;
    @Autowired
    private IGioHangRepository gioHangRepository;
    @RequestMapping("/add/{maDienThoai}")
    public String view(Model model, HttpSession session,@PathVariable(name = "maDienThoai") int maDienThoai) {
        User u =(User) session.getAttribute("u");
        Cart gh = gioHangRepository.findByNguoiSoHuuIs(u.getId());
        List<CartDetail> ghct = gioHangChiTietRepository.listGHCT(gh.getMaGioHang());

        return "redirect:/cart";
    }
    @GetMapping
    public String xemGioHang(Model model, HttpSession session) {
        GioHangViewModel danhSachSanPham = service.xemGioHang();
        model.addAttribute("cart",danhSachSanPham.getSanPham());
        return "cart";
    }

    @GetMapping("/delete/{maSanPham}")
    public String boSanPhamRaKhoiGio(@PathVariable(name = "maSanPham") int maSanPham) {
        service.boSanPhamKhoiGio(maSanPham);
        return "redirect:/cart";
    }
}
