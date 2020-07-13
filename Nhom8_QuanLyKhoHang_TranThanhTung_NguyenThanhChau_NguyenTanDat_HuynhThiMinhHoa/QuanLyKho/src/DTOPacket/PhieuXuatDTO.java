/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOPacket;

import java.util.Date;

/**
 *
 * @author asus
 */
public class PhieuXuatDTO {
    private String MaPhieuXuat;
    private String MaNV;
    private String TenNV;
    private String Ngaylapphieu;
    private String Nguoinhan;
    private String Noidung;

    public PhieuXuatDTO() {
    }

    public PhieuXuatDTO(String MaPhieuXuat, String MaNV,String TenNV ,String Ngaylapphieu,String Nguoinhan ,String Noidung) {
        this.MaPhieuXuat = MaPhieuXuat;
        this.MaNV = MaNV;
        this.TenNV=TenNV;
        this.Ngaylapphieu = Ngaylapphieu;
        this.Nguoinhan=Nguoinhan;
        this.Noidung = Noidung;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getNguoinhan() {
        return Nguoinhan;
    }

    public void setNguoinhan(String Nguoinhan) {
        this.Nguoinhan = Nguoinhan;
    }

    public String getMaPhieuXuat() {
        return MaPhieuXuat;
    }

    public void setMaPhieuXuat(String MaPhieuXuat) {
        this.MaPhieuXuat = MaPhieuXuat;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getNgaylapphieu() {
        return Ngaylapphieu;
    }

    public void setNgaylapphieu(String Ngaylapphieu) {
        this.Ngaylapphieu = Ngaylapphieu;
    }

    public String getNoidung() {
        return Noidung;
    }

    public void setNoidung(String Noidung) {
        this.Noidung = Noidung;
    }
    
}
