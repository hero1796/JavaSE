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
public class Phong implements Serializable {
    private int ma;
    private String ten;
    private String moTa;
    private float donGia;

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
    
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public Phong() {
    }

    public Phong(int ma, String ten, String moTa, float donGia) {
        this.ma = ma;
        this.ten = ten;
        this.moTa = moTa;
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "Phong{" + "ma=" + ma + ", ten=" + ten + ", moTa=" + moTa + ", donGia=" + donGia + '}';
    }
    
    
}
