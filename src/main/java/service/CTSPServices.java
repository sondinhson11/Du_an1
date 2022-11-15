/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.ChiTietSanPham;

/**
 *
 * @author vuong
 */
public interface CTSPServices {

    ArrayList<ChiTietSanPham> getAll();

    String add(ChiTietSanPham ctsp);

    String update(ChiTietSanPham ctsp, int id);

    String delete(int id);
}
