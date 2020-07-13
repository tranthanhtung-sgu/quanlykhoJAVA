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
public class CTPXDTO {
    private String MaPhieuXuat;
    private String MAHH;
    private int Soluong;
    private int Dongia;
    private String MaKho;
    private String TenHH;
    private String TenKho;

    public CTPXDTO() {
    }

    public CTPXDTO(String MaPhieuXuat, String MAHH, int Soluong, int Dongia, String MaKho, String TenHH, String TenKho) {
        this.MaPhieuXuat = MaPhieuXuat;
        this.MAHH = MAHH;
        this.Soluong = Soluong;
        this.Dongia = Dongia;
        this.MaKho = MaKho;
        this.TenHH = TenHH;
        this.TenKho = TenKho;
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

    

    public String getMaPhieuXuat() {
        return MaPhieuXuat;
    }

    public void setMaPhieuXuat(String MaPhieuXuat) {
        this.MaPhieuXuat = MaPhieuXuat;
    }

    public String getMAHH() {
        return MAHH;
    }

    public void setMAHH(String MAHH) {
        this.MAHH = MAHH;
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
