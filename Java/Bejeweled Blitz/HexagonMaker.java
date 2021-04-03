/* Rob Hughes
 * 03/22/2020
 * Creating a HexagonMaker class
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/* HEXAGON COLOR WILL BE WHEAT
 * Class to make a hexagon, extending the super class Jewel
 */

public class HexagonMaker extends Jewel{

 /* declaring arrays for polygon points
 */
  protected double[] xArray;
  protected double[] yArray;
  
  /* variable to delcare the jewel's color
   */
  public static final Color HEXAGON_COLOR= Color.WHEAT;
  
  /* contructor takes @param1 (x-val) and @param2 (y-val) and uses super class constructor
   */
  public HexagonMaker(int boardX, int boardY){
    super(boardX, boardY, HEXAGON_COLOR);
    this.xArray= new double[6];
    this.yArray= new double[6];
  }
  
 /*method to draw a hexagon
 */
  
  public void draw(GraphicsContext gc){
    this.xArray[0]= ((4* (this.boardX*Jewel.JEWEL_SIZE))+ Jewel.JEWEL_SIZE)/4;
    this.xArray[1]= ((4* (this.boardX*Jewel.JEWEL_SIZE))+ (3*Jewel.JEWEL_SIZE))/4;
    this.xArray[2]= ((this.boardX*Jewel.JEWEL_SIZE)+ Jewel.JEWEL_SIZE)-3;
    this.xArray[3]= ((4* (this.boardX*Jewel.JEWEL_SIZE))+ (3*Jewel.JEWEL_SIZE))/4;
    this.xArray[4]= ((4* (this.boardX*Jewel.JEWEL_SIZE))+ Jewel.JEWEL_SIZE)/4;
    this.xArray[5]= (this.boardX*Jewel.JEWEL_SIZE)+3;
    
    this.yArray[0]= (this.boardY*Jewel.JEWEL_SIZE)+3;
    this.yArray[1]= (this.boardY*Jewel.JEWEL_SIZE)+3;
    this.yArray[2]= ((2* (this.boardY*Jewel.JEWEL_SIZE))+ Jewel.JEWEL_SIZE)/2;
    this.yArray[3]= ((this.boardY*Jewel.JEWEL_SIZE) + Jewel.JEWEL_SIZE)-3;
    this.yArray[4]= ((this.boardY*Jewel.JEWEL_SIZE) + Jewel.JEWEL_SIZE)-3;
    this.yArray[5]= ((2* (this.boardY*Jewel.JEWEL_SIZE))+ Jewel.JEWEL_SIZE)/2;
      
    if(this.selected==true){
      gc.setFill(Color.WHITE);
      gc.fillRect(this.boardX*Jewel.JEWEL_SIZE, this.boardY*Jewel.JEWEL_SIZE, Jewel.JEWEL_SIZE, Jewel.JEWEL_SIZE);
      gc.setFill(HEXAGON_COLOR);
      gc.fillPolygon(this.xArray, this.yArray, 6);
    }
    else{
      gc.setFill(HEXAGON_COLOR);
      gc.fillPolygon(this.xArray, this.yArray, 6);
    }
  }
   
   /* returns constant relating to shape type
   */
  
  
  public int getType(){
    return Jewel.HEXAGON;
  }
   
  /* Used to easily recognize the specific shape being used in simulation situations
   */
  
  public String toString(){
    return ("Hexagon @ " + boardX+ ", " + boardY);
  }
}