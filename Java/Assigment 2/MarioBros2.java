/**Rob Hughes
  * Dr. Tartaro
  * 02/03/2020
  * Play second slot machine game
  */

import java.util.Scanner; 

/**
 * creates game2 class
 */

public class MarioBros2 { 
  /**
   * declares variable to call first game
   */
  
  public MarioBros mb;
  private Scanner scan; //declaring IVs
  
  /**
   * defines the IVs
   */
  
  public MarioBros2(){
    this.mb= new MarioBros(); 
    this.scan= new Scanner(System.in);
  }
  
  /**
   * begins game 2 that calls game 1 methods
   */
  
  public void play2(){ //starts method
    int gametwoPoints=0;
    boolean quitGame= false;
    int gameCount=0;
    do{ //starts while loop to play
      this.mb.play(1); //calls function from MarioBros
      gameCount+=1;
      gametwoPoints+= this.mb.pointCount(); //calls point counter for final score
      System.out.println("Your cumulative score is " +gametwoPoints + " points on " + gameCount+ " play(s).");
      System.out.println("\nTo quit enter 0, to continue enter 1.");
      int gameNum= this.scan.nextInt();
      if (gameNum==0){
        quitGame= true;
      }
    } while(quitGame==false);
      
    
  }
  public static void main(String[]args){ //main
    MarioBros2 mb2= new MarioBros2();
    mb2.play2();  
  }
}