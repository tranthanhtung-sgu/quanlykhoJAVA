/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;


import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Checklogin {
    public static Connection conn= null;
    public static ResultSet rs = null;
    public static PreparedStatement pst = null;
    public static String testConnect(){
        
        try
        {
            conn = Connect.getConnect();
            
            
            
            return "Ket Noi Du Lieu Thanh Cong";
            
            
            
        }
        catch(Exception ex){
            return "Ket Noi Du Lieu That Bai";
        }
    }
    public static ResultSet  clog(String user , String pass){
                try {
            String sql  ="SELECT * FROM `dangnhap` WHERE taikhoan =? and matkhau=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, pass);
            
           return rs = pst.executeQuery();
                       
        } catch (SQLException ex) {
              return rs=null;  
        }
                
        
    }
    public static ResultSet  clog123(){
                try {
            String sql  ="SELECT * FROM `dangnhap`";
            pst = conn.prepareStatement(sql);
                        
           return rs = pst.executeQuery();
                       
        } catch (SQLException ex) {
              return rs=null;  
        }
                
        
    }
              
            }
