/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author macintoshhd
 */
public class login {
    private String taikhoan;
    private String matkhau;
    private String phanquyen;
    public login(){
        
    }
    public login(String taikhoan, String matkhau, String phanquyen) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.phanquyen = phanquyen;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getPhanquyen() {
        return phanquyen;
    }

    public void setPhanquyen(String phanquyen) {
        this.phanquyen = phanquyen;
    }
    
}
