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
import model.CHITIETSANPHAM;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.KhuyenMai;
import service.CTSPServices;
import service.HDCTservice;
import service.HoaDonService;
import service.KhuyenMaiService;
import service.impl.CTSPServicesImpl;
import service.impl.HDCTServiceImpl;
import service.impl.HoaDonServiceImpl;
import service.impl.KhuyenMaiServiceImpl;

/**
 *
 * @author thean
 */
public class HoaDonChiTietView extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel defaultComboBoxModel;
    private HDCTservice hdctsv = new HDCTServiceImpl();
    private HoaDonService hds = new HoaDonServiceImpl();
    private CTSPServices ctsps = new CTSPServicesImpl();
    private KhuyenMaiService khuyenMaiViews = new KhuyenMaiServiceImpl();

    /**
     * Creates new form HoaDonChiTietView
     */
    public HoaDonChiTietView() {
        initComponents();
        cbbMaCTSP();
        cbbMaHD();
        LoadData();
        cbbKhuyenMai();
    }

    void cbbMaHD() {
        defaultComboBoxModel = (DefaultComboBoxModel) cbx_mahd.getModel();
        for (HoaDon hoaDon : hds.getAll()) {
            defaultComboBoxModel.addElement(hoaDon);
        }
    }

    void cbbMaCTSP() {
        defaultComboBoxModel = (DefaultComboBoxModel) cbx_mactsp.getModel();
        for (CHITIETSANPHAM chitietsanpham : ctsps.getAll()) {
            defaultComboBoxModel.addElement(chitietsanpham);
        }
    }

    void cbbKhuyenMai() {
        defaultComboBoxModel = (DefaultComboBoxModel) cbx_mahd1.getModel();
        for (KhuyenMai khuyenMai : khuyenMaiViews.getListKM()) {
            defaultComboBoxModel.addElement(khuyenMai);
        }
    }

    void LoadData() {
        defaultTableModel = (DefaultTableModel) this.tb_bang.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDonChiTiet hoaDonChiTiet : hdctsv.getListHDCT()) {
            defaultTableModel.addRow(new Object[]{
                hoaDonChiTiet.getMaHDCT(),
                hoaDonChiTiet.getHoaDon(),
                hoaDonChiTiet.getChitietsanpham(),
                hoaDonChiTiet.getSoluong(),
                hoaDonChiTiet.getGia(),
                hoaDonChiTiet.getGiamGia(),
                hoaDonChiTiet.getThanhTien(),
                hoaDonChiTiet.getGhiChu(),
                hoaDonChiTiet.getNgayTao(),
                hoaDonChiTiet.getNgaySua(),
                hoaDonChiTiet.getTrangThai() == 1 ? "Đã Thanh Toán" : "Chưa Thanh Toán"
            });

        }
    }

    private int TrangThai() {
        if (cbx_trangthai.getSelectedItem() == "Đã Thanh Toán") {
            return 1;
        } else {
            return 0;
        }
    }

    private HoaDonChiTiet getdata() {
        HoaDon maHD = (HoaDon) cbx_mahd.getSelectedItem();
        CHITIETSANPHAM maCTSP = (CHITIETSANPHAM) cbx_mactsp.getSelectedItem();
        int soluong = Integer.parseInt(txt_soluong.getText().trim());
        Float gia = Float.valueOf(txt_gia.getText().trim());
        KhuyenMai km2 = (KhuyenMai)cbx_mahd1.getSelectedItem();
        String ghichu = txt_ghichu.getText().trim();
        Date ngayTao = (Date.valueOf(txt_ngaytao.getText()));
        Date ngaySua = (Date.valueOf(txt_ngaysua.getText()));
        Integer TrangThai = TrangThai();
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setHoaDon(maHD);
        hdct.setChitietsanpham(maCTSP);
        hdct.setSoluong(soluong);
        hdct.setGia(gia);
        hdct.setGiamGia(km2);
        hdct.setThanhTien(gia-km2.getGiamGia());
        hdct.setGhiChu(ghichu);
        hdct.setNgayTao(ngayTao);
        hdct.setNgaySua(ngaySua);
        hdct.setTrangThai(TrangThai);
        return hdct;
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
        txt_mahdct = new javax.swing.JTextField();
        cbx_mahd = new javax.swing.JComboBox<>();
        cbx_mactsp = new javax.swing.JComboBox<>();
        txt_soluong = new javax.swing.JTextField();
        txt_gia = new javax.swing.JTextField();
        txt_thanhtien = new javax.swing.JTextField();
        txt_ghichu = new javax.swing.JTextField();
        txt_ngaytao = new javax.swing.JTextField();
        cbx_trangthai = new javax.swing.JComboBox<>();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_bang = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txt_ngaysua = new javax.swing.JTextField();
        cbx_mahd1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("HÓA ĐƠN CHI TIẾT");

        jLabel2.setText("Mã HDCT");

        jLabel3.setText("Mã HĐ");

        jLabel4.setText("Mã CTSP");

        jLabel5.setText("Số Lượng");

        jLabel6.setText("Giá");

        jLabel7.setText("Giảm Giá");

        jLabel8.setText("Thành Tiền");

        jLabel9.setText("Ghi chú");

        jLabel10.setText("Ngày Tạo");

        jLabel11.setText("Trạng Thái");

        txt_gia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giaActionPerformed(evt);
            }
        });

        txt_thanhtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_thanhtienActionPerformed(evt);
            }
        });

        txt_ghichu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ghichuActionPerformed(evt);
            }
        });

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
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HĐCT", "Mã HĐ", "Mã CTSP", "Số Lượng", "Giá", "Giảm Giá", "Thành Tiền", "Ghi Chú", "Ngày Tạo", "Ngày sửa", "Trạng Thái"
            }
        ));
        tb_bang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_bang);

        jLabel12.setText("Ngày Sửa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(12, 12, 12)
                                        .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbx_mactsp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(26, 26, 26)
                                        .addComponent(cbx_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_mahdct, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_thanhtien, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                            .addComponent(txt_ghichu)
                            .addComponent(txt_gia)
                            .addComponent(cbx_mahd1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ngaytao)
                            .addComponent(txt_ngaysua)
                            .addComponent(cbx_trangthai, 0, 90, Short.MAX_VALUE))
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_them)
                        .addGap(40, 40, 40)
                        .addComponent(btn_sua)
                        .addGap(45, 45, 45)
                        .addComponent(btn_xoa)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(txt_mahdct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbx_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(txt_ngaysua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_mahd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbx_mactsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8)
                    .addComponent(txt_thanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txt_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_sua)
                        .addComponent(btn_xoa))
                    .addComponent(btn_them))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_thanhtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_thanhtienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_thanhtienActionPerformed

    private void txt_ghichuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ghichuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ghichuActionPerformed

    private void txt_giaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed

        JOptionPane.showMessageDialog(this, hdctsv.addSanPham(getdata()));
        LoadData();
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int row = tb_bang.getSelectedRow();
        String id = tb_bang.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        JOptionPane.showMessageDialog(this, hdctsv.update(getdata(), ID));
        LoadData();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        int row = tb_bang.getSelectedRow();
        String id = tb_bang.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        JOptionPane.showMessageDialog(this, hdctsv.delete(ID));
        LoadData();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void tb_bangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangMouseClicked
        // TODO add your handling code here:
        int row = tb_bang.getSelectedRow();
        txt_mahdct.setText(tb_bang.getValueAt(row, 0).toString());
        cbx_mahd.setSelectedItem(tb_bang.getValueAt(row, 1).toString());
        cbx_mactsp.setSelectedItem(tb_bang.getValueAt(row, 2).toString());
        txt_soluong.setText(tb_bang.getValueAt(row, 3).toString());
        txt_gia.setText(tb_bang.getValueAt(row, 4).toString());
        cbx_mahd1.setSelectedItem(tb_bang.getValueAt(row, 5).toString());
        txt_thanhtien.setText(tb_bang.getValueAt(row, 6).toString());
        txt_ghichu.setText(tb_bang.getValueAt(row, 7).toString());
        txt_ngaytao.setText(tb_bang.getValueAt(row, 8).toString());
        txt_ngaysua.setText(tb_bang.getValueAt(row, 9).toString());
        cbx_trangthai.setSelectedItem(tb_bang.getValueAt(row, 10).toString());


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
            java.util.logging.Logger.getLogger(HoaDonChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonChiTietView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbx_mactsp;
    private javax.swing.JComboBox<String> cbx_mahd;
    private javax.swing.JComboBox<String> cbx_mahd1;
    private javax.swing.JComboBox<String> cbx_trangthai;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_bang;
    private javax.swing.JTextField txt_ghichu;
    private javax.swing.JTextField txt_gia;
    private javax.swing.JTextField txt_mahdct;
    private javax.swing.JTextField txt_ngaysua;
    private javax.swing.JTextField txt_ngaytao;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JTextField txt_thanhtien;
    // End of variables declaration//GEN-END:variables
}
