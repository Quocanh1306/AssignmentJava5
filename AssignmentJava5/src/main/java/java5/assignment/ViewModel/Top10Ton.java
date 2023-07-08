package java5.assignment.ViewModel;

public class Top10Ton {
    private String tenDienThoai;
    private int soLuong;

    public Top10Ton() {
    }

    public Top10Ton(String tenDienThoai, int soLuong) {
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
