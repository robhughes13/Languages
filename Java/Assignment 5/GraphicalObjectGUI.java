/**
 * The main class for a basic GUI for drawing graphical objects.
 * @author Andrea Tartaro
 * @version September 24, 2017
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

public class GraphicalObjectGUI extends Application {
  
  // no data fields
  
  // constructors
  
  /**
   * Constructs a new GraphicalObjectGUI by calling
   * the Application superclass constructor
   */
  public GraphicalObjectGUI() {
    super();
  }
  
  // methods

  /**
   * The required JavaFX start method
   * @param primaryStage the primary stage for this application
   * @see javafx.application.Application
   */
  public void start(Stage primaryStage) {
    
    // create a GraphicalObjectCanvas and tell it to draw
    GraphicalObjectCanvas gc = new GraphicalObjectCanvas();
    gc.draw();
    
    // use a flow layout and add the canvas
    FlowPane pane = new FlowPane();
    pane.getChildren().add(gc);
    
    // create the scene with the layout object
    // with a size of 500x500 pixels
    Scene scene = new Scene(pane, 500, 500);
    primaryStage.setTitle("Graphical Object GUI");
    
    // set this as the scene of the primary stage
    // and show the application
    primaryStage.setScene(scene);
    primaryStage.show();  
  }
  
  // main
  
  /**
   * the main method to start this program
   * @param args Arguments
   */
  public static void main(String[] args) {
    // launches this application
    launch(args);
  }
}