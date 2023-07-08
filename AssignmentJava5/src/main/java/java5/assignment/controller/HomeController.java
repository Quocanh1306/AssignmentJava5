package java5.assignment.controller;

import java5.assignment.model.DienThoai;
import java5.assignment.repository.IDienThoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private IDienThoaiRepository repository;
    @GetMapping
    public String view(Model model, @RequestParam(defaultValue = "1") int page
            , @RequestParam(required = false) String tenDienThoai,
                       @RequestParam(defaultValue = "0") int ram) {
        Page<DienThoai> pageSanPham;
        if(page < 1) page = 1;
        Pageable pageable = PageRequest.of(page -1, 10);

        if(tenDienThoai == null || tenDienThoai.isBlank()) {
            pageSanPham  = repository.findAll(pageable);
        }else if(tenDienThoai !=null && ram == 0){
            pageSanPham = repository.findByTenDienThoaiContains(tenDienThoai, pageable);

        }else if((tenDienThoai == null || tenDienThoai.isBlank()) && ram != 0) {
            pageSanPham = repository.findDienThoaiByRamIs(ram, pageable);
        }else {
            pageSanPham = repository.findDienThoaiByRamIsAndTenDienThoaiContains(ram, tenDienThoai, pageable);
        }

        model.addAttribute("page", pageSanPham);
        return "product-list";
    }

    @GetMapping ("/detail/{maDienThoai}")
    public String viewDetail (Model model, @PathVariable(name = "maDienThoai") int maDienThoai) {
        Optional<DienThoai> dienThoaiOptional = repository.findById(maDienThoai);
        DienThoai dienThoai = dienThoaiOptional.get();
        model.addAttribute("dt", dienThoai);
        return "product-detail";
    }
    @GetMapping("/{min}/{max}")
    public String viewSX(Model model, @RequestParam(defaultValue = "1") int page,
                         @PathVariable(name = "min") BigDecimal min,
                         @PathVariable(name = "max") BigDecimal max) {
        Page<DienThoai> pageSanPham;
        if(page < 1) page = 1;
        Pageable pageable = PageRequest.of(page -1, 10);
        pageSanPham = repository.findByDonGiaBetween(min,max, pageable);
        model.addAttribute("page", pageSanPham);
        return "product-list";
    }
    @GetMapping("/{ram}")
    public String viewTK(Model model, @PathVariable(name = "ram") int ram,
                         @RequestParam(defaultValue = "1") int page) {
        Page<DienThoai> pageSanPham;
        if(page < 1) page = 1;
        Pageable pageable = PageRequest.of(page -1, 10);
        pageSanPham = repository.findDienThoaiByRamIs(ram, pageable);
        model.addAttribute("page", pageSanPham);
        return "product-list";
    }
}
