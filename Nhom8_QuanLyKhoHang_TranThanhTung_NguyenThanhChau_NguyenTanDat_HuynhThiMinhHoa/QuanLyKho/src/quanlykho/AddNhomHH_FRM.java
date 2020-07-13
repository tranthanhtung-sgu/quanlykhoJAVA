package quanlykho;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BusPacket.HangHoaBUS;
import DTOPacket.DSNhom;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddNhomHH_FRM extends JFrame {

	/**
	 * 
	 */
	HangHoaBUS dsNhom = new HangHoaBUS();
	public AddNhomHH_FRM(Frame parent, boolean modal){
		
	}
	public String getContent(){
	    return txtMaNhom.getText();
	}
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaNhom;
	private JTextField txtTenNhom;
	private DefaultTableModel model;
	private JTable tblNhomHH;
	private JButton btnTaiNhomHH;
	public AddNhomHH_FRM() {
		initGUI();
		btnTaiNhomHH.doClick();
	}
	private void initGUI() {
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblMaNhom = new JLabel("Mã Nhóm :");
		lblMaNhom.setBounds(24, 11, 88, 16);
		desktopPane.add(lblMaNhom);
		
		txtMaNhom = new JTextField();
		txtMaNhom.setBounds(102, 6, 100, 26);
		desktopPane.add(txtMaNhom);
		txtMaNhom.setColumns(10);
		
		JLabel lblTnNhm = new JLabel("Tên Nhóm :");
		lblTnNhm.setBounds(214, 11, 88, 16);
		desktopPane.add(lblTnNhm);
		
		txtTenNhom = new JTextField();
		txtTenNhom.setColumns(10);
		txtTenNhom.setBounds(303, 6, 100, 26);
		desktopPane.add(txtTenNhom);
		
		JButton btnThemNhom = new JButton("Thêm");
		btnThemNhom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMaNhom.getText().isEmpty() && txtTenNhom.getText().isEmpty()) {
					//JOptionPane.showMessageDialog(rootPane, "Phải điền đầy đủ thông tin");
					CustomMessage.ErrorPanel("Phải điền đầy đủ thông tin");
				}else {
					DSNhom nhom = new DSNhom();
					nhom.setMaNhom(txtMaNhom.getText());
					nhom.setTenNhom(txtTenNhom.getText());
					String error = dsNhom.KiemtraTrungLapMaNhom(nhom);
					if(!"".equals(error)){
		                CustomMessage.ErrorPanel(error);
		            }else {
						try {
							dsNhom.ThemNhomHH(nhom);
							dsNhom.TaiDSNhomHH();
							btnTai_DSNhom_Len_Table(e);
							CustomMessage.ErrorPanel("Thêm Thành Công");
							txtMaNhom.setText("");
							txtTenNhom.setText("");
						} catch (SQLException e1) {
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnThemNhom.setBounds(69, 39, 106, 29);
		desktopPane.add(btnThemNhom);
		
		JButton btnHuyThemNhom = new JButton("<-");
		btnHuyThemNhom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNhomHH_FRM.this.setVisible(false);
			}
		});
		btnHuyThemNhom.setBounds(6, 39, 51, 29);
		desktopPane.add(btnHuyThemNhom);
		String[] columnNames = { "Mã nhóm", "Tên nhóm"}; 
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
		tblNhomHH = new JTable(model);
		tblNhomHH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblmouseClickd(e);
			}
		});
		
        JScrollPane scrollPane = new JScrollPane(tblNhomHH);
		scrollPane.setBounds(6, 80, 428, 262);
		desktopPane.add(scrollPane);
		
		JButton btnSuaNhom = new JButton("Sửa");
		btnSuaNhom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSuaNhomHHActionPerformed(e);
			}
		});
		btnSuaNhom.setBounds(185, 39, 106, 29);
		desktopPane.add(btnSuaNhom);
		
		JButton btnXoaNhom = new JButton("Xoá");
		btnXoaNhom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoaNhomHHActionPerformed(e);
			}
		});
		btnXoaNhom.setBounds(303, 39, 106, 29);
		desktopPane.add(btnXoaNhom);
		
		btnTaiNhomHH = new JButton("New button");
		btnTaiNhomHH.setVisible(false);
		btnTaiNhomHH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTai_DSNhom_Len_Table(e);
			}
		});
		btnTaiNhomHH.setBounds(2, 0, 10, 16);
		desktopPane.add(btnTaiNhomHH);
	}
	
	protected void btnXoaNhomHHActionPerformed(ActionEvent e) {
		if (!txtMaNhom.getText().isEmpty()) {
			HangHoaBUS dsNhom = new HangHoaBUS();
			DSNhom nhom = new DSNhom();
			nhom.setMaNhom(txtMaNhom.getText());
			nhom.setTenNhom(txtTenNhom.getText());
			if (dsNhom.KiemtraTontaiNhom(nhom)) {
				try {
					dsNhom.XoaNhomHH(nhom);
					txtMaNhom.setText("");
					txtTenNhom.setText("");
				} catch (Exception e1) {
				}
			} else {
				CustomMessage.ErrorPanel("Kho Không tồn tại");
			}
			this.btnTai_DSNhom_Len_Table(e);
		}
	}
	
	protected void btnSuaNhomHHActionPerformed(ActionEvent e) {
		if (txtMaNhom.getText() != "") {
			HangHoaBUS dsNhom = new HangHoaBUS();
			DSNhom nhom = new DSNhom();
			int index = tblNhomHH.getSelectedRow();
			String MaNhomCu = tblNhomHH.getModel().getValueAt(index, 0).toString();
			nhom.setMaNhom((txtMaNhom.getText()));
			nhom.setTenNhom((txtTenNhom.getText()));

			String error = dsNhom.KiemtraHopleNhom(nhom, MaNhomCu);
			if (error.equals("")) {
				try {
					dsNhom.SuaNhom(nhom);
					this.btnTai_DSNhom_Len_Table(e);
					CustomMessage.ErrorPanel("Sửa thành công");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				CustomMessage.ErrorPanel(error);
			}
		}
	}
	protected void tblmouseClickd(MouseEvent e) {
		int i = tblNhomHH.getSelectedRow();
		txtMaNhom.setText(tblNhomHH.getModel().getValueAt(i, 0).toString());
		txtTenNhom.setText(tblNhomHH.getModel().getValueAt(i, 1).toString());
	}
	private void btnTai_DSNhom_Len_Table(java.awt.event.ActionEvent e) {
		HangHoaBUS dsNhom = new HangHoaBUS();
		try {
			dsNhom.TaiDSNhomHH();
		} catch (Exception ex) {
			Logger.getLogger(KhoFRM.class.getName()).log(Level.SEVERE, null, ex);
		}
		String[] columnNames = { "Mã nhóm", "Tên nhóm"};
		Vector<String> header = new Vector<String>();
		header.add("Mã nhóm");
		header.add("Tên nhóm");
		model = new DefaultTableModel(header, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			/**
			 * 
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for (DSNhom nhom : HangHoaBUS.dsNhom) {
			Vector row = new Vector();
			row.add(nhom.getMaNhom());
			row.add(nhom.getTenNhom()); 
			model.addRow(row);
		}
		tblNhomHH.setModel(model);
	}
}
