/* Rob Hughes
 * Dr.Tartaro
 * 02/12/2020
 * Assignment 4
 */

import java.util.Scanner;


 /*Begins shelf to hold books
   */

public class BookShelf{
  
  /*declaring IVs
   */
  
  private Scanner scan;
  public Book[] library;
  public int count;
  
  /*constructor
   */
  
  public BookShelf(){ 
    
    /*defining IVs
     */
    
    this.scan= new Scanner(System.in);
    this.library= new Book[25];
    this.count=0;
  }
  
  /*method to add a book
   */
  
  public void addBook(){
    if (this.count<25){
      library[this.count]= new Book();
      System.out.println("\nAdded book: " +library[this.count]+"\n");
      this.count+=1;
    }
    else{
      System.out.println("The max amount of books are on the shelf.");
    }
  }
  
  /*method to print all the books
   */
  
  public void printBooks(){
    if(this.count==0){
      System.out.println("There are no books on the shelf!");
    }
    else{
      for (int i=0;i<this.count; i++){
        System.out.println(library[i]+"\n");
      }
    }
  }
  /*main method
   */
  public void interact(){
    boolean quit=false;
    while (quit==false){
      System.out.println("Enter a command (add, print, or quit):");
      String command= this.scan.nextLine();
      if(command.equals("add")){
        this.addBook();
      }
      else if(command.equals("print")){
        this.printBooks();
      }
      else if(command.equals("quit")){
        quit= true;
      }
      else{
        System.out.println("That command isn't valid.");
      }
    }
  }
  
  public static void main(String[]args){
    BookShelf bs= new BookShelf();
    bs.interact();
  }
}
  
  
  