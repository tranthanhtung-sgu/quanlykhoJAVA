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
public class KhoDTO {
    private String MaKho;
    private String TenKho;
    private String Sodt;
    private String Diachi;
    private String noidung;

    public KhoDTO(String makho, String tenkho, String sodienthoai, String diachi, String noidung) {
        this.MaKho = makho;
        this.TenKho = tenkho;
        this.Sodt = sodienthoai;
        this.Diachi = diachi;
        this.noidung = noidung;
    }

    public KhoDTO() {
    }

    public String getMakho() {
        return MaKho;
    }

    public void setMakho(String makho) {
        this.MaKho = makho;
    }

    public String getTenkho() {
        return TenKho;
    }

    public void setTenkho(String tenkho) {
        this.TenKho = tenkho;
    }

    public String getSodienthoai() {
        return Sodt;
    }

    public void setSodienthoai(String sodienthoai) {
        this.Sodt = sodienthoai;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        this.Diachi = diachi;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
    
}
