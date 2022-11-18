package view;

import java.sql.Date;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CHATLIEU;
import model.CHITIETSANPHAM;
import model.KICHTHUOC;
import model.LoaiSP;
import model.MONTHETHAO;
import model.MauSac;
import model.SanPham;
import service.CTSPServices;
import service.ChatLieuServices;
import service.KichThuocServices;
import service.LoaiSPServices;
import service.MTTService;
import service.MauSacService;
import service.SanPhamService;

import service.impl.CTSPServicesImpl;
import service.impl.ChatLieuServicesImpl;
import service.impl.KichThuocServicesImpl;
import service.impl.LoaiSPServicesImpl;
import service.impl.MTTServiceImpl;
import service.impl.MauSacServiceimpl;
import service.impl.SanPhamServiceImpl;

/**
 *
 * @author vuong
 */
public class CTSPView extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel defaultComboBoxModel;
    
    private CTSPServices ctsps = new CTSPServicesImpl();
    private ChatLieuServices cls = new ChatLieuServicesImpl();
    private KichThuocServices kts = new KichThuocServicesImpl();
    private SanPhamService sps = new SanPhamServiceImpl();
    private LoaiSPServices lsps = new LoaiSPServicesImpl();
    private MTTService mtts = new MTTServiceImpl();
    private MauSacService mss = new MauSacServiceimpl();

    public CTSPView() {
        initComponents();
        txt_maCTSP.disable();
        cbbMauSac();
        cbbChatLieu();
        cbbKichThuoc();
        cbbLoaiSP();
        cbbSanPham();
        cbbMTT();
        LoadTable();
    }

    void cbbMauSac() {
        defaultComboBoxModel = (DefaultComboBoxModel) cb_maMauSac.getModel();
        for (MauSac mauSac : mss.getlistMauSac()) {
            defaultComboBoxModel.addElement(mauSac);
        }
    }

    void cbbLoaiSP() {
        defaultComboBoxModel = (DefaultComboBoxModel) cb_maLoai.getModel();
        for (LoaiSP loaiSP : lsps.getlist()) {
            defaultComboBoxModel.addElement(loaiSP);
        }
    }

    void cbbKichThuoc() {
        defaultComboBoxModel = (DefaultComboBoxModel) cb_maKichThuoc.getModel();
        for (KICHTHUOC kichthuoc : kts.getListKT()) {
            defaultComboBoxModel.addElement(kichthuoc);
        }
    }

    void cbbSanPham() {
        defaultComboBoxModel = (DefaultComboBoxModel) cb_maSP.getModel();
        for (SanPham sanPham : sps.getListSanPham()) {
            defaultComboBoxModel.addElement(sanPham);
        }
    }

    void cbbMTT() {
        defaultComboBoxModel = (DefaultComboBoxModel) cb_maMTT.getModel();
        for (MONTHETHAO monthethao : mtts.getListMTT()) {
            defaultComboBoxModel.addElement(monthethao);
        }
    }

    void cbbChatLieu() {
        defaultComboBoxModel = (DefaultComboBoxModel) cb_maChatLieu.getModel();
        for (CHATLIEU chatlieu : cls.getListCL()) {
            defaultComboBoxModel.addElement(chatlieu);
        }
    }

    void LoadTable() {
        defaultTableModel = (DefaultTableModel) tb_CTSP.getModel();
        defaultTableModel.setRowCount(0);
        for (CHITIETSANPHAM chiTietSanPham : ctsps.getAll()) {
            defaultTableModel.addRow(new Object[]{
                chiTietSanPham.getMaCTSP(), chiTietSanPham.getSanPham(),
                chiTietSanPham.getLoaiSP(), chiTietSanPham.getMauSac(),
                chiTietSanPham.getKichThuoc(), chiTietSanPham.getChatLieu(),
                chiTietSanPham.getMonTT(), chiTietSanPham.getGia(),
                chiTietSanPham.getSoLuong(), chiTietSanPham.getNgayTao(), chiTietSanPham.getNgaySua(),
                chiTietSanPham.getTrangThai()
            });
        }
    }

    private CHITIETSANPHAM getData() {
        SanPham maSP = (SanPham) cb_maSP.getSelectedItem();
        LoaiSP LoaiSP = (LoaiSP) cb_maLoai.getSelectedItem();
        MauSac MauSac = (MauSac) cb_maMauSac.getSelectedItem();
        KICHTHUOC KichThuoc = (KICHTHUOC) cb_maKichThuoc.getSelectedItem();
        CHATLIEU ChatLieu = (CHATLIEU) cb_maChatLieu.getSelectedItem();
        MONTHETHAO MonTheThao = (MONTHETHAO) cb_maMTT.getSelectedItem();
        Integer gia = Integer.valueOf(txt_gia.getText().trim());
        Integer soLuong = Integer.valueOf(txt_soLuong.getText().trim());
        Date ngayTao = (Date.valueOf(txt_ngayTao.getText()));
        Date ngaySua = (Date.valueOf(txt_ngaySua.getText()));
        Integer TrangThai = Integer.valueOf(cb_trangThai.getSelectedItem().toString());
        JOptionPane.showMessageDialog(this, maSP.toString());

        CHITIETSANPHAM ctsp = new CHITIETSANPHAM();
        ctsp.setSanPham(maSP);
        ctsp.setMonTT(MonTheThao);
        ctsp.setChatLieu(ChatLieu);
        ctsp.setMauSac(MauSac);
        ctsp.setKichThuoc(KichThuoc);
        ctsp.setLoaiSP(LoaiSP);
        ctsp.setGia(gia);
        ctsp.setSoLuong(soLuong);
        ctsp.setNgayTao(ngayTao);
        ctsp.setNgaySua(ngaySua);
        ctsp.setTrangThai(TrangThai);

        return ctsp;
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
        jLabel12 = new javax.swing.JLabel();
        txt_maCTSP = new javax.swing.JTextField();
        txt_gia = new javax.swing.JTextField();
        txt_soLuong = new javax.swing.JTextField();
        txt_ngayTao = new javax.swing.JTextField();
        txt_ngaySua = new javax.swing.JTextField();
        cb_maSP = new javax.swing.JComboBox<>();
        cb_maLoai = new javax.swing.JComboBox<>();
        cb_maMauSac = new javax.swing.JComboBox<>();
        cb_maKichThuoc = new javax.swing.JComboBox<>();
        cb_maChatLieu = new javax.swing.JComboBox<>();
        cb_trangThai = new javax.swing.JComboBox<>();
        cb_maMTT = new javax.swing.JComboBox<>();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_CTSP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã");

        jLabel2.setText("Mã SP");

        jLabel3.setText("Mã Loại");

        jLabel4.setText("Mã Màu Sắc");

        jLabel5.setText("Mã Chất Liệu");

        jLabel6.setText("Ngày Tạo");

        jLabel7.setText("Giá");

        jLabel8.setText("Số Lượng");

        jLabel9.setText("Ngày Sửa");

        jLabel10.setText("Trạng Thái");

        jLabel11.setText("Mã MTTT");

        jLabel12.setText("Mã Kích Thước");

        cb_maSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_maSPActionPerformed(evt);
            }
        });

        cb_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));

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

        jButton4.setText("Clear");

        tb_CTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MãCTSP", "Mã SP", "Mã Loaị", "Mã Màu Sắc", "Mã Kích Thước", "Mã Chất Liệu", "Mã MTT", "Giá", "Số lượng", "Ngày tạo", "Ngày Sửa", "Trạng Thái"
            }
        ));
        tb_CTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_CTSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_CTSP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_maMauSac, 0, 182, Short.MAX_VALUE)
                            .addComponent(cb_maLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_maSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_maCTSP))
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel11)
                                .addGap(24, 24, 24)
                                .addComponent(cb_maMTT, 0, 238, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(btn_xoa))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(39, 39, 39)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_gia)
                                    .addComponent(txt_soLuong)
                                    .addComponent(txt_ngayTao)
                                    .addComponent(txt_ngaySua)
                                    .addComponent(cb_trangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jButton4)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_maKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_them)
                                        .addGap(54, 54, 54)
                                        .addComponent(btn_sua))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(cb_maChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11)
                    .addComponent(txt_maCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_maMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(txt_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_maSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_maLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(txt_ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_maMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(txt_ngaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_maKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(cb_maChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed

        JOptionPane.showMessageDialog(this, ctsps.add(getData()));
        LoadTable();
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        int row = tb_CTSP.getSelectedRow();
        String id = tb_CTSP.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        JOptionPane.showMessageDialog(this, ctsps.update(getData(), ID));
        LoadTable();

    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        int row = tb_CTSP.getSelectedRow();
        String id = tb_CTSP.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        JOptionPane.showMessageDialog(this, ctsps.delete(ID));
        LoadTable();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void tb_CTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_CTSPMouseClicked
        // TODO add your handling code here:
        int row = tb_CTSP.getSelectedRow();
        txt_maCTSP.setText(tb_CTSP.getValueAt(row, 0).toString());
        cb_maSP.setSelectedItem(tb_CTSP.getValueAt(row, 1).toString());
        cb_maLoai.setSelectedItem(tb_CTSP.getValueAt(row, 2).toString());
        cb_maMauSac.setSelectedItem(tb_CTSP.getValueAt(row, 3).toString());
        cb_maKichThuoc.setSelectedItem(tb_CTSP.getValueAt(row, 4).toString());
        cb_maChatLieu.setSelectedItem(tb_CTSP.getValueAt(row, 5).toString());
        cb_maMTT.setSelectedItem(tb_CTSP.getValueAt(row, 6).toString());
        txt_gia.setText(tb_CTSP.getValueAt(row, 7).toString());
        txt_soLuong.setText(tb_CTSP.getValueAt(row, 8).toString());
        txt_ngayTao.setText(tb_CTSP.getValueAt(row, 9).toString());
        txt_ngaySua.setText(tb_CTSP.getValueAt(row, 10).toString());
        cb_trangThai.setSelectedItem(tb_CTSP.getValueAt(row, 11).toString());
    }//GEN-LAST:event_tb_CTSPMouseClicked

    private void cb_maSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_maSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_maSPActionPerformed

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
            java.util.logging.Logger.getLogger(CTSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CTSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CTSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CTSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CTSPView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cb_maChatLieu;
    private javax.swing.JComboBox<String> cb_maKichThuoc;
    private javax.swing.JComboBox<String> cb_maLoai;
    private javax.swing.JComboBox<String> cb_maMTT;
    private javax.swing.JComboBox<String> cb_maMauSac;
    private javax.swing.JComboBox<String> cb_maSP;
    private javax.swing.JComboBox<String> cb_trangThai;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JTable tb_CTSP;
    private javax.swing.JTextField txt_gia;
    private javax.swing.JTextField txt_maCTSP;
    private javax.swing.JTextField txt_ngaySua;
    private javax.swing.JTextField txt_ngayTao;
    private javax.swing.JTextField txt_soLuong;
    // End of variables declaration//GEN-END:variables
}
