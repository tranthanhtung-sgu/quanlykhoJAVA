/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusPacket;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DTOPacket.CTPNDTO;
import DTOPacket.HangHoaDTO;
import DTOPacket.KhoDTO;
import DTOPacket.PhieuNhapDTO;
import DTOPacket.PhieuXuatDTO;

/**
 *
 * @author asus
 */
public class ExportFile {

    public ExportFile() {
    }
    
    public void Export(String DTOtype,String fileDir) throws Exception{
        switch (DTOtype){
            case "Kho": ExportKho(Khodata(),fileDir);
            case "Hàng hóa":ExportHangHoa(HangHoadata(), fileDir);
            case "Phiếu nhập": ExportPhieuNhap(PhieuNhapdata(),fileDir);
            case "Phiếu xuất": ExportPhieuXuat(PhieuXuatdata(), fileDir);
            case "Chi tiết phiếu nhập": ExportCTPhieuNhap(CTPhieuNhapdata(), fileDir);
            case "Chi tiết phiếu xuất":;
            case "Nhân viên":;
            case "Nhà cung cấp":;
            case "Kho hàng hóa":;
        }
    }
    
    private void ExportPhieuNhap(ArrayList<PhieuNhapDTO> dataset, String fileDir) throws IOException {
    	XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet();
        int rowindex = 0;
        WriteHeader(spreadsheet,new String[]{"Mã phiếu nhập","Nhà cung cấp","Tên nhà cung cấp","Mã nhân viên","Tên nhân viên","Ngày nhập","Người giao","Nội dung"}, rowindex);
        rowindex++;
        for (PhieuNhapDTO phieuNhapDTO : dataset) {
            XSSFRow row = spreadsheet.createRow(rowindex);
            WriteDataPhieuNhap(phieuNhapDTO, row);
            rowindex++;
        }
        FileOutputStream fos;
        fos = new FileOutputStream(new File(fileDir+"/phieunhap.xlsx"));
        workbook.write(fos);
        fos.close();
		
    }

	private ArrayList PhieuNhapdata() throws Exception {
		PhieuNhapBUS pn = new PhieuNhapBUS();
        ArrayList<PhieuNhapDTO> data = new ArrayList<>();
        data=pn.TaiDSPN();
        return data;
	}
	
	private void WriteDataPhieuNhap(PhieuNhapDTO pn,XSSFRow row){
//    	{"Mã phiếu nhập","Nhà cung cấp","Tên nhà cung cấp","Mã nhân viên",
//    		"Tên nhân viên","Ngày nhập","Người giao","Nội dung"}
        Cell cell = row.createCell(0);
        cell.setCellValue(pn.getMaPhieuNhap());
        cell = row.createCell(1);
        cell.setCellValue(pn.getMaNCC());
        cell = row.createCell(2);
        cell.setCellValue(pn.getTenNCC());
        cell = row.createCell(3);
        cell.setCellValue(pn.getMaNV());
        cell = row.createCell(4);
        cell.setCellValue(pn.getTenNV());
        cell = row.createCell(5);
        cell.setCellValue(pn.getNgaylapphieu());
        cell = row.createCell(6);
        cell.setCellValue(pn.getNguoigiao());
        cell = row.createCell(7);
        cell.setCellValue(pn.getNoidung());
    }
	//Phieu Xuat 
    private void ExportPhieuXuat(ArrayList<PhieuXuatDTO> dataset, String fileDir) throws IOException {
    	XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet();
        int rowindex = 0;
        WriteHeader(spreadsheet,new String[]{"Mã phiếu xuất","Mã nhân viên","Tên nhân viên","Ngày xuất","Người nhận","Nội dung"}, rowindex);
        rowindex++;
        for (PhieuXuatDTO phieuXuatDTO : dataset) {
            XSSFRow row = spreadsheet.createRow(rowindex);
            WriteDataPhieuXuat(phieuXuatDTO, row);
            rowindex++;
        }
        FileOutputStream fos;
        fos = new FileOutputStream(new File(fileDir+"/phieuxuat.xlsx"));
        workbook.write(fos);
        fos.close();
		
    }

	private ArrayList PhieuXuatdata() throws Exception {
		PhieuXuatBUS px = new PhieuXuatBUS();
        ArrayList<PhieuXuatDTO> data = new ArrayList<>();
        data=px.TaiDSPX();
        return data;
	}
	
	private void WriteDataPhieuXuat(PhieuXuatDTO px,XSSFRow row){
		//{"Mã phiếu xuất","Mã nhân viên","Tên nhân viên","Ngày xuất","Người nhận","Nội dung"}
        Cell cell = row.createCell(0);
        cell.setCellValue(px.getMaPhieuXuat());
        cell = row.createCell(1);
        cell.setCellValue(px.getMaNV());
        cell = row.createCell(2);
        cell.setCellValue(px.getTenNV());
        cell = row.createCell(3);
        cell.setCellValue(px.getNgaylapphieu());
        cell = row.createCell(4);
        cell.setCellValue(px.getNguoinhan());
        cell = row.createCell(5);
        cell.setCellValue(px.getNoidung());
    }
	// Chi tiet Phieu Nhap 
    private void ExportCTPhieuNhap(ArrayList<CTPNDTO> dataset, String fileDir) throws IOException {
    	XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet();
        int rowindex = 0;
        WriteHeader(spreadsheet,new String[]{"Mã phiếu nhập","Mã hàng hoá","Tên hàng hoá","Mã kho","Tên kho","Số lượng","Đơn giá"}, rowindex);
        rowindex++;
        for (CTPNDTO ctpndto : dataset) {
            XSSFRow row = spreadsheet.createRow(rowindex);
            WriteDataCTPhieuNhap(ctpndto, row);
            rowindex++;
        }
        FileOutputStream fos;
        fos = new FileOutputStream(new File(fileDir+"/chitietphieunhap.xlsx"));
        workbook.write(fos);
        fos.close();
		
    }

	private ArrayList CTPhieuNhapdata() throws Exception {
		CTPNBUS ctpnbus = new CTPNBUS();
        ArrayList<CTPNDTO> data = new ArrayList<>();
        data=ctpnbus.docCTPN();
        return data;
	}
	
	private void WriteDataCTPhieuNhap(CTPNDTO ctpn,XSSFRow row){
		//{"Mã phiếu nhập","Mã hàng hoá","Tên hàng hoá","Mã kho","Tên kho","Số lượng","Đơn giá"}
        Cell cell = row.createCell(0);
        cell.setCellValue(ctpn.getMaPhieuNhap());
        cell = row.createCell(1);
        cell.setCellValue(ctpn.getMaHH());
        cell = row.createCell(2);
        cell.setCellValue(ctpn.getTenHH());
        cell = row.createCell(3);
        cell.setCellValue(ctpn.getMaKho());
        cell = row.createCell(4);
        cell.setCellValue(ctpn.getTenKho());
        cell = row.createCell(5);
        cell.setCellValue(ctpn.getSoluong());
        cell = row.createCell(5);
        cell.setCellValue(ctpn.getDongia());
    }

	private ArrayList Khodata() throws Exception{
        KhoBUS kho = new KhoBUS();
        ArrayList<KhoDTO> data = new ArrayList<>();
        data=kho.TaiDSKho();
        return data;
    }
    private ArrayList HangHoadata() throws Exception{
        HangHoaBUS hanghoa = new HangHoaBUS();
        ArrayList<HangHoaDTO> data = new ArrayList<>();
        data=hanghoa.TaiDSHangHoa();
        return data;
    }
    
    private void ExportKho(ArrayList<KhoDTO> dataset,String fileDir) throws FileNotFoundException, IOException{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet();
        int rowindex = 0;
        WriteHeader(spreadsheet,new String[]{"Mã Kho","Tên Kho","Địa chỉ","Số điện thoại","Nội dung"}, rowindex);
        rowindex++;
        for (KhoDTO khoDTO : dataset) {
            XSSFRow row = spreadsheet.createRow(rowindex);
            WriteDataKho(khoDTO, row);
            rowindex++;
        }
        FileOutputStream fos;
        fos = new FileOutputStream(new File(fileDir+"/kho.xlsx"));
        workbook.write(fos);
        fos.close();
    }
    private void ExportHangHoa(ArrayList<HangHoaDTO> dataset,String fileDir) throws FileNotFoundException, IOException{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet();
        int rowindex = 0;
        WriteHeader(spreadsheet,new String[]{"Mã Hàng Hoá","Ma nhóm","Tên hàng hoá","Số lượng","Đơn vị tính"}, rowindex);
        rowindex++;
        for (HangHoaDTO HangHoaDTO : dataset) {
            XSSFRow row = spreadsheet.createRow(rowindex);
            WriteDataHH(HangHoaDTO, row);
            rowindex++;
        }
        FileOutputStream fos;
        fos = new FileOutputStream(new File(fileDir+"/hanghoa.xlsx"));
        workbook.write(fos);
        fos.close();
    }
    
    
    private void WriteHeader(Sheet sheet,String[] header,int rowindex){
        CellStyle cellstyle = createCellStyleForHeader(sheet);
        XSSFRow row = (XSSFRow) sheet.createRow(rowindex);
        int ColumnIndex = 0;
        for (int i = 0; i < header.length; i++) {
            Cell cell = row.createCell(ColumnIndex++);
            cell.setCellStyle(cellstyle);
            cell.setCellValue(header[i]);
        }
    }
    
    private void WriteDataKho(KhoDTO kho,XSSFRow row){
        Cell cell = row.createCell(0);
        cell.setCellValue(kho.getMakho());
        cell = row.createCell(1);
        cell.setCellValue(kho.getTenkho());
        cell = row.createCell(2);
        cell.setCellValue(kho.getDiachi());
        cell = row.createCell(3);
        cell.setCellValue(kho.getSodienthoai());
        cell = row.createCell(4);
        cell.setCellValue(kho.getNoidung());
    }
    private void WriteDataHH(HangHoaDTO HangHoa,XSSFRow row){
        Cell cell = row.createCell(0);
        cell.setCellValue(HangHoa.getMaHH());
        cell = row.createCell(1);
        cell.setCellValue(HangHoa.getMaNhom());
        cell = row.createCell(2);
        cell.setCellValue(HangHoa.getTenHH());
        cell = row.createCell(3);
        cell.setCellValue(HangHoa.getSoluong());
        cell = row.createCell(4);
        cell.setCellValue(HangHoa.getDonvitinh());
    }
  
    
    private CellStyle createCellStyleForHeader(Sheet sheet){
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman"); 
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
    
}
