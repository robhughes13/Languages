/* Rob Hughes
 * Linked List Assignment
 * Linked List portion
 */


/* list object class
 */


public class DLL{
  
  /* dummy head of the list
   */
  private DLLNode head;
  
  /*dummy tail of the list
   */
  private DLLNode tail;
  
  /*keeps count of the size of the list
   */
  private int size;
  
  public DLL(){
    this.size=0;
    this.head= new DLLNode(null);
    this.tail= new DLLNode(null);
    this.head.setNext(this.tail);
    this.tail.setPrev(this.head);
  }
  
  
  /* method to add a node to the list
   * @param the data
   */
  public void add(String data){
    DLLNode newNode= new DLLNode(data);
    DLLNode baseNode= this.tail.getPrev();
    this.addAfter(baseNode, newNode);
  }
  
  
  /* adds the created node in the list after @param1 (the baseNode), and connects the 
   * @param2 properly
   */
  private void addAfter(DLLNode baseNode, DLLNode newNode){
    DLLNode nextNode= baseNode.getNext();
    newNode.setNext(nextNode);
    newNode.setPrev(baseNode);
    baseNode.setNext(newNode);
    nextNode.setPrev(newNode);
    this.size++;
  }
  
  
  /* removes the node in the list after @param baseNode
   */
  private void removeAfter(DLLNode baseNode){
    DLLNode removedNode= baseNode.getNext();
    DLLNode nextNode= removedNode.getNext();
    baseNode.setNext(nextNode);
    nextNode.setPrev(baseNode);
    this.size= this.size-1;
  }
  
  
  /* prints all the nodes in the list excluding dummy nodes
   */
  public void printList(){
    if(this.isEmpty()==false){
      DLLNode current= this.head.getNext();
      while(current != this.tail){
        String nodeData= current.getNodeData();
        System.out.println(nodeData);
        current= current.getNext();
      }
    }
    else{
      System.out.println("The list is empty.");
    }
  }
  
  
  /* adds the node with data @param at the index @param2
   */
  public void add(int index, String data){
    try{
      DLLNode newNode= new DLLNode(data);
      DLLNode baseNode= this.head;
      int count=0;
      while(count<index){
        baseNode= baseNode.getNext();
        count++;
      }
      this.addAfter(baseNode, newNode);
    }
    catch(NullPointerException e){
      System.out.println("That index is out of range.");
    }
  }
  
  
  /* adds the node with data @param at the beginning of the list
   */
  public void addFirst(String data){
    DLLNode newNode= new DLLNode(data);
    this.addAfter(this.head, newNode);
  }
  
  
  /* adds the node with data @param at the end of the list
   */
  public void addLast(String data){
    DLLNode newNode= new DLLNode(data);
    DLLNode baseNode= this.tail.getPrev();
    this.addAfter(baseNode, newNode);
  }
  
  
  /* clears the list
   */ 
  public void clear(){
    this.head.setNext(this.tail);
    this.tail.setPrev(this.head);
    this.size=0;
  }
  
  
  /* gets the first node in the list and @returns the node
   */
  public String getFirst(){
    if(this.isEmpty()==true){
      return "The list is empty.";
    }
      DLLNode nodeWanted= this.head.getNext();
      String wantedData= nodeWanted.getNodeData();
      return wantedData;
  }
  
  
  
  /* gets the last node in the list and @returns the node data
   */
  public String getLast(){
    if(this.isEmpty()==true){
      return "The list is empty.";
    }
    else{
      DLLNode nodeWanted= this.tail.getPrev();
      String wantedData= nodeWanted.getNodeData();
      return wantedData;
    }
  }
  
  
  
  /* gets the node at the index @param and @returns the node data
   */
  public String get(int index){
    try{
      if(this.isEmpty()==true){
        return "The list is empty.";
      }
      else{
        int count=0;
        DLLNode nodeWanted= this.head;
        while(count<index+1){
          nodeWanted= nodeWanted.getNext();
          count++;
        }
        String wantedData= nodeWanted.getNodeData();
        return wantedData;
      }
    }
    catch (NullPointerException e){
      return "That index is out of range.";
    }
  }
  
  
  /* checks if the list is empty @returns whether it is or isn't
   */
  public Boolean isEmpty(){
    if (this.head.getNext()==this.tail){
      return true;
    }
    else{
      return false;
    }
  }
  
  
  /* removes the first node in the list and @returns the node data
   */
  public String removeFirst(){
    if(this.isEmpty()==true){
      return "The list is empty.";
    }
    else{
      DLLNode removedNode= this.head.getNext();
      String removedData= removedNode.getNodeData();
      this.removeAfter(this.head);
      return removedData;
    }
  }
  
  
  /* removes the last node in the list and @returns the node data
   */
  public String removeLast(){
    if(this.isEmpty()==true){
      return "The list is empty.";
    }
    else{
      DLLNode lastNode= this.tail.getPrev();
      String removedData= lastNode.getNodeData();
      DLLNode baseNode= lastNode.getPrev();
      this.removeAfter(baseNode);
      return removedData;
    }
  }
  
  
  /* removes the node in the list at the index @param 
   * and @returns the node data
   */
  public String remove(int index){
    try{
      if(this.isEmpty()==true){
        return "The list is empty.";
      }
      
      else{
        int count=0;
        DLLNode baseNode= this.head;
        String wantedData= null;
        while(count<index){
          baseNode= baseNode.getNext();
          count++;
        }
        DLLNode wantedNode= baseNode.getNext();
        this.removeAfter(baseNode);
        wantedData= wantedNode.getNodeData();
        return wantedData;
      }
    }
    catch(NullPointerException e){
      return "That index is out of range.";
    }
  }
  
  
  /* gets the size  of the list and @returns the size
   */
  public int size(){
    return this.size;
  }
  
  
  /* takes a value @param and checks whether it is in the list or not
   * @return is whether it is or isnt
   */
  public boolean contains(String data){
    DLLNode current= this.head.getNext();
    String nodeData= null;
    Boolean within=false;
    while(current!= this.tail){
      nodeData= current.getNodeData();
      current= current.getNext();
      if (nodeData.equals(data)==true){
        within=true;
      }
    }
    if (within==true){
      return true;
    }
    else{
      return false;
    }
  }
}
    
    
  
  