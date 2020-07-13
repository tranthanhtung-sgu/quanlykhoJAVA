/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusPacket;


import DatabaseConnection.MySQLConnectUnit;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class PhieuXuatBUS {
    public static PreparedStatement pst = null;
    public static ArrayList<PhieuXuatDTO> dspx;
    public static Connection conn = null;
    public static ResultSet rs =null;
    public PhieuXuatBUS(){
    }
    public PhieuXuatBUS(ArrayList<PhieuXuatDTO> dspx){
        this.dspx=dspx;
    }
    public ArrayList TaiDSPX() throws Exception{
        ArrayList dspx = new ArrayList<PhieuXuatDTO>();
        MySQLConnectUnit connect = new MySQLConnectUnit();
        ResultSet rs = connect.Select("`phieuxuat`,`nhanvien`", "`phieuxuat`.`MaNV`=`nhanvien`.`MaNV`");;
        while (rs.next()) {            
           PhieuXuatDTO kho = new PhieuXuatDTO();
            kho.setMaPhieuXuat(rs.getString("MaPhieuXuat"));
            kho.setMaNV(rs.getString("MaNV"));
            kho.setTenNV(rs.getString("TenNV"));
            kho.setNgaylapphieu(rs.getString("Ngayxuat"));
            kho.setNguoinhan(rs.getString("Nguoinhan"));
            kho.setNoidung(rs.getString("Noidung"));
            dspx.add(kho);
        }
        this.dspx = dspx;
        connect.connect.Close();
        return dspx;
    }
   public void ThemPX(PhieuXuatDTO kho) throws Exception{
        MySQLConnectUnit connect =new MySQLConnectUnit();
        try {
            HashMap ColumnValues = new HashMap();
            ColumnValues.put("MaPhieuXuat",kho.getMaPhieuXuat());
            ColumnValues.put("MaNV",kho.getMaNV());
            ColumnValues.put("Ngayxuat",kho.getNgaylapphieu());
            ColumnValues.put("Nguoinhan",kho.getNguoinhan());
            ColumnValues.put("Noidung",kho.getNoidung());
            connect.Insert("phieuxuat", ColumnValues);
            this.dspx.add(kho);
        } catch (Exception e) {
        }
        connect.connect.Close();
    }

    public void suaPX(PhieuXuatDTO px) throws SQLException{
        MySQLConnectUnit connect = new MySQLConnectUnit();
        try{
            HashMap ComlumnValues  = new HashMap();
            ComlumnValues.put("MaPhieuXuat", px.getMaPhieuXuat());
            ComlumnValues.put("MaNV", px.getMaNV());
                    ComlumnValues.put("Ngayxuat", px.getNgaylapphieu());
                                        ComlumnValues.put("Nguoinhan", px.getNguoinhan());

                    ComlumnValues.put("Noidung", px.getNoidung());
                    String Condition = "MaPhieuXuat ='"+px.getMaPhieuXuat()+"'";
                    connect.Update("phieuxuat", ComlumnValues, Condition);
                    
        }catch(Exception e){
            
        }
        connect.connect.Close();
    }
    public void xoaPX(PhieuXuatDTO px) throws SQLException{
        MySQLConnectUnit connect = new MySQLConnectUnit();
        try{
            String Conditon ="MaPhieuXuat='"+px.getMaPhieuXuat()+"'";
            connect.Delete("phieuxuat", Conditon);
        }catch(Exception e){
            
        }
        connect.connect.Close();
    }
    public boolean KiemtraTontai(PhieuXuatDTO px){
        boolean ret=false;
        for (PhieuXuatDTO temp : this.dspx) {
            if(temp.getMaPhieuXuat().equals(px.getMaPhieuXuat())&&
                    temp.getMaNV().equals(px.getMaNV())&&
                    temp.getNgaylapphieu().equals(px.getNgaylapphieu())&&
                    temp.getNguoinhan().equals(px.getNguoinhan()) &&
                    temp.getNoidung().equals(px.getNoidung())){
                ret=true;
                break;
            }
        }
        return ret;
    }
        public String Kiemtratrunglap(PhieuXuatDTO px){
        String error = "";
        String maphieuXuat2 = px.getMaPhieuXuat();
        for (PhieuXuatDTO temp : this.dspx) {
            String maphieuXuat1 = temp.getMaPhieuXuat();
            if(maphieuXuat1.equals(maphieuXuat2)){
                error += "Mã phieu xuat đã tồn tại \n";
            }           
        }
        return error;
    }
         public String KiemtraHople(PhieuXuatDTO px,String MaKhoCu){
        String error = "";
        String mapx2 = px.getMaPhieuXuat();
        for (PhieuXuatDTO temp : this.dspx) {
            String mapx1 = temp.getMaPhieuXuat();
            if(mapx1.equals(MaKhoCu)){
                continue;
            }
            if(mapx1.equals(mapx2)){
                error += "Mã PX đã tồn tại";
                break;
            }
        }
        return error;
    }
       


}
