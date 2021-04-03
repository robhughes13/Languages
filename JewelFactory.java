/* Rob Hughes
 * 03/25/2020
 * Creating a JewelFactory class
 */


import java.util.Random;
import java.util.Scanner;

/* class that makes jewel objects
   */
public class JewelFactory{
  
  /* jewel's x val on the board
   */
  public int boardX;
  
  /* jewel's y val on the board
  */
  public int boardY;
  
  /* a random variable
   */
  private Random rand;
  
  /* a jewel variable
   */
  private Jewel shape;
  
  
  public JewelFactory (int x, int y){
    this.boardX= x;
    this.boardY= y;
    this.rand= new Random();
  }
  
  
  /* method creating a jewel and giving it the x-y coord of the 
   * @params that are the preferred x and y
   * @return sends a jewel object back
   */
  public Jewel createJewel(int x, int y){
    int randJewel= this.rand.nextInt(7);
    if (randJewel==0){
      this.shape= new CircleMaker(x, y);
    }
    else if (randJewel==1){
      this.shape= new TriangleMaker(x, y);
    }
    else if (randJewel==2){
      this.shape= new SquareMaker(x, y);
    }
    else if (randJewel==3){
      this.shape= new PentagonMaker(x, y);
    }
    else if (randJewel==4){
      this.shape= new HexagonMaker(x, y);
    }
    else if (randJewel==5){
      this.shape= new OctagonMaker(x, y);
    }
    else if (randJewel==6){
      this.shape= new DiamondMaker(x, y);
    }
    return this.shape;
  }
  
  /* methods creating a specific jewel based on the 
   *  @param which is the specific jewel constant representation
   * @return sends a jewel object back
   */
  public Jewel createJewel(int jewelNum){
    if (jewelNum==0){
      this.shape= new CircleMaker(this.boardX, this.boardY);
    }
    else if (jewelNum==1){
      this.shape= new TriangleMaker(this.boardX, this.boardY);
    }
    else if (jewelNum==2){
      this.shape= new SquareMaker(this.boardX, this.boardY);
    }
    else if (jewelNum==3){
      this.shape= new PentagonMaker(this.boardX, this.boardY);
    }
    else if (jewelNum==4){
      this.shape= new HexagonMaker(this.boardX, this.boardY);
    }
    else if (jewelNum==5){
      this.shape= new OctagonMaker(this.boardX, this.boardY);
    }
    else if (jewelNum==6){
      this.shape= new DiamondMaker(this.boardX, this.boardY);
    }
    return this.shape;
  }
}
  
  
  
  