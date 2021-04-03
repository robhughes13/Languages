/* Rob Hughes
 * 03/22/2020
 * Creating a CircleMaker class
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/* CIRCLE COLOR WILL BE GRAY
 * Class to make a circle, extending the super class Jewel
 */

public class CircleMaker extends Jewel{
  
  /* variable to delcare the jewel's color
   */
  public static final Color CIRCLE_COLOR = Color.GRAY;
  
  /* contructor takes @param1 (x-val) and @param2 (y-val) and uses super class constructor
   */
  public CircleMaker(int boardX, int boardY){
    super(boardX, boardY, CIRCLE_COLOR);
  }
  
/*method to draw a circle
 */
  
  public void draw(GraphicsContext gc){
    if(this.selected==true){
      gc.setFill(Color.WHITE);
      gc.fillRect(this.boardX*Jewel.JEWEL_SIZE, this.boardY*Jewel.JEWEL_SIZE, Jewel.JEWEL_SIZE, Jewel.JEWEL_SIZE);
      gc.setFill(CIRCLE_COLOR);
      gc.fillOval((this.boardX*Jewel.JEWEL_SIZE)+5, (this.boardY*Jewel.JEWEL_SIZE)+5, Jewel.JEWEL_SIZE-10, Jewel.JEWEL_SIZE-10);
    }
    else{
      gc.setFill(CIRCLE_COLOR);
      gc.fillOval((this.boardX*Jewel.JEWEL_SIZE)+5, (this.boardY*Jewel.JEWEL_SIZE)+5, Jewel.JEWEL_SIZE-10, Jewel.JEWEL_SIZE-10);
    }
  }
  
  /* returns constant relating to shape type
   */
  
  
  public int getType(){
    return Jewel.CIRCLE;
  }
  
  /* Used to easily recognize the specific shape being used in simulation situations
   */
  
  public String toString(){
    return ("Circle @ " + boardX+ ", " + boardY);
  }
}