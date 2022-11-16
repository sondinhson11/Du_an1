package model;

public class DangNhap {

    private String Sdt;
    private int maCV;
    private String pass;

    public DangNhap() {
    }

    public DangNhap(String Sdt, int maCV, String pass) {
        this.Sdt = Sdt;
        this.maCV = maCV;
        this.pass = pass;
    }

    public DangNhap(String Sdt, String pass) {
        this.Sdt = Sdt;
        this.pass = pass;
    }
    

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
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
