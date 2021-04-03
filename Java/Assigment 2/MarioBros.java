/**Rob Hughes
  * Dr. Tartaro
  * 02/03/2020
  * Play first slot machine game
  */

import java.util.Random;
import java.util.Scanner;

/**
 * starts slot machine class
 */

public class MarioBros { 
  
  /**
   * declaring IVs
   */
   
  private Random random;
  private Scanner scan;
  public int finalPoints;
  
  /**
   * Constructor to define the IVs
   */
  
  public MarioBros(){
    
    /**
     * defining IVs
     */
    
    this.random= new Random();
    this.scan= new Scanner(System.in);
    this.finalPoints=0;
  }
  
  /**
   * finds the number of attempts desired by user
   */
  
  public void attempts(){
    int attemptNum=0;
    System.out.println("How many times would you like to play?");
    attemptNum= this.scan.nextInt();
    this.play(attemptNum);
  }
  /**
   * beginning game playing method 
   * @param int attemptNum used to set the amount of times the game is to be played
   */
  
  public void play(int attemptNum){
    int totalPoints=0;
    for (int count=0; count<attemptNum; count++){
      //for loop for attempt amount
      int mushFreq=0;
      int acornFreq=0;
      int ffFreq=0;
      int ifFreq=0;
      int leafFreq=0;
      int points=0;
      for (int count2=0; count2<4; count2++){
        //for loop for 5 types
        int typeOptions= this.random.nextInt(5);
        if (typeOptions==0){
          System.out.print("  Mushroom");
          mushFreq +=1;
        }
        else if (typeOptions==1){
          System.out.print("  Acorn");
          acornFreq+=1;
        }
        else if (typeOptions==2){
          System.out.print("  FireFlower");
          ffFreq+=1;
          }
        else if (typeOptions==3){
          System.out.print("  IceFlower");
          ifFreq+=1;
        }
        else {
          System.out.print("  Leaf");
          leafFreq+=1;
        }
      }
      //adding points based on type frequencies
      if (mushFreq==2){
         points+=100;
      }
      if (acornFreq==2){
          points+=100;
      }
      if (ffFreq==2){
          points+=100; 
      }
      if (ifFreq==2){
          points+=100;
      }
      if (leafFreq==2){
          points+=100;
      }
      if (mushFreq==3 || acornFreq==3 || ffFreq==3 || ifFreq==3 || leafFreq==3){
          points+=300;
      }
      if (mushFreq==4 || acornFreq==4 || ffFreq==4 || ifFreq==4 || leafFreq==4){
          points+=600;
      }
      System.out.println("\n  "+points+ " points!\n");
      totalPoints+= points;
    }
    System.out.println("You earned " +totalPoints+ " points!");
    this.finalPoints= totalPoints;
  }
  
  /**
   * keeps track of points for part 2
   * @return int this.finalPoints to show the amount of points accumlated after each game
   */
  
  public int pointCount(){ 
    return this.finalPoints;
  }
  
  
  public static void main(String[]args){ //main
    MarioBros mb= new MarioBros();
    mb.attempts();
  }
}
    
  

  