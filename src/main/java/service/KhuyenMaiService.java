
package service;

import java.util.ArrayList;
import model.KhuyenMai;

public interface KhuyenMaiService {
    ArrayList<KhuyenMai> getListKM();

    String add(KhuyenMai khuyenmai);

    String update(KhuyenMai khuyenmai, int id);

    String delete(int id);
}
