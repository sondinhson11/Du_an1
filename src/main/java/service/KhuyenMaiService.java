/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.KhuyenMai;

/**
 *
 * @author thean
 */
public interface KhuyenMaiService {
    ArrayList<KhuyenMai> getListKM();

    String add(KhuyenMai khuyenmai);

    String update(KhuyenMai khuyenmai, int id);

    String delete(int id);
}
