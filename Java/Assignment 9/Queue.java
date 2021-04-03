/* Rob Hughes
 * Linked List Assignment
 * Queue Portion
 */



public class Queue{
  
  /* variable to create an object of the list class
   */
  DLL list;
  
  public Queue(){
    this.list= new DLL();
  }
  
  
  /* enqueues a node in the list with data @param 
   */
  public void enqueue(String data){
    this.list.addLast(data);
  }
  
  
  /* checks if queue is empty and @returns whether it is or isn't
   */
  public Boolean isEmpty(){
    Boolean zero= this.list.isEmpty();
    if(zero==true){
      return true;
    }
    else{
      return false;
    }
  }
  
  
  /* dequeues a node and @returns the node removed's data
   */
  public String dequeue(){
    return this.list.removeFirst();
  }
  
  
  /* peeks at the first node in the list and @returns its data
   */
  public String peek(){
    return this.list.getFirst();
  }
  
  
  /*clears the queue
   */
  public void clear(){
    this.list.clear();
  }
  
  
  /*prints the queue
   */
  public void print(){
    this.list.printList();
  }
}
    