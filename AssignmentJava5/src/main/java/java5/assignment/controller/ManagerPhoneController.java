package java5.assignment.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java5.assignment.model.DienThoai;
import java5.assignment.model.User;
import java5.assignment.repository.IDienThoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/manager-phone")
public class ManagerPhoneController {
    @Autowired
    private IDienThoaiRepository repository;
    @GetMapping
    public String view(Model model, HttpSession session) {
        User u = (User) session.getAttribute("u");
        if( session.isNew()) {
            return "redirect:/phone";
        }
        List<DienThoai> list = repository.findAll();
        model.addAttribute("danhSachDienThoai", list);
        return "manager-phone";
    }
    @PostMapping ("/add")
    public String add(Model model, @RequestParam String tenDienThoai, @RequestParam BigDecimal donGia, @RequestParam int dungLuong, @RequestParam int ram, @RequestParam String hangDienThoai, @RequestParam String anh) {
        DienThoai dt = new DienThoai();
        dt.setDonGia(donGia);
        dt.setAnh(anh);
        dt.setTenDienThoai(tenDienThoai);
        dt.setRam(ram);
        dt.setHangDienThoai(hangDienThoai);
        dt.setDungLuong(dungLuong);
        repository.save(dt);

        return "redirect:/manager-phone";
    }
    @GetMapping("/delete/{maDienThoai}")
    public String deletePhone(@PathVariable(name = "maDienThoai") int maDienThoai) {
        repository.deleteById(maDienThoai);
        return "redirect:/manager-phone";
    }

    @GetMapping("/detail/{maDienThoai}")
    public String detailPhone(Model model, @PathVariable(name = "maDienThoai") int maDienThoai) {
        Optional<DienThoai> dienThoaiOpt = repository.findById(maDienThoai);
        DienThoai dienThoai = dienThoaiOpt.get();
        model.addAttribute("dt", dienThoai);
        List<DienThoai> list = repository.findAll();
        model.addAttribute("danhSachDienThoai", list);
        return "manager-phone";
    }

    @GetMapping("/view-update/{maDienThoai}")
    public String viewUpdate(Model model, @PathVariable(name = "maDienThoai") int maDienThoai) {
        Optional<DienThoai> dienThoaiOptional = repository.findById(maDienThoai);
        DienThoai dt = dienThoaiOptional.get();
        List<DienThoai> list = repository.findAll();
        model.addAttribute("danhSachDienThoai", list);
        model.addAttribute("dt" ,dt);
        return "update-phone";
    }

    @PostMapping("/phone-update/{maDienThoai}")
    public String updatePhone(Model model, @RequestParam String tenDienThoai, @RequestParam BigDecimal donGia, @RequestParam int dungLuong, @RequestParam int ram, @RequestParam String hangDienThoai, @RequestParam String anh,
                              @PathVariable(name = "maDienThoai") int maDienThoai) {
        DienThoai dt = new DienThoai();
        dt.setDungLuong(dungLuong);
        dt.setRam(ram);
        dt.setAnh(anh);
        dt.setMaDienThoai(maDienThoai);
        dt.setHangDienThoai(hangDienThoai);
        dt.setDonGia(donGia);
        dt.setTenDienThoai(tenDienThoai);
        repository.saveAndFlush(dt);
        return "redirect:/manager-phone";
    }

}
