package java5.assignment.controller;

import jakarta.servlet.http.HttpSession;
import java5.assignment.ViewModel.DienThoaiThongKe;
import java5.assignment.ViewModel.Top10BanChay;
import java5.assignment.ViewModel.Top10Ton;
import java5.assignment.repository.IDienThoaiRepository;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/thongke")
public class ThongKeController {
    @Autowired
    IDienThoaiRepository repository;

    @GetMapping
    public String view(Model model, HttpSession session) {
        if( session.isNew()) {
            return "redirect:/phone";
        }

        List<Object> list = repository.top10BanChay();
        List<Top10Ton> listTon = repository.top10Ton();

        model.addAttribute("listTon", listTon);
        model.addAttribute("list", list);
        return "thong-ke";
    }
}
