package java5.assignment.controller;

import java5.assignment.model.DienThoai;
import java5.assignment.repository.IDienThoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dien-thoai")
public class DienThoaiController{
    @Autowired
    private IDienThoaiRepository repository;
    @GetMapping
    public String view(Model model) {
        List<DienThoai> list = repository.findAll();

        model.addAttribute("danhSachDienThoai", list);
        return "index";
    }
}
