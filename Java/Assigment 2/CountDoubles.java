/**
 * Rob Hughes
 * Dr. Tartaro
 * 01/27/2020
 * Plays CountDoubles game
 */ 


import java.util.Scanner; 

/**
 * public class of count doubles created
 */

public class CountDoubles {
  
  /**
   * makes the IV of the first die
   */
  
  public Die die1; 
  
  /**
   * makes the IV of the second die
   */
  
  public Die die2;
  
  /**
   * makes private scanner variable
   */
  
  private Scanner scan;
  
  /**
   * constructor for countdoubles that defines the IVs
   */
  
  public CountDoubles() {
    this.die1= new Die();
    this.die2= new Die(); 
    this.scan= new Scanner(System.in);
  }
  
  /**
   * the game method that counts the doubles, @param for amount of rolls
   */
  
  public void play(int rollNum) { 
    System.out.println("The dice will roll " + rollNum+ " times.");
    System.out.println("Guess how many times the dice will roll doubles out of " +rollNum+ " attempts.");
    int userGuess= this.scan.nextInt();
    int totalRight=0;
    for (int count=0; count<rollNum; count++) { 
      int firstRoll= this.die1.roll();
      int secondRoll= this.die2.roll();
      System.out.println(firstRoll+ " " + secondRoll);
      if (firstRoll==secondRoll) {
        totalRight+=1;}
     }
    if (totalRight!=userGuess) { 
      System.out.println("You guessed " +userGuess+ " doubles, and there were " +totalRight+ ".");
    }
    else {
      System.out.println("Congrats! You guessed all " +userGuess+ " doubles correctly!");
    }
        
    }
 //main
   public static void main(String[]args){
    CountDoubles cd= new CountDoubles();
    cd.play(5);
    }
}
