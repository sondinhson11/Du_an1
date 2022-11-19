/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.HoaDonChiTiet;

/**
 *
 * @author thean
 */
public interface HDCTservice {
    ArrayList<HoaDonChiTiet> getListHDCT();
 

    String addSanPham(HoaDonChiTiet hct);

    String delete(int id);
    
   

    String update(HoaDonChiTiet hct, int id);
}
