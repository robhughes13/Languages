/* Rob Hughes
 * 02/28/2020
 * Creating a Jewels class
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
  
/*Super class to make the shapes
 */

public abstract class Jewel{
  
  /* variables that are constant that give each shape a number to be referenced by
   */
  
  public static final int CIRCLE= 0;
  public static final int TRIANGLE= 1;
  public static final int SQUARE= 2;
  public static final int PENTAGON= 3;
  public static final int HEXAGON= 4;
  public static final int OCTAGON= 5;
  public static final int DIAMOND= 6;
  public static final int JEWEL_SIZE= 60;
  
  /* jewel's x val on the board
   */
  protected int boardX;
  
  /* jewel's y val on the board
  */
  protected int boardY;
  
  /* jewel's color on the board
  */
  protected Color color;
  
  /* boolean to determine if a jewel has been selected
  */
  protected boolean selected;
 
  /* contructor takes @param1 (x-val) and @param2 (y-val) and @param3 (shape color) to declare them
   */
  public Jewel (int boardX, int boardY, Color color){
    this.boardX= boardX;
    this.boardY= boardY;
    this.color= color;
    this.selected= false;
   }
  
/*Abstract method to draw the shape in the respected subclass
 */
 
  public abstract void draw(GraphicsContext gc);
  
  
   
   /* returns constant relating to shape type
   */
  
  
  public abstract int getType();
  
  /* Sets x-val
   * @param the preferred x-val
   */
  
  public void setX(int x){
    this.boardX= x;
  }
  
  /* returns x-val
   */
  
  public int getX(){
    return this.boardX;
  }
  
   /* Sets y-val
    * @param the preferred y-val
   */
  public void setY(int y){
    this.boardY= y;
  }
                        
   /* returns y-val
   */
  
  public int getY(){
    return this.boardY;
  }
  
  /* selects the jewel
   */
  public void select(){
    this.selected= true;
  }
  
  /* unselects the jewel
   */
  public void unselect(){
    this.selected= false;
  }
}