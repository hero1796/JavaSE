package main;

import controller.TCPServerController;

public class MainServer {

	public static void main(String[] args) {
		TCPServerController tcpServer = new TCPServerController();
		tcpServer.openServer(1796);
		while(true) {
			tcpServer.listening();
		}
	}

}