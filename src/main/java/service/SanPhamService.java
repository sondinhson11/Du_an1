package service;

import java.util.ArrayList;
import model.SanPham;

public interface SanPhamService {

    ArrayList<SanPham> getListSanPham();
    
   ArrayList<SanPham> getListSanPhamAn();

    String addSanPham(SanPham sp);

    String delete(int id);
    
    String hienThi(int id);

    String update(SanPham sp, int id);
}
