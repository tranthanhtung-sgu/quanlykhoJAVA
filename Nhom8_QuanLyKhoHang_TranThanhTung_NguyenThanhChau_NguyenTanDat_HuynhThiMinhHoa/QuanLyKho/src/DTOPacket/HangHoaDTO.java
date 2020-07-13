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
public class HangHoaDTO {
    private String MaHH;
    private String TenHH;
    private int Soluong;
    private int Donvitinh;
    private String MaNhom;
    private String HinhAnh;

    public HangHoaDTO() {
    }

    public HangHoaDTO(String MaHH, String TenHH, int Soluong, int Donvitinh, String MaNhom, String HinhAnh) {
        this.MaHH = MaHH;
        this.TenHH = TenHH;
        this.Soluong = Soluong;
        this.Donvitinh = Donvitinh;
        this.MaNhom = MaNhom;
        this.HinhAnh = HinhAnh;
    }

    public String getHinhAnh() {
		return HinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}

	public String getMaNhom() {
		return MaNhom;
	}

	public void setMaNhom(String maNhom) {
		MaNhom = maNhom;
	}

	public String getMaHH() {
        return MaHH;
    }

    public void setMaHH(String MaHH) {
        this.MaHH = MaHH;
    }

    public String getTenHH() {
        return TenHH;
    }

    public void setTenHH(String TenHH) {
        this.TenHH = TenHH;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public int getDonvitinh() {
        return Donvitinh;
    }

    public void setDonvitinh(int Donvitinh) {
        this.Donvitinh = Donvitinh;
    }
    
}
