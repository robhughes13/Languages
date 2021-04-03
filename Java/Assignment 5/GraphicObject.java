/* Rob Hughes
 * 02/28/2020
 * Creating a GraphicObjects class
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
  

public class GraphicObject{
  protected int xVal;
  protected int yVal;
  protected int width;
  protected int height;
  protected double[] xArray;
  protected double[] yArray;
  public GraphicObject(int x, int y, int width, int height){
    this.xVal=x;
    this.yVal=y;
    this.width=width;
    this.height=height;
    this.xArray= new double[3];
    this.yArray= new double[3];
  }

  public void draw(GraphicsContext gc){
    this.xArray[0]= this.xVal+(this.width/2);
    this.xArray[1]= this.xVal+this.width;
    this.xArray[2]= this.xVal;
    this.yArray[0]= this.yVal;
    this.yArray[1]= this.height+this.yVal;
    this.yArray[2]= this.height+this.yVal;
    gc.setFill(Color.RED);
    gc.fillRect(this.xVal, this.yVal, this.width, this.height);
    gc.setFill(Color.BLUE);
    gc.fillPolygon(this.xArray,this.yArray, 3);
  }
}