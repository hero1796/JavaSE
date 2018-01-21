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
public class Match implements Serializable {
    private int id;
    private Round round;
    private java.util.Date date;
    private Team homeTeam;
    private Team clientTeam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getClientTeam() {
        return clientTeam;
    }

    public void setClientTeam(Team clientTeam) {
        this.clientTeam = clientTeam;
    }

    public Match(int id, Round round, Date date, Team homeTeam, Team clientTeam) {
        this.id = id;
        this.round = round;
        this.date = date;
        this.homeTeam = homeTeam;
        this.clientTeam = clientTeam;
    }

    public Match(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Match{" + "id=" + id + ", round=" + round + ", date=" + date + ", homeTeam=" + homeTeam + ", clientTeam=" + clientTeam + '}';
    }
    
}
