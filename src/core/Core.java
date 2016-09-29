package core;
/*
 * Author: Shaun Porter
 * Date: 29/09/2016
 * 
 * This is a program I used to demo JavaFX's PieChart feature. It's a simple program that I tried making from scratch during my early days in programming.
 * If anyone has any recommendations to make it more efficient, neat or just better, then please feel free to let me know. I've still got a LOT to learn! :)
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Core extends Application {
	private static TextField tf_input01, tf_input02, tf_input03, tf_input04;
	private static int piedata01, piedata02, piedata03, piedata04;
	private static Button btn_show;
	private static Scene scene;
	private static BorderPane root;
	private static Stage window;
	private static HBox layoutTop;
	private static ObservableList<PieChart.Data> pieChartData;
	private static PieChart chart;

	public static void main(String[] args) {
		initalizeObjects();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("JavaFX PieChart Demo - Shaun Porter");
		window.setResizable(false);

		layoutTop = new HBox(10);
		layoutTop.getChildren().addAll(tf_input01, tf_input02, tf_input03, tf_input04, btn_show);

		btn_show.setOnAction(e -> buttonAction()); // Using Lambda to skip uneccesary code. Bad Coding?

		root.setTop(layoutTop); 
		
		scene = new Scene(root, 300, 300);
		window.setScene(scene);
		window.show();
	}
	
	// Sets up JavaFX Objects away from the rest of the code.
	public static void initalizeObjects() {
		tf_input01 = new TextField();
		tf_input02 = new TextField();
		tf_input03 = new TextField();
		tf_input04 = new TextField();
		btn_show = new Button("Go!");
		root = new BorderPane();
		System.out.println("Objects initalized");
	}
	// Sets up the PieChart by by using user input stored in variables and then adds it to the layout.
	public static void buttonAction() {
		piedata01 = Integer.parseInt(tf_input01.getText());
		piedata02 = Integer.parseInt(tf_input02.getText());
		piedata03 = Integer.parseInt(tf_input03.getText());
		piedata04 = Integer.parseInt(tf_input04.getText());

		pieChartData = FXCollections.observableArrayList(new PieChart.Data(Integer.toString(piedata01), piedata01),
				new PieChart.Data(Integer.toString(piedata02), piedata02), new PieChart.Data(Integer.toString(piedata03), piedata03),
				new PieChart.Data(Integer.toString(piedata04), piedata04));

		chart = new PieChart(pieChartData);

		root.setCenter(chart);

	}

}
