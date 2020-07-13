/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusPacket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import DTOPacket.DSNhom;
import DTOPacket.HangHoaDTO;
import DatabaseConnection.MySQLConnectUnit;

/**
 *
 * @author asus
 */
public class HangHoaBUS {
	public static ArrayList<HangHoaDTO> dsHangHoa;
	public static ArrayList<DSNhom> dsNhom;

    public HangHoaBUS() {
    }
    
    public HangHoaBUS(ArrayList<HangHoaDTO> dsHangHoa) {
        HangHoaBUS.dsHangHoa = dsHangHoa;
    }
    
    public void ThemNhomHH(DSNhom nhom) throws SQLException {
		MySQLConnectUnit connect =new MySQLConnectUnit();
        try {
			HashMap ColumnValues = new HashMap();
            ColumnValues.put("MaNhom",nhom.getMaNhom());
            ColumnValues.put("TenNhom",nhom.getTenNhom());
            connect.Insert("danhmucnhom", ColumnValues);
            this.dsNhom.add(nhom);
        } catch (Exception e) {
        }
        connect.connect.Close();
	}
    
    public ArrayList<DSNhom> TaiDSNhomHH() throws Exception{
        ArrayList<DSNhom> dsNhom = new ArrayList<DSNhom>();
        MySQLConnectUnit connect = new MySQLConnectUnit();
        ResultSet rs = connect.Select("danhmucnhom");
        while (rs.next()) {            
        	DSNhom nhom = new DSNhom();
        	nhom.setMaNhom(rs.getString(1));
        	nhom.setTenNhom(rs.getString(2));
        	dsNhom.add(nhom);
        }
        HangHoaBUS.dsNhom = dsNhom;
        connect.connect.Close();
        return dsNhom;
    }
    
    public ArrayList<HangHoaDTO> TaiDSHangHoa() throws Exception{
        ArrayList<HangHoaDTO> dsHangHoa = new ArrayList<HangHoaDTO>();
        MySQLConnectUnit connect = new MySQLConnectUnit();
        ResultSet rs = connect.Select("danhmuchanghoa");
        while (rs.next()) {            
        	HangHoaDTO hanghoa = new HangHoaDTO();
        	hanghoa.setMaHH(rs.getString(1));
        	hanghoa.setTenHH(rs.getString(2));
        	hanghoa.setMaNhom(rs.getString(3));
        	hanghoa.setDonvitinh(Integer.parseInt(rs.getString(4)));
        	hanghoa.setSoluong(Integer.parseInt(rs.getString(5)));
        	hanghoa.setHinhAnh(rs.getString(6));
        	dsHangHoa.add(hanghoa);
        }
        HangHoaBUS.dsHangHoa = dsHangHoa;
        connect.connect.Close();
        return dsHangHoa;
    }

	public void ThemHangHoa(HangHoaDTO hanghoa) throws Exception{
        MySQLConnectUnit connect =new MySQLConnectUnit();
        try {
			HashMap ColumnValues = new HashMap();
            ColumnValues.put("MaHH",hanghoa.getMaHH());
            ColumnValues.put("TenHH",hanghoa.getTenHH());
            ColumnValues.put("MaNhom",hanghoa.getMaNhom());
            ColumnValues.put("Donvitinh",hanghoa.getDonvitinh());
            ColumnValues.put("TongSoluong",hanghoa.getSoluong());
            ColumnValues.put("HinhAnh", hanghoa.getHinhAnh());
            connect.Insert("danhmuchanghoa", ColumnValues);
            this.dsHangHoa.add(hanghoa);
        } catch (Exception e) {
        }
        connect.connect.Close();
    }
//    public void ThemKho(KhoDTO kho) throws Exception{
//        MySQLConnectUnit connect =new MySQLConnectUnit();
//        try {
//            HashMap ColumnValues = new HashMap();
//            ColumnValues.put("MaKho",kho.getMakho());
//            ColumnValues.put("TenKho",kho.getTenkho());
//            ColumnValues.put("Diachi",kho.getDiachi());
//            ColumnValues.put("Sodt",kho.getSodienthoai());
//            ColumnValues.put("Noidung",kho.getNoidung());
//            connect.Insert("kho", ColumnValues);
//            this.dskho.add(kho);
//        } catch (Exception e) {
//        }
//        connect.connect.Close();
//    }
//    
    public void XoaHH(HangHoaDTO hanghoa) throws Exception{
        MySQLConnectUnit connect = new MySQLConnectUnit();
        try {
            String condition = "MaHH='"+hanghoa.getMaHH()+"'";
            connect.Delete("danhmuchanghoa",condition);
            this.dsHangHoa.remove(hanghoa);
        } catch (Exception e) {
        }
        connect.connect.Close();
    }
    public void SuaHH(HangHoaDTO hanghoa) throws Exception{
        MySQLConnectUnit connect = new MySQLConnectUnit();
        try {
            HashMap ColumnValues = new HashMap();
            ColumnValues.put("MaHH", hanghoa.getMaHH());
            ColumnValues.put("TenHH", hanghoa.getTenHH());
            ColumnValues.put("MaNhom", hanghoa.getMaNhom());
            ColumnValues.put("Donvitinh", hanghoa.getDonvitinh());
            ColumnValues.put("TongSoluong", hanghoa.getSoluong());
            ColumnValues.put("HinhAnh", hanghoa.getHinhAnh());
            String condition = "MaHH='"+hanghoa.getMaHH()+"'";
            connect.Update("danhmuchanghoa", ColumnValues, condition);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        connect.connect.Close();
    }
//    public String KiemtraTrungLap(KhoDTO kho){
//        String error = new String(""); 
//        String makho2 = kho.getMakho();
//        for (KhoDTO checker : this.dskho) {
//            String makho1 = checker.getMakho();
//            if(makho1.equals(makho2)){
//                error+="Mã kho đã tồn tại \n";
//            }
//        }
//        return error;
//    }
//    
    public boolean KiemtraTontaiHH(HangHoaDTO kho){
        boolean ret=false;
        for (HangHoaDTO temp : this.dsHangHoa) {
            if(temp.getMaHH().equals(kho.getMaHH())){
                ret=true;
                break;
            }
        }
        return ret;
    }
//    //Nhận tham số đầu vào là thông tin kho đã sửa và mã kho cũ để kiểm tra xem thông tin sửa có hợp lệ hay không
    public String KiemtraHopleHH(HangHoaDTO hanghoa,String MaHHCu){
        String error = "";
        String mahh2 = hanghoa.getMaHH();
        for (HangHoaDTO temp : this.dsHangHoa) {
            String mahh1 = temp.getMaHH();
            if(mahh1.equals(MaHHCu)){
                continue;
            }
            if(mahh1.equals(mahh2)){
                error += "Mã kho đã tồn tại";
                break;
            }
        }
        return error;
    }

	public String KiemtraTrungLap(HangHoaDTO hanghoa) {
		String error = new String ("");
		String maHH2 = hanghoa.getMaHH();
		for(HangHoaDTO checker : this.dsHangHoa) {
			String maHH1 = checker.getMaHH();
			if(maHH1.equals(maHH2)) {
				error+="Mã hàng này đã tồn tại \n";
			}
		}
		return error;
	}
	
	public String KiemtraTrungLapMaNhom(DSNhom nhom) {
		String error = new String ("");
		String ma2 = nhom.getMaNhom();
		for(DSNhom checker : this.dsNhom) {
			String ma1 = checker.getMaNhom();
			if(ma1.equals(ma2)) {
				error+="Mã nhóm hàng này đã tồn tại \n";
			}
		}
		return error;
	}

	public String KiemtraHopleNhom(DSNhom nhom, String maNhomCu) {
		String error = "";
        String manhom2 = nhom.getMaNhom();
        for (DSNhom temp : this.dsNhom) {
            String manhom1 = temp.getMaNhom();
            if(manhom1.equals(maNhomCu)){
                continue;
            }
            if(manhom1.equals(manhom2)){
                error += "Mã nhóm đã tồn tại";
                break;
            }
        }
        return error;
	}

	public void SuaNhom(DSNhom nhom) throws SQLException {
		MySQLConnectUnit connect = new MySQLConnectUnit();
        try {
            HashMap ColumnValues = new HashMap();
            ColumnValues.put("MaNhom", nhom.getMaNhom());
            ColumnValues.put("TenNhom", nhom.getTenNhom());
            String condition = "MaNhom='"+nhom.getMaNhom()+"'";
            connect.Update("danhmucnhom", ColumnValues, condition);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        connect.connect.Close();
	}

	public boolean KiemtraTontaiNhom(DSNhom nhom) {
		boolean ret=false;
        for (DSNhom temp : this.dsNhom) {
            if(temp.getMaNhom().equals(nhom.getMaNhom())){
                ret=true;
                break;
            }
        }
        return ret;
	}

	public void XoaNhomHH(DSNhom nhom) throws SQLException {
		MySQLConnectUnit connect = new MySQLConnectUnit();
        try {
            String condition = "MaNhom='"+nhom.getMaNhom()+"'";
            connect.Delete("danhmucnhom",condition);
            this.dsNhom.remove(nhom);
        } catch (Exception e) {
        }
        connect.connect.Close();
	} 
}
