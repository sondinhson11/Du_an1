/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import ConfigHibernate.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.LoaiSP;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vuong
 */
public class LoaiSPRepository {

    Session session = HibernateConfig.getFACTORY().openSession();

    public ArrayList<LoaiSP> getlist() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("From LoaiSP");
        ArrayList<LoaiSP> list = (ArrayList<LoaiSP>) q.getResultList();
        return list;
    }

    public Boolean add(LoaiSP loaiSP) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            check = (Integer) session.save(loaiSP);
            transaction.commit();
            System.err.println("Ma LoaiSP " + check);
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public Boolean update(LoaiSP loaiSP, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            LoaiSP lsp = session.get(LoaiSP.class, id);

            lsp.setTenLoai(loaiSP.getTenLoai());
            lsp.setNgayTao(loaiSP.getNgayTao());
            lsp.setNgaySua(loaiSP.getNgaySua());
            lsp.setTrangThai(loaiSP.getTrangThai());
            transaction = session.beginTransaction();
            session.update(lsp);
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
            LoaiSP lsp = session.get(LoaiSP.class, id);
            transaction = session.beginTransaction();
            session.delete(lsp);
            transaction.commit();
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
