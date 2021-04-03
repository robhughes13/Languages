/* Rob Hughes
 * 03/22/2020
 * Creating a TriangleMaker class
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/* TRIANGLE COLOR WILL BE BLUE
 * Class to make a triangle, extending the super class Jewel
 */


public class TriangleMaker extends Jewel{
  
 /* declaring arrays for polygon points
 */
  protected double[] xArray;
  protected double[] yArray;
  
  /* variable to delcare the jewel's color
   */
  public static final Color TRIANGLE_COLOR= Color.BLUE;
  
  /* contructor takes @param1 (x-val) and @param2 (y-val) and uses super class constructor
   */
  public TriangleMaker(int boardX, int boardY){
    super(boardX, boardY, TRIANGLE_COLOR);
    this.xArray= new double[3];
    this.yArray= new double[3];
  }
  
/*method to draw a triangle
 */
  
  public void draw(GraphicsContext gc){
    this.xArray[0]= ((2* (this.boardX*Jewel.JEWEL_SIZE))+ Jewel.JEWEL_SIZE)/2;
    this.xArray[1]= (this.boardX*Jewel.JEWEL_SIZE) + Jewel.JEWEL_SIZE-5;
    this.xArray[2]= (this.boardX*Jewel.JEWEL_SIZE)+5;
    
    this.yArray[0]= (this.boardY*Jewel.JEWEL_SIZE)+5;
    this.yArray[1]= (this.boardY*Jewel.JEWEL_SIZE)+ Jewel.JEWEL_SIZE-5;
    this.yArray[2]= (this.boardY*Jewel.JEWEL_SIZE)+ Jewel.JEWEL_SIZE-5;
    
    if(this.selected==true){
      gc.setFill(Color.WHITE);
      gc.fillRect(this.boardX*Jewel.JEWEL_SIZE, this.boardY*Jewel.JEWEL_SIZE, Jewel.JEWEL_SIZE, Jewel.JEWEL_SIZE);
      gc.setFill(TRIANGLE_COLOR);
      gc.fillPolygon(this.xArray, this.yArray, 3);
    }
    else{
      gc.setFill(TRIANGLE_COLOR);
      gc.fillPolygon(this.xArray, this.yArray, 3);
    }
  }
  
   /* returns constant relating to shape type
   */
  
   
  public int getType(){
    return Jewel.TRIANGLE;
  }
   
  /* Used to easily recognize the specific shape being used in simulation situations
   */
  
  public String toString(){
    return ("Triangle @ " + boardX+ ", " + boardY);
  }
}
  
  