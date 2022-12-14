package ConfigHibernate;

import java.util.Properties;
import model.CHATLIEU;
import model.ChucVu;
import model.CLB;
import model.CHITIETSANPHAM;
import model.DoiTra;
import model.HINHTHUCTHANHTOAN;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.KICHTHUOC;
import model.KhachHang;
import model.KhuyenMai;
import model.LoaiSP;
import model.MONTHETHAO;
import model.MauSac;
import model.NhanVien;
import model.SanPham;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfig {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=DuAn1_QuanLyBanQuanAo");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(KhuyenMai.class);
        conf.addAnnotatedClass(CLB.class);
        conf.addAnnotatedClass(MONTHETHAO.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(KICHTHUOC.class);
        conf.addAnnotatedClass(CHATLIEU.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(HINHTHUCTHANHTOAN.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(CHITIETSANPHAM.class);
        conf.addAnnotatedClass(LoaiSP.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(DoiTra.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }

}
