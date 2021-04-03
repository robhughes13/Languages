/**
 * Rob Hughes
 * Dr.Tartaro
 * 01/29/2020
 * Plays the High/Low game
 */



import java.util.Random;
import java.util.Scanner;

public class HighLow { 
  
  /**
   * starts class for HighLow
   */
  
  private Random random; 
  
  /**
   * declares random
   */
  
  private Scanner scan; 
  
  /**
   * declares scan
   */
  
  public HighLow() {
    
    /**
     * defining IVs
     */
    
    this.random= new Random();
    this.scan= new Scanner(System.in); 
  }
  
  /*
   * plays the guessing game
   */
  
  public void playGame(){ //starting game method
    boolean correctGuess= false;
    int comValue= this.random.nextInt(1000)+1;
    int userInput= -1;
    int countNum= 0;
    while (correctGuess==false && userInput!=0){ //loop that continues until guessed correctly
      System.out.println("Guess the random number between 1-1000, or enter 0 to quit.");
      userInput= this.scan.nextInt();
      countNum +=1;
      if (userInput>comValue) { //prints too high if guess is high
        System.out.println("Too high, guess lower.");
      }
      else if (userInput<comValue && userInput>0) { //prints too low if guess is low
        System.out.println("Too low, guess higher.");
      }
      else if (userInput==comValue) { // if user guess correctly
        System.out.println("Congrats, you won on Guess "+countNum+"! Thanks for playing!");
        correctGuess= true;
      }
      else { // if user quits
        System.out.println("Thanks for playing, you quitter");
      } 
   }
  }
  public static void main(String[]args){ //main
    HighLow hl = new HighLow();
    hl.playGame();
  }
}