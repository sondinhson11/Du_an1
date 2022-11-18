/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.ThongKe;
import repository.ThongKeRepository;
import service.ThongKeService;

/**
 *
 * @author thean
 */
public class ThongKeServiceImpl implements ThongKeService{
    private ThongKeRepository ThongKeRepository = new ThongKeRepository();
    @Override
    public ArrayList<ThongKe> getListThongKe() {
        return ThongKeRepository.getlist();
    }

    @Override
    public String addThongKe(ThongKe tk) {
        if (ThongKeRepository.add(tk)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String delete(int id) {
        if (ThongKeRepository.delete(id)) {
            return "Xoa Thành Công";
        } else {
            return "Xoa Thất Bại";
        }
    }

    @Override
    public String update(ThongKe tk, int id) {
        if (ThongKeRepository.update(tk, id)) {
            return "Sua Thành Công";
        } else {
            return "Sua Thất Bại";
        }
    }
    
}
