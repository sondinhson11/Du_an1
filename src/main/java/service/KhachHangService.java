package service;

import java.util.ArrayList;
import model.KhachHang;

public interface KhachHangService {
    
    ArrayList<KhachHang> getListKH();

    String add(KhachHang kh);

    String update(KhachHang kh, int id);

    String delete(int id);
    
    ArrayList<KhachHang> search(String ten);
}
