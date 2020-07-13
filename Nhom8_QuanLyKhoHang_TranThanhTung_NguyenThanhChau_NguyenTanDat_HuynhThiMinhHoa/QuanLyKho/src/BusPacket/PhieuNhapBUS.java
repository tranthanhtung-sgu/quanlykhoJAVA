/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusPacket;


import DatabaseConnection.MySQLConnectUnit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import DTOPacket.*;

/**
 *
 * @author macintoshhd
 */
public class PhieuNhapBUS {
    public static ArrayList<PhieuNhapDTO> dspn;
    public PhieuNhapBUS(){
        
    }
    public PhieuNhapBUS(ArrayList<PhieuNhapDTO> dspn){
        this.dspn=dspn;
    }
    public ArrayList TaiDSPN() throws Exception{
        ArrayList dspn = new ArrayList<PhieuNhapDTO>();
        MySQLConnectUnit connect = new MySQLConnectUnit();
        ResultSet rs = connect.Select("`phieunhap`,`nhanvien`,`nhacungcap`","`phieunhap`.`MaNV`=`nhanvien`.`MaNV` AND `phieunhap`.`MaNCC`=`nhacungcap`.`MaNCC`");
        while (rs.next()) {            
           PhieuNhapDTO pt = new PhieuNhapDTO();
           pt.setMaPhieuNhap(rs.getString("MaPhieuNhap"));
           pt.setMaNCC(rs.getString("MaNCC"));
           pt.setTenNCC(rs.getString("TenNCC"));
           pt.setMaNV(rs.getString("MaNV"));
           pt.setTenNV(rs.getString("TenNV"));
           pt.setNgaylapphieu(rs.getString("NgayNhap"));
           pt.setNguoigiao(rs.getString("Nguoigiao"));
           pt.setNoidung(rs.getString("Noidung"));
            dspn.add(pt);
        }
        this.dspn = dspn;
        connect.connect.Close();
        return dspn;
    }
   public void ThemPN(PhieuNhapDTO pt) throws Exception{
        MySQLConnectUnit connect =new MySQLConnectUnit();
        try {
            HashMap ColumnValues = new HashMap();
            ColumnValues.put("MaPhieuNhap",pt.getMaPhieuNhap());
            ColumnValues.put("MaNCC",pt.getMaNCC());
            ColumnValues.put("MaNV",pt.getMaNV());
            ColumnValues.put("NgayNhap", pt.getNgaylapphieu());
            ColumnValues.put("Nguoigiao",pt.getNguoigiao());
            ColumnValues.put("Noidung",pt.getNoidung());
            connect.Insert("phieunhap", ColumnValues);
            this.dspn.add(pt);
        } catch (Exception e) {
        }
        connect.connect.Close();
    }

    public void suaPN(PhieuNhapDTO pt) throws SQLException{
        MySQLConnectUnit connect = new MySQLConnectUnit();
        try{
            HashMap ColumnValues  = new HashMap();
           ColumnValues.put("MaPhieuNhap",pt.getMaPhieuNhap());
            ColumnValues.put("MaNCC",pt.getMaNCC());
            ColumnValues.put("MaNV",pt.getMaNV());
            ColumnValues.put("NgayNhap", pt.getNgaylapphieu());
            ColumnValues.put("Nguoigiao",pt.getNguoigiao());
            ColumnValues.put("Noidung",pt.getNoidung());
                    String Condition = "MaPhieuNhap ='"+pt.getMaPhieuNhap()+"'";
                    connect.Update("phieunhap", ColumnValues, Condition);
                    
        }catch(Exception e){
            
        }
        connect.connect.Close();
    }
    public void xoaPN(PhieuNhapDTO pt) throws SQLException{
        MySQLConnectUnit connect = new MySQLConnectUnit();
        try{
            String Conditon ="MaPhieuNhap='"+pt.getMaPhieuNhap()+"'";
            connect.Delete("phieunhap", Conditon);
        }catch(Exception e){
            
        }
        connect.connect.Close();
    }
    public boolean KiemtraTontai(PhieuNhapDTO pt){
        boolean ret=false;
        for (PhieuNhapDTO temp : this.dspn) {
            if(temp.getMaPhieuNhap().equals(pt.getMaPhieuNhap())&&
                    temp.getMaNCC().equals(pt.getMaNCC())&&
                    temp.getMaNV().equals(pt.getMaNV())){
                    
                ret=true;
                break;
            }
        }
        return ret;
    }
        public String Kiemtratrunglap(PhieuNhapDTO pt){
        String error = "";
        String maphieunhap2 = pt.getMaPhieuNhap();
        for (PhieuNhapDTO temp : this.dspn) {
            String maphieunhap1 = temp.getMaPhieuNhap();
            if(maphieunhap1.equals(maphieunhap2)){
                error += "Mã phieu nhap đã tồn tại \n";
            }           
        }
        return error;
    }
         public String KiemtraHople(PhieuNhapDTO px,String MapnCu){
        String error = "";
        String mapn2 = px.getMaPhieuNhap();
        for (PhieuNhapDTO temp : this.dspn) {
            String mapn1 = temp.getMaPhieuNhap();
            if(mapn1.equals(MapnCu)){
                continue;
            }
            if(mapn1.equals(mapn2)){
                error += "Mã PN đã tồn tại";
                break;
            }
        }
        return error;
    }


}
