/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusPacket;

import DatabaseConnection.MySQLConnectUnit;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import DTOPacket.KhoDTO;

/**
 *
 * @author asus
 */
public class KhoBUS {
    public static ArrayList<KhoDTO> dskho;
    public static ArrayList<KhoDTO> listTimkiem;

    public KhoBUS() {
    }
    
    public KhoBUS(ArrayList<KhoDTO> dskho) {
        this.dskho = dskho;
    }
    
    public ArrayList TaiDSKho() throws Exception{
        ArrayList dskho = new ArrayList<KhoDTO>();
        MySQLConnectUnit connect = new MySQLConnectUnit();
        ResultSet rs = connect.Select("kho");
        while (rs.next()) {            
            KhoDTO kho = new KhoDTO();
            kho.setMakho(rs.getString(1));
            kho.setTenkho(rs.getString(2));
            kho.setDiachi(rs.getString(3));
            kho.setSodienthoai(rs.getString(4));
            kho.setNoidung(rs.getString(5));
            dskho.add(kho);
        }
        this.dskho = dskho;
        connect.connect.Close();
        return dskho;
    }
    public void ThemKho(KhoDTO kho) throws Exception{
        MySQLConnectUnit connect =new MySQLConnectUnit();
        try {
            HashMap ColumnValues = new HashMap();
            ColumnValues.put("MaKho",kho.getMakho());
            ColumnValues.put("TenKho",kho.getTenkho());
            ColumnValues.put("Diachi",kho.getDiachi());
            ColumnValues.put("Sodt",kho.getSodienthoai());
            ColumnValues.put("Noidung",kho.getNoidung());
            connect.Insert("kho", ColumnValues);
            this.dskho.add(kho);
        } catch (Exception e) {
        }
        connect.connect.Close();
    }
    
    public void XoaKho(KhoDTO kho) throws Exception{
        MySQLConnectUnit connect = new MySQLConnectUnit();
        try {
            String condition = "MaKho='"+kho.getMakho()+"'";
            connect.Delete("kho",condition);
            this.dskho.remove(kho);
        } catch (Exception e) {
        }
        connect.connect.Close();
    }
    public void SuaKho(KhoDTO kho) throws Exception{
        MySQLConnectUnit connect = new MySQLConnectUnit();
        try {
            HashMap ColumnValues = new HashMap();
            ColumnValues.put("MaKho", kho.getMakho());
            ColumnValues.put("TenKho", kho.getTenkho());
            ColumnValues.put("Diachi", kho.getDiachi());
            ColumnValues.put("Sodt", kho.getSodienthoai());
            ColumnValues.put("Noidung", kho.getNoidung());
            String condition = "MaKho='"+kho.getMakho()+"'";
            connect.Update("kho", ColumnValues, condition);
        } catch (Exception e) {
        }
        connect.connect.Close();
    }
    
    public boolean KiemtraTontai(KhoDTO kho){
        boolean ret=false;
        for (KhoDTO temp : this.dskho) {
            if(temp.getMakho().equals(kho.getMakho())&&
                    temp.getTenkho().equals(kho.getTenkho())&&
                    temp.getDiachi().equals(kho.getDiachi())&&
                    temp.getSodienthoai().equals(kho.getSodienthoai())&&
                    temp.getNoidung().equals(kho.getNoidung())){
                ret=true;
                break;
            }
        }
        return ret;
    }
    //Nhận tham số đầu vào là thông tin kho đã sửa và mã kho cũ để kiểm tra xem thông tin sửa có hợp lệ hay không
    public String KiemtraHople(KhoDTO kho){
        String error = "";
        String makho2 = kho.getMakho();
        for (KhoDTO temp : this.dskho) {
            String makho1 = temp.getMakho();
            if(makho1.equals(makho2)){
                error += "Mã kho đã tồn tại \n";
            }
            if(kho.getTenkho().equals("")){
                error += "Tên kho không được trống \n";
            }
            if(kho.getDiachi().equals("")){
                error += "Địa chỉ không được trống \n";
            }
            if(kho.getSodienthoai().equals("")){
                error += "Số điện thoại không được trống \n";
            }
            if(!kho.getSodienthoai().matches("\\d/g") && kho.getSodienthoai().charAt(0)!='0'){
                error += "Số điện thoại chỉ được bao gồm số và phải bắt đầu bằng số 0 \n";
            }
        }
        return error;
    }
    public ArrayList TimkiemKho(String[] kho) throws Exception{
        ArrayList listTimkiem = new ArrayList<KhoDTO>();
        MySQLConnectUnit connect = new MySQLConnectUnit();
        StringBuilder condition = new StringBuilder();
        String makho = kho[0];
        String tenkho = kho[1];
        String diachi = kho[2];
        String sodt = kho[3];
        String HHdangco = kho[4];
        String HHkhongco = kho[5];
        ResultSet rs;
        if(!makho.equals("")){
            if(!condition.toString().equals("")){
                condition.append(" or kho.Makho like '%"+makho+"%' ");
            }
            else{
                condition.append(" kho.Makho like '%"+makho+"%' ");
            }
        }
        if(!tenkho.equals("")){
            if(!condition.toString().equals("")){
                condition.append(" or kho.TenKho like '%"+tenkho+"%' ");
            }
            else{
                condition.append(" kho.TenKho like '%"+tenkho+"%' ");
            }
        }
        if(!diachi.equals("")){
            if(!condition.toString().equals("")){
                condition.append(" or kho.Diachi like '%"+diachi+"%' ");
            }
            else{
                condition.append(" kho.Diachi like '%"+diachi+"%' ");
            }
        }
        if(!sodt.equals("")){
            if(!condition.toString().equals("")){
                condition.append(" or kho.Sodt like '%"+sodt+"%' ");
            }
            else{
                condition.append(" kho.Sodt like '%"+sodt+"%' ");
            }
        }
        if(!condition.toString().equals("") || !HHdangco.equals("") || !HHkhongco.equals("") ){
            if( HHdangco.equals("") && HHkhongco.equals("")){
                rs = connect.Select("kho",condition.toString());
            }
            else{
                if( !HHdangco.equals("") && HHkhongco.equals("")){
                    if(!condition.toString().equals("")){
                        condition.append(" or danhmuchanghoa.TenHH like '%"+HHdangco+"%' ");
                    }else{
                        condition.append(" danhmuchanghoa.TenHH like '%"+HHdangco+"%' ");
                    }
                    rs = connect.Join3Select("kho",
                            "khohanghoa",
                            "danhmuchanghoa",
                            "distinct kho.*",
                            "kho.MaKho=khohanghoa.MaKho",
                            "khohanghoa.MaHH=danhmuchanghoa.MaHH",
                            "join",
                            "join",
                            condition.toString(),
                            null);
                }
                else if( HHdangco.equals("") && !HHkhongco.equals("") ){
                    rs = connect.Select("kho",
                            condition.toString()+" kho.MaKho not in "
                                    + "("
                                    + "select distinct kho.MaKho from "
                                    + "kho join khohanghoa on kho.MaKho=khohanghoa.MaKho join danhmuchanghoa on khohanghoa.MaHH=danhmuchanghoa.MaHH"
                                    + " where danhmuchanghoa.TenHH like '%"+HHkhongco+"'"
                                    + ")");
                }
                else{
                    rs = connect.Select("kho",
                            condition.toString()+" kho.MaKho not in "
                                    + "("
                                    + "select distinct kho.MaKho from "
                                    + "kho join khohanghoa on kho.MaKho=khohanghoa.MaKho join danhmuchanghoa on khohanghoa.MaHH=danhmuchanghoa.MaHH"
                                    + " where danhmuchanghoa.TenHH like '%"+HHkhongco+"'"
                                    + ")" 
                                    + " and kho.MaKho in"
                                    + "("
                                    + "select distinct kho.MaKho from"
                                    + "kho join khohanghoa on kho.MaKho=khohanghoa.MaKho join danhmuchanghoa on khohanghoa.MaHH=danhmuchanghoa.MaHH"
                                    + " where danhmuchanghoa.TenHH like '%"+HHdangco+"'"
                                    + ")"
                    );
                }
            }
        }
        else{
            rs = connect.Select("kho");
        }
        if(!rs.next()){
            return null;
        }
        rs.beforeFirst();
        while (rs.next()) {
            KhoDTO temp = new KhoDTO();
            temp.setMakho(rs.getString(1));
            temp.setTenkho(rs.getString(2));
            temp.setDiachi(rs.getString(3));
            temp.setSodienthoai(rs.getString(4));
            temp.setNoidung(rs.getString(5));
            listTimkiem.add(temp);
        }
        this.listTimkiem=listTimkiem;
        connect.connect.Close();
        return listTimkiem;
    }
    public HashMap DataThongKe() throws SQLException{
        HashMap listData = new HashMap();
        MySQLConnectUnit con = new MySQLConnectUnit();
        StringBuilder condition = new StringBuilder();
        condition.append("1 group by kho.MaKho");
        ResultSet rs;
        rs = con.Join2Select("kho","khohanghoa","kho.MaKho,count(khohanghoa.MaHH) as Tongsoluong","join","kho.MaKho=khohanghoa.MaKho", condition.toString(),null);
        while(rs.next()){
            listData.put(rs.getString("Kho.MaKho"),rs.getString("Tongsoluong"));
        }
        return listData;
    }
}
