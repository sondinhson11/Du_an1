/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import ConfigHibernate.HibernateConfig;
import org.hibernate.Session;

import java.util.ArrayList;
import javax.persistence.Query;
import model.HoaDonChiTiet;

import org.hibernate.Transaction;

/**
 *
 * @author thean
 */
public class HoaDonChiTietRepository {

    Session session = HibernateConfig.getFACTORY().openSession();
public ArrayList<HoaDonChiTiet> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("From HoaDonChiTiet");
        ArrayList<HoaDonChiTiet> list = (ArrayList<HoaDonChiTiet>) q.getResultList();
        return list;
    }
public Boolean add(HoaDonChiTiet hct) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            check = (Integer) session.save(hct);
            transaction.commit();
            System.err.println("Ma " + check);
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
public Boolean update(HoaDonChiTiet hct, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            HoaDonChiTiet hdct = session.get(HoaDonChiTiet.class, id);
            hdct.setMaHDCT(hct.getMaHDCT());
            hdct.setHoaDon(hct.getHoaDon());
            hdct.setChitietsanpham(hct.getChitietsanpham());
            hdct.setSoluong(hct.getSoluong());
            hdct.setGiamgia(hct.getGiamgia());
            hdct.setThanhTien(hct.getThanhTien());
            hdct.setGhiChu(hct.getGhiChu());
            hdct.setNgayTao(hct.getNgayTao());
            hdct.setNgaySua(hct.getNgaySua());
            hdct.setTrangThai(hct.getTrangThai());
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
            HoaDonChiTiet hdct = session.get(HoaDonChiTiet.class, id);
            transaction = session.beginTransaction();
            session.delete(id);
            transaction.commit();
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
