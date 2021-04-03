/* Rob Hughes
 * 03/22/2020
 * Creating a SquareMaker class
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/* SQUARE COLOR WILL BE YELLOW
 * Class to make a square, extending the super class Jewel
 */

public class SquareMaker extends Jewel{
 
 /* declaring arrays for polygon points
 */
  protected double[] xArray;
  protected double[] yArray;
  
  /* variable to delcare the jewel's color
   */
  public static final Color SQUARE_COLOR= Color.YELLOW;
  
  /* contructor takes @param1 (x-val) and @param2 (y-val) and uses super class constructor
   */
  public SquareMaker(int boardX, int boardY){
    super(boardX, boardY, SQUARE_COLOR);
    this.xArray= new double[4];
    this.yArray= new double[4];
  }
  
/*method to draw a square
 */  

  public void draw(GraphicsContext gc){
    this.xArray[0]= (this.boardX*Jewel.JEWEL_SIZE)+8;
    this.xArray[1]= ((this.boardX*Jewel.JEWEL_SIZE)+ Jewel.JEWEL_SIZE)-8;
    this.xArray[2]= ((this.boardX*Jewel.JEWEL_SIZE)+ Jewel.JEWEL_SIZE)-8;
    this.xArray[3]= (this.boardX*Jewel.JEWEL_SIZE)+8;
    
    this.yArray[0]= (this.boardY*Jewel.JEWEL_SIZE)+8;
    this.yArray[1]= (this.boardY*Jewel.JEWEL_SIZE)+8;
    this.yArray[2]= ((this.boardY*Jewel.JEWEL_SIZE)+ Jewel.JEWEL_SIZE)-8;
    this.yArray[3]= ((this.boardY*Jewel.JEWEL_SIZE)+ Jewel.JEWEL_SIZE)-8;
    
    if(this.selected==true){
      gc.setFill(Color.WHITE);
      gc.fillRect(this.boardX*Jewel.JEWEL_SIZE, this.boardY*Jewel.JEWEL_SIZE, Jewel.JEWEL_SIZE, Jewel.JEWEL_SIZE);
      gc.setFill(SQUARE_COLOR);
      gc.fillPolygon(this.xArray, this.yArray, 4);
    }
    else{
      gc.setFill(SQUARE_COLOR);
      gc.fillPolygon(this.xArray, this.yArray, 4);
    }
  }
  
   /* returns constant relating to shape type
   */
  
   
  public int getType(){
    return Jewel.SQUARE;
  }
   
  /* Used to easily recognize the specific shape being used in simulation situations
   */
  
  public String toString(){
    return ("Square @ " + boardX+ ", " + boardY);
  }
}