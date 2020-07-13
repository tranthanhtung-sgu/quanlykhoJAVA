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
public class PhieuNhapDTO {
    private String MaPhieuNhap;
    private String MaNCC;
    private String TenNCC;
    private String MaNV;
    private String TenNV;
    private String Ngaylapphieu;
    private String Nguoigiao;
    private String Noidung;

    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(String MaPhieuNhap, String MaNCC,String TenNCC,String MaNV,String TenNV,String Ngaylapphieu, String Nguoigiao, String Noidung) {
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.MaNV=MaNV;
        this.TenNV=TenNV;
        this.Ngaylapphieu = Ngaylapphieu;
        this.Nguoigiao = Nguoigiao;
        this.Noidung = Noidung;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getNgaylapphieu() {
        return Ngaylapphieu;
    }

    public void setNgaylapphieu(String Ngaylapphieu) {
        this.Ngaylapphieu = Ngaylapphieu;
    }

    public String getNguoigiao() {
        return Nguoigiao;
    }

    public void setNguoigiao(String Nguoigiao) {
        this.Nguoigiao = Nguoigiao;
    }

    public String getNoidung() {
        return Noidung;
    }

    public void setNoidung(String Noidung) {
        this.Noidung = Noidung;
    }
    
}
