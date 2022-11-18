/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.KhuyenMai;
import repository.KhuyenMaiRepository;
import service.KhuyenMaiService;

/**
 *
 * @author thean
 */
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    public KhuyenMaiRepository kmrp = new KhuyenMaiRepository();

    @Override
    public ArrayList<KhuyenMai> getListKM() {
        return kmrp.getList();
    }

    @Override
    public String add(KhuyenMai khuyenmai) {
        if (kmrp.add(khuyenmai)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KhuyenMai khuyenmai, int id) {
        if (kmrp.update(khuyenmai, id)) {
            return "Sua Thanh Cong";
        } else {
            return "Sua That Bai";
        }

    }

    @Override
    public String delete(int id) {
        if (kmrp.delete(id)) {
            return "xoa thành công";
        } else {
            return "xoa thất bại";
        }
    }

}
