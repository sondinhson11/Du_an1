package service.impl;

import java.util.ArrayList;
import model.DoiTra;
import repository.DoiTraRepository;
import service.DoiTraService;

public class DoiTraImpl implements DoiTraService {

    private DoiTraRepository dtr;

    public DoiTraImpl() {
        this.dtr = new DoiTraRepository();
    }

    @Override
    public ArrayList<DoiTra> getList() {
        return this.dtr.getlist();
    }

    @Override
    public String add(DoiTra dt) {
        if (dtr.add(dt)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String update(DoiTra dt, int id) {
        if (dtr.update(dt,id)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String delete(int id) {
        if (dtr.delete(id)) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

}
