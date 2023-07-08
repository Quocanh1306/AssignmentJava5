package java5.assignment.controller;

import jakarta.servlet.http.HttpSession;
import java5.assignment.model.User;
import java5.assignment.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private IUsersRepository repository;
    @Autowired
    HttpSession session;
    @GetMapping
    public String view() {
        return "login";
    }
    @PostMapping("/check")
    public String check(Model model, @RequestParam String username, @RequestParam String password, HttpSession session) {
        List<User> list = repository.findAll();
        for (User u: list) {
            if(u.getUserName().equals(username) && u.getPassWord().equals(password)) {
                session.setAttribute("u", u);
                return "redirect:/home";
            }
        }
        return null;
    }
    @PostMapping("/register")
    public String register(Model model, @RequestParam String username, @RequestParam String password, @RequestParam String password2) {
        if(!password.equals(password2)) {
            return null;
        }else {
            User u = new User();
            if(password.equals(password2)) {
                u.setUserName(username);
                u.setPassWord(password);
                repository.save(u);
            }else {
                model.addAttribute("mat khau khong dung");
                return "login";
            }

            model.addAttribute("mess","Dang ky thanh cong");
            return "redirect:/home";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("u");
        return "redirect:/login";
    }
}
