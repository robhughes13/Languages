/* Rob Hughes
 * 03/22/2020
 * Creating a PentagonMaker class
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/* PENTAGON COLOR WILL BE GREEN
 * Class to make a pentagon, extending the super class Jewel
 */


public class PentagonMaker extends Jewel{
  
 /* declaring arrays for polygon points
 */
  protected double[] xArray;
  protected double[] yArray;
  
  /* variable to delcare the jewel's color
   */
  public static final Color PENTAGON_COLOR= Color.GREEN;
  
  /* contructor takes @param1 (x-val) and @param2 (y-val) and uses super class constructor
   */
  public PentagonMaker(int boardX, int boardY){
    super(boardX, boardY, PENTAGON_COLOR);
    this.xArray= new double[5];
    this.yArray= new double[5];
  }

/*method to draw a pentagon
 */
  
  public void draw(GraphicsContext gc){    
    this.xArray[0]= ((2*(this.boardX*Jewel.JEWEL_SIZE))+ Jewel.JEWEL_SIZE)/2;
    this.xArray[1]= ((this.boardX*Jewel.JEWEL_SIZE)+ Jewel.JEWEL_SIZE)-3;
    this.xArray[2]= ((4*(this.boardX*Jewel.JEWEL_SIZE))+(3*Jewel.JEWEL_SIZE))/4;
    this.xArray[3]= ((4*(this.boardX*Jewel.JEWEL_SIZE))+Jewel.JEWEL_SIZE)/4;
    this.xArray[4]= (this.boardX*Jewel.JEWEL_SIZE)+3;
    
    this.yArray[0]= (this.boardY*Jewel.JEWEL_SIZE)+3;
    this.yArray[1]= ((2*(this.boardY*Jewel.JEWEL_SIZE))+Jewel.JEWEL_SIZE)/2;
    this.yArray[2]= ((this.boardY*Jewel.JEWEL_SIZE)+Jewel.JEWEL_SIZE)-3;
    this.yArray[3]= ((this.boardY*Jewel.JEWEL_SIZE)+Jewel.JEWEL_SIZE)-3;
    this.yArray[4]= ((2*(this.boardY*Jewel.JEWEL_SIZE))+Jewel.JEWEL_SIZE)/2;
    
    if(this.selected==true){
      gc.setFill(Color.WHITE);
      gc.fillRect(this.boardX*Jewel.JEWEL_SIZE, this.boardY*Jewel.JEWEL_SIZE, Jewel.JEWEL_SIZE, Jewel.JEWEL_SIZE);
      gc.setFill(PENTAGON_COLOR);
      gc.fillPolygon(this.xArray, this.yArray, 5);
    }
    else{
      gc.setFill(PENTAGON_COLOR);
      gc.fillPolygon(this.xArray, this.yArray, 5);
    }
  }
   
   /* returns constant relating to shape type
   */
  
  
  public int getType(){
    return Jewel.PENTAGON;
  }
   
  /* Used to easily recognize the specific shape being used in simulation situations
   */
  
  public String toString(){
    return ("Pentagon @ " + boardX+ ", " + boardY);
  }
}