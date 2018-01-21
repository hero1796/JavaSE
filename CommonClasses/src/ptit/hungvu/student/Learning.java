/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.hungvu.student;

import java.io.Serializable;

/**
 *
 * @author HungVu
 */
public class Learning implements Serializable{
    private Student st;
    private Subject subj;
    private SubjectClass subjClass;
    private int ccPoint;
    private int tbktPoint;
    private int btlPoint;

    public Learning(Student st, Subject subj, SubjectClass subjClass, int ccPoint, int tbktPoint, int btlPoint) {
        this.st = st;
        this.subj = subj;
        this.subjClass = subjClass;
        this.ccPoint = ccPoint;
        this.tbktPoint = tbktPoint;
        this.btlPoint = btlPoint;
    }

    public Student getSt() {
        return st;
    }

    public void setSt(Student st) {
        this.st = st;
    }

    public Subject getSubj() {
        return subj;
    }

    public void setSubj(Subject subj) {
        this.subj = subj;
    }

    public SubjectClass getSubjClass() {
        return subjClass;
    }

    public void setSubjClass(SubjectClass subjClass) {
        this.subjClass = subjClass;
    }

    public int getCcPoint() {
        return ccPoint;
    }

    public void setCcPoint(int ccPoint) {
        this.ccPoint = ccPoint;
    }

    public int getTbktPoint() {
        return tbktPoint;
    }

    public void setTbktPoint(int tbktPoint) {
        this.tbktPoint = tbktPoint;
    }

    public int getBtlPoint() {
        return btlPoint;
    }

    public void setBtlPoint(int btlPoint) {
        this.btlPoint = btlPoint;
    }
    @Override
    public boolean equals(Object ob) {
        if (ob == null) {
            return false;
        }
        if (this == ob) {
            return true;
        }
        if (ob instanceof Learning) {
            Learning ot = (Learning) ob;
            return (st.getId() == ot.st.getId()
                    && subj.getId() == ot.subj.getId()
                    && subjClass.getId() == ot.subjClass.getId());
        }
        return false;
    }
}
