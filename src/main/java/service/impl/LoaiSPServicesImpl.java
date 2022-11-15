/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.LoaiSP;
import repository.LoaiSPRepository;
import service.LoaiSPServices;

/**
 *
 * @author vuong
 */
public class LoaiSPServicesImpl implements LoaiSPServices {

    private LoaiSPRepository LoaiSPRepo = new LoaiSPRepository();

    @Override
    public ArrayList<LoaiSP> getlist() {
        return LoaiSPRepo.getlist();
    }

    @Override
    public String delete(int id) {
        if (LoaiSPRepo.delete(id)) {
            return "delete Thành Công";
        } else {
            return "delete Thất Bại";
        }
    }

    @Override
    public String update(LoaiSP loaiSP, int id) {
        if (LoaiSPRepo.update(loaiSP, id)) {
            return "update Thành Công";
        } else {
            return "update Thất Bại";
        }
    }

    @Override
    public String add(LoaiSP loaiSP) {
        if (LoaiSPRepo.add(loaiSP)) {
            return "add Thành Công";
        } else {
            return "add Thất Bại";
        }
    }

}
