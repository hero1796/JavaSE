package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ptit.hungvu.model.Student;

public class TCPServerController {
	private ServerSocket serverSocket;
	private Socket tcpSocket;
	private DAO dao;

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	public Socket getTcpSocket() {
		return tcpSocket;
	}

	public void setTcpSocket(Socket tcpSocket) {
		this.tcpSocket = tcpSocket;
	}

	public TCPServerController() {
	}

	public void openServer(int serverPort) {
		try {
			serverSocket = new ServerSocket(serverPort);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listening() {
		try {
			tcpSocket = serverSocket.accept();
			System.out.println("da ket noi");
			dao = new DAO();
			Student st = receiveStudent();
			if(saveIntoDB(st)) sendResult("Success!");
			else sendResult("False!");
			dao.closeConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Student receiveStudent() {
		Student st = null;
		try {
			ObjectInputStream in = new ObjectInputStream(tcpSocket.getInputStream());
			Object o = in.readObject();
			if(o instanceof Student) {
				st = (Student) o;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return st;
	}
	
	public void sendResult(String res) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(tcpSocket.getOutputStream());
			out.writeObject(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean saveIntoDB(Student st) {
		if(dao.addStudent(st)) return true;
		else return false;
	}
}
