package service;

import java.util.ArrayList;
import model.DoiTra;

public interface DoiTraService {
    ArrayList<DoiTra> getList();

    String add(DoiTra dt);

    String update(DoiTra dt, int id);

    String delete(int id);
}
