/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusPacket;

import DatabaseConnection.ThongKeDAO;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class ThongKeBUS {
    private static final File FILE = new File("resource/times.ttf");

    public ThongKeBUS() {
    }
    
    public HashMap ThongKeHangHoa() throws SQLException{
        HashMap dataList = new HashMap();
        ThongKeDAO con = new ThongKeDAO();
        ResultSet rs = null;
        rs = con.ThongKeHangHoa();
        if(!rs.next()){
            return null;
        }
        rs.beforeFirst();
        while(rs.next()){
            dataList.put(rs.getString(1), rs.getString(2));
        }
        return dataList;
    }
    
    public ArrayList ThongKeTheoQuy(LocalDate ThangBatDau,LocalDate ThangKetThuc) throws SQLException{
        ArrayList<String[]> dataList = new ArrayList();
        ThongKeDAO con = new ThongKeDAO();
        ResultSet rs = null;
        rs = con.ThongKeTheoQuy(ThangBatDau, ThangKetThuc);
        while(rs.next()){
            dataList.add(new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
        }
        return dataList;
    }
    
    public  ArrayList ThongKeTheoNgay(LocalDate NgayBatDau,LocalDate NgayKetThuc) throws SQLException{
        ArrayList<String[]> dataList = new ArrayList();
        ThongKeDAO con = new ThongKeDAO();
        ResultSet rs = null;
        rs = con.ThongKetTheoNgay(NgayBatDau, NgayKetThuc);
        while(rs.next()){
            dataList.add(new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
        }
        return dataList;
    }
    public void XuatPDF(String filePath,String type,DefaultTableModel model){
        try {
            FileOutputStream fos = new FileOutputStream(filePath+"/thongke.pdf");
            PdfWriter writer = new PdfWriter(fos);
            PdfDocument pdf = new PdfDocument(writer);
            Document doc = new Document(pdf);
            PdfFont font = PdfFontFactory.createFont(FILE.getCanonicalPath(),PdfEncodings.IDENTITY_H,true);
            Paragraph para = new Paragraph("Thống kê dữ liệu theo "+type);
            para.setFont(font);
            para.setFontSize(20);
            para.setBold();
            para.setHorizontalAlignment(HorizontalAlignment.CENTER);
            doc.add(para);
            int count = model.getRowCount();
            switch (type){
                case "Hàng Hóa":{
                    Table tab = new Table(2);
                    tab.setFont(font);
                    tab.setWidth(UnitValue.createPercentValue(100));
                    tab.addHeaderCell("Hàng hóa");
                    tab.addHeaderCell("Số lượng");
                    for (int i = 0; i < count; i++) {
                        Object tenHH = GetData(model, i, 0);
                        Object soluong = GetData(model, i, 1);
                        tab.addCell(tenHH.toString());
                        tab.addCell(soluong.toString());
                    }
                    doc.add(tab);
                };break;
                case "Nhập/Xuất":{
                    Table tab = new Table(3);
                    tab.setFont(font);
                    tab.setWidth(UnitValue.createPercentValue(100));
                    tab.addHeaderCell("Nhập/Xuất");
                    tab.addHeaderCell("Số lượng");
                    tab.addHeaderCell("Tổng tiền");
                    for (int i = 0; i < count; i++) {
                        Object nhapxuat = GetData(model, i, 0);
                        Object soluong = GetData(model, i, 1);
                        Object dongia = GetData(model, i, 2);
                        tab.addCell(nhapxuat.toString());
                        tab.addCell(soluong.toString());
                        tab.addCell(dongia.toString());
                    }
                    doc.add(tab);
                };break;
            }
            doc.close();
            writer.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private Object GetData(DefaultTableModel model,int row,int col){
        return model.getValueAt(row, col);
    }
}
