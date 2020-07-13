/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusPacket;

import DatabaseConnection.MySQLConnectUnit;
import DTOPacket.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author macintoshhd
 */
public class CTPNBUS {
       public static ArrayList<CTPNDTO> ctpn;
        public CTPNBUS(){
            
        }

    public CTPNBUS(ArrayList<CTPNDTO> ctpn) {
        this.ctpn = ctpn;
    }
        public ArrayList docCTPN() throws Exception{
            MySQLConnectUnit connect = new MySQLConnectUnit();
            ArrayList ctpn = new ArrayList<CTPXDTO>();
            ResultSet rs = connect.Select("`ctpn`,`kho`,`danhmuchanghoa`","`ctpn`.`MaHH`=`danhmuchanghoa`.`MaHH`AND`ctpn`.`MaKho`=`kho`.`MaKho`");
            while(rs.next()){
                CTPNDTO pnct  = new CTPNDTO();
                pnct.setMaPhieuNhap(rs.getString("MaPhieuNhap"));
                pnct.setMaHH(rs.getString("MaHH"));
                pnct.setTenHH(rs.getString("TenHH"));
                pnct.setMaKho(rs.getString("MaKho"));
                                pnct.setTenKho(rs.getString("TenKho"));

                pnct.setSoluong(rs.getInt("Soluong"));
                pnct.setDongia(rs.getInt("Dongia"));
                ctpn.add(pnct);
            }
            this.ctpn=ctpn;
            connect.connect.Close();
            return ctpn;
        }
        public void themCTPN(CTPNDTO pnct) throws SQLException{
            MySQLConnectUnit connect = new MySQLConnectUnit();
            try{
                HashMap ColumnValues = new HashMap();
                ColumnValues.put("MaPhieuNhap", pnct.getMaPhieuNhap());
                ColumnValues.put("MaHH", pnct.getMaHH());
                ColumnValues.put("MaKho", pnct.getMaKho());
                ColumnValues.put("Soluong", pnct.getSoluong());
                ColumnValues.put("Dongia", pnct.getDongia());
                CapnhatSLHH(pnct.getMaHH(), pnct.getSoluong());
                connect.Insert("ctpn", ColumnValues);
                this.ctpn.add(pnct);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Mã hàng đã tồn tại trong chi tiết");
            }
            connect.connect.Close();
        }
        public void suaCTPN(CTPNDTO pnct) throws SQLException{
            MySQLConnectUnit connect = new MySQLConnectUnit();
            try{
                HashMap ColumnValues = new HashMap();
                ColumnValues.put("MaPhieuNhap", pnct.getMaPhieuNhap());
                ColumnValues.put("MaHH", pnct.getMaHH());
                ColumnValues.put("MaKho", pnct.getMaKho());
                ColumnValues.put("Soluong", pnct.getSoluong());
                ColumnValues.put("Dongia", pnct.getDongia());
                CapnhatSLHH(pnct.getMaHH(), pnct.getSoluong());
                String Condition = "MaPhieuNhap='"+pnct.getMaPhieuNhap()+"'";
                connect.Update("ctpn", ColumnValues, Condition);
                this.ctpn.add(pnct);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "abcxyz");

        }
            connect.connect.Close();
        }
        public void xoaCTPX(CTPNDTO pnct) throws SQLException{
            MySQLConnectUnit connect = new MySQLConnectUnit();
            try{
                
                String Condition ="MaPhieuNhap='"+pnct.getMaPhieuNhap()+"'";
                connect.Delete("ctpn", Condition);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "ABC");
            }
            connect.connect.Close();
        }
           public boolean KiemtraTontai(CTPNDTO pnct){
        boolean ret=false;
        for (CTPNDTO temp : this.ctpn) {
            if(temp.getMaPhieuNhap().equals(pnct.getMaPhieuNhap())&&
                    temp.getMaHH().equals(pnct.getMaHH())&&
                    temp.getMaKho().equals(pnct.getMaKho()))
                   {
                ret=true;
                break;
            }
        }
        return ret;
    }
        public String Kiemtratrunglap(CTPNDTO pnct){
        String error = "";
        String maphieunhap2 = pnct.getMaPhieuNhap();
        for (CTPNDTO temp : this.ctpn) {
            String maphieunhap1 = temp.getMaPhieuNhap();
            if(maphieunhap1.equals(maphieunhap2)){
                error += "Mã phieu xuat đã tồn tại \n";
            }           
        }
        return error;
    }
         public String KiemtraHople(CTPNDTO pnct,String MaKhoCu){
        String error = "";
        String mapn2 = pnct.getMaPhieuNhap();
        for (CTPNDTO temp : this.ctpn) {
            String mapn1 = temp.getMaPhieuNhap();
            if(mapn1.equals(MaKhoCu)){
                continue;
                  }
            if(mapn1.equals(mapn2)){
                error += "Mã PX đã tồn tại";
                break;
            }
        }
        return error;
    }
         
         private void CapnhatSLHH(String MaHH, int Soluong) throws Exception {
        	 MySQLConnectUnit connect = new MySQLConnectUnit();
        	 ResultSet rs;
        	 String Condition ="MaHH='"+MaHH+"'";
        	 rs = connect.Select("danhmuchanghoa",Condition);
        	 HangHoaDTO hang = new HangHoaDTO();
        	 while(rs.next()) {
        		 hang.setMaHH(rs.getString("MaHH"));
        		 hang.setMaNhom(rs.getString("MaNhom"));
        		 hang.setTenHH(rs.getString("TenHH"));
        		 hang.setSoluong(Integer.parseInt(rs.getString("TongSoLuong")));
        		 hang.setDonvitinh(Integer.parseInt(rs.getString("Donvitinh")));
        		 hang.setHinhAnh(rs.getString("HinhAnh"));
        		 
        	 }
        	 hang.setSoluong(hang.getSoluong()+Soluong);
        	 HashMap<String,Object> ColumnValues = new HashMap<String,Object>();
        	 ColumnValues.put("TongSoluong",Integer.toString(hang.getSoluong()));
        	 connect.Update("danhmuchanghoa", ColumnValues, Condition);
         }

}
