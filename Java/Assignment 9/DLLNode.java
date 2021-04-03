/* Rob Hughes
 * Linked List Assignment
 * Linked List portion
 */

/* class to create a node object
*/ 
public class DLLNode{
  
  /* the data the node holds
   */
  private String data;
  
   /* the next node in the list
   */
  private DLLNode next;
  
   /* the previous node in the list
   */
  private DLLNode previous;
  
  public DLLNode(String data){
    this.data= data;
  }
  
  
   /* @returns the data of the node
   */
  public String getNodeData(){
    return this.data;
  }
  
  
   /* takes the @param of data and sets it to the node's data
   */
  public void setNodeData(String data){
    this.data= data;
  }
  
  
   /* @returns the next node in the list
   */
  public DLLNode getNext(){
    return this.next;
  }
  
  
   /* sets the current node's next to @param
   */
  public void setNext(DLLNode next){
    this.next= next;
  }
  
  
   /* @returns the previous node of the current node
   */
  public DLLNode getPrev(){
    return this.previous;
  }
  
   /* sets the current node's previous to @param
   */
  public void setPrev(DLLNode prev){
    this.previous= prev;
  }
}