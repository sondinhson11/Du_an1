/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.HoaDon;
import repository.HoaDonRepository;
import service.HoaDonService;

/**
 *
 * @author thean
 */
public class HoaDonServiceImpl implements HoaDonService {

    private HoaDonRepository hdrp = new HoaDonRepository();

    @Override
    public ArrayList<HoaDon> getAll() {
        return hdrp.getList();
    }

    @Override
    public String add(HoaDon hd) {
        if (hdrp.add(hd)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String update(HoaDon hoaDon, int id) {
        if (hdrp.update(hoaDon, id)) {
            return "update Thành Công";
        } else {
            return "update Thất Bại";
        }
    }

    @Override
    public String delete(int id) {
        if (hdrp.delete(id)) {
            return "delete Thành Công";
        } else {
            return "delete Thất Bại";
        }

    }
}
