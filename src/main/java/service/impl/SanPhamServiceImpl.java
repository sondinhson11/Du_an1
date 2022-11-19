package service.impl;

import java.util.ArrayList;
import model.SanPham;
import repository.SanPhamRepository;
import service.SanPhamService;

public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository sanphamRepository = new SanPhamRepository();

    @Override
    public ArrayList<SanPham> getListSanPham() {
        return sanphamRepository.getList();
    }

    @Override
    public ArrayList<SanPham> getListSanPhamAn() {
        return sanphamRepository.getListAn();
    }

    @Override
    public String addSanPham(SanPham sp) {
        if (sanphamRepository.add(sp)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String delete(int id) {
        if (sanphamRepository.delete(id)) {
            return "Ẩn Thành Công";
        } else {
            return "Ẩn Thất Bại";
        }
    }

    @Override
    public String hienThi(int id) {
        if (sanphamRepository.hienThi(id)) {
            return "Hiển Thị Thành Công";
        } else {
            return "Hiển Thị Thất Bại";
        }
    }

    @Override
    public String update(SanPham sp, int id) {
        if (sanphamRepository.update(sp, id)) {
            return "Sua Thành Công";
        } else {
            return "Sua Thất Bại";
        }
    }
}
