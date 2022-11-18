/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.NhanVien;

/**
 *
 * @author duong
 */
public interface NhanVienServices {
    ArrayList<NhanVien> getlistNhanVien();
    String addNhanVien(NhanVien nv);
    String delete(int id);
    String Update(NhanVien nv ,int id);
    
}
