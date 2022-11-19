package repository;

import ConfigHibernate.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SanPhamRepository {

    Session session = HibernateConfig.getFACTORY().openSession();

    public ArrayList<SanPham> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("From SanPham Where TrangThai Like 1");
        ArrayList<SanPham> list = (ArrayList<SanPham>) q.getResultList();
        return list;
    }

    public ArrayList<SanPham> getListAn() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("From SanPham Where TrangThai Like 0");
        ArrayList<SanPham> list = (ArrayList<SanPham>) q.getResultList();
        return list;
    }

    public Boolean add(SanPham sp) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            check = (Integer) session.save(sp);
            transaction.commit();
            System.err.println("Ma San Pham " + check);
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
            SanPham cv = session.get(SanPham.class, id);
            cv.setTrangThai(0);
            transaction = session.beginTransaction();
            check = (Integer) session.save(cv);
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
            SanPham cv = session.get(SanPham.class, id);
            cv.setTrangThai(1);
            transaction = session.beginTransaction();
            check = (Integer) session.save(cv);
            transaction.commit();
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public Boolean update(SanPham sp, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            SanPham cv = session.get(SanPham.class, id);
            cv.setTensp(sp.getTensp());
            cv.setNgayTao(sp.getNgayTao());
            cv.setNgaySua(sp.getNgaySua());
            cv.setTrangThai(sp.getTrangThai());

            transaction = session.beginTransaction();
            session.update(cv);
            transaction.commit();

            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
