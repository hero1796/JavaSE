/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.hungvu.footballleague;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author HungVu
 */
public class Round implements Serializable {
    private int id;
    private String name;
    private ArrayList<Match> listMatch;

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

    public ArrayList<Match> getListMatch() {
        return listMatch;
    }

    public void setListMatch(ArrayList<Match> listMatch) {
        this.listMatch = listMatch;
    }

    public Round(int id, String name, ArrayList<Match> listMatch) {
        this.id = id;
        this.name = name;
        this.listMatch = listMatch;
    }

    public Round(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Round{" + "id=" + id + ", name=" + name + ", listMatch=" + listMatch + '}';
    }
    
}
