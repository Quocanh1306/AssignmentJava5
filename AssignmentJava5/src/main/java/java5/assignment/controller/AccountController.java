package java5.assignment.controller;

import jakarta.servlet.http.HttpSession;
import java5.assignment.model.User;
import java5.assignment.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IUserRepository repository;
    @GetMapping
    public String view() {
        return "edit-account";
    }
    @PostMapping("/update/{userName}")
    public String update(Model model, @RequestParam String password, @RequestParam String password1
            , @RequestParam String password2, @PathVariable(name = "userName") String userName,
                         HttpSession session) {
        List<User> list = repository.findAll();
        for (User us : list) {
            if(us.getUserName().equals(userName)) {
                if(us.getPassWord().equals(password)) {
                    if(password1.equals(password2)) {
                        us.setPassWord(password2);
                       repository.save(us);
                       model.addAttribute("mess", "Doi mat khau thanh cong");
                    }else {
                        model.addAttribute("mess", "password thay doi phai giong nhau");
                    }
                }else {
                    model.addAttribute("mess", "Mat khau khong dung");
                }
            }else {
                model.addAttribute("mess", "username khong dung");
            }
        }
        return "redirect:/account";
    }
}
