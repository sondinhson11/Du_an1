package repository;

import ConfigHibernate.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class KhachHangRepository {

    Session session = HibernateConfig.getFACTORY().openSession();

    public ArrayList<KhachHang> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("From KhachHang");
        ArrayList<KhachHang> list = (ArrayList<KhachHang>) q.getResultList();
        return list;
    }

    public Boolean add(KhachHang KhachHang) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            check = (Integer) session.save(KhachHang);
            transaction.commit();
            System.err.println("Ma Hoa Don " + check);
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public Boolean update(KhachHang KhachHang, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            KhachHang kh = session.get(KhachHang.class, id);
            kh.setTen(KhachHang.getTen());
            kh.setNgaySinh(KhachHang.getNgaySinh());
            kh.setGioiTinh(KhachHang.getGioiTinh());
            kh.setDiaChi(KhachHang.getDiaChi());
            kh.setSoDienThoai(KhachHang.getSoDienThoai());
            kh.setNgayTao(KhachHang.getNgayTao());
            kh.setNgaySua(KhachHang.getNgaySua());
            kh.setTrangThai(KhachHang.getTrangThai());

            transaction = session.beginTransaction();
            session.update(kh);
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
            KhachHang clb = session.get(KhachHang.class, id);
            transaction = session.beginTransaction();
            session.delete(clb);
            transaction.commit();
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
}
