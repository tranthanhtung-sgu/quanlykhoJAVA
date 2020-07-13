/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykho;

import DTOPacket.KhoDTO;
import BusPacket.ExportFile;
import BusPacket.KhoHHBUS;
import BusPacket.FileTypeFilter;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author asus
 */
public class CustomMessage {
    private static JFrame frame;

    public CustomMessage() {
    }
    
    public static void ErrorPanel(String message){
        JOptionPane.showMessageDialog(frame, message);
    }
    
    public String[] AdvancedSearchKho() throws Exception{
        String[] kho= new String[6];
        JPanel mainPane = new JPanel();
        mainPane.setLayout(new FlowLayout());
        JLabel lblMakho = new JLabel("Tìm theo Mã kho :");
        JTextField txtMakho = new JTextField(15);
        JLabel lblTenkho = new JLabel("Tìm theo Tên kho :");
        JTextField txtTenkho = new JTextField(15);
        JLabel lblDiachi = new JLabel("Tìm theo Địa chỉ :");
        JTextField txtDiachi = new JTextField(15);
        JLabel lblSodt = new JLabel("Tìm theo Số điện thoại: ");
        JTextField txtSodt = new JTextField(15);
        JLabel lblHHdangco = new JLabel("Hàng hóa đang có :");
        ArrayList listHH = new KhoHHBUS().TenHHtrongkho();
        JComboBox listHHdangco = new JComboBox();
        listHHdangco.addItem("");
        for (Object object : listHH) {
            listHHdangco.addItem(object);
        }
        JLabel lblHHkhongco = new JLabel("Hàng hóa không có: ");
        JComboBox listHHkhongco = new JComboBox();
        listHHkhongco.addItem("");
        for (Object object : listHH) {
            listHHkhongco.addItem(object);
        }
        mainPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPane.setPreferredSize(new Dimension(200,400));
        mainPane.add(lblMakho);
        mainPane.add(txtMakho);
        mainPane.add(lblTenkho);
        mainPane.add(txtTenkho);
        mainPane.add(lblDiachi);
        mainPane.add(txtDiachi);
        mainPane.add(lblSodt);
        mainPane.add(txtSodt);
        mainPane.add(lblHHdangco);
        mainPane.add(listHHdangco);
        mainPane.add(lblHHkhongco);
        mainPane.add(listHHkhongco);
        String[] options = new String[2];
        options[0] = new String("Tìm kiếm");
        options[1] = new String("Hủy bỏ");
        int result = JOptionPane.showOptionDialog(frame,mainPane,
                "Tìm kiếm kho nâng cao",
                0,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                null);
        if(result==JOptionPane.YES_OPTION){
            kho[0]=txtMakho.getText();
            kho[1]=txtTenkho.getText();
            kho[2]=txtDiachi.getText();
            kho[3]=txtSodt.getText();
            kho[4]=(String)listHHdangco.getSelectedItem();
            kho[5]=(String)listHHkhongco.getSelectedItem();
        }
        return kho;
    }
    public void ExportData(){
        frame = new JFrame("Export dữ liệu");
        JPanel mainPane = new JPanel(new BorderLayout());
        JPanel startPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel endPane = new JPanel(new FlowLayout());
        JLabel dulieuXuat = new JLabel("Chọn bảng dữ liệu: ");
        JComboBox loai = new JComboBox();
        loai.addItem("Kho");
        loai.addItem("Hàng hóa");
        loai.addItem("Kho hàng hóa");
        loai.addItem("Phiếu nhập");
        loai.addItem("Phiếu xuất");
        loai.addItem("Chi tiết phiếu nhập");
        loai.addItem("Chi tiết phiếu xuất");
        loai.addItem("Nhà cung cấp");
        loai.addItem("Nhân viên");
        JLabel lblDir = new JLabel("Thư mục: ");
        JTextField txtDir = new JTextField(20);
        JButton btnOK = new JButton("Đồng ý");
        JButton btnCancel = new JButton("Thoát");
        JButton btnPick = new JButton("...");
        startPane.add(dulieuXuat,BorderLayout.PAGE_START);
        startPane.add(loai,BorderLayout.PAGE_START);
        centerPane.add(lblDir);
        centerPane.add(txtDir);
        centerPane.add(btnPick);
        endPane.add(btnOK);
        endPane.add(btnCancel);
        mainPane.add(startPane,BorderLayout.PAGE_START);
        mainPane.add(centerPane,BorderLayout.CENTER);
        mainPane.add(endPane,BorderLayout.PAGE_END);
        frame.add(mainPane);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        btnCancel.addActionListener( (e) -> {
            frame.dispose();
        });
        btnPick.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Chọn thư mục chứa tệp xuất");
                jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                jfc.showSaveDialog(new JFrame());
                Path fileDir=jfc.getSelectedFile().toPath();
                txtDir.setText(fileDir.toString());
            }
        });
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExportFile IEfile = new ExportFile();
                try {
                    IEfile.Export((String)loai.getSelectedItem(), txtDir.getText());
                } catch (Exception ex) {
                    Logger.getLogger(CustomMessage.class.getName()).log(Level.SEVERE, null, ex);
                }
                frame.dispose();
            }
        });
    }
}
