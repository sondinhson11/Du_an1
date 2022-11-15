/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.LoaiSP;

/**
 *
 * @author vuong
 */
public interface LoaiSPServices {
    ArrayList<LoaiSP> getlist();

    String add(LoaiSP loaiSP);

    String delete(int id);

    String update(LoaiSP loaiSP, int id);
}
