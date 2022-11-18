/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import ConfigHibernate.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.KhuyenMai;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author thean
 */
public class KhuyenMaiRepository {
    Session session = HibernateConfig.getFACTORY().openSession();
    public ArrayList<KhuyenMai> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("From KhuyenMai");
        ArrayList<KhuyenMai> list = (ArrayList<KhuyenMai>) q.getResultList();
        return list;
    }
    public Boolean add(KhuyenMai khuyenmai) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            check = (Integer) session.save(khuyenmai);
            transaction.commit();
            System.err.println("Ma Khuyen Mai " + check);
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    public Boolean update(KhuyenMai khuyenmai, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
           KhuyenMai km=session.get(KhuyenMai.class, id);
           km.setTenKM(khuyenmai.getTenKM());
           km.setNgayBD(khuyenmai.getNgayBD());
           km.setNgayKT(khuyenmai.getNgayKT());
           km.setGiamGia(khuyenmai.getGiamGia());
           km.setNgayTao(khuyenmai.getNgayTao());
           km.setNgaySua(khuyenmai.getNgaySua());
           km.setTrangThai(khuyenmai.getTrangThai());
           transaction=session.beginTransaction();
           session.update(km);
           transaction.commit();
            
            return check >0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    public Boolean delete(int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            KhuyenMai km = session.get(KhuyenMai.class, id);
            transaction = session.beginTransaction();
            session.delete(km);
            transaction.commit();
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
