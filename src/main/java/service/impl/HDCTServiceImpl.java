/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.HoaDonChiTiet;
import repository.HoaDonChiTietRepository;
import service.HDCTservice;

/**
 *
 * @author thean
 */
public class HDCTServiceImpl implements HDCTservice{
    private HoaDonChiTietRepository hdctrp = new HoaDonChiTietRepository();
    @Override
    public ArrayList<HoaDonChiTiet> getListHDCT() {
        return hdctrp.getList();
    }

    @Override
    public String addSanPham(HoaDonChiTiet hct) {
        if (hdctrp.add(hct)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String delete(int id) {
        if (hdctrp.delete(id)) {
            return "delete Thành Công";
        } else {
            return "delete Thất Bại";
        }

    }

    @Override
    public String update(HoaDonChiTiet hct, int id) {
        if (hdctrp.update(hct, id)) {
            return "update Thành Công";
        } else {
            return "update Thất Bại";
        }
    }
    
}
