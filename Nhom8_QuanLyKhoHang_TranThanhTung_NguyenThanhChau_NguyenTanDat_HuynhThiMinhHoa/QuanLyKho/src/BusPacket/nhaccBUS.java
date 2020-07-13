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

import DTOPacket.nhaccDTO;
import DatabaseConnection.MySQLConnectUnit;

/**
 *
 * @author macintoshhd
 */
public class nhaccBUS {
    public static ArrayList<nhaccDTO> dsncc;
    public nhaccBUS(){
        
    }
    public nhaccBUS(ArrayList<nhaccDTO> dsncc){
        this.dsncc=dsncc;
    }
    public ArrayList docNCC() throws SQLException, Exception{
        MySQLConnectUnit connect = new MySQLConnectUnit();
        ArrayList dsncc = new ArrayList<nhaccDTO>();
        ResultSet rs = connect.Select("nhacungcap");
        while(rs.next()){
            nhaccDTO ncc = new nhaccDTO();
            ncc.setMancc(rs.getString(1));
            ncc.setTenncc(rs.getString(2));
            ncc.setDiachincc(rs.getString(3));
            ncc.setSdtncc(rs.getString(4));
            ncc.setEmailncc(rs.getString(5));
            ncc.setNoidung(rs.getString(6));
            dsncc.add(ncc);
        }
        this.dsncc=dsncc;
        connect.connect.Close();
        return dsncc;
    }
    public void ThemNCC(nhaccDTO ncc) throws SQLException{
        MySQLConnectUnit connect = new MySQLConnectUnit();
        try{
            HashMap ColumnValues = new HashMap();
            ColumnValues.put("MaNCC", ncc.getMancc());
            ColumnValues.put("TenNCC", ncc.getTenncc());
            ColumnValues.put("Diachi", ncc.getDiachincc());
            ColumnValues.put("Sodt", ncc.getSdtncc());
            ColumnValues.put("Email", ncc.getEmailncc());
            ColumnValues.put("Ghichu", ncc.getNoidung());
            connect.Insert("nhacungcap", ColumnValues);
            this.dsncc.add(ncc);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "aaaaa");
        }
        connect.connect.Close();
    }
    public void SuaNCC(nhaccDTO ncc) throws SQLException{
         MySQLConnectUnit connect = new MySQLConnectUnit();
        try{
            HashMap ColumnValues = new HashMap();
            ColumnValues.put("MaNCC", ncc.getMancc());
            ColumnValues.put("TenNCC", ncc.getTenncc());
            ColumnValues.put("Diachi", ncc.getDiachincc());
            ColumnValues.put("Sodt", ncc.getSdtncc());
            ColumnValues.put("Email", ncc.getEmailncc());
            ColumnValues.put("Ghichu", ncc.getNoidung());
            String Condition = "MaNCC='"+ncc.getMancc()+"'";
            connect.Update("nhacungcap", ColumnValues, Condition);
            this.dsncc.add(ncc);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "asdasdas");
    }
    connect.connect.Close();
    }
    public void XoaNCC(nhaccDTO ncc) throws SQLException{
        MySQLConnectUnit connect = new MySQLConnectUnit();
        try{
            String Condition = "MaNCC='"+ncc.getMancc()+"'";
            connect.Delete("nhacungcap", Condition);
            this.dsncc=dsncc;
        }catch(Exception e){
            
        }
        connect.connect.Close();
    }
    public boolean KiemtraTontai(nhaccDTO ncc){
        boolean ret=false;
        for (nhaccDTO temp : this.dsncc) {
            if(temp.getMancc().equals(ncc.getMancc())&&
                    temp.getTenncc().equals(ncc.getTenncc())
                    
                    ){
                ret=true;
                break;
            }
        }
        return ret;
    }
        public String Kiemtratrunglap(nhaccDTO px){
        String error = "";
        String mancc2 = px.getMancc();
        for (nhaccDTO temp : this.dsncc) {
            String mancc1 = temp.getMancc();
            if(mancc1.equals(mancc2)){
                error += "Mã phieu ncc đã tồn tại \n";
            }           
        }
        return error;
    }
         public String KiemtraHople(nhaccDTO px,String MaKhoCu){
        String error = "";
        String mancc2 = px.getMancc();
        for (nhaccDTO temp : this.dsncc) {
            String mancc1 = temp.getMancc();
            if(mancc1.equals(MaKhoCu)){
                continue;
            }
            if(mancc1.equals(mancc2)){
                error += "Mã ncc đã tồn tại";
                break;
            }
        }
        return error;
    }

}
