/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import ConfigHibernate.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.ChiTietSanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vuong
 */
public class CTTSPRepository {

    Session session = HibernateConfig.getFACTORY().openSession();

    public ArrayList<ChiTietSanPham> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("From CHITIETSANPHAM");
        ArrayList<ChiTietSanPham> list = (ArrayList<ChiTietSanPham>) q.getResultList();
        return list;
    }

    public Boolean add(ChiTietSanPham ctsp) {
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

    public Boolean update(ChiTietSanPham chiTietSanPham, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            ChiTietSanPham ctsp = session.get(ChiTietSanPham.class, id);
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
            ChiTietSanPham ctsp = session.get(ChiTietSanPham.class, id);
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
