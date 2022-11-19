/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.sql.Date;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.ChucVu;
import model.NhanVien;
import service.ChucVuService;
import service.NhanVienServices;
import service.impl.ChucVuServiceImpl;
import service.impl.NhanVienServiceimpl;

/**
 *
 * @author ThisPC
 */
public class NhanVienViews extends javax.swing.JInternalFrame {

    private DefaultComboBoxModel defaultComboBoxModel;
    private DefaultTableModel defaultTableModel;
    private NhanVienServices nvsr = new NhanVienServiceimpl();
    private ChucVuService cvs = new ChucVuServiceImpl();

    public NhanVienViews() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        LoadData();
        cbbChucVu();
        txt_manv.disable();
    }
    ButtonGroup btngGroup = new ButtonGroup();

    void LoadData() {
        defaultTableModel = (DefaultTableModel) tb_NhanVien.getModel();
        defaultTableModel.setRowCount(0);
        for (NhanVien nhanvien : nvsr.getlistNhanVien()) {
            defaultTableModel.addRow(new Object[]{
                nhanvien.getMaNv(), nhanvien.getChucvu(), nhanvien.getTenNv(), nhanvien.getDiaChi(), nhanvien.getGioiTinh() == 1 ? "Nam" : "Nữ",
                nhanvien.getEmail(), nhanvien.getSdt(), nhanvien.getNgaySinh(), nhanvien.getNgayTao(), nhanvien.getNgaySua(),
                nhanvien.getTrangThai() == 1 ? "Đang Làm" : "Nghỉ Làm"
            });
        }
    }

    private int TrangThai() {
        if (cb_Trangthai.getSelectedItem() == "Đang Làm") {
            return 1;
        } else {
            return 0;
        }
    }

    private int Gioitinh() {
        if (cb_gioitinh.getSelectedItem() == "Nam") {
            return 1;
        } else {
            return 0;
        }
    }

    void cbbChucVu() {
        defaultComboBoxModel = (DefaultComboBoxModel) cb_macv.getModel();
        for (ChucVu chucvu : cvs.getListChucVu()) {
            defaultComboBoxModel.addElement(chucvu);
        }
    }

    private NhanVien getData() {
        ChucVu macv = (ChucVu) cb_macv.getSelectedItem();
        String Tenv = (txt_Tennv.getText().trim());
        String diachi = (txt_diachi.getText().trim());
        int gioitinh = Gioitinh();
        String email = (txt_email.getText().trim());
        String sdt = (txt_sdt.getText().trim());
        String ngs = txt_ngaysinh.getText().trim();
        String ngt = txt_NgayTao.getText().trim();
        String ngsua = txt_ngaysua.getText().trim();

        Date ngaySinh = (Date.valueOf(ngs));
        Date ngayTao = (Date.valueOf(ngt));
        Date ngaySua = (Date.valueOf(ngsua));
        int TrangThai = TrangThai();
        JOptionPane.showMessageDialog(this, macv.toString());

        if (Tenv.length() == 0 || diachi.length() == 0 || email.length() == 0 || sdt.length() == 0 || ngs.length() == 0 || ngt.length() == 0 || ngsua.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống dữ liệu");
            return null;
        }

        NhanVien ctsp = new NhanVien();
        ctsp.setChucvu(macv);
        ctsp.setTenNv(Tenv);
        ctsp.setDiaChi(diachi);
        ctsp.setGioiTinh(gioitinh);
        ctsp.setEmail(email);
        ctsp.setSdt(sdt);
        ctsp.setNgaySinh(ngaySinh);
        ctsp.setNgayTao(ngayTao);
        ctsp.setNgaySua(ngaySua);
        ctsp.setTrangThai(TrangThai);

        return ctsp;
    }

    void clear() {
        txt_manv.setText("");
        cb_macv.setSelectedItem("");
        txt_Tennv.setText("");
        txt_diachi.setText("");
        txt_email.setText("");
        cb_gioitinh.setSelectedItem("");
        txt_sdt.setText("");
        txt_ngaysinh.setText("");
        txt_NgayTao.setText("");
        txt_ngaysua.setText("");
        cb_Trangthai.setSelectedItem("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_manv = new javax.swing.JTextField();
        cb_macv = new javax.swing.JComboBox<>();
        txt_diachi = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        txt_ngaysinh = new javax.swing.JTextField();
        txt_NgayTao = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_ngaysua = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Tennv = new javax.swing.JTextField();
        btn_clear1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_Sua1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_them1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn_xoa1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_NhanVien = new javax.swing.JTable();
        cb_Trangthai = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cb_gioitinh = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel11.setText("Ngày Sửa");

        jLabel12.setText("TrangThai");

        txt_diachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_diachiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel2.setText("Mã Nhân Viên");

        btn_clear1.setText("Clear");
        btn_clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clear1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Mã Chức Vụ");

        btn_Sua1.setText("Sửa");
        btn_Sua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Sua1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên Nhân Viên");

        btn_them1.setText("Thêm");
        btn_them1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Địa Chỉ");

        btn_xoa1.setText("Ẩn");
        btn_xoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Giới Tính");

        tb_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Mã CV", "Tên NV", "Địa Chỉ", "Giới Tính", "Email", "Số Điện Thoại", "Ngày Sinh", "Ngày Tạo", "Ngày Sửa", "Trạng Thái"
            }
        ));
        tb_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_NhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_NhanVien);

        cb_Trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Làm", "Nghỉ Làm" }));
        cb_Trangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_TrangthaiActionPerformed(evt);
            }
        });

        jLabel7.setText("Email");

        cb_gioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nu" }));
        cb_gioitinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_gioitinhActionPerformed(evt);
            }
        });

        jLabel8.setText("Số Điện Thoại");

        jLabel9.setText("Ngày Sinh");

        jLabel10.setText("Ngày Tạo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(338, 338, 338)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5))
                                            .addGap(19, 19, 19))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(49, 49, 49)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(67, 67, 67)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_Tennv)
                                        .addComponent(txt_manv)
                                        .addComponent(cb_macv, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_them1)
                                        .addGap(36, 36, 36)
                                        .addComponent(btn_xoa1)
                                        .addGap(40, 40, 40)
                                        .addComponent(btn_Sua1)
                                        .addGap(27, 27, 27)
                                        .addComponent(btn_clear1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel11))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(22, 22, 22)))
                                        .addGap(44, 44, 44)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_ngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                            .addComponent(txt_sdt)
                                            .addComponent(txt_NgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                            .addComponent(txt_ngaysua, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                            .addComponent(cb_Trangthai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(0, 463, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_manv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_macv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_Tennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_NgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_ngaysua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(cb_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cb_Trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them1)
                            .addComponent(btn_xoa1)
                            .addComponent(btn_Sua1)
                            .addComponent(btn_clear1))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_diachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_diachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_diachiActionPerformed

    private void btn_clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clear1ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btn_clear1ActionPerformed

    private void btn_Sua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Sua1ActionPerformed
        // TODO add your handling code here:

        int row = tb_NhanVien.getSelectedRow();

        NhanVien nhanvien = getData();
        if (nhanvien == null) {
            return;
        }
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dữ liệu");
            return;
        }
        String id = tb_NhanVien.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        JOptionPane.showMessageDialog(this, nvsr.Update(getData(), ID));
        LoadData();
    }//GEN-LAST:event_btn_Sua1ActionPerformed

    private void btn_them1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them1ActionPerformed

        JOptionPane.showMessageDialog(this, nvsr.addNhanVien(getData()));
        LoadData();
    }//GEN-LAST:event_btn_them1ActionPerformed

    private void btn_xoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa1ActionPerformed
        int row = tb_NhanVien.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this,"Bạn Chưa Chọn Dữ Liệu");
            return;
        }
        String id = tb_NhanVien.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        JOptionPane.showMessageDialog(this, nvsr.delete(ID));
        LoadData();
    }//GEN-LAST:event_btn_xoa1ActionPerformed

    private void tb_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_NhanVienMouseClicked
        int row = tb_NhanVien.getSelectedRow();
        txt_manv.setText(tb_NhanVien.getValueAt(row, 0).toString());
        cb_macv.setSelectedItem(tb_NhanVien.getValueAt(row, 1).toString());
        txt_Tennv.setText(tb_NhanVien.getValueAt(row, 2).toString());
        txt_diachi.setText(tb_NhanVien.getValueAt(row, 3).toString());
        cb_gioitinh.setSelectedItem(tb_NhanVien.getValueAt(row, 4).toString());
        txt_email.setText(tb_NhanVien.getValueAt(row, 5).toString());
        txt_sdt.setText(tb_NhanVien.getValueAt(row, 6).toString());
        txt_ngaysinh.setText(tb_NhanVien.getValueAt(row, 7).toString());
        txt_NgayTao.setText(tb_NhanVien.getValueAt(row, 8).toString());
        txt_ngaysua.setText(tb_NhanVien.getValueAt(row, 9).toString());
        cb_Trangthai.setSelectedItem(tb_NhanVien.getValueAt(row, 10).toString());
    }//GEN-LAST:event_tb_NhanVienMouseClicked

    private void cb_TrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TrangthaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_TrangthaiActionPerformed

    private void cb_gioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_gioitinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_gioitinhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Sua1;
    private javax.swing.JButton btn_clear1;
    private javax.swing.JButton btn_them1;
    private javax.swing.JButton btn_xoa1;
    private javax.swing.JComboBox<String> cb_Trangthai;
    private javax.swing.JComboBox<String> cb_gioitinh;
    private javax.swing.JComboBox<String> cb_macv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_NhanVien;
    private javax.swing.JTextField txt_NgayTao;
    private javax.swing.JTextField txt_Tennv;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_manv;
    private javax.swing.JTextField txt_ngaysinh;
    private javax.swing.JTextField txt_ngaysua;
    private javax.swing.JTextField txt_sdt;
    // End of variables declaration//GEN-END:variables
}
