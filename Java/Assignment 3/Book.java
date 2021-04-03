/* Rob Hughes
 * Dr.Tartaro
 * 02/12/2020
 * Assignment 4
 */

import java.util.Scanner;

/*starts class to create a book
 */

public class Book { 
  
  /*declaring IVs
   */
  public String aLast;
  public String aFirst;
  public String yoPub;
  public String title;
  public String publish;
  private Scanner scan;
  
  
  public Book(){
    
    /*defining IVs
     */
    this.scan= new Scanner(System.in);
    System.out.println("Enter the author's last name:");
    this.aLast= this.scan.nextLine();
    System.out.println("Enter the author's first name:");
    this.aFirst= this.scan.nextLine();
    System.out.println("Enter the book's year of publication:");
    this.yoPub= this.scan.nextLine();
    System.out.println("Enter the book's title:");
    this.title= this.scan.nextLine();
    System.out.println("Enter the publisher:");
    this.publish= this.scan.nextLine();
  }
  
  
  
  /* @returns authors last name
   */
  public String getLast(){
    return this.aLast;
  }
  
  
  
  /* @returns authors first name
   */
  public String getFirst(){
    return this.aFirst;
  }
  
  
  
  /* @returns year of publication
   */
  public String getyearPub(){
    return this.yoPub;
  }
  
  
  
  /* @returns name of the title
   */
  public String getTitle(){
    return this.title;
  }
  
  
  
  /* @returns publisher
   */
  public String getPublish(){
    return this.publish;
  }

  
  
/*method to create the book
   * @return line is a string of the book's description
   */
  public String toString(){
    String line= this.aLast+", "+ this.aFirst+" ("+this.yoPub+"). "+this.title+". "+this.publish+".";
    return line;
  }
}


      
    
