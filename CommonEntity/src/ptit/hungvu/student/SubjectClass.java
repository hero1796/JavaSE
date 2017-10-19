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
public class SubjectClass implements Serializable{
    private int id;
    private String name;
    private String learnTime;
    private String room;
    private int maxSlot;
    private Subject subject;

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

    public String getLearnTime() {
        return learnTime;
    }

    public void setLearnTime(String learnTime) {
        this.learnTime = learnTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getMaxSlot() {
        return maxSlot;
    }

    public void setMaxSlot(int maxSlot) {
        this.maxSlot = maxSlot;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public SubjectClass(int id) {
        this.id = id;
    }

    public SubjectClass(int id, String name, String learnTime, String room, int maxSlot, Subject subject) {
        this.id = id;
        this.name = name;
        this.learnTime = learnTime;
        this.room = room;
        this.maxSlot = maxSlot;
        this.subject = subject;
    }
    @Override
    public boolean equals(Object ob) {
        if (ob == null) {
            return false;
        }
        if (this == ob) {
            return true;
        }
        if (ob instanceof SubjectClass) {
            SubjectClass other = (SubjectClass) ob;
            return (this.id == other.getId());
        }
        return false;
    }
}
