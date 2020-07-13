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
public class nhaccDTO {
    private String Mancc;
    private String Tenncc;
    private String Diachincc;
    private String sdtncc;
    private String Emailncc;
    private String noidung;

    public nhaccDTO() {
    }

    public nhaccDTO(String Mancc, String Tenncc, String Diachincc, String sdtncc, String Emailncc, String noidung) {
        this.Mancc = Mancc;
        this.Tenncc = Tenncc;
        this.Diachincc = Diachincc;
        this.sdtncc = sdtncc;
        this.Emailncc = Emailncc;
        this.noidung = noidung;
    }

    public String getMancc() {
        return Mancc;
    }

    public void setMancc(String Mancc) {
        this.Mancc = Mancc;
    }

    public String getTenncc() {
        return Tenncc;
    }

    public void setTenncc(String Tenncc) {
        this.Tenncc = Tenncc;
    }

    public String getDiachincc() {
        return Diachincc;
    }

    public void setDiachincc(String Diachincc) {
        this.Diachincc = Diachincc;
    }

    public String getSdtncc() {
        return sdtncc;
    }

    public void setSdtncc(String sdtncc) {
        this.sdtncc = sdtncc;
    }

    public String getEmailncc() {
        return Emailncc;
    }

    public void setEmailncc(String Emailncc) {
        this.Emailncc = Emailncc;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
    
}
