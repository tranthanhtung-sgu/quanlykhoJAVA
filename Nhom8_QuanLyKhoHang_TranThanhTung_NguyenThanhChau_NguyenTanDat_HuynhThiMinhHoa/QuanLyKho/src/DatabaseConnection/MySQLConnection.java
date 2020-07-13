/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.*;

/**
 *
 * @author asus
 */
public class MySQLConnection {
    String host="";
    String Username="";
    String Password="";
    String Database="";
    Connection con=null;
    Statement stm=null;
    ResultSet rs=null;

    public MySQLConnection(String host,String username,String password,String database) {
        this.host=host;
        this.Username=username;
        this.Password=password;
        this.Database=database;
    }

    public MySQLConnection() {
    }
    
    public void testDriver() throws Exception {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (Exception e) {
            throw new Exception("MySQL JDBC Driver not found");
        }
    }
    public Connection getConnection() throws Exception {
        if(this.con==null? true: this.stm.isClosed()){
            String url="jdbc:mysql://"+this.host+":3306/"+this.Database;
            try {
                this.con = DriverManager.getConnection(url,this.Username,this.Password);
            } catch (Exception e) {
                throw new Exception("Không thể kết nối đến database: "+url +e.getMessage());
            }
        }
        return this.con;
    }
    public Statement getStatement() throws Exception {
        if(this.stm==null){
            this.stm = (Statement) this.getConnection().createStatement();
        } else {
        }
        return this.stm;
    }
    
    public ResultSet executeQuery(String qry) {
        try {
            this.rs = getStatement().executeQuery(qry);
        } catch (Exception e) {
        }
        return this.rs;
    }
    public int executeUpdate(String qry) throws Exception{
        int res = Integer.MIN_VALUE;
        try {
            res = getStatement().executeUpdate(qry);
        } catch (Exception e) {
            throw new Exception("Error: "+e.getMessage()+qry);
        }finally{
            this.Close();
        }
        return res;
    }
    public void Close() throws SQLException{
        if(this.rs!=null && !this.rs.isClosed()){
            this.rs.close();
            this.rs = null;
        }
        if(this.stm!=null && !this.stm.isClosed()){
            this.stm.close();
            this.stm = null;
        }
        if(this.con!=null && !this.con.isClosed()){
            this.con.close();
            this.con = null;
        }
    }
}
