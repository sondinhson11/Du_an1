package service.impl;

import java.util.ArrayList;
import model.KhachHang;
import repository.KhachHangRepository;

public class KhachHangImpl {
    public KhachHangRepository khrp ;
    public  KhachHangImpl(){
        this.khrp =  new KhachHangRepository();
    }
    public ArrayList<KhachHang> getListKhachHang() {
        return khrp.getList();
    }

    public String addKhachHang(KhachHang KhachHang) {
        if (khrp.add(KhachHang)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    public String updateKhachHang(KhachHang KhachHang, int id) {
        if (khrp.update(KhachHang, id)) {
            return "Sửa Thành Công";
        } else {
            return "Sửa Thất Bại";
        }
    }

    public String deleteKhachHang(int id) {
        if (khrp.delete(id)) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Thất Bại";
        }
    }
}
