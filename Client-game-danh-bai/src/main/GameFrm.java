/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.Socket;
import javafx.util.Pair;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ptit.hungvu.cardgame.Card;
import ptit.hungvu.cardgame.ConnectionToServer;
import ptit.hungvu.cardgame.Delegate;
import ptit.hungvu.cardgame.Protocol;

/**
 *
 * @author HungVu
 */
public class GameFrm extends JFrame implements Delegate {

    private ConnectionToServer connection;
    private String playerName;
    private String playerId;
    private JPanel gamePanel;
    private JPanel currentCardsPanel;
    private JPanel hitCardsPanel;
    private JPanel listPlayersPanel;

    public GameFrm(String serverAddress, int serverport, String playerName) {
        initComponents();
        init();
        currentCardsPanel.add(new Card(2, 5));
        hitCardsPanel.add(new Card(1, 13));
        try {
            Socket socket = new Socket(serverAddress, serverport);
            connection = new ConnectionToServer(socket, this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.playerName = playerName;
    }

    @Override
    public void callBack(Object data, Object sender) {
        Pair dataReceived = (Pair) data;
        String key = (String) dataReceived.getKey();
        Object value = dataReceived.getValue();
        System.out.println(key);
        System.out.println(value);
        if (Protocol.S_PLAYER_NAME.equals(key)) {
            connection.send(new Pair(Protocol.C_PLAYER_NAME, this.playerName));
        }
    }

    public void init() {
        gamePanel = new JPanel(new BorderLayout(5, 5));
        currentCardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 10));
        hitCardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        gamePanel.add(currentCardsPanel, BorderLayout.SOUTH);
        gamePanel.add(hitCardsPanel, BorderLayout.CENTER);
        listPlayersPanel = new JPanel(new GridLayout(20, 1));
        this.add(listPlayersPanel, BorderLayout.WEST);
        this.add(gamePanel, BorderLayout.CENTER);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
