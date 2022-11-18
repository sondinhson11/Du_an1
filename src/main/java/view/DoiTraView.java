package view;

import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DoiTra;
import service.impl.DoiTraImpl;

public class DoiTraView extends javax.swing.JFrame {
    private DoiTraImpl dtIm = new DoiTraImpl();
    public DoiTraView() {
        initComponents();
        load();
        setLocationRelativeTo(null);
    }
    private int tt() {
        if (cbbTrangThai.getSelectedItem() == "Có") {
            return 1;
        } else {
            return 0;
        }
    }
    private void load(){
        DefaultTableModel dtm = (DefaultTableModel)this.tbDoiTra.getModel();
        dtm.setRowCount(0);
        for (DoiTra dt : this.dtIm.getList()) {
            Object[] row = {
                dt.getMaDT(),
                dt.getMaCTSP(),
                dt.getMaHDCT(),
                dt.getLydo(),
                dt.getNgayDoi(),
                dt.getNgayBan(),
                dt.getTrangThai() == 1 ? "Có":"Không"
            };
        }
    }
    private DoiTra getForm(){
        int maCTSP = Integer.parseInt(txtMaCTSP.getText().trim());
        int maHD = Integer.parseInt(txtMaHD.getText().trim());
        String lydo = txaLyDO.getText();
        String ngayban = txtNgayban.getText().trim();
        String ngaydoi = txtNgayDoi.getText().trim();
        int trangThai = tt();
        if(maCTSP==0||maHD==0||ngayban.length()==0||ngaydoi.length()==0){
            JOptionPane.showMessageDialog(this, "bạn chưa nhập đủ");
            return null;
        }
        Date ngayBan;
        Date ngayDoi;
        try {
            ngayBan = Date.valueOf(ngayban);
            ngayDoi = Date.valueOf(ngaydoi);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sai định dạng ngày tháng");
            return null;
        }

        return new DoiTra(0, maCTSP, maHD, lydo, ngayDoi, ngayBan, trangThai);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDoiTra = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaLyDO = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        txtMaDT = new javax.swing.JTextField();
        txtMaCTSP = new javax.swing.JTextField();
        txtMaHD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNgayban = new javax.swing.JTextField();
        txtNgayDoi = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbDoiTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaDT", "MaCTSP", "MaHD", "LyDo", "NgayDoi", "NgayBan", "TrangThai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDoiTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDoiTraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDoiTra);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Đổi Trả");

        jLabel2.setText("Chi Tiết SP :");

        jLabel3.setText("Mã :");

        jLabel4.setText("Mã Hóa Đơn : ");

        txaLyDO.setColumns(20);
        txaLyDO.setRows(5);
        jScrollPane2.setViewportView(txaLyDO);

        jLabel5.setText("Lý do :");

        jLabel6.setText("Trạng thái :");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Có", "Không" }));

        txtMaDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDTActionPerformed(evt);
            }
        });

        txtMaCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaCTSPActionPerformed(evt);
            }
        });

        txtMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDActionPerformed(evt);
            }
        });

        jLabel7.setText("Ngày Đổi : ");

        jLabel8.setText("Ngày bán:");

        txtNgayban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaybanActionPerformed(evt);
            }
        });

        txtNgayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayDoiActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

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
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnThem)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnSua)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnXoa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMaDT, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cbbTrangThai, 0, 123, Short.MAX_VALUE)
                    .addComponent(txtNgayban)
                    .addComponent(txtNgayDoi))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNgayDoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtNgayban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDTActionPerformed

    private void txtMaCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaCTSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaCTSPActionPerformed

    private void txtMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDActionPerformed

    private void txtNgaybanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaybanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaybanActionPerformed

    private void txtNgayDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayDoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayDoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       DoiTra dt = this.getForm();
       if(dt == null){
           return;
       }
       String traLoi = dtIm.add(dt);
        JOptionPane.showMessageDialog(this, traLoi);
        load();
    }//GEN-LAST:event_btnThemActionPerformed

    private void tbDoiTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDoiTraMouseClicked
        int row = this.tbDoiTra.getSelectedRow();
        if(row == -1)
        {
            return;
        }
        this.txtMaDT.setText(this.tbDoiTra.getValueAt(row, 0).toString());
        this.txtMaCTSP.setText(this.tbDoiTra.getValueAt(row, 1).toString());
        this.txtMaHD.setText(this.tbDoiTra.getValueAt(row, 2).toString());
        this.txaLyDO.setText(this.tbDoiTra.getValueAt(row, 3).toString());
        this.txtNgayDoi.setText(this.tbDoiTra.getValueAt(row, 4).toString());
        this.txtNgayban.setText(this.tbDoiTra.getValueAt(row, 5).toString());
        this.cbbTrangThai.setSelectedItem(this.tbDoiTra.getValueAt(row, 6).toString());
        
    }//GEN-LAST:event_tbDoiTraMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tbDoiTra.getSelectedRow();
        DoiTra cv = getForm();
        if (cv == null) {
            return;
        }
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dữ liệu");
            return;
        }
        String id = tbDoiTra.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        String traLoi = dtIm.update(cv, ID);
        load();
        JOptionPane.showMessageDialog(this, traLoi);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tbDoiTra.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dữ liệu");
            return;
        }
        String id = tbDoiTra.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        String traLoi = dtIm.delete(ID);
        load();
        JOptionPane.showMessageDialog(this, traLoi);
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(DoiTraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiTraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiTraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiTraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiTraView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbDoiTra;
    private javax.swing.JTextArea txaLyDO;
    private javax.swing.JTextField txtMaCTSP;
    private javax.swing.JTextField txtMaDT;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayDoi;
    private javax.swing.JTextField txtNgayban;
    // End of variables declaration//GEN-END:variables
}
