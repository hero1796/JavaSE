/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author HungVu
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import ptit.hungvu.student.Student;
import ptit.hungvu.student.Subject;
import ptit.hungvu.student.SubjectClass;

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
            if ("insertStudent".equals(typeRequest)) {
                Student st = receiveStudent();
                if (dao.addStudent(st)) {
                    sendResult("Success!");
                } else {
                    sendResult("False!");
                }
            } else if("searchStudent".equals(typeRequest)) {
                String key = receiveString();
                ArrayList<Student> listStudent = dao.searchStudent(key);
                sendResult(listStudent);
                System.out.println("response done!");
            } else if("searchSubject".equals(typeRequest)) {
                String key = receiveString();
                ArrayList<Subject> listStudent = dao.searchSubject(key);
                sendResult(listStudent);
                System.out.println("response done!");
            } else if("searchSubjectClass".equals(typeRequest)) {
                String key = receiveString();
                int i = Integer.parseInt(key);
                ArrayList<SubjectClass> listStudent = dao.searchSubjectClass(i);
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
