import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane with a background
        Pane centerPane = new Pane();
        centerPane.setStyle("-fx-background-color: lightblue;");

        // Create a BorderPane
        BorderPane borderPane = new BorderPane(centerPane);

        // Create the Scene
        Scene scene = new Scene(borderPane, 600, 400);

        // Set the Scene to the Stage
        primaryStage.setScene(scene);

        // Set other stage properties
        primaryStage.setTitle("Pane Bounds Example");

        // Show the stage
        primaryStage.show();

        // Get the bounds of the centerPane in screen coordinates
        Bounds boundsInScreen = centerPane.localToScreen(centerPane.getBoundsInLocal());

        // Extract xMin, yMin, xMax, yMax
        double xMin = boundsInScreen.getMinX();
        double yMin = boundsInScreen.getMinY();
        double xMax = boundsInScreen.getMaxX();
        double yMax = boundsInScreen.getMaxY();

        System.out.println("Top-Left (xMin, yMin): (" + xMin + ", " + yMin + ")");
        System.out.println("Top-Right (xMax): " + xMax);
        System.out.println("Bottom-Left (yMax): " + yMax);
        System.out.println("Bottom-Right (xMax, yMax): (" + xMax + ", " + yMax + ")");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
