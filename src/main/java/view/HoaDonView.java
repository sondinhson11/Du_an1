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
import model.KhachHang;
import model.NhanVien;
import model.HINHTHUCTHANHTOAN;
import model.HoaDon;
import model.KhuyenMai;
import service.KhachHangService;

import service.HTTTServices;
import service.HoaDonService;
import service.KhuyenMaiService;
import service.NhanVienServices;
import service.impl.HTTTServicesImpl;
import service.impl.HoaDonServiceImpl;
import service.impl.KhachHangImpl;
import service.impl.KhuyenMaiServiceImpl;
import service.impl.NhanVienServiceimpl;

/**
 *
 * @author thean
 */
public class HoaDonView extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel defaultComboBoxModel;
    private HoaDonService hdsv = new HoaDonServiceImpl();
    private KhachHangService khsv = new KhachHangImpl();
    private KhuyenMaiService kmsv = new KhuyenMaiServiceImpl();
    private HTTTServices htttsv = new HTTTServicesImpl();
    private NhanVienServices nvsv = new NhanVienServiceimpl();

    /**
     * Creates new form HoaDonView
     */
    public HoaDonView() {
        initComponents();
        cbbMaHTTT();
        cbbMaKH();
        cbbMaNV();
        cbbMaKM();
        LoadTable();
    }

    void cbbMaKH() {
        defaultComboBoxModel = (DefaultComboBoxModel) cbx_makh.getModel();
        for (KhachHang khachHang : khsv.getListKT()) {
            defaultComboBoxModel.addElement(khachHang);
        }
    }

    void cbbMaNV() {
        defaultComboBoxModel = (DefaultComboBoxModel) cbx_manv.getModel();
        for (NhanVien nhanVien : nvsv.getlistNhanVien()) {
            defaultComboBoxModel.addElement(nhanVien);
        }
    }

    void cbbMaHTTT() {
        defaultComboBoxModel = (DefaultComboBoxModel) cbx_mahttt.getModel();
        for (HINHTHUCTHANHTOAN hinhthucthanhtoan : htttsv.getList()) {
            defaultComboBoxModel.addElement(hinhthucthanhtoan);
        }
    }
void cbbMaKM() {
        defaultComboBoxModel = (DefaultComboBoxModel) cbx_makm.getModel();
        for (KhuyenMai khuyenMai : kmsv.getListKM()) {
            defaultComboBoxModel.addElement(khuyenMai);
        }
    }
    void LoadTable() {
        defaultTableModel = (DefaultTableModel) this.tb_bang.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDon hoaDon : hdsv.getAll()) {
            defaultTableModel.addRow(new Object[]{
                hoaDon.getMaHD(),
                hoaDon.getKhachHang(),
                hoaDon.getNhanVien(),
                hoaDon.getHinhthucthanhtoan(),
                hoaDon.getGhiChu(),
                hoaDon.getThanhTien(),
                hoaDon.getNgayTao(),
                hoaDon.getNgaySua(),
                hoaDon.getTrangThai()== 1?"Đã Thanh Toán":"Chưa Thanh Toán"
            });

        }
    }

    private HoaDon getdata() {
        KhachHang maKH = (KhachHang) cbx_makh.getSelectedItem();
        NhanVien maNV = (NhanVien) cbx_manv.getSelectedItem();
        HINHTHUCTHANHTOAN maHTTT = (HINHTHUCTHANHTOAN) cbx_mahttt.getSelectedItem();
        String ghichu = txt_ghichu.getText().trim();
        Integer thanhtien = Integer.valueOf(txt_thanhTien.getText().trim());
        Date ngayTao = (Date.valueOf(txt_ngaytao.getText()));
        Date ngaySua = (Date.valueOf(txt_ngaysua.getText()));
        Integer TrangThai = TrangThai();
        HoaDon hd = new HoaDon();
        hd.setKhachHang(maKH);
        hd.setNhanVien(maNV);
        hd.setHinhthucthanhtoan(maHTTT);
        hd.setGhiChu(ghichu);
        hd.setThanhTien(TOP_ALIGNMENT);
        hd.setNgayTao(ngayTao);
        hd.setNgaySua(ngaySua);
        hd.setTrangThai(TrangThai);
        return hd;

    }


    private int TrangThai() {
        if (cbx_trangthai.getSelectedItem() == "Đã Thanh Toán") {
            return 1;
        } else {
            return 0;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_mahd = new javax.swing.JTextField();
        cbx_makh = new javax.swing.JComboBox<>();
        cbx_manv = new javax.swing.JComboBox<>();
        cbx_mahttt = new javax.swing.JComboBox<>();
        cbx_makm = new javax.swing.JComboBox<>();
        txt_ghichu = new javax.swing.JTextField();
        txt_thanhTien = new javax.swing.JTextField();
        txt_ngaytao = new javax.swing.JTextField();
        txt_ngaysua = new javax.swing.JTextField();
        cbx_trangthai = new javax.swing.JComboBox<>();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_bang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Hóa Đơn");

        jLabel2.setText("Mã HĐ");

        jLabel3.setText("Mã KH");

        jLabel4.setText("Mã NV");

        jLabel5.setText("Mã HTTT");

        jLabel6.setText("Mã KM");

        jLabel7.setText("Ghi Chú ");

        jLabel8.setText("Thành Tiền");

        jLabel9.setText("Ngày Tạo");

        jLabel10.setText("Ngày Sửa");

        jLabel11.setText("Trạng Thái");

        cbx_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Thanh Toán", "Chưa Thanh Toán" }));

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        tb_bang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Mã KH", "Mã NV", "Mã HTTT", "Mã KM", "Ghi Chú", "Thành Tiền", "Ngày Tạo", "Ngày Sửa", "Trạng Thái"
            }
        ));
        tb_bang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_bang);
        if (tb_bang.getColumnModel().getColumnCount() > 0) {
            tb_bang.getColumnModel().getColumn(4).setHeaderValue("Mã KM");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel5)))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbx_makh, 0, 127, Short.MAX_VALUE)
                                    .addComponent(txt_mahd, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbx_manv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbx_mahttt, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbx_makm, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(24, 24, 24))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(24, 24, 24)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ngaysua)
                            .addComponent(txt_ghichu, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_thanhTien)
                            .addComponent(txt_ngaytao)
                            .addComponent(cbx_trangthai, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_them)
                            .addComponent(btn_sua)
                            .addComponent(btn_xoa))))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(cbx_makh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(cbx_manv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(cbx_mahttt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaysua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11)
                    .addComponent(cbx_makm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        JOptionPane.showMessageDialog(this, hdsv.add(getdata()));
        LoadTable();// TODO add your handling code here:
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int row = tb_bang.getSelectedRow();
        String id = tb_bang.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        JOptionPane.showMessageDialog(this, hdsv.update(getdata(), ID));
        LoadTable();

    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        int row = tb_bang.getSelectedRow();
        String id = tb_bang.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        JOptionPane.showMessageDialog(this, hdsv.delete(ID));
        LoadTable();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void tb_bangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangMouseClicked
        // TODO add your handling code here:
        int row = tb_bang.getSelectedRow();
        txt_mahd.setText(tb_bang.getValueAt(row, 0).toString());
        cbx_makh.setSelectedItem(tb_bang.getValueAt(row, 1).toString());
        cbx_manv.setSelectedItem(tb_bang.getValueAt(row, 2).toString());
        cbx_mahttt.setSelectedItem(tb_bang.getValueAt(row, 3).toString());
        cbx_makm.setSelectedItem(tb_bang.getValueAt(row, 4).toString());
        txt_ghichu.setText(tb_bang.getValueAt(row, 5).toString());
        txt_thanhTien.setText(tb_bang.getValueAt(row, 6).toString());
        txt_ngaytao.setText(tb_bang.getValueAt(row, 7).toString());
        txt_ngaysua.setText(tb_bang.getValueAt(row, 8).toString());
        cbx_trangthai.setSelectedItem(tb_bang.getValueAt(row, 9).toString());
    }//GEN-LAST:event_tb_bangMouseClicked

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
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbx_mahttt;
    private javax.swing.JComboBox<String> cbx_makh;
    private javax.swing.JComboBox<String> cbx_makm;
    private javax.swing.JComboBox<String> cbx_manv;
    private javax.swing.JComboBox<String> cbx_trangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField txt_ghichu;
    private javax.swing.JTextField txt_mahd;
    private javax.swing.JTextField txt_ngaysua;
    private javax.swing.JTextField txt_ngaytao;
    private javax.swing.JTextField txt_thanhTien;
    // End of variables declaration//GEN-END:variables
}
