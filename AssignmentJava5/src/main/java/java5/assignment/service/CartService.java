package java5.assignment.service;

import jakarta.servlet.http.HttpSession;
import java5.assignment.model.DienThoai;
import java5.assignment.model.GioHangDomainModel;
import java5.assignment.model.GioHangViewModel;
import java5.assignment.model.SanPhamTrongGioViewModel;
import java5.assignment.repository.CartRepository;
import java5.assignment.repository.IDienThoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
    List<SanPhamTrongGioViewModel> list = new ArrayList<>();
    @Autowired
    HttpSession session;

    @Autowired
    private CartRepository repository;
    @Autowired
    private IDienThoaiRepository sanPhamRepository;

    public void themSanPhamVaoGioHang(Integer maSanPham, Integer soLuong) {
        if(repository.sanPhamDaCoTrongGio(maSanPham) == false) {
            repository.themSanPhamVaoGio(maSanPham, soLuong);
        }else {
            Integer soLuongHienCo = repository.laySoLuongSanPhamTrongGio(maSanPham);
            Integer soLuongCongDon = soLuongHienCo + soLuong;
            repository.suaSoLuongSanPhamTrongGio(maSanPham, soLuong);
        }
    }
    public void boSanPhamKhoiGio(Integer maSanPham) {
        repository.boSanPhamKhoiGio(maSanPham);
    }
    public GioHangViewModel xemGioHang() {
        GioHangDomainModel gioHangDomainModel = repository.layGioHang();
        Map<Integer, Integer> danhSachSanPham = gioHangDomainModel.getDanhSachSanPham();

        GioHangViewModel viewModel = new GioHangViewModel();
        SanPhamTrongGioViewModel sptg = new SanPhamTrongGioViewModel();
        for (Map.Entry<Integer, Integer> sp : danhSachSanPham.entrySet()) {
            Integer maSanPham = sp.getKey();
            Integer soLuong = sp.getValue();
            DienThoai sanPham = sanPhamRepository.findById(maSanPham).get();

            sptg.setMaSanPham(maSanPham);
            sptg.setSoLuong(soLuong);
            sptg.setDonGia(sanPham.getDonGia());
            sptg.setTenSanPham(sanPham.getTenDienThoai());
            sptg.setAnh(sanPham.getAnh());
        }
        list.add(sptg);
        viewModel.setSanPham(list);
        return viewModel;
    }
}
