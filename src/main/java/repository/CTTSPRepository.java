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
        Query q = session.createQuery("From CHITIETSANPHAM");
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
        return null;
    }

    public Boolean update(CHITIETSANPHAM chiTietSanPham, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            CHITIETSANPHAM ctsp = session.get(CHITIETSANPHAM.class, id);
            ctsp.setMaCTSP(chiTietSanPham.getMaCTSP());
            ctsp.setMaSanPham(chiTietSanPham.getMaSanPham());
            ctsp.setMaMauSac(chiTietSanPham.getMaMauSac());
            ctsp.setMaKichThuoc(chiTietSanPham.getMaKichThuoc());
            ctsp.setMaChatLieu(chiTietSanPham.getMaChatLieu());
            ctsp.setMaMonTheThao(chiTietSanPham.getMaMonTheThao());
            ctsp.setSoLuong(chiTietSanPham.getSoLuong());
            ctsp.setGia(chiTietSanPham.getGia());
            ctsp.setNgayTao(chiTietSanPham.getNgayTao());
            ctsp.setNgaySua(chiTietSanPham.getNgaySua());
            ctsp.setTrangThai(chiTietSanPham.getTrangThai());
            transaction = session.beginTransaction();
            session.update(ctsp);
            transaction.commit();
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public Boolean delete(int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            CHITIETSANPHAM ctsp = session.get(CHITIETSANPHAM.class, id);
            transaction = session.beginTransaction();
            session.delete(ctsp);
            transaction.commit();
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
