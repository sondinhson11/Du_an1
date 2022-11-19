/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.Date;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhuyenMai;
import service.KhuyenMaiService;
import service.impl.KhuyenMaiServiceImpl;

/**
 *
 * @author thean
 */
public class KhuyenMaiViews extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel defaultComboBoxModel;
    private KhuyenMaiService kmsv = new KhuyenMaiServiceImpl();

    /**
     * Creates new form KhuyenMaiView
     */
    public KhuyenMaiViews() {
        initComponents();
        LoadTable();
        txt_makm.disable();
        loadCB();
    }

    void LoadTable() {
        defaultTableModel = (DefaultTableModel) this.tb_bang.getModel();
        defaultTableModel.setRowCount(0);
        for (KhuyenMai khuyenMai : kmsv.getListKM()) {
            defaultTableModel.addRow(new Object[]{
                khuyenMai.getMaKM(),
                khuyenMai.getTenKM(),
                khuyenMai.getNgayBD(),
                khuyenMai.getNgayKT(),
                khuyenMai.getGiamGia(),
                khuyenMai.getNgayTao(),
                khuyenMai.getNgaySua(),
                khuyenMai.getTrangThai() == 1 ? "Còn" : "Hết"
            });

        }
    }

    private void loadCB() {
        defaultComboBoxModel = (DefaultComboBoxModel) cbx_trangthai.getModel();
        ArrayList<String> list = new ArrayList<>();
        list.add("Còn");
        list.add("hết");
        for (String string : list) {
            defaultComboBoxModel.addElement(string);
        }

    }

    private int TrangThai() {
        if (cbx_trangthai.getSelectedItem() == "Còn") {
            return 1;
        } else {
            return 0;
        }
    }

    private KhuyenMai getData() {

        String tenkm = txt_tenkm.getText().trim();
        String ngaybd = txt_ngaybd.getText().trim();
        String ngaykt = txt_ngaykt.getText().trim();
        Date ngayBD = (Date.valueOf(ngaybd));
        Date ngayKT = (Date.valueOf(ngaykt));
        String giamgia = txt_giamgia.getText().trim();
        Float giamgia2 = Float.valueOf(giamgia);
        String ngaytao = txt_ngaytao.getText().trim();
        String ngaysua = txt_ngaysua.getText().trim();
        Date ngayTao = (Date.valueOf(ngaytao));
        Date ngaySua = (Date.valueOf(java.time.LocalDate.now()));
        int trangthai = TrangThai();
        if (tenkm.length() == 0 || ngaybd.length() == 0 || ngaykt.length() == 0 || giamgia.length() == 0 || ngaytao.length() == 0 || ngaysua.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống");
            return null;
        }
        KhuyenMai km = new KhuyenMai(null, tenkm, ngayBD, ngayKT, giamgia2, ngayTao, ngaySua, trangthai);
        return km;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_bang = new javax.swing.JTable();
        txt_tenkm = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_ngaybd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_ngaykt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_giamgia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_ngaytao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_ngaysua = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbx_trangthai = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        txt_makm = new javax.swing.JTextField();

        tb_bang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã KM", "Tên KM", "Ngày BĐ", "Ngày KT", "Giảm Giá", "Ngày Tạo", "Ngày Sửa", "Trạng Thái"
            }
        ));
        tb_bang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_bang);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Khuyến Mãi");

        jLabel2.setText("Mã KM");

        jLabel3.setText("Tên KM");

        jLabel4.setText("Ngày BĐ");

        jLabel5.setText("Ngày KT");

        jLabel6.setText("Giảm Giá");

        jLabel7.setText("Ngày Tạo");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel8.setText("Ngày Sửa");

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel9.setText("Trạng Thái");

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_makm, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_tenkm)
                                        .addComponent(txt_ngaybd)
                                        .addComponent(txt_ngaykt, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(112, 112, 112)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel9))))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_ngaytao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_giamgia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ngaysua, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbx_trangthai, 0, 237, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)
                            .addComponent(btnThem))
                        .addGap(1, 1, 1)))
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ngaysua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua))
                        .addGap(18, 18, 18)
                        .addComponent(cbx_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txt_makm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(txt_giamgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThem))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_tenkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnXoa))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_ngaybd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_ngaykt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_bangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangMouseClicked
        // TODO add your handling code here:
        int row = tb_bang.getSelectedRow();
        txt_makm.setText(tb_bang.getValueAt(row, 0).toString());
        txt_tenkm.setText(tb_bang.getValueAt(row, 1).toString());
        txt_ngaybd.setText(tb_bang.getValueAt(row, 2).toString());
        txt_ngaykt.setText(tb_bang.getValueAt(row, 3).toString());
        txt_giamgia.setText(tb_bang.getValueAt(row, 4).toString());
        txt_ngaytao.setText(tb_bang.getValueAt(row, 5).toString());
        txt_ngaysua.setText(tb_bang.getValueAt(row, 6).toString());
        cbx_trangthai.setSelectedItem(tb_bang.getValueAt(row, 7).toString());
    }//GEN-LAST:event_tb_bangMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        JOptionPane.showMessageDialog(this, kmsv.add(getData()));
        LoadTable();        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = tb_bang.getSelectedRow();
        KhuyenMai km = getData();
        if (km == null) {
            return;
        }
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dữ liệu");
            return;
        }
        String id = tb_bang.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        String traLoi = kmsv.update(km, ID);
        JOptionPane.showMessageDialog(this, traLoi);
        LoadTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tb_bang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dữ liệu");
            return;
        }
        String id = tb_bang.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        String traLoi = kmsv.delete(ID);
        JOptionPane.showMessageDialog(this, traLoi);
        LoadTable();
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbx_trangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_bang;
    private javax.swing.JTextField txt_giamgia;
    private javax.swing.JTextField txt_makm;
    private javax.swing.JTextField txt_ngaybd;
    private javax.swing.JTextField txt_ngaykt;
    private javax.swing.JTextField txt_ngaysua;
    private javax.swing.JTextField txt_ngaytao;
    private javax.swing.JTextField txt_tenkm;
    // End of variables declaration//GEN-END:variables
}
