package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import ptit.hungvu.karaoke.Phong;

public interface RMIInterface extends Remote {
	public boolean checkLogin(Phong user) throws RemoteException;
}
