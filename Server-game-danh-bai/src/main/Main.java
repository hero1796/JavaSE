/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author HungVu
 */
public class Main {
    public static void main(String[] args) {
        Server gameServer = new Server(1796);
        Thread serverThread = new Thread(gameServer);
        serverThread.start();
    }
}
