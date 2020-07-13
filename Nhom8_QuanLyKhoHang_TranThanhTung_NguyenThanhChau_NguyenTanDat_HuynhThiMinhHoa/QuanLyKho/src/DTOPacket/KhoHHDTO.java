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
public class KhoHHDTO {
    private String MaKho;
    private String MaHH;
    private int Soluong;

    public KhoHHDTO() {
    }

    public KhoHHDTO(String MaKho, String MaHH, int Soluong) {
        this.MaKho = MaKho;
        this.MaHH = MaHH;
        this.Soluong = Soluong;
    }

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
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
    
}
