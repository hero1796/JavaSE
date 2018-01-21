/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.net.Socket;
import ptit.hungvu.cardgame.ConnectionToServer;
import ptit.hungvu.cardgame.Delegate;

/**
 *
 * @author HungVu
 */
public class ConnectionForOneClient extends ConnectionToServer {

    private String playerName;
    private int playerId;

    public ConnectionForOneClient(Socket socket, Delegate delegate) {
        super(socket, delegate);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

}
