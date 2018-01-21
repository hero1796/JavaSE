/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javafx.util.Pair;
import ptit.hungvu.cardgame.Protocol;
import ptit.hungvu.cardgame.Delegate;

/**
 *
 * @author HungVu
 */
public class Server implements Runnable, Delegate {

    private ServerSocket serverSocket;
    private ArrayList<ConnectionForOneClient> connections;
    private boolean isListening = true;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting players connect to server...");
            while (true) {
                if (isListening) {
                    Socket socket = serverSocket.accept();
                    System.out.println("connected!");
                    ConnectionForOneClient connection = new ConnectionForOneClient(socket, this);
                    connection.send(new Pair(Protocol.S_PLAYER_NAME, null));
                } else {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void callBack(Object data, Object sender) {
        Pair dataReceived = (Pair) data;
        String key = (String) dataReceived.getKey();
        Object value = dataReceived.getValue();
        System.out.println(key);
        System.out.println(value);
        if(Protocol.C_PLAYER_NAME.equals(key)) {
            ConnectionForOneClient p = ((ConnectionForOneClient) sender);
            p.send(new Pair(Protocol.S_PLAYER_ID, connections.size()));
            Logic.sleep(1000);
            String PLS = "";

            for (NodeConnection Player : connectedNodes) {
                Player.Send("S_PCN" + connectedNodes.size() + "," + p.getPlayerName());
                PLS += Player.getPlayerIndex() + "," + Player.getPlayerName() + "-";
            }
            p.setPlayerIndex(connectedNodes.size());
            this.connectedNodes.add(p);
            if (connectedNodes.size() != 0) {
                p.Send("S_PLS" + PLS);
            }

            if (connectedNodes.size() == 4) {
                Logic.sleep(1000);
                sendToAll("S_TBC");
                this.listinegFlag = false;
                Logic.sleep(2000);
                ArrayList<ArrayList<CardData>> Cards = Logic.generatePlayersCardSets();

                for (int i = 0; i < 4; i++) {
                    ArrayList<CardData> clst = Cards.get(i);
                    String strCLst = Logic.SerializeCards(clst);
                    connectedNodes.get(i).Send("S_CLS" + strCLst);
                }

                Logic.sleep(1000);

                connectedNodes.get(tablehead).Send("S_STH");
                Logic.sleep(1000);

                this.gameModes.add(new Integer(5));

            }
        }
    }
}
