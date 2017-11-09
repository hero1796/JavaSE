package controller;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import ptit.hungvu.karaoke.Phong;

public class RMIClientController {
	private String serverHost = "localhost";
	private int serverPort = 1796;
	private RMIInterface rmiServer;
	private String rmiService = "rmiLoginxxx";
	private Registry registry;
	public String getServerHost() {
		return serverHost;
	}
	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}
	public int getServerPort() {
		return serverPort;
	}
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	public RMIInterface getRmiServer() {
		return rmiServer;
	}
	public void setRmiServer(RMIInterface rmiServer) {
		this.rmiServer = rmiServer;
	}
	public String getRmiService() {
		return rmiService;
	}
	public void setRmiService(String rmiService) {
		this.rmiService = rmiService;
	}
	public Registry getRegistry() {
		return registry;
	}
	public void setRegistry(Registry registry) {
		this.registry = registry;
	}
	public RMIClientController() {
		try {
			registry = LocateRegistry.getRegistry(serverHost, serverPort);
			rmiServer = (RMIInterface) registry.lookup(rmiService);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}	
	}
	
	public boolean remoteCheckLogin(Phong user) throws RemoteException {
		boolean res = false;
                res = rmiServer.checkLogin(user);
		return res;
	}
}
