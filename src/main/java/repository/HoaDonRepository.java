/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import ConfigHibernate.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thean
 */
public class HoaDonRepository {

    Session session ;
    
    public static HoaDon getOne(int maHD){
        Session session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("From HoaDon where MaHD =:ma");
        q.setParameter("ma", maHD);
        return (HoaDon) q.getSingleResult();
    }
    public static void main(String[] args) {
        HoaDon hd = getOne(1);
        System.out.println(hd);
    }
    

    public ArrayList<HoaDon> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("From HoaDon");
        ArrayList<HoaDon> list = (ArrayList<HoaDon>) q.getResultList();
        return list;
    }

    public Boolean add(HoaDon hd) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            check = (Integer) session.save(hd);
            transaction.commit();
            System.err.println("Ma " + check);
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static Boolean update(HoaDon hoaDon) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
//            HoaDon hd = session.get(HoaDon.class, id);
            transaction = session.beginTransaction();
//            hd.setKhachHang(hoaDon.getKhachHang());
//            hd.setNhanVien(hoaDon.getNhanVien());
//            hd.setHinhthucthanhtoan(hoaDon.getHinhthucthanhtoan());
//            hd.setKhuyenMai(hoaDon.getKhuyenMai());
//            hd.setGhiChu(hoaDon.getGhiChu());
//            hd.setThanhTien(hoaDon.getThanhTien());
//            hd.setNgayTao(hoaDon.getNgayTao());
//            hd.setNgaySua(hoaDon.getNgaySua());
//            hd.setTrangThai(hoaDon.getTrangThai());
//            check = (Integer) session.save(hd);
            JOptionPane.showMessageDialog(null, "Bug đéo vào đây"+hoaDon);
                session.update(hoaDon);
            transaction.commit();
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public Boolean delete(int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            HoaDon hd = session.get(HoaDon.class, id);
            transaction = session.beginTransaction();
            session.delete(hd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    public Boolean updateKhachHang(HoaDon hoaDon, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            HoaDon hd = session.get(HoaDon.class, id);
            transaction = session.beginTransaction();
            hd.setKhachHang(hoaDon.getKhachHang());
            check = (Integer) session.save(hd);
            transaction.commit();
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    
}
