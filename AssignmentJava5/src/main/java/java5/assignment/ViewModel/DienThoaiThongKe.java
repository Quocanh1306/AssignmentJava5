package java5.assignment.ViewModel;

public class DienThoaiThongKe {
    private String tenDienThoai;
    private long soLuong;

    public DienThoaiThongKe() {
    }

    public DienThoaiThongKe(String tenDienThoai, long soLuong) {
        this.tenDienThoai = tenDienThoai;
        this.soLuong = soLuong;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public long getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(long soLuong) {
        this.soLuong = soLuong;
    }
}
