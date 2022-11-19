/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import ConfigHibernate.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.NhanVien;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author duong
 */
public class NhanVienRepository {
   Session session = HibernateConfig.getFACTORY().openSession();
    public ArrayList<NhanVien> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("From NhanVien");
        ArrayList<NhanVien> list = (ArrayList<NhanVien>) q.getResultList();
        return list;
    }
    public Boolean add(NhanVien nv) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            check = (Integer) session.save(nv);
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
            NhanVien nv = session.get(NhanVien.class, id);
            transaction = session.beginTransaction();
            session.delete(nv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public Boolean update(NhanVien nv, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            NhanVien cv = session.get(NhanVien.class, id);
            cv.setMaNv(nv.getMaNv());
            cv.setChucvu(nv.getChucvu());
            cv.setTenNv(nv.getTenNv());
            cv.setDiaChi(nv.getDiaChi());
            cv.setGioiTinh(nv.getGioiTinh());
            cv.setEmail(nv.getEmail());
            cv.setSdt(nv.getSdt());
            cv.setNgaySinh(nv.getNgaySinh());
            cv.setNgayTao(nv.getNgayTao());
            cv.setNgaySua(nv.getNgaySua());
            cv.setTrangThai(nv.getTrangThai());
            transaction = session.beginTransaction();
            check = (Integer) session.save(cv); 
            transaction.commit();
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
