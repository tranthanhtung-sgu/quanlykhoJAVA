/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykho;

import BusPacket.ThongKeBUS;
import java.awt.Frame;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 *
 * @author asus
 */
public class ThongKe extends javax.swing.JFrame {

    /**
     * Creates new form ThongKe
     */
    public ThongKe() {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        rbtnTheoQuy.setEnabled(false);
        rbtnTheoNgay.setEnabled(false);
        cbboxQuy.setEnabled(false);
        jdcNgayBatDau.setEnabled(false);
        jdcNgayKetThuc.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupLoaiThongKe = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbboxKieuThongKe = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        jbtnIn = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rbtnTheoQuy = new javax.swing.JRadioButton();
        rbtnTheoNgay = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbboxQuy = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JButton();
        jdcNgayBatDau = new com.toedter.calendar.JDateChooser();
        jdcNgayKetThuc = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thống Kê");

        jLabel1.setText("Thống kê theo");

        cbboxKieuThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hàng Hóa", "Nhập/Xuất" }));
        cbboxKieuThongKe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbboxKieuThongKeItemStateChanged(evt);
            }
        });

        jScrollPane1.setViewportView(tblThongKe);

        jbtnIn.setText("In thống kê");
        jbtnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnInActionPerformed(evt);
            }
        });

        jbtnExit.setText("Đóng");
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });

        jLabel2.setText("Kiểu thống kê");

        btnGroupLoaiThongKe.add(rbtnTheoQuy);
        rbtnTheoQuy.setText("Theo quý");
        rbtnTheoQuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTheoQuyActionPerformed(evt);
            }
        });

        btnGroupLoaiThongKe.add(rbtnTheoNgay);
        rbtnTheoNgay.setText("Theo ngày");
        rbtnTheoNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTheoNgayActionPerformed(evt);
            }
        });

        jLabel3.setText("Đến ngày");

        jLabel4.setText("Từ ngày");

        cbboxQuy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quý 1", "Quý 2", "Quý 3", "Quý 4" }));

        jLabel5.setText("Quý");

        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        jdcNgayBatDau.setDateFormatString("yyyy-MM-dd");

        jdcNgayKetThuc.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jbtnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbboxKieuThongKe, 0, 120, Short.MAX_VALUE)
                    .addComponent(cbboxQuy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnTheoQuy)
                    .addComponent(jdcNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(rbtnTheoNgay)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThongKe)))
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbboxKieuThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnTheoQuy)
                    .addComponent(rbtnTheoNgay))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbboxQuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnThongKe))
                            .addComponent(jdcNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jdcNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnIn)
                    .addComponent(jbtnExit))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbboxKieuThongKeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbboxKieuThongKeItemStateChanged
        // TODO add your handling code here:
        if(cbboxKieuThongKe.getSelectedItem().equals("Hàng Hóa")){
            rbtnTheoQuy.setEnabled(false);
            rbtnTheoNgay.setEnabled(false);
            cbboxQuy.setEnabled(false);
            jdcNgayBatDau.setEnabled(false);
            jdcNgayKetThuc.setEnabled(false);
        }
        else{
            rbtnTheoQuy.setEnabled(true);
            rbtnTheoNgay.setEnabled(true);
        }
    }//GEN-LAST:event_cbboxKieuThongKeItemStateChanged

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        if(cbboxKieuThongKe.getSelectedItem().equals("Hàng Hóa")){
            ThongKeHangHoa();
        }
        else if( cbboxKieuThongKe.getSelectedItem().equals("Nhập/Xuất")){
            if(rbtnTheoQuy.isSelected()){
                String quy = (String) cbboxQuy.getSelectedItem();
                try {
                    ThongKeTheoQuy(quy);
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                LocalDate NgayBatDau = LocalDate.parse(((JTextField)jdcNgayBatDau.getDateEditor().getUiComponent()).getText()) ;
                LocalDate NgayKetThuc = LocalDate.parse(((JTextField)jdcNgayKetThuc.getDateEditor().getUiComponent()).getText()) ;
                if(NgayBatDau.compareTo(NgayKetThuc)>0||NgayBatDau.compareTo(NgayKetThuc)==0){
                    CustomMessage.ErrorPanel("Ngày kết thúc phải lớn hơn ngày bắt đầu");
                }
                else{
                    try {
                        ThongKeTheoNgay(NgayBatDau, NgayKetThuc);
                    } catch (SQLException ex) {
                        Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void rbtnTheoQuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTheoQuyActionPerformed
        // TODO add your handling code here:
        cbboxQuy.setEnabled(true);
        jdcNgayBatDau.setEnabled(false);
        jdcNgayKetThuc.setEnabled(false);
    }//GEN-LAST:event_rbtnTheoQuyActionPerformed

    private void rbtnTheoNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTheoNgayActionPerformed
        // TODO add your handling code here:
        cbboxQuy.setEnabled(false);
        jdcNgayBatDau.setEnabled(true);
        jdcNgayKetThuc.setEnabled(true);
    }//GEN-LAST:event_rbtnTheoNgayActionPerformed

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void jbtnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Chọn thư mục chưa tệp xuất");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.showSaveDialog(new Frame());
        Path filePath = jfc.getSelectedFile().toPath();
        ThongKeBUS bus = new ThongKeBUS();
        String type = cbboxKieuThongKe.getSelectedItem().toString();
        DefaultTableModel tblModel = (DefaultTableModel) tblThongKe.getModel();
        bus.XuatPDF(filePath.toString(), type, tblModel);
        this.dispose();
    }//GEN-LAST:event_jbtnInActionPerformed

    private void ThongKeHangHoa(){
        ThongKeBUS bus = new ThongKeBUS();
        HashMap data = null;
            try {
                data = bus.ThongKeHangHoa();
            } catch (SQLException ex) {
                Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
            Vector header = new Vector();
            header.add("Tên hàng hóa");
            header.add("Số lượng");
            DefaultTableModel model = new DefaultTableModel(header,0){
                @Override
                public boolean isCellEditable(int row,int column){
                    return false;
                }
            };
            for (Object key : data.keySet()) {
                Vector row = new Vector();
                row.add(key);
                row.add(data.get(key));
                model.addRow(row);
            }
            tblThongKe.setModel(model);
    }
    
    private void ThongKeTheoQuy(String Quy) throws SQLException{
        LocalDate ThangBatDau = LocalDate.now();
        LocalDate ThangKetThuc = LocalDate.now();
        switch (Quy){
            case "Quý 1" : {
                ThangBatDau = LocalDate.of(LocalDateTime.now().getYear(),1,1) ;
                ThangKetThuc = LocalDate.of(LocalDateTime.now().getYear(),3,31);
                break;
            }
            case "Quý 2" :{
                ThangBatDau = LocalDate.of(LocalDateTime.now().getYear(),4,1) ;
                ThangKetThuc = LocalDate.of(LocalDateTime.now().getYear(),6,30) ;
                break;
            }
            case "Quý 3" :{
                ThangBatDau = LocalDate.of(LocalDateTime.now().getYear(),7,1) ;
                ThangKetThuc = LocalDate.of(LocalDateTime.now().getYear(),9,30) ;
                break;
            }
            case "Quý 4" :{
                ThangBatDau = LocalDate.of(LocalDateTime.now().getYear(),10,1) ;
                ThangKetThuc = LocalDate.of(LocalDateTime.now().getYear(),12,31) ;
                break;
            }
        }
        
        ThongKeBUS bus = new ThongKeBUS();
        ArrayList<String[]> data = bus.ThongKeTheoQuy(ThangBatDau, ThangKetThuc);
        Vector header = new Vector();
        header.add("Nhập/Xuất");
        header.add("Số lượng");
        header.add("tổng tiền");
        DefaultTableModel model = new DefaultTableModel(header,0){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        for (String[] value : data) {
            Vector row = new Vector();
            row.add(value[0]);
            row.add(value[1]);
            row.add(value[2]);
            model.addRow(row);
        }
        tblThongKe.setModel(model);
    }
    
    private void ThongKeTheoNgay(LocalDate NgayBatDau,LocalDate NgayKetThuc) throws SQLException{
        ThongKeBUS bus = new ThongKeBUS();
        ArrayList<String[]> data = bus.ThongKeTheoNgay(NgayBatDau, NgayKetThuc);
        Vector header = new Vector();
        header.add("Nhập/Xuất");
        header.add("Số lượng");
        header.add("tổng tiền");
        DefaultTableModel model = new DefaultTableModel(header,0){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        for (String[] value : data) {
            Vector row = new Vector();
            row.add(value[0]);
            row.add(value[1]);
            row.add(value[2]);
            model.addRow(row);
        }
        tblThongKe.setModel(model);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupLoaiThongKe;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JComboBox<String> cbboxKieuThongKe;
    private javax.swing.JComboBox<String> cbboxQuy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnIn;
    private com.toedter.calendar.JDateChooser jdcNgayBatDau;
    private com.toedter.calendar.JDateChooser jdcNgayKetThuc;
    private javax.swing.JRadioButton rbtnTheoNgay;
    private javax.swing.JRadioButton rbtnTheoQuy;
    private javax.swing.JTable tblThongKe;
    // End of variables declaration//GEN-END:variables
}
