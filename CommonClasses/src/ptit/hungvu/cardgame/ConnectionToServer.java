/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.hungvu.cardgame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author HungVu
 */
public class ConnectionToServer implements Sender {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Delegate delegate;
    private boolean isSending = false;
    private Object data;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }

    public Delegate getDelegate() {
        return delegate;
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    public boolean isIsSending() {
        return isSending;
    }

    public void setIsSending(boolean isSending) {
        this.isSending = isSending;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ConnectionToServer() {
    }

    public ConnectionToServer(Socket socket, Delegate delegate) {
        this.delegate = delegate;
        try {
            this.socket = socket;
            out = new ObjectOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        if (isSending) {
                            System.out.println("sending " + data.toString());
                            out.writeObject(data);
                            out.flush();
                            isSending = false;
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }).start();
            in = new ObjectInputStream(socket.getInputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        try {
                            Object data = in.readObject();
                            delegate.callBack(data, this);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }).start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void send(Object data) {
        this.data = data;
        isSending = true;
    }
}
