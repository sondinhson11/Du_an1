/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import ConfigHibernate.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.CHITIETSANPHAM;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vuong
 */
public class CTTSPRepository {

    Session session = HibernateConfig.getFACTORY().openSession();

    public ArrayList<CHITIETSANPHAM> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("From CHITIETSANPHAM Where TrangThai = 1");
        ArrayList<CHITIETSANPHAM> list = (ArrayList<CHITIETSANPHAM>) q.getResultList();
        return list;
    }

    public ArrayList<CHITIETSANPHAM> getListAn() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("From CHITIETSANPHAM Where TrangThai = 0");
        ArrayList<CHITIETSANPHAM> list = (ArrayList<CHITIETSANPHAM>) q.getResultList();
        return list;
    }

    public Boolean add(CHITIETSANPHAM ctsp) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            check = (Integer) session.save(ctsp);
            transaction.commit();
            System.err.println("Ma " + check);
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public Boolean update(CHITIETSANPHAM chiTietSanPham, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            CHITIETSANPHAM ctsp = session.get(CHITIETSANPHAM.class, id);
            ctsp.setSanPham(chiTietSanPham.getSanPham());
            ctsp.setMauSac(chiTietSanPham.getMauSac());
            ctsp.setKichThuoc(chiTietSanPham.getKichThuoc());
            ctsp.setChatLieu(chiTietSanPham.getChatLieu());
            ctsp.setMonTT(chiTietSanPham.getMonTT());
            ctsp.setSoLuong(chiTietSanPham.getSoLuong());
            ctsp.setGia(chiTietSanPham.getGia());
            ctsp.setNgayTao(chiTietSanPham.getNgayTao());
            ctsp.setNgaySua(chiTietSanPham.getNgaySua());
            ctsp.setTrangThai(chiTietSanPham.getTrangThai());
            transaction = session.beginTransaction();
            check = (Integer) session.save(ctsp);
            transaction.commit();
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    public Boolean updateSoluong(CHITIETSANPHAM chiTietSanPham, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            CHITIETSANPHAM ctsp = session.get(CHITIETSANPHAM.class, id);
            ctsp.setSoLuong(chiTietSanPham.getSoLuong());
            transaction = session.beginTransaction();
            check = (Integer) session.save(ctsp);
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
            CHITIETSANPHAM ctsp = session.get(CHITIETSANPHAM.class, id);
            ctsp.setTrangThai(0);
            transaction = session.beginTransaction();
            check = (Integer) session.save(ctsp);
            transaction.commit();
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public Boolean hienThi(int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            CHITIETSANPHAM ctsp = session.get(CHITIETSANPHAM.class, id);
            ctsp.setTrangThai(1);
            transaction = session.beginTransaction();
            check = (Integer) session.save(ctsp);
            transaction.commit();
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
