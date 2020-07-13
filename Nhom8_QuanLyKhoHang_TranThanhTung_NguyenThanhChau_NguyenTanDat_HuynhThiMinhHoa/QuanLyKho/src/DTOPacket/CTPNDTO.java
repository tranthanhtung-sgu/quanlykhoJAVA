/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOPacket;

/**
 *
 * @author asus
 */
public class CTPNDTO {
    private String MaPhieuNhap;
    private String MaHH;
    private String TenHH;
    private int Soluong;
    private int Dongia;
    private String MaKho;
    private String TenKho;

    public CTPNDTO() {
    }

    public String getTenHH() {
        return TenHH;
    }

    public void setTenHH(String TenHH) {
        this.TenHH = TenHH;
    }

    public String getTenKho() {
        return TenKho;
    }

    public void setTenKho(String TenKho) {
        this.TenKho = TenKho;
    }

    public CTPNDTO(String MaPhieuNhap, String MaHH, String TenHH, int Soluong, int Dongia, String MaKho, String TenKho) {
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaHH = MaHH;
        this.TenHH = TenHH;
        this.Soluong = Soluong;
        this.Dongia = Dongia;
        this.MaKho = MaKho;
        this.TenKho = TenKho;
    }

    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }

    public String getMaHH() {
        return MaHH;
    }

    public void setMaHH(String MaHH) {
        this.MaHH = MaHH;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public int getDongia() {
        return Dongia;
    }

    public void setDongia(int Dongia) {
        this.Dongia = Dongia;
    }

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
    }
    
}
