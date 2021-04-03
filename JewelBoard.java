/* Rob Hughes
 * March 21, 2020
 * Making a JewelBoard class
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import javafx.scene.text.Font;


/* Class to make the jewelboard canvas and fill the pieces in, with memory and visual representations
 */

public class JewelBoard extends Canvas{
  
  /* creates the array of pieces
  */
  private Jewel[][] jewels;
  
  /* a graphics context variable to draw
  */
  public GraphicsContext gc;
  
  /* a jewelfactory variable to use its methods
  */
  private JewelFactory jf;
  
  /* the background color
  */
  private Color bgColor;
  
  /* cumulative score of the game
  */
  public int score;
  
  /* checks if an object is adjacent to another
  */
  private boolean adjacent;
  
  /* checks if an onject is to be removed or not
  */
  private boolean remove;
  
  /* number of rows
  */
  public static final int NUM_ROWS=8;
  
  /* number of columns 
  */
  public static final int NUM_COLS=8;
  
  /* to control the clicks
  */
  public ClickHandler handler;
  
  /* first jewel selected
  */
  private Jewel selected1;
  
  /* list of jewels to be removed
  */
  private ArrayList <Jewel> removeList;
  
  /* second jewel selected
  */
  private Jewel selected2;
  
  /* jewel the pointer is on
  */
  private Jewel currentJewel;
  
  /* jewel to replace the current jewel
  */
  private Jewel replaceJewel;
  
  /* the amount of jewels selected
  */
  public int selectCount;
  
  /* defining the variable needed to be defined
  */
  public JewelBoard(){
    
    super(NUM_ROWS*Jewel.JEWEL_SIZE, NUM_COLS*Jewel.JEWEL_SIZE +30);
      
    this.jewels= new Jewel[NUM_ROWS][NUM_COLS];
    
    this.bgColor= Color.BLACK;
    
    this.selectCount=0;
    
    this.remove= false;
    
    this.score=0;
    
    this.adjacent= false;
    
    this.removeList= new ArrayList<Jewel>();
      
    this.handler= new ClickHandler();
    
    this.addEventHandler(MouseEvent.MOUSE_CLICKED, this.handler);
    
    this.add();
  }
  
  
  
  /* method to clear the canvas
   */
  
  
  private void clear() {
    GraphicsContext gc = this.getGraphicsContext2D();
    gc.setFill(this.bgColor);
    gc.fillRect(0, 0, NUM_ROWS*Jewel.JEWEL_SIZE, NUM_COLS*Jewel.JEWEL_SIZE+30);
  }
  
  
  /* method to draw the pieces on the board
   */
  
  public void draw(){
    this.clear();
    GraphicsContext gc = this.getGraphicsContext2D();
    gc.setFill(Color.BLACK);  
    gc.fillRect(0, 480, 480,50);
    gc.setFill(Color.WHITE);
    gc.setFont(Font.font("Sans Serif", 20));
    String scoreString= "Score: " + String.valueOf(this.score);
    gc.fillText(scoreString, 200,500);
    for (int y=0; y<NUM_COLS; y++){
        for (int x=0; x<NUM_ROWS ; x++){
          jewels[x][y].draw(gc);
        }
      }
  }
  
  /* method to add the pieces in the array
   */
  
  public void add(){
    for (int y=0; y<NUM_COLS; y++){
      for (int x=0; x<NUM_ROWS ; x++){
        this.jf = new JewelFactory(x,y);
        this.jewels[x][y]= this.jf.createJewel(x,y);
        }
      }
      this.threeCheck();
      this.removeLoop();
  }
  
  
  /*method to change the appearance of the selected jewel, count clicks, and basically serve as the control
   * center for the methods making the game work
   * @params are the x-y cood of jewel being selected
   */
  private void selectJewel(int x, int y){
    if(this.selected1==null){
      this.selected1= this.jewels[x][y];
      this.selected1.select();
      this.draw();
    }
    else{
      if(this.selected1.getX()==x & this.selected1.getY()==y){
        this.selected1.unselect();
        this.draw();
        this.selected1= null;
      }
      else{
        int aboveX= this.selected1.getX();
        int aboveY= this.selected1.getY()-1;
        int leftX= this.selected1.getX()-1;
        int leftY= this.selected1.getY();
        int rightX= this.selected1.getX()+1;
        int rightY= this.selected1.getY();
        int belowX= this.selected1.getX();
        int belowY= this.selected1.getY()+1;
        this.selected2= this.jewels[x][y];
        if(this.selected2.getX()==aboveX & this.selected2.getY()==aboveY){
          this.adjacent=true;
        }
        else if(this.selected2.getX()==leftX & this.selected2.getY()==leftY){
          this.adjacent=true;
        }
        else if(this.selected2.getX()==rightX & this.selected2.getY()==rightY){
          this.adjacent=true;
        }
        else if(this.selected2.getX()==belowX & this.selected2.getY()==belowY){
          this.adjacent=true;
        }
        else{
          this.adjacent= false;
        }
        
        if(this.adjacent==true){       
          this.selected2.select();
          this.swapPieces(this.selected1, this.selected2);
          this.threeCheck();
          if(this.removeList.size()==0){
            this.swapPieces(this.selected2, this.selected1);
          }
          this.selected1= null;
          this.selected2= null;
          this.removeLoop();
          this.score+=100;
          this.draw();
          if(this.score>999){
            this.gameOver();
          }
        }
        else{
          this.selected1.unselect();
          this.selected1= this.selected2;
          this.selected1.select();
          this.selected2= null;
          this.draw();
          }
      }
    }
  }
  
  
  /*method to deselect the jewel
   * @params are the x-y cood of jewel being unselected
   */
  
  private void unselectJewel(int x, int y){
      this.jewels[x][y].unselect();
      this.draw();
  }

  
  /* method controlling what happens when the user wins the game
   */
  
  public void gameOver(){
      this.clear();
      GraphicsContext gc = this.getGraphicsContext2D();
      gc.setFill(Color.WHITE);
      gc.fillText("CONGRATS YOU WON!",130,255);
      gc.fillText("Click 'New Game' to play again!",95,285);
      this.score=0;
  }
      
  /*  method swapping the pieces in memory and visually
   * @params are the two jewels being swapped
   */
  
  private void swapPieces(Jewel s1, Jewel s2){
    this.selected1.unselect();
    this.selected2.unselect();
    int firstX= s1.getX();
    int secondX= s2.getX();
    int firstY= s1.getY();
    int secondY= s2.getY();
    s1.setX(secondX);
    s2.setX(firstX);
    s1.setY(secondY);
    s2.setY(firstY);
    
    this.jewels[firstX][firstY]= s2;
    this.jewels[secondX][secondY]= s1;
  }
  
  /* method removing and readding pieces
   */
  
  public void removeLoop(){
    for(int i=0; i< this.removeList.size();i++){
      this.currentJewel= this.removeList.get(i);
      int currentX= this.currentJewel.getX();
      int currentY= this.currentJewel.getY();
      while(currentY>=1){
        this.replaceJewel= this.jewels[currentX][currentY-1];
        this.replaceJewel.setX(currentX);
        this.replaceJewel.setY(currentY);
        this.jewels[currentX][currentY]= this.replaceJewel;
        currentY=currentY-1;
        }
      this.jewels[currentX][0]= this.jf.createJewel(currentX,0);
      }
      this.removeList.clear();
      this.threeCheck();
      if (this.removeList.size()!=0){
        this.removeLoop();
      }
  }
 
  
  /* methods checking for three jewels in a row
   */
  
 public void threeCheck(){
    for (int y=0; y<NUM_COLS; y++){
      for (int x=0; x<NUM_ROWS ; x++){
        this.remove=false;
        this.checkSides(x, y);
        this.checkCols(x, y);
        if(this.remove==true){
          this.removeList.add(this.jewels[x][y]);
        }
      }
    }
  }
  
 /* methods checking for three jewels in a row
  * @params are the x-y cood of jewel being checked
   */
  public void checkSides(int x, int y){
    if(x>=2 && x<=5){
      this.rightCheck(x, y);
      this.leftCheck(x, y);
      this.middleXCheck(x, y);
    }
    else if (x==0){
      this.rightCheck(x, y);
    }
    else if (x==1){
      this.rightCheck(x, y);
      this.middleXCheck(x, y);
    }
    else if (x==7){
      this.leftCheck(x, y);
    }
    else{
      this.leftCheck(x, y);
      this.middleXCheck(x, y);
    }
  }
  
  /* methods checking for three jewels in a row
   *  @params are the x-y cood of jewel being checked
   */
  public void checkCols(int x, int y){
    if(y>=2 && y<=5){
      this.upCheck(x, y);
      this.downCheck(x, y);
      this.middleYCheck(x, y);
    }
    else if (y==0){
      this.downCheck(x, y);
    }
    else if (y==1){
      this.downCheck(x, y);
      this.middleYCheck(x, y);
    }
    else if (y==7){
      this.upCheck(x, y);
    }
    else{
      this.upCheck(x, y);
      this.middleYCheck(x, y);
    }
  }
 
  /* methods checking for three jewels in a row
   *  @params are the x-y cood of jewel being checked
   */
  public void rightCheck(int x, int y){
    if(this.jewels[x][y].getType()==this.jewels[x+1][y].getType() && this.jewels[x][y].getType()==this.jewels[x+2][y].getType()){
      this.remove= true;
      }
  }
  /* methods checking for three jewels in a row
   *  @params are the x-y cood of jewel being checked
   */
  public void leftCheck(int x, int y){
    if(this.jewels[x][y].getType()==this.jewels[x-1][y].getType() && this.jewels[x][y].getType()==this.jewels[x-2][y].getType()){
      this.remove= true;
    }
  }
  /* methods checking for three jewels in a row
   *  @params are the x-y cood of jewel being checked
   */
  public void downCheck(int x, int y){
    if(this.jewels[x][y].getType()==this.jewels[x][y+1].getType() && this.jewels[x][y].getType()==this.jewels[x][y+2].getType()){
      this.remove= true;
    }
  }
  /* methods checking for three jewels in a row
   *  @params are the x-y cood of jewel being checked
   */
  public void upCheck(int x, int y){
    if(this.jewels[x][y].getType()==this.jewels[x][y-1].getType() && this.jewels[x][y].getType()==this.jewels[x][y-2].getType()){
      this.remove= true;
    }
  }
  /* methods checking for three jewels in a row
   *  @params are the x-y cood of jewel being checked
   */
  public void middleXCheck(int x, int y){
    if(this.jewels[x][y].getType()==this.jewels[x+1][y].getType() && this.jewels[x][y].getType()==this.jewels[x-1][y].getType()){
      this.remove= true;
    }
  }
  /* methods checking for three jewels in a row
   *  @params are the x-y cood of jewel being checked
   */
  public void middleYCheck(int x, int y){
     if(this.jewels[x][y].getType()==this.jewels[x][y+1].getType() && this.jewels[x][y].getType()==this.jewels[x][y-1].getType()){
      this.remove= true;
     }
   }
  /* method used to make a new board when the button is clicked
   */
   public void createBoard(){
     this.score=0;
     this.clear();
     this.add();
     this.draw();
   }
    
    
/* class that uses the mouse click to determine what the user is doing
   */
  private class ClickHandler implements EventHandler<MouseEvent>{
    public void handle(MouseEvent e){
      double x= e.getX();
      double y= e.getY();
      int gridX= (int)(x/Jewel.JEWEL_SIZE);
      int gridY= (int)(y/Jewel.JEWEL_SIZE);
      selectJewel(gridX, gridY);
    }
  }
  
  
}
    
    
    
    
  