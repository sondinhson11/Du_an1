package service.impl;

import java.util.ArrayList;
import model.KhachHang;
import repository.KhachHangRepository;
import service.KhachHangService;

public class KhachHangImpl implements KhachHangService {

    public KhachHangRepository khrp = new KhachHangRepository();

    public KhachHangImpl() {
        this.khrp = new KhachHangRepository();
    }

    @Override
    public ArrayList<KhachHang> getListKH() {
        return khrp.getList();
    }

    @Override
    public String add(KhachHang khachhang) {
        if (khrp.add(khachhang)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String update(KhachHang khachhang, int id) {
        if (khrp.update(khachhang, id)) {
            return "Sửa Thành Công";
        } else {
            return "Sửa Thất Bại";
        }
    }

    @Override
    public String delete(int id) {
        if (khrp.delete(id)) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Thất Bại";
        }
    }

    @Override
    public ArrayList<KhachHang> search(String ten) {
        return this.khrp.Search(ten);
    }
}
