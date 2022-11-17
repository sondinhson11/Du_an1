/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.CHITIETSANPHAM;
import repository.CTTSPRepository;
import service.CTSPServices;

/**
 *
 * @author vuong
 */
public class CTSPServicesImpl implements CTSPServices {

    private CTTSPRepository ctspR = new CTTSPRepository();

    @Override
    public ArrayList<CHITIETSANPHAM> getAll() {
        return ctspR.getList();
    }

    @Override
    public String add(CHITIETSANPHAM ctsp) {
        if (ctspR.add(ctsp)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String update(CHITIETSANPHAM ctsp, int id) {
        if (ctspR.update(ctsp, id)) {
            return "update Thành Công";
        } else {
            return "update Thất Bại";
        }

    }

    @Override
    public String delete(int id) {
        if (ctspR.delete(id)) {
            return "delete Thành Công";
        } else {
            return "delete Thất Bại";
        }
    }

}
