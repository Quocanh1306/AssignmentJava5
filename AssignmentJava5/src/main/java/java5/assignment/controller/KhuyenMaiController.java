package java5.assignment.controller;

import jakarta.servlet.http.HttpSession;
import java5.assignment.ViewModel.Top10BanChay;
import java5.assignment.ViewModel.Top10Ton;
import java5.assignment.model.DienThoai;
import java5.assignment.model.KhuyenMai;
import java5.assignment.model.User;
import java5.assignment.repository.IDienThoaiRepository;
import java5.assignment.repository.IKhuyenMauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/khuyen-mai")
public class KhuyenMaiController {
    @Autowired
    IKhuyenMauRepository repository;
    @Autowired
    IDienThoaiRepository dienThoaiRepository;
    @GetMapping
    public String view(Model model, HttpSession session) {
        User u = (User) session.getAttribute("u");
        if(u.getRole() == 0) {
            return "redirect:/phone";
        }
        List<DienThoai> list = dienThoaiRepository.findAll();
        model.addAttribute("list", list);
        return "khuyen-mai";
    }

    @GetMapping("/check/{maDienThoai}")
    public String check(Model model, @RequestParam String tenPhieu, @RequestParam int giaTriGiam, @PathVariable(name = "maDienThoai") int maDienThoai) {
        List<Top10Ton> list = dienThoaiRepository.top10Ton();
        Optional<DienThoai> dienThoaiOptional = dienThoaiRepository.findById(maDienThoai);
        DienThoai dienThoai = dienThoaiOptional.get();
        KhuyenMai km = new KhuyenMai();
        km.setTenPhieu(tenPhieu);
        km.setGiaTriGiam(giaTriGiam);

        repository.save(km);
        return "product-detail";
    }
    @PostMapping("/add/{maDienThoai}")
    public String add(Model model, @PathVariable(name = "maDienThoai") int maDienThoai, @RequestParam int maPhieu ,@RequestParam String tenPhieu, @RequestParam int giaTriGiam) {
        KhuyenMai km = new KhuyenMai();
        km.setMaPhieu(maPhieu);
        km.setTenPhieu(tenPhieu);
        km.setGiaTriGiam(giaTriGiam);
        km.setMaDienThoai(maDienThoai);
        repository.save(km);
        Optional<DienThoai> dienThoaiOpt = dienThoaiRepository.findById(maDienThoai);
        DienThoai dienThoai = dienThoaiOpt.get();
        BigDecimal donGiaKM = dienThoai.getDonGia();
        BigDecimal tienGiam = dienThoai.getDonGia();
        tienGiam = tienGiam.multiply(BigDecimal.valueOf(km.getGiaTriGiam()).divide(BigDecimal.valueOf(100)));
        donGiaKM.subtract(tienGiam);
        dienThoai.setGiaSauKM(donGiaKM);
        dienThoaiRepository.save(dienThoai);
        return "redirect:/khuyen-mai";
    }
    @GetMapping("/detail/{maDienThoai}")
    public String detail(Model model, @PathVariable(name = "maDienThoai") int maDienThoai) {
        Optional<DienThoai> dienThoaiOptional = dienThoaiRepository.findById(maDienThoai);
        DienThoai dienThoai = dienThoaiOptional.get();
        model.addAttribute("dt", dienThoai);
        return "khuyen-mai";
    }

}
