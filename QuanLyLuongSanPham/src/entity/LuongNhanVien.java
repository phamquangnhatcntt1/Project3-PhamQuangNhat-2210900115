package entity;

import java.math.BigDecimal;

public class LuongNhanVien {
    protected String maLuong;
    protected int thang;
    protected int nam;
    protected BigDecimal luong; // Sửa từ double sang BigDecimal
    protected NhanVienHanhChinh nhanVienHanhChinh;

    public LuongNhanVien() {
    }

    public LuongNhanVien(String maLuong, int thang, int nam, BigDecimal luong) {
        this.maLuong = maLuong;
        this.thang = thang;
        this.nam = nam;
        this.luong = luong;
    }

    public String getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(String maLuong) {
        this.maLuong = maLuong;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public BigDecimal getLuong() { // Sửa kiểu trả về
        return luong;
    }

    public void setLuong(BigDecimal luong) { // Sửa tham số đầu vào
        this.luong = luong;
    }

    public NhanVienHanhChinh getNhanVienHanhChinh() {
        return nhanVienHanhChinh;
    }

    public void setNhanVienHanhChinh(NhanVienHanhChinh nhanVienHanhChinh) {
        this.nhanVienHanhChinh = nhanVienHanhChinh;
    }
}
