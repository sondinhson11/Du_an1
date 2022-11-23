/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import service.KhachHangService;
import service.impl.KhachHangImpl;

public class KhachHangViews extends javax.swing.JInternalFrame {

    private KhachHangService khs = new KhachHangImpl();
    private DefaultTableModel defaultTableModel;

    public KhachHangViews() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        txtNgayTao.setText(java.time.LocalDate.now().toString());
        this.clear();
        this.loadTable();
    }

    private void clear() {
        this.txtMa.setText("");
        this.txtTen.setText("");
        this.txtNgaySinh.setText("YYYY-MM-DD");
        this.txtDiaChi.setText("");
        this.txtSoDienThoai.setText("");
        this.txtNgayTao.setText(java.time.LocalDate.now().toString());
        this.txtNgaySua.setText("");
        this.cbbGioiTinh.setSelectedIndex(0);
        this.cbbTrangThai.setSelectedIndex(0);
    }

    private void loadTable() {
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (KhachHang kh : khs.getListKH()) {
            defaultTableModel.addRow(new Object[]{
                kh.getMa(), kh.getTen(), kh.getNgaySinh(), kh.getGioiTinh() == 1 ? "Nam" : "Nữ",
                kh.getDiaChi(), kh.getSoDienThoai(), kh.getNgayTao(), kh.getNgaySua(),
                kh.getTrangThai() == 1 ? "Có" : "Không"
            });
        }
    }

    private int tt() {
        if (cbbTrangThai.getSelectedItem() == "Có") {
            return 1;
        } else {
            return 0;
        }
    }

    private int gt() {
        if (cbbGioiTinh.getSelectedItem() == "Nam") {
            return 1;
        } else {
            return 0;
        }
    }

    private KhachHang getForm() {
        String ten = this.txtTen.getText().trim();
        String ns = this.txtNgaySinh.getText().trim();
        String diaChi = this.txtDiaChi.getText().trim();
        String soDienThoai = this.txtSoDienThoai.getText().trim();
        int gioiTinh = gt();
        String nT = this.txtNgayTao.getText().trim();
        Date ngayTao = (Date.valueOf(nT));
        Date ngaySua = (Date.valueOf(java.time.LocalDate.now()));
        Date ngaySinh = null;
        if (ten.length() == 0 || ns.length() == 0 || diaChi.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập 1 số trường");
            return null;
        }
        if (soDienThoai.length() != 10) {
            JOptionPane.showMessageDialog(this, "Số Điện thoại phải là 10 số");
            return null;
        }
        try {
            ngaySinh = Date.valueOf(ns);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh sai định dạng */ YYYY-MM-DD /*");
            return null;
        }
        int trangThai = tt();
        return new KhachHang(0, ten, ngaySinh, gioiTinh, soDienThoai, diaChi, ngayTao, ngaySua, trangThai);
    }
    public int maKH(){
        return Integer.parseInt(this.lblKH.getText());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        cbbGioiTinh = new javax.swing.JComboBox<>();
        txtNgayTao = new javax.swing.JTextField();
        txtNgaySua = new javax.swing.JTextField();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnChon = new javax.swing.JButton();
        lblKH = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1305, 820));

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Số Điện Thoại", "Ngày Tạo", "Ngày Sửa", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setText("Quản Lý Khách Hàng ");

        cbbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        txtNgayTao.setEditable(false);

        txtNgaySua.setEditable(false);

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Có", "Không" }));

        jLabel12.setText("Trạng Thái :");

        jLabel13.setText("Ngày Sửa :");

        jLabel14.setText("Ngày Tạo :");

        jLabel15.setText("Giới Tính :");

        jLabel16.setText("Số Điện Thoại :");

        txtMa.setEditable(false);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel17.setText("Địa Chỉ :");

        jLabel18.setText("Ngày Sinh :");

        jLabel19.setText("Tên :");

        jLabel20.setText("Mã :");

        btnChon.setText("Chon");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        lblKH.setText("Khách Hàng Bạn Chọn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(210, 210, 210))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNgaySinh)
                                    .addComponent(txtMa)
                                    .addComponent(txtTen)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(41, 41, 41)
                                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNgaySua)
                                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoDienThoai)
                                    .addComponent(cbbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKH)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnChon)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cbbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lblKH)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int row = this.tblKhachHang.getSelectedRow();
        if (row == -1) {
            return;
        }
        this.txtMa.setText(this.tblKhachHang.getValueAt(row, 0).toString());
        this.txtTen.setText(this.tblKhachHang.getValueAt(row, 1).toString());
        this.txtNgaySinh.setText(this.tblKhachHang.getValueAt(row, 2).toString());
        this.txtDiaChi.setText(this.tblKhachHang.getValueAt(row, 4).toString());
        this.cbbGioiTinh.setSelectedItem(this.tblKhachHang.getValueAt(row, 3).toString());
        this.txtSoDienThoai.setText(this.tblKhachHang.getValueAt(row, 5).toString());
        this.txtNgayTao.setText(this.tblKhachHang.getValueAt(row, 6).toString());
        this.txtNgaySua.setText(this.tblKhachHang.getValueAt(row, 7).toString());
        this.cbbTrangThai.setSelectedItem(this.tblKhachHang.getValueAt(row, 8).toString());
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tblKhachHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dữ Liệu");
            return;
        }
        String id = tblKhachHang.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        JOptionPane.showMessageDialog(this, khs.delete(ID));
        loadTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = tblKhachHang.getSelectedRow();

        KhachHang kh = getForm();
        if (kh == null) {
            return;
        }
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dữ liệu");
            return;
        }
        String id = tblKhachHang.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        JOptionPane.showMessageDialog(this, khs.update(getForm(), ID));
        loadTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        KhachHang kh = getForm();
        if (kh == null) {
            return;
        }
        String traLoi = khs.add(kh);
        JOptionPane.showMessageDialog(this, traLoi);
        loadTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        int row = this.tblKhachHang.getSelectedRow();
        String maS = this.tblKhachHang.getValueAt(row, 0).toString();
        this.lblKH.setText(maS);
    }//GEN-LAST:event_btnChonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbGioiTinh;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKH;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNgaySua;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
