package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DangNhap;
import model.NhanVien;

public class DangNhapRepository {

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

    public DangNhap dangNhap(DangNhap dn) {
        try {
            Connection conn = getConnection();
            String sql = "Select * from userr where SoDienThoai = ? and Mk = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dn.getSdt());
            ps.setString(2, dn.getPass());
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String manv = rs.getString("SoDienThoai");
                int maCV = rs.getInt("MaCV");
                String pass = rs.getString("mk");
                return new DangNhap(manv, maCV, pass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DangNhap> check(String Sdt) {
        ArrayList<DangNhap> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String sql = "select * from userr where SoDienThoai = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Sdt);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String manv = rs.getString("SoDienThoai");
                int maCV = rs.getInt("MaCV");
                String pass = rs.getString("mk");
                list.add(new DangNhap(manv, maCV, pass));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(DangNhap dn) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO [dbo].[USERR]\n"
                    + "           ([SoDienThoai]\n"
                    + "           ,[MaCV]\n"
                    + "           ,[Mk])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dn.getSdt());
            ps.setInt(2, dn.getMaCV());
            ps.setString(3, dn.getPass());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NhanVien checkMa(String Sdt) {
        try {
            Connection conn = getConnection();
            String sql = "select SoDienThoai from NhanVien where SoDienThoai = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Sdt);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String manv = rs.getString("SoDienThoai");
                return new NhanVien();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(DangNhap dn) {
        try {
            Connection conn = getConnection();
            String sql = "    UPDATE [dbo].[USERR]\n"
                    + "   SET [Mk] = ?\n"
                    + " WHERE  [SoDienThoai] = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, dn.getSdt());
            ps.setString(1, dn.getPass());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public NhanVien checkChucVu(String Sdt){
        try {
            Connection conn = getConnection();
            String sql = "select maCv from NhanVien where SoDienThoai = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Sdt);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String maCva = rs.getString("maCv");
                return new NhanVien();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
