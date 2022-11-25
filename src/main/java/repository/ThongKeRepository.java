/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import ConfigHibernate.HibernateConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.persistence.Query;
import model.SanPham;
import model.ThongKe;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thean
 */
public class ThongKeRepository {
    String instance = "";
    String serverName = "localhost";
    String portNumber = "1433";
    String dbName = "DuAn1_QuanLyBanQuanAo";
    String userID = "sa";
    String password = "123456";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    Session session = HibernateConfig.getFACTORY().openSession();

    public ArrayList<ThongKe> getlist() {
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("From ThongKe");
        ArrayList<ThongKe> list = (ArrayList<ThongKe>) q.getResultList();
        return list;   
    }

    public Boolean add(ThongKe tk) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            check = (Integer) session.save(tk);
            transaction.commit();
            System.err.println("Ma Thong Ke" + check);
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
            ThongKe tk = session.get(ThongKe.class, id);
            transaction = session.beginTransaction();
            session.delete(tk);
            transaction.commit();
            return check > 0;
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public Boolean update(ThongKe tk, int id) {
        Transaction transaction = null;
        Integer check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            ThongKe tk1 = session.get(ThongKe.class, id);
            tk1.setMaHDCT(tk.getMaHDCT());
            tk1.setMaDT(tk.getMaDT());
            tk1.setMonney(tk.getMonney());
            tk1.setNgayban(tk.getNgayban());
            tk1.setTrangThai(tk.getTrangThai());
            transaction = session.beginTransaction();
            session.update(tk1);
            transaction.commit();
            
            return check > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    public int TongDH(){
        try{
           Connection conn = getConnection();
           String sql = "select count(maTK) as tong from thongKe";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int tondh = rs.getInt("tong");
                return tondh;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
