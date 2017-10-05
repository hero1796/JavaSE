package ptit.hungvu.student;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private Date dOb;
    private String address;

    public Student(int id, String name, Date dOb, String address) {
        this.id = id;
        this.name = name;
        this.dOb = dOb;
        this.address = address;
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

    public Date getdOb() {
        return dOb;
    }

    public void setdOb(Date dOb) {
        this.dOb = dOb;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
