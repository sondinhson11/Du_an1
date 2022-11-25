/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.sql.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
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
 * @author ThisPC
 */
public class CTSPViews extends javax.swing.JInternalFrame {
    
    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel defaultComboBoxModel;
    
    private CTSPServices ctsps = new CTSPServicesImpl();
    private ChatLieuServices cls = new ChatLieuServicesImpl();
    private KichThuocServices kts = new KichThuocServicesImpl();
    private SanPhamService sps = new SanPhamServiceImpl();
    private LoaiSPServices lsps = new LoaiSPServicesImpl();
    private MTTService mtts = new MTTServiceImpl();
    private MauSacService mss = new MauSacServiceimpl();
    
    public CTSPViews() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        txt_maCTSP.disable();
        cbbMauSac();
        cbbChatLieu();
        cbbKichThuoc();
        cbbLoaiSP();
        cbbSanPham();
        cbbMTT();
        LoadTable();
        LoadTableAn();
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
                chiTietSanPham.getTrangThai() == 1 ? "Hiển Thị" : "Ẩn"
            });
        }
    }
    
    void LoadTableAn() {
        defaultTableModel = (DefaultTableModel) tb_CTSP2.getModel();
        defaultTableModel.setRowCount(0);
        for (CHITIETSANPHAM chiTietSanPham : ctsps.getAllAn()) {
            defaultTableModel.addRow(new Object[]{
                chiTietSanPham.getMaCTSP(), chiTietSanPham.getSanPham(),
                chiTietSanPham.getLoaiSP(), chiTietSanPham.getMauSac(),
                chiTietSanPham.getKichThuoc(), chiTietSanPham.getChatLieu(),
                chiTietSanPham.getMonTT(), chiTietSanPham.getGia(),
                chiTietSanPham.getSoLuong(), chiTietSanPham.getNgayTao(), chiTietSanPham.getNgaySua(),
                chiTietSanPham.getTrangThai() == 1 ? "Hiển Thị" : "Ẩn"
            });
        }
    }
    
    private int TrangThai() {
        if (cb_trangThai.getSelectedItem() == "Hiển Thị") {
            return 1;
        } else {
            return 0;
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
        Integer TrangThai = TrangThai();
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
    void clear(){
        txt_maCTSP.setText("");
        cb_maSP.setSelectedItem("");
        cb_maLoai.setSelectedItem("");
        cb_maMauSac.setSelectedItem("");
        cb_maKichThuoc.setSelectedItem("");
        cb_maChatLieu.setSelectedItem("");
        cb_maMTT.setSelectedItem("");
        txt_gia.setText("");
        txt_soLuong.setText("");
        txt_ngayTao.setText("");
        txt_ngaySua.setText("");
        cb_trangThai.setSelectedItem("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
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
        jLabel1 = new javax.swing.JLabel();
        cb_trangThai = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cb_maMTT = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_CTSP = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_CTSP2 = new javax.swing.JTable();
        btnHienThi = new javax.swing.JButton();
        btnThemSp = new javax.swing.JButton();
        btnThemLSP = new javax.swing.JButton();
        btnThemMS = new javax.swing.JButton();
        btnThemKT = new javax.swing.JButton();
        btnThemCL = new javax.swing.JButton();
        btnThemMTT = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1305, 820));
        setRequestFocusEnabled(false);

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Ẩn");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        jLabel6.setText("Ngày Tạo");

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Giá");

        jLabel8.setText("Số Lượng");

        jLabel9.setText("Ngày Sửa");

        jLabel10.setText("Trạng Thái");

        jLabel11.setText("Tên MTTT");

        jLabel12.setText("Tên Kích Thước");

        cb_maSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_maSPActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã");

        cb_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hiển Thị", "Ẩn" }));

        jLabel2.setText("Tên SP");

        jLabel3.setText("Tên Loại");

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên Màu Sắc");

        jLabel5.setText("Tên Chất Liệu");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("Quản Lý Sản Phẩm");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm"));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm Ẩn"));

        tb_CTSP2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MãCTSP", "Mã SP", "Mã Loaị", "Mã Màu Sắc", "Mã Kích Thước", "Mã Chất Liệu", "Mã MTT", "Giá", "Số lượng", "Ngày tạo", "Ngày Sửa", "Trạng Thái"
            }
        ));
        tb_CTSP2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_CTSP2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_CTSP2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        btnHienThi.setText("Hiển Thị Sản Phẩm");
        btnHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiActionPerformed(evt);
            }
        });

        btnThemSp.setText("Thêm Sản Phẩm");
        btnThemSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSpActionPerformed(evt);
            }
        });

        btnThemLSP.setText("Thêm Loại SP");
        btnThemLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLSPActionPerformed(evt);
            }
        });

        btnThemMS.setText("Thêm Màu Sắc");
        btnThemMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMSActionPerformed(evt);
            }
        });

        btnThemKT.setText("Thêm Kích Thước");
        btnThemKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKTActionPerformed(evt);
            }
        });

        btnThemCL.setText("Thêm Chât Liệu");
        btnThemCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCLActionPerformed(evt);
            }
        });

        btnThemMTT.setText("Thêm Môn TT");
        btnThemMTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMTTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_maCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cb_maKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cb_maMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cb_maLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cb_maSP, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(56, 56, 56)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel7))
                                        .addGap(23, 23, 23))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cb_maChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_trangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_ngaySua)
                                    .addComponent(txt_ngayTao)
                                    .addComponent(txt_soLuong)
                                    .addComponent(cb_maMTT, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_gia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemCL, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemMTT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemMS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemLSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemSp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHienThi, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11)
                            .addComponent(cb_maMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_maCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(txt_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_maSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(cb_maLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(cb_maMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cb_maKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txt_ngaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cb_maChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_them)
                                .addGap(16, 16, 16)
                                .addComponent(btn_sua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_xoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThemKT))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnHienThi)
                                .addGap(16, 16, 16)
                                .addComponent(btnThemSp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThemLSP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThemMS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThemMTT)))
                        .addGap(18, 18, 18)
                        .addComponent(btnThemCL)
                        .addGap(1, 1, 1)))
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int row = tb_CTSP.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dữ Liệu");
            return;
        }
        String id = tb_CTSP.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        JOptionPane.showMessageDialog(this, ctsps.update(getData(), ID));
        LoadTable();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        int row = tb_CTSP.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dữ Liệu");
            return;
        }
        String id = tb_CTSP.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        JOptionPane.showMessageDialog(this, ctsps.delete(ID));
        LoadTable();
        LoadTableAn();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void tb_CTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_CTSPMouseClicked
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

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        JOptionPane.showMessageDialog(this, ctsps.add(getData()));
        LoadTable();
    }//GEN-LAST:event_btn_themActionPerformed

    private void tb_CTSP2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_CTSP2MouseClicked
        int row = tb_CTSP2.getSelectedRow();
        txt_maCTSP.setText(tb_CTSP2.getValueAt(row, 0).toString());
        cb_maSP.setSelectedItem(tb_CTSP2.getValueAt(row, 1).toString());
        cb_maLoai.setSelectedItem(tb_CTSP2.getValueAt(row, 2).toString());
        cb_maMauSac.setSelectedItem(tb_CTSP2.getValueAt(row, 3).toString());
        cb_maKichThuoc.setSelectedItem(tb_CTSP2.getValueAt(row, 4).toString());
        cb_maChatLieu.setSelectedItem(tb_CTSP2.getValueAt(row, 5).toString());
        cb_maMTT.setSelectedItem(tb_CTSP2.getValueAt(row, 6).toString());
        txt_gia.setText(tb_CTSP2.getValueAt(row, 7).toString());
        txt_soLuong.setText(tb_CTSP2.getValueAt(row, 8).toString());
        txt_ngayTao.setText(tb_CTSP2.getValueAt(row, 9).toString());
        txt_ngaySua.setText(tb_CTSP2.getValueAt(row, 10).toString());
        cb_trangThai.setSelectedItem(tb_CTSP2.getValueAt(row, 11).toString());
    }//GEN-LAST:event_tb_CTSP2MouseClicked

    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
        int row = tb_CTSP2.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dữ Liệu");
            return;
        }
        String id = tb_CTSP2.getValueAt(row, 0).toString();
        int ID = (Integer.parseInt(id));
        JOptionPane.showMessageDialog(this, ctsps.hienThi(ID));
        LoadTable();
        LoadTableAn();
    }//GEN-LAST:event_btnHienThiActionPerformed

    private void btnThemSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSpActionPerformed
        SanPhamView spf = new SanPhamView();
        spf.setVisible(true);
    }//GEN-LAST:event_btnThemSpActionPerformed

    private void btnThemLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLSPActionPerformed
        LoaiSPView loaiSPView = new LoaiSPView();
        loaiSPView.setVisible(true);
    }//GEN-LAST:event_btnThemLSPActionPerformed

    private void btnThemMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMSActionPerformed
        MauSacView msv = new MauSacView();
        msv.setVisible(true);
    }//GEN-LAST:event_btnThemMSActionPerformed

    private void btnThemMTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMTTActionPerformed
        MTTView mttV = new MTTView();
        mttV.setVisible(true);
    }//GEN-LAST:event_btnThemMTTActionPerformed

    private void btnThemKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKTActionPerformed
        KichThuocView kichThuocView = new KichThuocView();
        kichThuocView.setVisible(true);
    }//GEN-LAST:event_btnThemKTActionPerformed

    private void btnThemCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCLActionPerformed
        ChatLieuView clv = new ChatLieuView();
        clv.setVisible(true);
    }//GEN-LAST:event_btnThemCLActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         clear();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHienThi;
    private javax.swing.JButton btnThemCL;
    private javax.swing.JButton btnThemKT;
    private javax.swing.JButton btnThemLSP;
    private javax.swing.JButton btnThemMS;
    private javax.swing.JButton btnThemMTT;
    private javax.swing.JButton btnThemSp;
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tb_CTSP;
    private javax.swing.JTable tb_CTSP2;
    private javax.swing.JTextField txt_gia;
    private javax.swing.JTextField txt_maCTSP;
    private javax.swing.JTextField txt_ngaySua;
    private javax.swing.JTextField txt_ngayTao;
    private javax.swing.JTextField txt_soLuong;
    // End of variables declaration//GEN-END:variables
}
