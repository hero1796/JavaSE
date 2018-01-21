/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.hungvu.karaoke;

import java.io.Serializable;

/**
 *
 * @author HungVu
 */
public class MatHang implements Serializable {
    private int ma;
    private String ten;
    private float gia;
    private String donVi;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public MatHang(int ma, String ten, float gia, String donVi) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.donVi = donVi;
    }

    @Override
    public String toString() {
        return "MatHang{" + "ma=" + ma + ", ten=" + ten + ", gia=" + gia + ", donVi=" + donVi + '}';
    }
    
    
}
