/**
 * Rob Hughes
 * Dr. Tartaro
 * 01/27/2020
 * Creates Die method to find a random number 1-6
 */ 


import java.util.Random; 
/**
 * public class Die that controls the random roll
 */

public class Die {
  
  /**
   * creates random variable
   */
  
  private Random random; 
  
  /**
   * makes the public contructor that defines the random variable
   */
  
  public Die() {
    this.random= new Random(); 
  }
  /**
   * method @returns integer of a random die number
   */
  
  public int roll() { 
    int dieNumber= this.random.nextInt(6) +1; //
    return dieNumber;
  }
}