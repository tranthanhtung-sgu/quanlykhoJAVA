/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

import DatabaseConnection.MySQLConnectUnit;

/**
 *
 * @author macintoshhd
 */
public class loginBUS {
    public static ArrayList<login> dsdn;
   
    public loginBUS() {
    }
    public loginBUS(ArrayList<login> dsdn){
        this.dsdn = dsdn;
    }
     public ArrayList docdsdn() throws Exception{
        ArrayList dsdn = new ArrayList<login>();
        MySQLConnectUnit connect = new MySQLConnectUnit();
        ResultSet rs = connect.Select("dangnhap");
        while(rs.next()){
            login lg = new login();
            lg.setTaikhoan(rs.getString(1));
            lg.setMatkhau(rs.getString(2));
            lg.setPhanquyen(rs.getString(3));
            dsdn.add(lg);
        }
        this.dsdn = dsdn;
        connect.connect.Close();
        return dsdn;
        
    }
     public void themlogin(login lg) throws SQLException{
         MySQLConnectUnit conn = new MySQLConnectUnit();
         try{
             HashMap ComlumnValues = new HashMap();
             ComlumnValues.put("taikhoan", lg.getTaikhoan());
             ComlumnValues.put("matkhau", lg.getMatkhau());
             ComlumnValues.put("phanquyen", lg.getPhanquyen());
             conn.Insert("dangnhap", ComlumnValues);
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, "them tk khong duoc");
         }
         conn.connect.Close();
     }
     public String kiemtratrunglap(login lg){
        String error = new String("");
        String taikhoan2 = lg.getTaikhoan();
        for(login checker : this.dsdn){
            String taikhoan1 = checker.getTaikhoan();
            if(taikhoan1.equals(taikhoan2)){
                error+="tai khoan trung lap \n";
            }
        }
        return error;
     }
      
}
