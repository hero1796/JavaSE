/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author HungVu
 */
public class Client extends Application {

	private TextArea textArea;
	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;

	public Client() {
		textArea = new TextArea();
		in = null;
		out = null;
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane paneForTextField = new BorderPane();
		paneForTextField.setPadding(new Insets(5, 5, 5, 5));
		paneForTextField.setLeft(new Label("Enter radius: "));
		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		paneForTextField.setCenter(tf);
		ScrollPane scroll = new ScrollPane(textArea);
		scroll.setFitToWidth(true);
		scroll.setFitToHeight(true);
		BorderPane mainPane = new BorderPane();
		mainPane.setCenter(scroll);
		mainPane.setTop(paneForTextField);
		Scene scene = new Scene(mainPane, 500, 300);
		stage.setTitle("Client");
		stage.setScene(scene);
		stage.show();
		try {
			socket = new Socket("localhost", 7899);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		tf.setOnAction((ActionEvent t) -> {
			try {
				String message = tf.getText();
				out.writeUTF(message);
				out.flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
		new Thread(() -> {
			try {
				while (true) {
					String line = in.readUTF();
					Platform.runLater(() -> {
						textArea.appendText(line);
					});
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}).start();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
