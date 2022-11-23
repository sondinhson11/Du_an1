/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.HoaDon;

/**
 *
 * @author thean
 */
public interface HoaDonService {
    ArrayList<HoaDon> getAll();

    String add(HoaDon hd);

    String update(HoaDon hoaDon, int id);

    String delete(int id);
    
    String updateKH(HoaDon hoaDon, int id);
}
