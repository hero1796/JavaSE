package main;

import java.rmi.RemoteException;

import controller.RMIServerController;
import view.RMIServerFrm;

public class ServerRun {

    public static void main(String[] args) {
        try {
            RMIServerController rmiServer = new RMIServerController();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        RMIServerFrm serverFrm = new RMIServerFrm();
        serverFrm.setVisible(true);
    }

}
