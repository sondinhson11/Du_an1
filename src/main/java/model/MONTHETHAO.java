package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MONTHETHAO")
public class MONTHETHAO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAMTT")
    private Integer MAMTT;

    @Column(name = "TENMTT")
    private String TENMTT;

    @Column(name = "NGAYTAO")
    private Date NGAYTAO;

    @Column(name = "NGAYSUA")
    private Date NGAYSUA;

    @Column(name = "TRANGTHAI")
    private Integer TRANGTHAI;

    @OneToMany(mappedBy = "monTT", fetch = FetchType.LAZY)
    private List<CHITIETSANPHAM> listChiTiet;

    public Integer getMAMTT() {
        return MAMTT;
    }

    public void setMAMTT(Integer MAMTT) {
        this.MAMTT = MAMTT;
    }

    public String getTENMTT() {
        return TENMTT;
    }

    public void setTENMTT(String TENMTT) {
        this.TENMTT = TENMTT;
    }

    public Date getNGAYTAO() {
        return NGAYTAO;
    }

    public void setNGAYTAO(Date NGAYTAO) {
        this.NGAYTAO = NGAYTAO;
    }

    public Date getNGAYSUA() {
        return NGAYSUA;
    }

    public void setNGAYSUA(Date NGAYSUA) {
        this.NGAYSUA = NGAYSUA;
    }

    public Integer getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(Integer TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public List<CHITIETSANPHAM> getListChiTiet() {
        return listChiTiet;
    }

    public void setListChiTiet(List<CHITIETSANPHAM> listChiTiet) {
        this.listChiTiet = listChiTiet;
    }

    public MONTHETHAO() {
    }

    public MONTHETHAO(Integer MAMTT, String TENMTT, Date NGAYTAO, Date NGAYSUA, Integer TRANGTHAI, List<CHITIETSANPHAM> listChiTiet) {
        this.MAMTT = MAMTT;
        this.TENMTT = TENMTT;
        this.NGAYTAO = NGAYTAO;
        this.NGAYSUA = NGAYSUA;
        this.TRANGTHAI = TRANGTHAI;
        this.listChiTiet = listChiTiet;
    }

    @Override
    public String toString() {
        return TENMTT ;
    }

}
