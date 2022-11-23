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

    public Boolean add(KhachHang khachhang) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            check = (Integer) session.save(khachhang);
            transaction.commit();
            System.err.println("Ma Hoa Don " + check);
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public Boolean update(KhachHang khachhang, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            KhachHang kh = session.get(KhachHang.class, id);
            kh.setTen(khachhang.getTen());
            kh.setNgaySinh(khachhang.getNgaySinh());
            kh.setGioiTinh(khachhang.getGioiTinh());
            kh.setDiaChi(khachhang.getDiaChi());
            kh.setSoDienThoai(khachhang.getSoDienThoai());
            kh.setNgayTao(khachhang.getNgayTao());
            kh.setNgaySua(khachhang.getNgaySua());
            kh.setTrangThai(khachhang.getTrangThai());
            transaction = session.beginTransaction();
            check = (Integer) session.save(kh);
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
            KhachHang kh = session.get(KhachHang.class, id);
            transaction = session.beginTransaction();
            session.delete(kh);
            transaction.commit();
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    public ArrayList<KhachHang> Search(String ten) {
        session = HibernateConfig.getFACTORY().openSession();
        String tenn = "%"+ten+"%";
        Query q = session.createQuery("From KhachHang where tenKH like : ten or diaChi like : ten or soDienThoai like : ten");
        q.setParameter("ten", tenn);
        ArrayList<KhachHang> list = (ArrayList<KhachHang>) q.getResultList();
        return list;
    }
}
