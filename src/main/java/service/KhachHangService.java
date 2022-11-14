package service;

import java.util.ArrayList;
import model.KhachHang;

public interface KhachHangService {
    
    ArrayList<KhachHang> getListKT();

    String add(KhachHang kichThuoc);

    String update(KhachHang kichThuoc, int id);

    String delete(int id);
}
