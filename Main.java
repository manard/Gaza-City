import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	private ArrayList<Line> pathLines = new ArrayList<>();
	private static final double SCALE_DELTA = 1.1;
	private ComboBox<String> source;
	private ComboBox<String> target;
	private Button btn1, btn2;
	private VBox vbox1, vbox2;
	private HBox hbox1;
	private Label lb1, lb2, lb3, lb4;
	private TextArea txta1, txta2;
	private ArrayList<String> list1;
	Pane pane = new Pane();
	private double WxMax1 = 476.79998779296875;
	private double WyMax1 = 550.4000244140625;
	private double WxMin1 = 0;
	private double WyMin1 = 0;
	private double MxMin = 34.173524;
	private double MyMin = 31.601641;
	private double MxMax = 34.567508;
	private double MyMax = 31.221195;
	private Vertix src;
	private Vertix tar;
	Graph g = null;
	Vertix v2;
	Line l;
	 Polygon sahm;

	public static void main(String[] args) {
		Application.launch(args);

	}

	public void start(Stage stage) {
		BorderPane border = new BorderPane();
		border.setStyle("-fx-background-color: dee2e6;");
		ArrayList<String> list = new ArrayList<>();
		vbox1 = new VBox(25);
		vbox2 = new VBox();
		hbox1 = new HBox(10);
		lb1 = new Label("Source:");
		lb1.setStyle("-fx-padding: 20px; -fx-font-weight: bold;");
		lb2 = new Label("Target:");
		lb2.setStyle("-fx-padding: 20px; -fx-font-weight: bold;");
		btn1 = new Button("Run");
		btn2 = new Button("Clear");
		txta1 = new TextArea();
		txta1.setPromptText("PATH");
		txta1.setPrefHeight(100);
		txta1.setStyle("-fx-border-color: #6c757d; -fx-border-width: 2;");
		txta1.setPrefWidth(200);
		txta2 = new TextArea();
		txta2.setPrefHeight(100);
		txta2.setPrefWidth(200);

		txta2.setPromptText("Distance");
		txta2.setStyle("-fx-border-color: #6c757d; -fx-border-width: 2;");

		vbox2.setPadding(new Insets(0, 10, 0, 0));
		vbox1.setPadding(new Insets(20, 20, 0, 0));

		btn1.setStyle(
				"-fx-background-color: Gray; -fx-text-fill: black; -fx-font-size: 16px;-fx-font-family: 'Times New Roman'");
		btn1.setOnMouseEntered(e -> {// just some action for button
			ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), btn1);
			scaleTransition.setToX(1.2);
			scaleTransition.setToY(1.2);
			scaleTransition.play();
		});
		btn1.setOnMouseExited(e -> {// some action for button
			ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), btn1);
			scaleTransition.setToX(1.0);
			scaleTransition.setToY(1.0);
			scaleTransition.play();
		});

		btn2.setStyle(
				"-fx-background-color: Gray; -fx-text-fill: black; -fx-font-size: 16px;-fx-font-family: 'Times New Roman'");
		btn2.setOnMouseEntered(e -> {// just some action for button
			ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), btn2);
			scaleTransition.setToX(1.2);
			scaleTransition.setToY(1.2);
			scaleTransition.play();
		});
		btn2.setOnMouseExited(e -> {// some action for button
			ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), btn2);
			scaleTransition.setToX(1.0);
			scaleTransition.setToY(1.0);
			scaleTransition.play();
		});
		btn2.setOnAction(e -> {
			if (source.getSelectionModel().getSelectedIndex() != -1
					||(!l.equals(null))|| target.getSelectionModel().getSelectedIndex() != -1 || (!txta1.getText().equals(null))||(!txta1.getText().equals(null))) {
				source.setValue(null);
				target.setValue(null);
				txta1.setText(null);
				txta2.setText(null);
				clearLines();
				pane.getChildren().remove(sahm);
			}
		});

		pane.setStyle("-fx-background-image: url('file:C:/Users/Lenovo/Downloads/gazza.jpg');"
				+ "-fx-background-repeat: no-repeat;" + "-fx-background-size: cover;");

		FileChooser fileChooser = new FileChooser(); // To create a file chooser
		File fileSelected = fileChooser.showOpenDialog(stage);
		Vertix Obj;

		int numberOfAdjEdge = 0;
		int numberOfVertix = 0;
		String[] cityinfo;
		if (fileSelected != null) {
			try {
				Scanner in = new Scanner(fileSelected);
				if (in.hasNextLine()) {
					// Read the first line to get the number of cities or any other relevant
					// information
					String firstLine = in.nextLine();

					String[] firstLineValues = firstLine.split(",");

					// Assuming the first value is the number of cities
					numberOfVertix = Integer.parseInt(firstLineValues[0]);
					numberOfAdjEdge = Integer.parseInt(firstLineValues[1]);
					System.out.println("Number Adj= " + numberOfAdjEdge);
					System.out.println("Number of Cities= " + numberOfVertix);
					// بعمل اوبجكت الجراف بعدد الفيرتكش والادجيسنت
					g = new Graph(numberOfVertix, numberOfAdjEdge);

					// Read city names and add them to the list
					for (int i = 0; i < numberOfVertix; i++) {
						Circle c;
						// Assuming each line after the first contains city names separated by commas
						String vertixLine = in.nextLine();
						cityinfo = vertixLine.split(" ");
						// Assuming the first value is the city name
						String cityName = cityinfo[0].trim();
						if (Integer.parseInt(cityinfo[3]) == 1) {
							list.add(cityName);
						}

						double x = findX(Double.parseDouble(cityinfo[2]));
						double y = findY(Double.parseDouble(cityinfo[1]));
						Obj = new Vertix(i, cityName, x, y);
						if (Integer.parseInt(cityinfo[3]) == 1) {
							c = new Circle();
							c.setRadius(3);
							c.setLayoutX(x);
							c.setLayoutY(y);
							c.setFill(Color.RED);
							Label lb = new Label(cityName);
							lb.setFont(new Font(10)); // Adjust the size as needed
							lb.setLayoutX(x - 17);
							lb.setLayoutY(y - 15);
							labelStyle(lb);
							Obj.setC(c);

							pane.getChildren().addAll(lb, c);

							CircleEvent(c, lb);// make event for circle and label to fill combobox
						}
						g.addVertix(Obj);
						v2 = Obj;

					}

				} else {
					showErrorDialog("Error File", "Invalid file format");

				}

				Edge edge;// Adjusent
				// To take the second Part from File,Adjecent Part
				for (int i = 0; i < numberOfAdjEdge; i++) {
					cityinfo = in.nextLine().split(" ");
					int firstPart = 0;
					int secondPart = 0;
					for (int j = 0; j < numberOfVertix; j++) {
						// ***************
						// g****
						if (g.getVertixArray()[j] != null && g.getVertixArray()[j].getName().equals(cityinfo[0])) {
							firstPart = j;
						} else if (g.getVertixArray()[j] != null
								&& g.getVertixArray()[j].getName().equals(cityinfo[1])) {
							secondPart = j;

						}

					}
					double dist = distance1(g.getVertixArray()[firstPart].getX(), g.getVertixArray()[secondPart].getX(),
							g.getVertixArray()[firstPart].getY(), g.getVertixArray()[secondPart].getY());

					edge = new Edge(g.getVertixArray()[firstPart], g.getVertixArray()[secondPart], dist);
					g.addEdge(edge, firstPart, secondPart);

				}

				in.close();
				source = new ComboBox<>();

				target = new ComboBox<>();
				ObservableList<String> options = FXCollections.observableArrayList(list);
				source.setItems(options);
				target.setItems(options);
				vbox1.getChildren().addAll(source, target, btn1, btn2, txta1, txta2);
				vbox2.getChildren().addAll(lb1, lb2);
				hbox1.getChildren().addAll(vbox2, vbox1);
				// pane.getChildren().addAll(imageView,vbox1,vbox2);
				border.setCenter(pane);
				// border.setCenter(pane);
				// border.setCenter(vbox2);
				border.setRight(hbox1);
				Scene scene = new Scene(border, 800, 550);
				//scene.setOnScroll(this::handleScroll);
				stage.setTitle("Dijkstra’s ");
				// stage.setResizable(false);
				stage.setScene(scene);
				stage.show();
				pane.setOnMouseClicked((MouseEvent event) -> {
					double xCoordinate = event.getX();
					double yCoordinate = event.getY();

					System.out.println("Mouse Clicked at: (" + xCoordinate + ", " + yCoordinate + ")");
				});

				// GetCornerXY();
				RunButton(btn1);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	private void showErrorDialog(String title, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(title);
		alert.setContentText(content);

		// Show the dialog
		alert.showAndWait();
	}

	
	private void labelStyle(Label lb) {
		lb.setOnMouseEntered(e -> {// just some action for button
			ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), lb);
			scaleTransition.setToX(1.8);
			scaleTransition.setToY(1.8);
			lb.setTextFill(Color.GREEN);
			scaleTransition.play();
		});
		lb.setOnMouseExited(e -> {// some action for button
			ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), lb);
			scaleTransition.setToX(1.0);
			scaleTransition.setToY(1.0);
			lb.setTextFill(Color.BLACK);
			scaleTransition.play();
		});
	}

	private void CircleEvent(Circle c, Label lb) {
		c.setOnMouseClicked(e -> {
			System.out.println("PPPPPPPPPPPPPP");
			if (source.getSelectionModel().getSelectedIndex() == -1) {
				System.out.println("MMMMM");
				src = v2;
				// source.setItems(FXCollections.observableArrayList(src.getName()));
				source.setValue(lb.getText());

			} else if (target.getSelectionModel().getSelectedIndex() == -1) {
				tar = v2;
				target.setValue(lb.getText());

			}
			if (source.getSelectionModel().getSelectedItem().equals(target.getSelectionModel().getSelectedItem())) {
				showErrorDialog("Error", "Dup values");
				target.setValue(null);
				System.out.println("NOOO");

			}

		});
		lb.setOnMouseClicked(e -> {
			System.out.println("PPPPPPPPPPPPPP");
			if (source.getSelectionModel().getSelectedIndex() == -1) {
				System.out.println("MMMMM");
				// source.setItems(FXCollections.observableArrayList(src.getName()));
				source.setValue(lb.getText());

			} else if (target.getSelectionModel().getSelectedIndex() == -1) {
				target.setValue(lb.getText());

			}
			if (source.getSelectionModel().getSelectedItem().equals(target.getSelectionModel().getSelectedItem())) {
				showErrorDialog("Error", "Dup values");
				target.setValue(null);
				System.out.println("NOOO");

			}

		});

	}

	public static double distance1(double Latitude1, double Latitude2, double longitude1, double longitude2) {
		// ببعت خطوط الطول والعرض للتو فيرتكس
         //للتحويل من الدرجات الى الرادين
		longitude1 = Math.toRadians(longitude1);
		longitude2 = Math.toRadians(longitude2);
		Latitude1 = Math.toRadians(Latitude1);
		Latitude2 = Math.toRadians(Latitude2);

		// معادلة هافرساين
		double dlon = longitude2 - longitude1;
		double dlat = Latitude2 - Latitude1;
	//	المسافة الكلية بين النقطتين يتم حسابها بضرب الزاوية في نصف قطر الأرض.
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(Latitude1) * Math.cos(Latitude2) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));

		double r = 6371; // // نصف قطر الأرض في كيلومتر
		return (c * r);
	}

	public void RunButton(Button btn1) {
		btn1.setOnAction(e -> {
			int count = 0;
			System.out.println(source.getSelectionModel().getSelectedItem());
			for (int i = 0; i < g.getVertixArray().length; i++) {
				System.out.println("OOOO" + g.getVertixArray()[i]);
				System.out.println("EDGEEE" + g.getEdgeArray()[i]);
				count++;
				if (source.getSelectionModel().getSelectedItem()
						.compareToIgnoreCase(g.getVertixArray()[i].getName()) == 0) {
					src = g.getVertixArray()[i];
				}

				else if (target.getSelectionModel().getSelectedItem()
						.compareToIgnoreCase(g.getVertixArray()[i].getName()) == 0) {
					tar = g.getVertixArray()[i];
				}

			}
			System.out.println("Count==" + count);
			Alert a = new Alert(AlertType.WARNING);
			if (src == null) {
				a.setContentText("Source Isn't A Valid Name");
				a.show();
				// tfSource.clear();
				// Clear();
				return;
			} else if (tar == null) {
				a.setContentText("Destination is Same As Source, Or its Invalid");
				a.show();
				// tfDestination.clear();
				// Clear();
				return;
			}

			Dijkstra diObj = new Dijkstra();
			System.out.println("SRCC" + src);
			diObj.makeTable(src, g);
			diObj.findMinUnknownDistance(src, tar);
			diObj.printPath(tar);
			System.out.println("TARR" + tar);
			System.out.println("ARRAY" + diObj.Path);
			if (diObj.dis == Integer.MAX_VALUE) {
				txta2.setText("");
				txta1.appendText("No Path");
				return;
			}

			txta2.setText("Distance:" + (diObj.dis / 1000) + " Km");
			txta1.appendText(src.getName());

			// Create a new Line object for each iteration
			l = new Line();
			l.setStartX(src.getX());
			l.setStartY(src.getY());
			  sahm = new Polygon();
			for (int i = diObj.Path.size() - 1; i >= 0; i--) {
			    System.out.println("LLLLL");

			    // Set the end point of the line
			    l.setEndX(diObj.Path.get(i).getX());
			    l.setEndY(diObj.Path.get(i).getY());

			    // Add the line to the pane
			    pane.getChildren().add(l);

			    // Save the line to the list
			    pathLines.add(l);
			   

			    // Create an arrowhead (triangle) for the starting point
			    if (i == diObj.Path.size() - 1) {
			       
			        sahm.getPoints().addAll(0.0, 0.0, 10.0, 5.0, 0.0, 10.0);
			        sahm.setFill(Color.GREEN);
			        sahm.setLayoutX(src.getX());
			        sahm.setLayoutY(src.getY());
			      
			        pane.getChildren().add(sahm);
			    }
			   
			    // Create a new Line object for the next iteration
			    l = new Line();
			    l.setStartX(diObj.Path.get(i).getX());
			    l.setStartY(diObj.Path.get(i).getY());

			    txta1.appendText("\n -> " + diObj.Path.get(i).getName());
			}

			System.out.println("Shortest Path:");

			for (Vertix vertex : diObj.Path) {
				System.out.println(
						"Vertex: " + vertex.getName() + " (X: " + vertex.getX() + ", Y: " + vertex.getY() + ")");
			}

			System.out.println("Total Distance: " + diObj.dis);

		});
	}

	public double findX(double x1) {
		double X = (x1 - MxMin) * (WxMax1 - WxMin1) / (MxMax - MxMin) + WxMin1;
		return X;

	}

	public double findY(double y1) {
		double Y = (y1 - MyMin) * (WyMax1 - WyMin1) / (MyMax - MyMin) + WyMin1;
		return Y;
	}
	private void clearLines() {
	    pane.getChildren().removeAll(pathLines);
	    pathLines.clear();
	}

}
