/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;
import java.sql.*;
import java.util.HashMap;
/**
 *
 * @author asus
 */
public class MySQLConnectUnit {
    public MySQLConnection connect;

    public MySQLConnectUnit() {
        this.connect = new MySQLConnection("localhost", "root", "", "qlkho");
    }
    
    private void addCondition(StringBuilder qry, String Condition) {
        if(Condition!=null){
            qry.append(" WHERE "+Condition);
        }
    }

    private void addOrderBy(StringBuilder qry, String OrderBy) {
        if(OrderBy!=null){
            qry.append(" ORDER BY" + OrderBy);
        }
    }
    public ResultSet Select(String TableName,String Condition,String OrderBy) throws Exception{
        StringBuilder qry = new StringBuilder("SELECT * FROM " + TableName);
        this.addCondition(qry, Condition);
        this.addOrderBy(qry, OrderBy);
        qry.append(";");
        return this.connect.executeQuery(qry.toString());
    }
    
    public ResultSet Select(String TableName,String Condition) throws Exception{
        return this.Select(TableName, Condition,null);
    }
    
    public ResultSet Select(String TableName) throws Exception{
        return this.Select(TableName,null);
    }
    
    public ResultSet Join2Select(String Table1,
            String Table2,
            String ColumnSelect,
            String JoinType,
            String JoinCondition,
            String Condition,
            String Orderby){
        StringBuilder qry = new StringBuilder("SELECT "+
                ColumnSelect + " FROM " 
                + Table1 + " "+JoinType+" " 
                + Table2 +" ON "+ JoinCondition);
        this.addCondition(qry, Condition);
        this.addOrderBy(qry, Orderby);
        return this.connect.executeQuery(qry.toString());
    }
    
    public ResultSet Join3Select(String Table1,
            String Table2,
            String Table3,
            String ColumnSelect,
            String JoinCondition1,
            String JoinCondition2,
            String JoinType1,
            String JoinType2,
            String Condition,
            String OrderBy){
        StringBuilder qry = new StringBuilder("SELECT " +
                ColumnSelect +" FROM "
                + Table1 + " "+JoinType1+" "
                + Table2 + " ON "
                + JoinCondition1 
                + " "+JoinType2+" " 
                + Table3 + " ON "
                + JoinCondition2);
        this.addCondition(qry, Condition);
        this.addOrderBy(qry, OrderBy);
        return this.connect.executeQuery(qry.toString());
    }
    
    public boolean Insert(String TableName,HashMap<String,Object> ColumnValues) throws Exception{
        StringBuilder qry = new StringBuilder("INSERT INTO "+ TableName);
        StringBuilder valueInsert = new StringBuilder();
        qry.append("(");
        for(String key : ColumnValues.keySet()){
            qry.append(key+",");
            valueInsert.append("'"+ColumnValues.get(key).toString()+"' ,");
        }
        qry = qry.delete(qry.length()-1,qry.length());
        valueInsert = valueInsert.delete(valueInsert.length()-1,valueInsert.length());
        qry.append(") VALUES("+ valueInsert.toString()+")");
        qry.append(";");
        return this.connect.executeUpdate(qry.toString()) > 0;
    }
    
    public boolean Update(String TableName,HashMap<String,Object> ColumnValues,String Condition) throws Exception{
        StringBuilder qry = new StringBuilder("UPDATE "+TableName+" SET ");
        for(String key : ColumnValues.keySet()){
            qry.append(key+" = '"+ColumnValues.get(key).toString()+"' ,");
        }
        qry = qry.delete(qry.length()-1,qry.length());
        this.addCondition(qry,Condition);
        qry.append(";");
        return this.connect.executeUpdate(qry.toString()) > 0;
    }
    
    public boolean Delete(String TableName,String Condidtion) throws Exception{
        StringBuilder qry = new StringBuilder("DELETE FROM "+ TableName);
        this.addCondition(qry, Condidtion);
        qry.append(";");
        return this.connect.executeUpdate(qry.toString()) > 0;
    }
    
    public static int getColumnCount(ResultSet rs) throws SQLException{
        return rs.getMetaData().getColumnCount();
    }
    
    public static String[] getColumnName(ResultSet rs) throws SQLException{
        ResultSetMetaData rsMetaData = (ResultSetMetaData)rs.getMetaData();
        int Columncount = rsMetaData.getColumnCount();
        String[] list = new String[Columncount];
        for (int i = 0; i < Columncount; i++) {
            list[i] = rsMetaData.getColumnName(i);
        }
        return list;
    }
}
