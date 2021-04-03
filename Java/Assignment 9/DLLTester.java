/* Rob Hughes
 * Linked List Assignment
 * Linked List portion
 */


/* Class used to test a made up linked list
 */


public class DLLTester{
  DLL list;
  public DLLTester(){
    this.list= new DLL();
  }
  
  public void addTest(){
    this.list.add("Rob");
    this.list.add("Reagan");
    this.list.add("Rhonda");
    this.list.add("John");
  }
  
  public void printTest(){
     System.out.println("printTest");
    System.out.println("Current list: ");
    this.list.printList();
    
  }
  
  public void clearTest(){
    System.out.println("clearTest");
    System.out.println("Cleared");
    this.list.clear();
  }
  
  public void addAtIndex(){
    System.out.println("addToIndexTest");
    System.out.println("Jefferson added at index 7");
    this.list.add(7, "Jefferson");
  }
  
  public void addFirstTest(){
    System.out.println("addFirstTest, First added");
    this.list.addFirst("First");
  }
  
  public void addLastTest(){
    System.out.println("addLastTest, Last added");
    this.list.addLast("Last");
  }
  
  public void containsTest(){
    System.out.println("containsTest");
    System.out.println("Jefferson in the list?: "+ this.list.contains("Jefferson"));
  }
  
  public void getFirstTest(){
    System.out.println("getFirstTest");
    System.out.println(this.list.getFirst());
  }
  
  public void getLastTest(){
    System.out.println("getLastTest");
    System.out.println(this.list.getLast());
  }
  
  public void getTest(){
    System.out.println("getTest at index 7");
    System.out.println(this.list.get(7));
  }
  
  public void emptyTest(){
    System.out.println("isEmptyTest");
    System.out.println(this.list.isEmpty());
  }
  
  public void sizeTest(){
    System.out.println("sizeTest");
    System.out.println(this.list.size());
  }
  
  public void removeTest(){
    System.out.println("removeTest at index 7");
    System.out.println(this.list.remove(7));
  }
  
  public void removeFirst(){
    System.out.println("removeFirstTest");
    System.out.println(this.list.removeFirst());
  }
  
  public void removeLast (){
    System.out.println("removeLastTest");
    System.out.println(this.list.removeLast());
  }
  
  
  public static void main(String[] args) {
    DLLTester dlt= new DLLTester();
    dlt.addTest();
    System.out.println('\n');
    dlt.printTest();
    System.out.println('\n');
    dlt.addAtIndex();
    System.out.println('\n');
    dlt.printTest();
    System.out.println('\n');
    dlt.addFirstTest();
    dlt.addLastTest();
    System.out.println('\n');
    dlt.printTest();
    System.out.println('\n');
    dlt.containsTest();
    System.out.println('\n');
    dlt.getFirstTest();
    System.out.println('\n');
    dlt.getLastTest();
    System.out.println('\n');
    dlt.getTest();
    System.out.println('\n');
    dlt.emptyTest();
    System.out.println('\n');
    dlt.sizeTest();
    System.out.println('\n');
    dlt.removeTest();
    System.out.println('\n');
    dlt.printTest();
    System.out.println('\n');
    dlt.removeFirst();
    System.out.println('\n');
    dlt.removeLast();
    System.out.println('\n');
    dlt.printTest();
    System.out.println('\n');
    dlt.sizeTest();
    System.out.println('\n');
    dlt.clearTest();
    System.out.println('\n');
    dlt.getFirstTest();
    System.out.println('\n');
    dlt.sizeTest();
    System.out.println('\n');
    dlt.printTest();
    
  }
}