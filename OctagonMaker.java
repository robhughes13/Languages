/* Rob Hughes
 * 03/22/2020
 * Creating a OctagonMaker class
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/* OCTAGON COLOR WILL BE PLUM
 * Class to make a hexagon, extending the super class Jewel
 */


public class OctagonMaker extends Jewel{
  
 /* declaring arrays for polygon points
 */
  protected double[] xArray;
  protected double[] yArray;
  
  /* variable to delcare the jewel's color
   */
  public static final Color OCTAGON_COLOR= Color.PLUM;
  
  /* contructor takes @param1 (x-val) and @param2 (y-val) and uses super class constructor
   */
  public OctagonMaker(int boardX, int boardY){
    super(boardX, boardY, OCTAGON_COLOR);
    this.xArray= new double[8];
    this.yArray= new double[8];
  }
  
/*method to draw an octagon
 */
  
  public void draw(GraphicsContext gc){
    this.xArray[0]= ((4* (this.boardX*Jewel.JEWEL_SIZE))+ Jewel.JEWEL_SIZE)/4;
    this.xArray[1]= ((4* (this.boardX*Jewel.JEWEL_SIZE))+ (3*Jewel.JEWEL_SIZE))/4;
    this.xArray[2]= ((this.boardX*Jewel.JEWEL_SIZE) + Jewel.JEWEL_SIZE)-5;
    this.xArray[3]= ((this.boardX*Jewel.JEWEL_SIZE) + Jewel.JEWEL_SIZE)-5;
    this.xArray[4]= ((4* (this.boardX*Jewel.JEWEL_SIZE))+ (3*Jewel.JEWEL_SIZE))/4;
    this.xArray[5]= ((4* (this.boardX*Jewel.JEWEL_SIZE))+ Jewel.JEWEL_SIZE)/4; 
    this.xArray[6]= (this.boardX*Jewel.JEWEL_SIZE)+5;
    this.xArray[7]= (this.boardX*Jewel.JEWEL_SIZE)+5;
    
    this.yArray[0]= (this.boardY*Jewel.JEWEL_SIZE)+5;
    this.yArray[1]= (this.boardY*Jewel.JEWEL_SIZE)+5;
    this.yArray[2]= ((4* (this.boardY*Jewel.JEWEL_SIZE))+ Jewel.JEWEL_SIZE)/4;
    this.yArray[3]= ((4* (this.boardY*Jewel.JEWEL_SIZE))+ (3*Jewel.JEWEL_SIZE))/4;
    this.yArray[4]= ((this.boardY*Jewel.JEWEL_SIZE) + Jewel.JEWEL_SIZE)-5;
    this.yArray[5]= ((this.boardY*Jewel.JEWEL_SIZE) + Jewel.JEWEL_SIZE)-5;
    this.yArray[6]= ((4* (this.boardY*Jewel.JEWEL_SIZE))+ (3*Jewel.JEWEL_SIZE))/4;
    this.yArray[7]= ((4* (this.boardY*Jewel.JEWEL_SIZE))+ Jewel.JEWEL_SIZE)/4;
    
    if(this.selected==true){
      gc.setFill(Color.WHITE);
      gc.fillRect(this.boardX*Jewel.JEWEL_SIZE, this.boardY*Jewel.JEWEL_SIZE, Jewel.JEWEL_SIZE, Jewel.JEWEL_SIZE);
      gc.setFill(OCTAGON_COLOR);
      gc.fillPolygon(this.xArray, this.yArray, 8);
    }
    else{
      gc.setFill(OCTAGON_COLOR);
      gc.fillPolygon(this.xArray, this.yArray, 8);
    }
  }
   
   /* returns constant relating to shape type
   */
  
  
  public int getType(){
    return Jewel.OCTAGON;
  }
   
  /* Used to easily recognize the specific shape being used in simulation situations
   */
  
  public String toString(){
    return ("Octagon @ " + boardX+ ", " + boardY);
  }
}