/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.hungvu.karaoke;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author HungVu
 */
public class HoaDon implements Serializable {
    private int ma;
    private ThuePhong thuePhong;
    private Date thoiGianThu;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public ThuePhong getThuePhong() {
        return thuePhong;
    }

    public void setThuePhong(ThuePhong thuePhong) {
        this.thuePhong = thuePhong;
    }

    public Date getThoiGianThu() {
        return thoiGianThu;
    }

    public void setThoiGianThu(Date thoiGianThu) {
        this.thoiGianThu = thoiGianThu;
    }

    
    
    public HoaDon(int ma, ThuePhong thuePhong, Date thoiGianThu) {
        this.ma = ma;
        this.thuePhong = thuePhong;
        this.thoiGianThu = thoiGianThu;
    }

    public HoaDon() {
    }

    @Override
    public String toString() {
        return "HoaDon{" + "ma=" + ma + ", thuePhong=" + thuePhong + ", thoiGianThu=" + thoiGianThu + '}';
    }
    
}
