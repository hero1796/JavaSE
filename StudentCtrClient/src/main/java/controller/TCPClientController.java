package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import ptit.hungvu.model.Student;

public class TCPClientController {
	private Socket tcpSocket;
	public Socket getTcpSocket() {
		return tcpSocket;
	}

	public void setTcpSocket(Socket tcpSocket) {
		this.tcpSocket = tcpSocket;
	}

	public TCPClientController() {
	}
	
	public void connect(int serverPort, String serverHost) {
		try {
			tcpSocket = new Socket(serverHost, serverPort);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean closeConnection() {
		try {
			tcpSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void sendStudent(Student st) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(tcpSocket.getOutputStream());
			System.out.println("bat dau nao");
			out.writeObject(st);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String receiveResult( ) {
		String res = null;
		try {
			ObjectInputStream in = new ObjectInputStream(tcpSocket.getInputStream());
			Object o = in.readObject();
			if(o instanceof String) {
				res = (String) o;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return res;
	}
}
