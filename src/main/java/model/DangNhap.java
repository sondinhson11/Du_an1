package model;

public class DangNhap {

    private String maNV;
    private int maCV;
    private String pass;

    public DangNhap() {
    }

    public DangNhap(String maNV, int maCV, String pass) {
        this.maNV = maNV;
        this.maCV = maCV;
        this.pass = pass;
    }

    public DangNhap(String maNV, String pass) {
        this.maNV = maNV;
        this.pass = pass;
    }
    

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getMaCV() {
        return maCV;
    }

    public void setMaCV(int maCV) {
        this.maCV = maCV;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
