/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import ptit.hungvu.controller.DAO;
import ptit.hungvu.controller.SQLServerConn;
import ptit.hungvu.footballleague.Player;
import ptit.hungvu.footballleague.Team;

/**
 *
 * @author HungVu
 */
public class main {
    public static void main(String[] args) {
        DAO dao = new DAO();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dob = null;
        try {
            dob = df.parse("1996-1-4");
        } catch(ParseException ex) {
            ex.printStackTrace();
        }
        Team team2 = new Team(2);
        Player player4 = new Player(4, "Player 4", dob, 70.8f, 162.5f, team2);
        dao.addPlayer(player4);
        
    }
}
