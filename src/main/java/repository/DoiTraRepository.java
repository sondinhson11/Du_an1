package repository;

import ConfigHibernate.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.DoiTra;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DoiTraRepository {
    
    Session session = HibernateConfig.getFACTORY().openSession();

    public ArrayList<DoiTra> getlist() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("From DoiTra");
        ArrayList<DoiTra> list = (ArrayList<DoiTra>) q.getResultList();
        return list;
        
    }

    public Boolean add(DoiTra dt) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            check = (Integer) session.save(dt);
            transaction.commit();
            System.err.println("Ma Doi Tra" + check);
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
            DoiTra tk = session.get(DoiTra.class, id);
            transaction = session.beginTransaction();
            session.delete(tk);
            transaction.commit();
            return check > 0;
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public Boolean update(DoiTra dt, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            DoiTra dtt = session.get(DoiTra.class, id);
            dtt.setMaCTSP(dt.getMaCTSP());
            dtt.setMaHDCT(dt.getMaHDCT());
            dtt.setLydo(dt.getLydo());
            dtt.setNgayDoi(dt.getNgayDoi());
            dtt.setNgayBan(dt.getNgayBan());
            dtt.setTrangThai(dt.getTrangThai());
            transaction = session.beginTransaction();
            session.update(dtt);
            transaction.commit();
            
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
