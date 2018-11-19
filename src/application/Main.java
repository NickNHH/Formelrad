package application;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * Formula wheel Application
 * @author Peter Rutschmann
 * @version 22.10.2018
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();

			// Creating an image
			Image image = new Image(new FileInputStream("bin\\application\\formelradelektronik.gif"));
			ImageView imageView = new ImageView(image);
			imageView.setX(10);
			imageView.setY(10);
			imageView.setFitHeight(300);
			imageView.setFitWidth(300);
			imageView.setPreserveRatio(true);
			root.getChildren().add(imageView);

			Label lbPower = new Label("Leistung:");
			lbPower.relocate(10, 285);
			lbPower.setFont(Font.font(15));
			root.getChildren().add(lbPower);

			TextField tfPower = new TextField();
			tfPower.relocate(100, 285);
			tfPower.setFont(Font.font("Verdana", 15));
			tfPower.setStyle("-fx-text-fill: red;");
			root.getChildren().add(tfPower);

			Label lbTension = new Label("Spannung:");
			lbTension.relocate(10, 325);
			lbTension.setFont(Font.font(15));
			root.getChildren().add(lbTension);

			TextField tfTension = new TextField();
			tfTension.relocate(100, 325);
			tfTension.setFont(Font.font("Verdana", 15));
			tfPower.setStyle("-fx-text-fill: red;");
			root.getChildren().add(tfTension);

			Label lbCurrent = new Label("Strom:");
			lbCurrent.relocate(10, 365);
			lbCurrent.setFont(Font.font(15));
			root.getChildren().add(lbCurrent);

			TextField tfCurrent = new TextField();
			tfCurrent.relocate(100, 365);
			tfCurrent.setFont(Font.font("Verdana", 15));
			tfPower.setStyle("-fx-text-fill: red;");
			root.getChildren().add(tfCurrent);

			Label lbResistance = new Label("Widerstand:");
			lbResistance.relocate(10, 405);
			lbResistance.setFont(Font.font(15));
			root.getChildren().add(lbResistance);

			TextField tfResistance = new TextField();
			tfResistance.relocate(100, 405);
			tfResistance.setFont(Font.font("Verdana", 15));
			tfPower.setStyle("-fx-text-fill: red;");
			root.getChildren().add(tfResistance);

			Button btCalculate = new Button();
			btCalculate.relocate(100, 445);
			btCalculate.setText("Berechnen");
			root.getChildren().add(btCalculate);
			
			btCalculate.setOnAction(e -> {
				double power = 0.0;
				double tension = 0.0;
				double current = 0.0;
				double resistance = 0.0;
				if(!tfPower.getText().isEmpty()) {
					power = Double.parseDouble(tfPower.getText());
				}
				if(!tfTension.getText().isEmpty()) {
					tension = Double.parseDouble(tfTension.getText());
				}
				if(!tfCurrent.getText().isEmpty()) {
					current = Double.parseDouble(tfCurrent.getText());
				}
				if(!tfResistance.getText().isEmpty()) {
					resistance = Double.parseDouble(tfResistance.getText());
				}
				Calculator myCalculator = new Calculator(
						power, tension, current, resistance);
				System.out.print("Vorher:  ");
				System.out.println(myCalculator.toString());
				myCalculator.calculate();
				System.out.print("Nachher: ");
				System.out.println(myCalculator.toString());
					
				tfPower.setText(Double.toString(myCalculator.getPower()));
				tfTension.setText(Double.toString(myCalculator.getTension()));
				tfCurrent.setText(Double.toString(myCalculator.getCurrent()));
				tfResistance.setText(Double.toString(myCalculator.getResistance()));
			});

			Scene scene = new Scene(root, 330, 490);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Formelrad");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
