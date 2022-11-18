/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.NhanVien;
import repository.NhanVienRepository;
import service.NhanVienServices;

/**
 *
 * @author duong
 */
public class NhanVienServiceimpl implements NhanVienServices{
    public  NhanVienRepository Nvrp = new NhanVienRepository();

    @Override
    public ArrayList<NhanVien> getlistNhanVien() {
       return Nvrp.getList();
    }

    @Override
    public String addNhanVien(NhanVien nv) {
          if (Nvrp.add(nv)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String delete(int id) {
          if (Nvrp.delete(id)) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Thất Bại";
        }
    }

    @Override
    public String Update(NhanVien nv, int id) {
          if (Nvrp.update(nv, id)) {
            return "Sửa Thành Công";
        } else {
            return "Sửa Thất Bại";
        }
    }
    
}
