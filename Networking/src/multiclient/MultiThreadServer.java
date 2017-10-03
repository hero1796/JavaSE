///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package multiclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.TextArea;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class MultiThreadServer extends Application {

	private ArrayList<ThreadForAClient> threads;
	private TextArea textArea;
	private int clientNo;
	private ServerSocket serverSocket;

	public MultiThreadServer() {
		textArea = new TextArea();
		clientNo = 0;
		threads = new ArrayList<>();
		new ArrayList<>();
	}

	@Override
	public void start(Stage stage) throws Exception {
		ScrollPane scrollPane = new ScrollPane(textArea);
		Scene scene = new Scene(scrollPane, 800, 600);
		scrollPane.setFitToWidth(true);
		scrollPane.setFitToHeight(true);
		stage.setTitle("Multi thread server");
		stage.setScene(scene);
		stage.show();
		new Thread(() -> {
			try {
				serverSocket = new ServerSocket(7899);
				Platform.runLater(() -> {
					textArea.appendText("Multi thread server started at: " + new Date());
				});
				while (true) {
					Socket socket = serverSocket.accept();
					clientNo++;
					Platform.runLater(() -> {
						textArea.appendText(
								"######Starting thread for client " + clientNo + " at " + new Date() + "\n");
					});
					InetAddress inet = socket.getInetAddress();

					textArea.appendText("Client " + clientNo + "'s host name is: " + inet.getHostName() + "\n");
					textArea.appendText("Client " + clientNo + "'s IP address is: " + inet.getHostAddress() + "\n");

					ThreadForAClient threadForAClient = new ThreadForAClient(socket);
					threadForAClient.setClientId(clientNo - 1);
					System.out.println("clientid= " + threadForAClient.getClientId());
					threadForAClient.start();
					threads.add(threadForAClient);
				}
			} catch (IOException ex) {
				System.err.print(ex);
			}
		}).start();
	}

	class ThreadForAClient extends Thread {

		private int clientId;

		public int getClientId() {
			return clientId;
		}

		public void setClientId(int clientId) {
			this.clientId = clientId;
		}

		public Socket getSocket() {
			return socket;
		}

		public void setSocket(Socket socket) {
			this.socket = socket;
		}

		private Socket socket;
		private DataInputStream in;
		private DataOutputStream out;

		public DataInputStream getIn() {
			return in;
		}

		public void setIn(DataInputStream in) {
			this.in = in;
		}

		public DataOutputStream getOut() {
			return out;
		}

		public void setOut(DataOutputStream out) {
			this.out = out;
		}

		public ThreadForAClient(Socket socket) throws IOException {
			this.socket = socket;
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		}

		@Override
		public void run() {
			try {
				while (true) {
					String line = in.readUTF();
					Platform.runLater(() -> {
						textArea.appendText(line);
					});
					for (ThreadForAClient thread : threads) {
						// if (thread.getClientId() == this.clientId) {
						// continue;
						// }
						thread.getOut().writeUTF(line);
					}
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
