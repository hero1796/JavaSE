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
public class MuaHang implements Serializable {
    private int ma;
    private MatHang matHang;
    private HoaDon hoaDon;
    private int soLuongMua;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public MuaHang() {
    }

    public MuaHang(int ma, MatHang matHang, HoaDon hoaDon, int soLuongMua) {
        this.ma = ma;
        this.matHang = matHang;
        this.hoaDon = hoaDon;
        this.soLuongMua = soLuongMua;
    }

    @Override
    public String toString() {
        return "MuaHang{" + "ma=" + ma + ", matHang=" + matHang + ", hoaDon=" + hoaDon + ", soLuongMua=" + soLuongMua + '}';
    }
    
    
}
