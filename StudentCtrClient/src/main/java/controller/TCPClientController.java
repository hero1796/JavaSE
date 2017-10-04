package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import ptit.hungvu.model.Student;

public class TCPClientController {

    private Socket tcpSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

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
            out = new ObjectOutputStream(tcpSocket.getOutputStream());
            in = new ObjectInputStream(tcpSocket.getInputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Student> receiveSearchResul() {
        ArrayList<Student> listStudent = new ArrayList<Student>();
        try {
            listStudent = (ArrayList<Student>) in.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
        return listStudent;
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

    public void sendSearchKey(String key) {
        try {
            out.writeObject("search");
            out.writeObject(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void sendStudent(Student st) {
        try {
            out.writeObject("insert");
            out.writeObject(st);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Object receiveObject() {
        Object o = null;
        try {
            o = in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }
}
