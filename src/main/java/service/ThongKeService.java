/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.ThongKe;

/**
 *
 * @author thean
 */
public interface ThongKeService {
     ArrayList<ThongKe> getListThongKe();

    String addThongKe(ThongKe tk);

    String delete(int id);

    String update(ThongKe tk, int id);
}
