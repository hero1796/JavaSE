/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.TCPServerController;

/**
 *
 * @author HungVu
 */
public class MainServer {

	public static void main(String[] args) {
		TCPServerController tcpServer = new TCPServerController();
		tcpServer.openSocket(1796);
		while(true) {
			tcpServer.listening();
		}
	}
}
