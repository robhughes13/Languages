/* Rob Hughes
 * Linked List Assignment
 * Queue Portion
 */


public class QueueTester{
  public Queue q;
  public QueueTester(){
    this.q = new Queue();
  }
  
  public void enqueueTest(){
    System.out.println("Enqueued words of enqueued test");
    this.q.enqueue("Rob");
    this.q.enqueue("Reagan");
    this.q.enqueue("Rhonda");
    this.q.enqueue("John");
    this.q.print();
  }
  
  
  public void dequeueTest(){
    System.out.println("Dequeued test");
    this.q.dequeue();
    this.q.print();
  }
      
  
  
  public void isEmptyTest(){
    System.out.println(this.q.isEmpty());
  }
      
  
  public void clearTest(){
    System.out.println("Cleared");
    this.q.clear();
    this.q.print();
  }
  
  
  public void peekTest(){
    System.out.println("Peek test");
    System.out.println(this.q.peek());
  }
  
  
  public void print(){
    this.q.print();
  }
  
  public static void main(String[] args) {
    QueueTester qt= new QueueTester();
    qt.enqueueTest();
    System.out.println('\n');
    qt.peekTest();
    System.out.println('\n');
    qt.isEmptyTest();
    System.out.println('\n');
    qt.dequeueTest();
    System.out.println('\n');
    qt.dequeueTest();
    System.out.println('\n');
    qt.peekTest();
    System.out.println('\n');
    qt.clearTest();
    System.out.println('\n');
    qt.isEmptyTest();
  }
    
    
}
  