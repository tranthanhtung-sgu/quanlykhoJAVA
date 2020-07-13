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
import javax.swing.JOptionPane;
import DTOPacket.*;
import DatabaseConnection.MySQLConnectUnit;

/**
 *
 * @author macintoshhd
 */
public class nhanvienBUS {
    public static ArrayList<nhanvienDTO> dsnv;

    public nhanvienBUS() {
    }
    public nhanvienBUS(ArrayList<nhanvienDTO> dsnv){
        this.dsnv=dsnv;
    }
    public ArrayList docnv() throws Exception{
        ArrayList dsnv = new ArrayList<nhanvienDTO>();
        MySQLConnectUnit connect = new MySQLConnectUnit();
        ResultSet rs = connect.Select("nhanvien");
        while(rs.next()){
            nhanvienDTO nv = new nhanvienDTO();
            nv.setManv(rs.getString(1));
            nv.setTennv(rs.getString(2));
            nv.setDiachi(rs.getString(3));
            nv.setSdt(rs.getString(4));
            nv.setEmail(rs.getString(5));
            dsnv.add(nv);
        }
        this.dsnv = dsnv;
        connect.connect.Close();
        return dsnv;
    }
    public void themNV(nhanvienDTO nv) throws SQLException{
        MySQLConnectUnit connect = new MySQLConnectUnit();
        try{
            HashMap ComlumnValues = new HashMap();
            ComlumnValues.put("MaNV",nv.getManv());
            ComlumnValues.put("TenNV", nv.getTennv());
            ComlumnValues.put("Diachi", nv.getDiachi());
            ComlumnValues.put("Sodt", nv.getSdt());
            ComlumnValues.put("Email", nv.getEmail());
            connect.Insert("nhanvien", ComlumnValues);
            this.dsnv.add(nv);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null  , "Loi themNV");
        }
        connect.connect.Close();
    }
    public void suaNV(nhanvienDTO nv) throws Exception{
        MySQLConnectUnit connect = new MySQLConnectUnit();
        try{
             HashMap ComlumnValues = new HashMap();
            ComlumnValues.put("MaNV", nv.getManv());
            ComlumnValues.put("TenNV", nv.getTennv());
            ComlumnValues.put("Diachi", nv.getDiachi());
            ComlumnValues.put("Sodt", nv.getSdt());
            ComlumnValues.put("Email", nv.getEmail());
            String condition = "MaNV='"+nv.getManv()+"'";
            connect.Update("nhanvien", ComlumnValues, condition);
            this.dsnv.add(nv);
        }catch(Exception ex){
                   }
        
    }
    public void xoaNV(nhanvienDTO nv){
        MySQLConnectUnit connect = new MySQLConnectUnit();
        try{
            String condition ="MaNV='"+nv.getManv()+"'";
            connect.Delete("nhanvien", condition);
        }catch(Exception ex){
            
        }
    }
    public boolean kiemtratontai(nhanvienDTO nv){
       boolean fet = false;
       for(nhanvienDTO temp: this.dsnv){
           if(temp.getManv().equals(nv.getManv())&&
                   temp.getTennv().equals(nv.getTennv())&&
                   temp.getDiachi().equals(nv.getDiachi())&&
                   temp.getSdt().equals(nv.getSdt())&&
                   temp.getEmail().equals(nv.getEmail())                   
                   ){
               fet = true;
               break;
           }
       }
        
        return fet;
        
    }
    public String kiemtratrunglap(nhanvienDTO nv){
        String error = new String("");
        String MaNV2 = nv.getManv();
        for(nhanvienDTO checker : this.dsnv){
            String MaNV1 = checker.getManv();
            if(MaNV1.equals(MaNV2)){
                error+="Ma NV da ton tai";
                break;
            }
            
        }
        return error;
       }
    public String kiemtrahople(nhanvienDTO nv,String Manvcu){
        String error ="";
        String Manv2 = nv.getManv();
        for(nhanvienDTO checker : this.dsnv){
            String Manv1 = checker.getManv();
            if(Manv1.equals(Manvcu)){
                continue;
            }if(Manv1.equals(Manv2)){
            error+="Ma NV trung nhau";
        }
        }
        
        
        return error;
        
    }
    public void find(String title){
        
    }
}
