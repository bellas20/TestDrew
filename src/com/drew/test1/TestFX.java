package com.drew.test1;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TestFX extends Application{

	public static void main(String[] args){

		launch(args);

	}//end main


	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("Weather Data Input");

		// Use this command to get a list of the available Fonts
		//System.out.println(javafx.scene.text.Font.getFamilies());

		//setup box borders
		BorderWidths bWidth = new BorderWidths(3);
		BorderStroke bStrokeBlue = new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, bWidth);
		BorderStroke bStrokeRed = new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, bWidth);
		BorderStroke bStrokeGreen = new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, bWidth);	
		Border chartInputBorder = new Border(bStrokeBlue);

		Font btnFont = new Font("Baskerville Old Face", 22);
		Font lblFont = new Font("Bell MT", 26);
		Font txtFont = new Font("Able", 18);
		Font tipFont = new Font("Able",18);
		
		//setup buttons
		Button btn = new Button("Enter Data");
		//btn.setMaxWidth(Double.MAX_VALUE);
		btn.setFont(btnFont);
		Button btn2 = new Button("Beep");
		final ToggleGroup group = new ToggleGroup();
		ToggleButton tb1 = new ToggleButton("Click ME!");
		tb1.setToggleGroup(group);
		tb1.setSelected(false);
		ToggleButton tb2 = new ToggleButton("No! Click ME!!");
		tb2.setToggleGroup(group);
		tb2.setSelected(true);
		
		tb1.setUserData(Color.LIGHTGREEN);
		tb2.setUserData(Color.LIGHTBLUE);
		
		Rectangle rect = new Rectangle();
		rect.setHeight(50);
		rect.setFill(Color.WHITE);
		rect.setStroke(Color.DARKGRAY);
		rect.setStrokeWidth(2);
		rect.setArcHeight(10);
		rect.setArcWidth(10);
		
		ChangeListener<Toggle> cLt = new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle){
				if (new_toggle != null) {
					System.out.println(group.getSelectedToggle().getUserData().toString());
				}else {
					System.out.println("Hello no");
				}
			}
		};
		
		
		
		//Scene 1 Setup
		TextField tempText = new TextField();
		TextField humidText = new TextField();

		Label tempLabel = new Label("Temperature");
		Label humidLabel = new Label("Humidity");

		tempText.setFont(txtFont);
		humidText.setFont(txtFont);
		tempLabel.setFont(lblFont);		
		humidLabel.setFont(lblFont);
		
		
		DatePicker datepick = new DatePicker(LocalDate.of(2018, 3, 28));
		
		//setup pane
		GridPane entryRoot = new GridPane();
		//entryRoot.setGridLinesVisible(true);
		//entryRoot.setAlignment(Pos.TOP_CENTER);
		entryRoot.setVgap(10);
		entryRoot.setHgap(5);
		
		//add buttons
		Label scn1Label = new Label("Main Screen");
		scn1Label.setFont(lblFont);
		entryRoot.add(scn1Label, 1,1,1,1);
		
		Tooltip tooltipDate = new Tooltip("Select Date");
		tooltipDate.setFont(tipFont);
		entryRoot.getChildren().add(new Label ("Start Date"));
		entryRoot.getChildren().add(datepick);
		datepick.setTooltip(tooltipDate);

		entryRoot.add(btn, 1,4,1,1);
		entryRoot.add(tempText, 1,2,1,1);
		entryRoot.add(tempLabel, 2,2,1,1);
		entryRoot.add(humidText, 1,3,1,1);
		entryRoot.add(humidLabel, 2,3,1,1);
		entryRoot.add(btn2, 1, 6,1,1);
		
		System.out.println("init'ed text fields");

		//Scene 1 Setup
		
		Scene firstScene = new Scene(entryRoot,800,600);
		
		//create scene and assign to stage
		primaryStage.setScene(firstScene);
		primaryStage.show();	

		
	btn.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {
			System.out.println("Button 1 clicked!");
			System.out.println(e.getTarget());
		}
	});
		
	btn2.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {
			System.out.println("Button 2 clicked!");
			System.out.println(e.getSource());
		}
	});
	
	
	}
	

	
}
