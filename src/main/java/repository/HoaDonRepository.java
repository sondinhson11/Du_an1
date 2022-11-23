/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import ConfigHibernate.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thean
 */
public class HoaDonRepository {

    Session session = HibernateConfig.getFACTORY().openSession();

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

    public Boolean update(HoaDon hoaDon, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            HoaDon hd = session.get(HoaDon.class, id);
            transaction = session.beginTransaction();
            hd.setKhachHang(hoaDon.getKhachHang());
            hd.setNhanVien(hoaDon.getNhanVien());
            hd.setHinhthucthanhtoan(hoaDon.getHinhthucthanhtoan());
            hd.setKhuyenMai(hoaDon.getKhuyenMai());
            hd.setGhiChu(hoaDon.getGhiChu());
            hd.setThanhTien(hoaDon.getThanhTien());
            hd.setNgayTao(hoaDon.getNgayTao());
            hd.setNgaySua(hoaDon.getNgaySua());
            hd.setTrangThai(hoaDon.getTrangThai());
            check = (Integer) session.save(hd);
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
