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
public class Team implements Serializable {
    private int id;
    private String name;
    private String address;
    private String stadium;
    private ArrayList<Player> listPlayer;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public ArrayList<Player> getListPlayer() {
        return listPlayer;
    }

    public void setListPlayer(ArrayList<Player> listPlayer) {
        this.listPlayer = listPlayer;
    }

    public Team(int id, String name, String address, String stadium, ArrayList<Player> listPlayer) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.stadium = stadium;
        this.listPlayer = listPlayer;
    }

    public Team(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Team{" + "id=" + id + ", name=" + name + ", address=" + address + ", stadium=" + stadium + ", listPlayer=" + listPlayer + '}';
    }
    
}
