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
public class CTPXBUS {
       public static ArrayList<CTPXDTO> ctpx;
        public CTPXBUS(){
            
        }

    public CTPXBUS(ArrayList<CTPXDTO> ctpx) {
        this.ctpx = ctpx;
    }
        public ArrayList docCTPX() throws Exception{
            MySQLConnectUnit connect = new MySQLConnectUnit();
            ArrayList ctpx = new ArrayList<CTPXDTO>();
            ResultSet rs = connect.Select("`chitietphieuxuat`,`kho`,`danhmuchanghoa`","`chitietphieuxuat`.`MaHH`=`danhmuchanghoa`.`MaHH`AND`chitietphieuxuat`.`MaKho`=`kho`.`MaKho`");
            while(rs.next()){
                CTPXDTO pxct  = new CTPXDTO();
                pxct.setMaPhieuXuat(rs.getString("MaPhieuXuat"));
                pxct.setMAHH(rs.getString("MaHH"));
                pxct.setTenHH(rs.getString("TenHH"));
                pxct.setTenKho(rs.getString("TenKho"));
                pxct.setMaKho(rs.getString("MaKho"));
                pxct.setSoluong(rs.getInt("Soluong"));
                pxct.setDongia(rs.getInt("Dongia"));
                ctpx.add(pxct);
            }
            this.ctpx=ctpx;
            connect.connect.Close();
            return ctpx;
        }
        public void themCTPX(CTPXDTO pxct) throws SQLException{
            MySQLConnectUnit connect = new MySQLConnectUnit();
            try{
                HashMap ColumnValues = new HashMap();
                ColumnValues.put("MaPhieuXuat", pxct.getMaPhieuXuat());
                ColumnValues.put("MaHH", pxct.getMAHH());
                ColumnValues.put("MaKho", pxct.getMaKho());
                ColumnValues.put("Soluong", pxct.getSoluong());
                ColumnValues.put("Dongia", pxct.getDongia());
                CapnhatSLHH(pxct.getMAHH(), pxct.getSoluong());
                connect.Insert("chitietphieuxuat", ColumnValues);
                this.ctpx.add(pxct);
            }catch(Exception e){
            	JOptionPane.showMessageDialog(null, "loi them chi tiet");
            }
            connect.connect.Close();
        }
        public void suaCTPX(CTPXDTO pxct, int SLbandau) throws SQLException{
            MySQLConnectUnit connect = new MySQLConnectUnit();
            try{
                HashMap ColumnValues = new HashMap();
                ColumnValues.put("MaPhieuXuat", pxct.getMaPhieuXuat());
                ColumnValues.put("MaHH", pxct.getMAHH());
                ColumnValues.put("MaKho", pxct.getMaKho());
                ColumnValues.put("Soluong", pxct.getSoluong());
                ColumnValues.put("Dongia", pxct.getDongia());
                CapnhatSLHHSua(pxct.getMAHH(), pxct.getSoluong(), SLbandau);
                String Condition = "MaPhieuXuat='"+pxct.getMaPhieuXuat()+"'";
                connect.Update("chitietphieuxuat", ColumnValues, Condition);
                this.ctpx.add(pxct);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Loi sua chi tiet phieu xuat");
        }
            connect.connect.Close();
        }
        public void xoaCTPX(CTPXDTO pxct) throws SQLException{
            MySQLConnectUnit connect = new MySQLConnectUnit();
            try{
                
                String Condition ="MaPhieuXuat='"+pxct.getMaPhieuXuat()+"'";
                connect.Delete("chitietphieuxuat", Condition);
            }catch(Exception e){
                
            }
            connect.connect.Close();
        }
           public boolean KiemtraTontai(CTPXDTO pxct){
        boolean ret=false;
        for (CTPXDTO temp : this.ctpx) {
            if(temp.getMaPhieuXuat().equals(pxct.getMaPhieuXuat())&&
                    temp.getMAHH().equals(pxct.getMAHH())&&
                    temp.getMaKho().equals(pxct.getMaKho()))
                   {
                ret=true;
                break;
            }
        }
        return ret;
    }
        public String Kiemtratrunglap(CTPXDTO px){
        String error = "";
        String maphieuXuat2 = px.getMaPhieuXuat();
        for (CTPXDTO temp : this.ctpx) {
            String maphieuXuat1 = temp.getMaPhieuXuat();
            if(maphieuXuat1.equals(maphieuXuat2)){
                error += "Mã phieu xuat đã tồn tại \n";
            }           
        }
        return error;
    }
         public String KiemtraHople(CTPXDTO px,String MaKhoCu){
        String error = "";
        String mapx2 = px.getMaPhieuXuat();
        for (CTPXDTO temp : this.ctpx) {
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
         
         private void CapnhatSLHH(String MaHH, int Soluong) throws Exception {
        	 MySQLConnectUnit connect = new MySQLConnectUnit();
        	 ResultSet rs;
        	 String Condition ="MAHH='"+MaHH+"'";
        	 rs = connect.Select("danhmuchanghoa",Condition);
        	 HangHoaDTO hang = new HangHoaDTO();
        	 while(rs.next()) {
        		 hang.setMaHH(rs.getString("MaHH"));
        		 hang.setMaNhom(rs.getString("MaNhom"));
        		 hang.setTenHH(rs.getNString("TenHH"));
        		 hang.setSoluong(Integer.parseInt(rs.getString("TongSoLuong")));
        		 hang.setDonvitinh(Integer.parseInt(rs.getString("Donvitinh")));
        		 hang.setHinhAnh(rs.getString("HinhAnh"));
        		 
        	 }
        	 if(hang.getSoluong()< Soluong) {
        		 JOptionPane.showMessageDialog(null,"Không đủ hàng trong kho!");
        	 }else {
        		 hang.setSoluong(hang.getSoluong()-Soluong);
            	 HashMap<String,Object> ColumnValues = new HashMap<String,Object>();
            	 ColumnValues.put("TongSoluong",Integer.toString(hang.getSoluong()));
            	 connect.Update("danhmuchanghoa", ColumnValues, Condition);
        	 }  
        	 
         }
         
         private void CapnhatSLHHSua(String MaHH, int SLtruyenvao, int SLbandau) throws Exception {
        	 MySQLConnectUnit connect = new MySQLConnectUnit();
        	 ResultSet rs;
        	 String Condition ="MAHH='"+MaHH+"'";
        	 rs = connect.Select("danhmuchanghoa",Condition);
        	 HangHoaDTO hang = new HangHoaDTO();
        	 while(rs.next()) {
        		 hang.setMaHH(rs.getString("MaHH"));
        		 hang.setMaNhom(rs.getString("MaNhom"));
        		 hang.setTenHH(rs.getNString("TenHH"));
        		 hang.setSoluong(Integer.parseInt(rs.getString("TongSoLuong")));
        		 hang.setDonvitinh(Integer.parseInt(rs.getString("Donvitinh")));
        		 hang.setHinhAnh(rs.getString("HinhAnh"));
        		 
        	 }
        	 if(hang.getSoluong()< SLtruyenvao) {
        		 JOptionPane.showMessageDialog(null,"Không đủ hàng trong kho!");
        	 }else {
        		 if(SLtruyenvao > SLbandau) {
        			 hang.setSoluong(hang.getSoluong()+SLtruyenvao);
        		 }else {
        			 hang.setSoluong(hang.getSoluong()-SLtruyenvao);
        		 }
            	 HashMap<String,Object> ColumnValues = new HashMap<String,Object>();
            	 ColumnValues.put("TongSoluong",Integer.toString(hang.getSoluong()));
            	 connect.Update("danhmuchanghoa", ColumnValues, Condition);
        	 }  
        	 
         }
         

}
