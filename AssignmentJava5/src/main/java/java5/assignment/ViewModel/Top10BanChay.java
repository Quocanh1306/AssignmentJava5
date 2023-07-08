package java5.assignment.ViewModel;

import java.math.BigDecimal;

public class Top10BanChay {
    private String tenDienThoai;
    private int soLuong;

    public Top10BanChay() {
    }

    public Top10BanChay(String tenDienThoai, int soLuong) {
        this.tenDienThoai = tenDienThoai;
        this.soLuong = soLuong;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }



    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }


}
