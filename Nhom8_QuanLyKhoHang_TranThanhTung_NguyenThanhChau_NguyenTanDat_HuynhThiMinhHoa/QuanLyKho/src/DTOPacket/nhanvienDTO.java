/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOPacket;

/**
 *
 * @author macintoshhd
 */
public class nhanvienDTO {
    private String Manv;
    private String Tennv;
    private String Diachi;
    private String sdt;
    private String email;
    public nhanvienDTO(){
        
    }
    public nhanvienDTO(String Manv, String Tennv, String Diachi, String sdt, String email) {
        this.Manv = Manv;
        this.Tennv = Tennv;
        this.Diachi = Diachi;
        this.sdt = sdt;
        this.email = email;
    }

    public String getManv() {
        return Manv;
    }

    public void setManv(String Manv) {
        this.Manv = Manv;
    }

    public String getTennv() {
        return Tennv;
    }

    public void setTennv(String Tennv) {
        this.Tennv = Tennv;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
