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
public class ThuePhong implements Serializable {
    private int ma;
    private Phong phong;
    private KhachHang khach;
    private Date thoiGianVao;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public KhachHang getKhach() {
        return khach;
    }

    public void setKhach(KhachHang khach) {
        this.khach = khach;
    }

    public Date getThoiGianVao() {
        return thoiGianVao;
    }

    public void setThoiGianVao(Date thoiGianVao) {
        this.thoiGianVao = thoiGianVao;
    }

    public ThuePhong() {
    }

    public ThuePhong(int ma, Phong phong, KhachHang khach, Date thoiGianVao) {
        this.ma = ma;
        this.phong = phong;
        this.khach = khach;
        this.thoiGianVao = thoiGianVao;
    }

    @Override
    public String toString() {
        return "ThuePhong{" + "ma=" + ma + ", phong=" + phong + ", khach=" + khach + ", thoiGianVao=" + thoiGianVao + '}';
    }
    
    
}
