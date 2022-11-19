/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.CHITIETSANPHAM;

/**
 *
 * @author vuong
 */
public interface CTSPServices {

    ArrayList<CHITIETSANPHAM> getAll();

    ArrayList<CHITIETSANPHAM> getAllAn();

    String add(CHITIETSANPHAM ctsp);

    String update(CHITIETSANPHAM ctsp, int id);

    String delete(int id);

    String hienThi(int id);

}
