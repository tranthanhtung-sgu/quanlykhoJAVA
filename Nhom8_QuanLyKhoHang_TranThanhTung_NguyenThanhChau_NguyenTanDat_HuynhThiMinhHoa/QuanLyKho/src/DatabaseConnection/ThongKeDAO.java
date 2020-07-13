/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;
import java.sql.*;
import java.time.LocalDate;
/**
 *
 * @author asus
 */
public class ThongKeDAO {
    public MySQLConnection connect;

    public ThongKeDAO() {
        this.connect = new MySQLConnection("localhost", "root", "", "qlkho");
    }
    
    public ResultSet ThongKeHangHoa(){
        StringBuilder sqlqry = new StringBuilder();
        sqlqry.append("(SELECT 'Tổng lượng hàng hóa' as TenHH, sum(TongSoLuong) TongSoLuong FROM danhmuchanghoa)"
                + " UNION "
                + "(SELECT TenHH,TongSoLuong FROM danhmuchanghoa)");
        ResultSet rs;
        rs = this.connect.executeQuery(sqlqry.toString());
        return rs;
    }
    
    public ResultSet ThongKeTheoQuy(LocalDate ThangBatDau, LocalDate ThangKetThuc){
        StringBuilder sqlqry = new StringBuilder();
        sqlqry.append("(select 'Nhập' as `Nhập/Xuất`, sum(ctpn.Soluong) as `Số lượng`,sum(ctpn.Dongia) as `Tổng tiền`" +
                        " from ctpn join phieunhap on ctpn.MaPhieuNhap=phieunhap.MaPhieuNhap" +
                        " WHERE phieunhap.NgayNhap BETWEEN '"+ThangBatDau+"' and '"+ThangKetThuc+"' )" +
                        "UNION" +
                        "(SELECT 'Xuất' as `Nhập/Xuất` , SUM(chitietphieuxuat.Soluong) as `Số lượng`,SUM(chitietphieuxuat.Dongia) AS `Tổng tiền` from chitietphieuxuat join phieuxuat on chitietphieuxuat.MaPhieuXuat=phieuxuat.MaPhieuXuat" +
                        " WHERE phieuxuat.NgayXuat BETWEEN '"+ThangBatDau+"' and '"+ThangKetThuc+"' )" +
                        "UNION" +
                        "(SELECT 'Tổng cộng' as `Nhập/Xuất`, SUM(Soluong) as `Số lượng`, SUM(Dongia) as `Tổng tiền` FROM " +
                        " (SELECT Soluong,Dongia " +
                        "  FROM ctpn join phieunhap on ctpn.MaPhieuNhap=phieunhap.MaPhieuNhap" +
                        "  WHERE phieunhap.NgayNhap BETWEEN '"+ThangBatDau+"' and '"+ThangKetThuc+"'" +
                        "  UNION ALL" +
                        "  SELECT Soluong,Dongia" +
                        "  FROM chitietphieuxuat JOIN phieuxuat on chitietphieuxuat.MaPhieuXuat=phieuxuat.MaPhieuXuat" +
                        "  WHERE phieuxuat.NgayXuat BETWEEN '"+ThangBatDau+"' and '"+ThangKetThuc+"'" +
                        " ) as total" +
                        " )");
        ResultSet rs = null;
        rs = this.connect.executeQuery(sqlqry.toString());
        return rs;
    }
    
    public ResultSet ThongKetTheoNgay(LocalDate NgayBatDau,LocalDate NgayKetThuc){
        StringBuilder sqlqry = new StringBuilder();
        sqlqry.append("(select 'Nhập' as `Nhập/Xuất`, sum(ctpn.Soluong) as `Số lượng`,sum(ctpn.Dongia) as `Tổng tiền`" +
                        " from ctpn join phieunhap on ctpn.MaPhieuNhap=phieunhap.MaPhieuNhap" +
                        " WHERE phieunhap.NgayNhap BETWEEN '"+NgayBatDau+"' and '"+NgayKetThuc+"' )" +
                        "UNION" +
                        "(SELECT 'Xuất' as `Nhập/Xuất` , SUM(chitietphieuxuat.Soluong) as `Số lượng`,SUM(chitietphieuxuat.Dongia) AS `Tổng tiền` from chitietphieuxuat join phieuxuat on chitietphieuxuat.MaPhieuXuat=phieuxuat.MaPhieuXuat" +
                        " WHERE phieuxuat.NgayXuat BETWEEN '"+NgayBatDau+"' and '"+NgayKetThuc+"' )" +
                        "UNION" +
                        "(SELECT 'Tổng cộng' as `Nhập/Xuất`, SUM(Soluong) as `Số lượng`, SUM(Dongia) as `Tổng tiền` FROM " +
                        " (SELECT Soluong,Dongia " +
                        "  FROM ctpn join phieunhap on ctpn.MaPhieuNhap=phieunhap.MaPhieuNhap" +
                        "  WHERE phieunhap.NgayNhap BETWEEN '"+NgayBatDau+"' and '"+NgayKetThuc+"'" +
                        "  UNION ALL" +
                        "  SELECT Soluong,Dongia" +
                        "  FROM chitietphieuxuat JOIN phieuxuat on chitietphieuxuat.MaPhieuXuat=phieuxuat.MaPhieuXuat" +
                        "  WHERE phieuxuat.NgayXuat BETWEEN '"+NgayBatDau+"' and '"+NgayKetThuc+"'" +
                        " ) as total" +
                        " )");
        ResultSet rs = null;
        rs = this.connect.executeQuery(sqlqry.toString());
        return rs;
    }
}
