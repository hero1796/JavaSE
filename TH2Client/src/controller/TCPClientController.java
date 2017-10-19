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
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import ptit.hungvu.student.Student;
import ptit.hungvu.student.Subject;
import ptit.hungvu.student.SubjectClass;

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
    
    public ArrayList<Student> receiveSearchStudentResult() {
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
    
    public ArrayList<Subject> receiveSearchSubjectResult() {
        ArrayList<Subject> listStudent = new ArrayList<Subject>();
        try {
            listStudent = (ArrayList<Subject>) in.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
        return listStudent;
    }
    
        public ArrayList<SubjectClass> receiveSearchSubjectClassResult() {
        ArrayList<SubjectClass> listStudent = new ArrayList<SubjectClass>();
        try {
            listStudent = (ArrayList<SubjectClass>) in.readObject();
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

    public void sendSearchKeyStudent(String key) {
        try {
            out.writeObject("searchStudent");
            out.writeObject(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void sendSearchKeySubject(String key) {
        try {
            out.writeObject("searchSubject");
            out.writeObject(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void sendSearchKeySubjectClass(String key) {
        try {
            out.writeObject("searchSubjectClass");
            out.writeObject(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void sendStudent(Student st) {
        try {
            out.writeObject("insertStudent");
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

    public void sendSearchKeySubjectClass(int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
