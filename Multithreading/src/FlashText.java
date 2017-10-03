/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HungVu
 */
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.scene.control.*;

public class FlashText extends Application {
	private String text = "";

	@Override
	public void start(Stage stage) throws Exception {
		StackPane pane = new StackPane();
		Label lbtext = new Label("Hung Vu");
		pane.getChildren().addAll(lbtext);
		StackPane.setAlignment(lbtext, Pos.CENTER);
		Scene scene = new Scene(pane, 800, 600);
		stage.setTitle("Flash text");
		stage.setScene(scene);
		stage.show();
		System.out.println(pane.getChildren().size());

		new Thread(() -> {
			try {
				while (true) {
					if (lbtext.getText().trim().length() == 0)
						text = "Hung Vu";
					else
						text = "";
					Platform.runLater(() -> {
						lbtext.setText(text);
					});
					Thread.sleep(200);
				}
			} catch (InterruptedException e) {

			}
		}).start();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
