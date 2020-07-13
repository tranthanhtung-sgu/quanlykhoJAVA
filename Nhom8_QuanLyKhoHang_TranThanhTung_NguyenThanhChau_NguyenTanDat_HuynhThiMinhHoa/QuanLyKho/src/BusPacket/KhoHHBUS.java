/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusPacket;

import DatabaseConnection.MySQLConnectUnit;
import java.util.ArrayList;
import java.sql.*;
import DTOPacket.KhoHHDTO;

/**
 *
 * @author asus
 */
public class KhoHHBUS {
    public static ArrayList<KhoHHDTO> dskhohh;
    public ArrayList docDsKhoHH() throws Exception{
        ArrayList dskhohh = new ArrayList();
        MySQLConnectUnit con = new MySQLConnectUnit();
        ResultSet rs = con.Select("khohanghoa");
        while(rs.next()){
            KhoHHDTO khohh = new KhoHHDTO();
            khohh.setMaHH(rs.getString(1));
            khohh.setMaKho(rs.getString(2));
            khohh.setSoluong(Integer.parseInt(rs.getString(3)));
            dskhohh.add(khohh);
        }
        this.dskhohh=dskhohh;
        return dskhohh;
    }
    public ArrayList TenHHtrongkho() throws SQLException{
        ArrayList listTenHH = new ArrayList();
        MySQLConnectUnit con = new MySQLConnectUnit();
        ResultSet rs = con.Join2Select("khohanghoa","danhmuchanghoa","distinct danhmuchanghoa.TenHH","join","khohanghoa.MaHH=danhmuchanghoa.MaHH",null,null);
        while(rs.next()){
            listTenHH.add(rs.getString(1));
        }
        return listTenHH;
    }
}
