package view;

import javax.swing.JOptionPane;
import model.DangNhap;
import model.NhanVien;
import service.impl.DangNhapimpl;

public class DangKyView extends javax.swing.JFrame {

    private DangNhapimpl dnImpl = new DangNhapimpl();

    public DangKyView() {
        initComponents();
        this.setLocationRelativeTo(null);
        Clear();
    }

    private DangNhap getForm() {
        String maNV = this.txtMaNv.getText().trim();
        int maCV = this.cbbCv.getSelectedIndex();
        String mk = this.txtMk.getText();
        String pass = this.txtNLMK.getText();

        if (maNV.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập Số điện thoại");
            return null;
        }
        if (mk.length() == 0 || pass.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập Mật Khẩu");
            return null;
        }
        if (maCV == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn chức vụ");
            return null;
        }

        if (!mk.equals(pass)) {
            System.out.println(mk + "\n" + pass);
            JOptionPane.showMessageDialog(this, "Mật khẩu phải trùng nhau");
            return null;
        }

        return new DangNhap(maNV, maCV, pass);
    }
    public void Clear(){
        this.txtMaNv.setText("");
        this.txtMk.setText("");
        this.txtNLMK.setText("");
        this.cbbCv.setSelectedIndex(2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaNv = new javax.swing.JTextField();
        txtMk = new javax.swing.JPasswordField();
        txtNLMK = new javax.swing.JPasswordField();
        cbbCv = new javax.swing.JComboBox<>();
        btnDK = new javax.swing.JButton();
        btncancer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Register"));

        jLabel1.setText("Số điện Thoại :");

        jLabel2.setText("Chức Vụ :");

        jLabel3.setText("Mật Khẩu :");

        jLabel4.setText("Nhập lại Mật Khẩu :");

        txtMk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMkActionPerformed(evt);
            }
        });

        cbbCv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Quản Lý", "Nhân Viên" }));

        btnDK.setText("Sign up");
        btnDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDKActionPerformed(evt);
            }
        });

        btncancer.setText("Cancer");
        btncancer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(32, 32, 32))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaNv)
                            .addComponent(txtMk)
                            .addComponent(txtNLMK, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(cbbCv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnDK)
                        .addGap(18, 18, 18)
                        .addComponent(btncancer)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbCv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNLMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDK)
                    .addComponent(btncancer))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMkActionPerformed

    private void btncancerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancerActionPerformed
        new DangNhapView().setVisible(true);
        dispose();
    }//GEN-LAST:event_btncancerActionPerformed

    private void btnDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDKActionPerformed
        DangNhap dn = this.getForm();
        if (dn == null) {
            return;
        }
        
        String maNV = this.txtMaNv.getText().trim();
        int check = this.dnImpl.check(maNV).size();
        if (check != 0) {
            JOptionPane.showMessageDialog(this, maNV + " Đã tồn tại tài khoản");
            return;
        }
        NhanVien nv = this.dnImpl.checkMa(maNV);
        if(nv == null){
            JOptionPane.showMessageDialog(this, "Bạn chưa được quản lý thêm vào cửa hàng");
            return;
        }
        NhanVien cv = this.dnImpl.checkChucVu(maNV);
        if(cv == null){
            JOptionPane.showMessageDialog(this, "Chức vụ của bạn không đúng");
            return;
        }
        this.dnImpl.insert(dn);
        Clear();
        new DangNhapView().setVisible(true);
        JOptionPane.showMessageDialog(this, "Đăng ký thành công");
        dispose();
    }//GEN-LAST:event_btnDKActionPerformed

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
            java.util.logging.Logger.getLogger(DangKyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKyView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDK;
    private javax.swing.JButton btncancer;
    private javax.swing.JComboBox<String> cbbCv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtMaNv;
    private javax.swing.JPasswordField txtMk;
    private javax.swing.JPasswordField txtNLMK;
    // End of variables declaration//GEN-END:variables
}
