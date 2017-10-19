/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.hungvu.student;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author HungVu
 */
public class Subject implements Serializable{
    private int id;
    private String name;
    private int numTinChi;
    private ArrayList<SubjectClass> listClass;

    public Subject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumTinChi() {
        return numTinChi;
    }

    public void setNumTinChi(int numTinChi) {
        this.numTinChi = numTinChi;
    }

    public ArrayList<SubjectClass> getListClass() {
        return listClass;
    }

    public void setListClass(ArrayList<SubjectClass> listClass) {
        this.listClass = listClass;
    }

    public Subject(int id, String name, int numTinChi, ArrayList<SubjectClass> listClass) {
        this.id = id;
        this.name = name;
        this.numTinChi = numTinChi;
        this.listClass = listClass;
    }
    @Override
    public boolean equals(Object ob) {
        if (ob == null) {
            return false;
        }
        if (this == ob) {
            return true;
        }
        if (ob instanceof Subject) {
            Subject other = (Subject) ob;
            return (this.id == other.getId());
        }
        return false;
    }

}
