/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.hungvu.footballleague;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author HungVu
 */
public class Player implements Serializable {
    private int id;
    private String name;
    private java.util.Date dob;
    private float weight;
    private float height;
    private Team team;

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Player(int id, String name, Date dob, float weight, float height, Team team) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.weight = weight;
        this.height = height;
        this.team = team;
    }

    public Player(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", weight=" + weight + ", height=" + height + ", team=" + team + '}';
    }
    
}
