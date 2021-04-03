/* Rob Hughes
 * March 21, 2020
 * Making a GUI class
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class JewelBoardGUI extends Application {
  
  public JewelBoard jb;
  
  /* sets up the game and plays it
  */
  public void start(Stage primaryStage) {
    
    this.jb = new JewelBoard();
    this.jb.draw();
    
   
    Button newBoard = new Button("New Game");
    ButtonClickHandler handler = new ButtonClickHandler();
    newBoard.setOnAction(handler);
    
    BorderPane pane = new BorderPane();
    pane.setCenter(jb);
    pane.setAlignment(newBoard, Pos.CENTER);
    pane.setTop(newBoard);
    pane.setStyle("-fx-background-color: black;");
    

    Scene scene = new Scene(pane,480,535);
    primaryStage.setTitle("Bejeweled");
    
    // set this as the scene of the primary stage
    // and show the application
    primaryStage.setScene(scene);
    primaryStage.show();  
  }
  
  /* provides what to do when the button is clicked
   */
  private class ButtonClickHandler implements EventHandler<ActionEvent> {
    public void handle(ActionEvent e) {
      jb.createBoard();
    }
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