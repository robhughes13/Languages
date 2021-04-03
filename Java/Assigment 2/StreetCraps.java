/**
 * Rob Hughes
 * Dr.Tartaro
 * 01/27/2020
 * Plays Street Craps game
 */ 

import java.util.Scanner;

/**
 * begins public class streetCraps
 */

public class StreetCraps {
  
  /**
   * declaring variables
   */
  
  public Die die1; 
  public Die die2;
  private Scanner scan;
  
  /**
   * constructor for StreetCraps
   */
  
  public StreetCraps() {
    
    /**
     * defining variables
     */
    
    this.die1= new Die(); 
    this.die2= new Die();
    this.scan= new Scanner(System.in);}
  
  /**
   * method to roll the die in a loop
   */
  
  public void play() { 
    System.out.println("Pick any number, 2-12, except for 7.");
    int crapsGuess= this.scan.nextInt();
    int r1= this.die1.roll();
    int r2= this.die2.roll();
    System.out.println(r1 + " "+ r2);
    boolean winner= false;
    if (r1+r2==7){ 
      System.out.println("Sorry, you lost on the first roll.");
    }
    if (r1+r2== crapsGuess){
      System.out.println("Congrats, you won on the first roll!");
      winner= true;
    }
    int rollCount=1;
    while (r1+r2!=7 && winner==false) { 
      r1= this.die1.roll();
      r2= this.die2.roll();
      System.out.println(r1 + " "+ r2);
      rollCount +=1;
      if (r1+r2==7){
        System.out.println("Sorry, you lost on roll number " +rollCount+".");
      }
      if (r1+r2== crapsGuess){
        System.out.println("Congrats, you won on roll number " +rollCount+".");
        winner=true;
      }
        
    }
      
  }
  public static void main(String[]args){ //main
    StreetCraps sc= new StreetCraps();
    sc.play();
  }
}