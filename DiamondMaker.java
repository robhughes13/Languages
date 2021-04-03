/* Rob Hughes
 * 03/22/2020
 * Creating a DiamondMaker class
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/* DIAMOND COLOR WILL BE RED
 * Class to make a diamond, extending the super class Jewel
 */


public class DiamondMaker extends Jewel{

/* declaring arrays for polygon points
 */
  protected double[] xArray;
  protected double[] yArray;
  
  /* variable to delcare the jewel's color
   */
  public static final Color DIAMOND_COLOR= Color.RED;
  
  /* contructor takes @param1 (x-val) and @param2 (y-val) and uses super class constructor
   */
  public DiamondMaker(int boardX, int boardY){
    super(boardX, boardY, DIAMOND_COLOR);
    this.xArray= new double[4];
    this.yArray= new double[4];
  }
  
/*method to draw a diamond
 */
  
  public void draw(GraphicsContext gc){
    this.xArray[0]= ((2*(this.boardX*Jewel.JEWEL_SIZE)) + Jewel.JEWEL_SIZE)/2;
    this.xArray[1]= (this.boardX*Jewel.JEWEL_SIZE) + Jewel.JEWEL_SIZE;
    this.xArray[2]= ((2*(this.boardX*Jewel.JEWEL_SIZE)) + Jewel.JEWEL_SIZE)/2;
    this.xArray[3]= (this.boardX*Jewel.JEWEL_SIZE);
    
    this.yArray[0]= (this.boardY*Jewel.JEWEL_SIZE);
    this.yArray[1]= ((2*(this.boardY*Jewel.JEWEL_SIZE))+ Jewel.JEWEL_SIZE)/2;
    this.yArray[2]= (this.boardY*Jewel.JEWEL_SIZE)+ Jewel.JEWEL_SIZE;
    this.yArray[3]= ((2*(this.boardY*Jewel.JEWEL_SIZE))+ Jewel.JEWEL_SIZE)/2;
    
    if(this.selected==true){
      gc.setFill(Color.WHITE);
      gc.fillRect(this.boardX*Jewel.JEWEL_SIZE, this.boardY*Jewel.JEWEL_SIZE, Jewel.JEWEL_SIZE, Jewel.JEWEL_SIZE);
      gc.setFill(DIAMOND_COLOR);
      gc.fillPolygon(this.xArray, this.yArray, 4);
    }
    else{
      gc.setFill(DIAMOND_COLOR);
      gc.fillPolygon(this.xArray, this.yArray, 4);
    }
  }
  
   /* returns constant relating to shape type
   */
  
  
  public int getType(){
    return Jewel.DIAMOND;
  }
   
  /* Used to easily recognize the specific shape being used in simulation situations
   */
  
  public String toString(){
    return ("Diamond @ " + boardX+ ", " + boardY);
  }
}
    
    
    
    