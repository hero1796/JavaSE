package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import ptit.hungvu.model.Student;

public class TCPServerController {

    private ServerSocket serverSocket;
    private Socket tcpSocket;
    private DAO dao;
    private String requestType;
    private ObjectInputStream in;
    private ObjectOutputStream out;
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

    public void openSocket(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listening() {
        try {
            tcpSocket = serverSocket.accept();
            System.out.println("connected");
            dao = new DAO();
            in = new ObjectInputStream(tcpSocket.getInputStream());
            out = new ObjectOutputStream(tcpSocket.getOutputStream());
            String typeRequest = "";
            try {
                typeRequest = (String) in.readObject();
                System.out.println("Type of request: " + typeRequest);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            if ("insert".equals(typeRequest)) {
                Student st = receiveStudent();
                if (dao.addStudent(st)) {
                    sendResult("Success!");
                } else {
                    sendResult("False!");
                }
            } else if("search".equals(typeRequest)) {
                String key = receiveString();
                ArrayList<Student> listStudent = dao.searchStudent(key);
                sendResult(listStudent);
                System.out.println("response done!");
            }
            dao.closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String receiveString() {
        String str = "";
        try {
            Object o = in.readObject();
            if(o instanceof String) {
                str = (String) o;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return "";
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return "";
        }
        return str;
    }
    
    public Student receiveStudent() {
        Student st = null;
        try {
            Object o = in.readObject();
            if (o instanceof Student) {
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

    public void sendResult(Object res) {
        try {
            out.writeObject(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
