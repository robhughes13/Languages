// Dante Stewart
// Robert Hughes
package cpsc2150.MyDeque;

import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class ListDeque extends AbsDeque implements IDeque {

    // this time store the deque in a list
    // myQ.get(0) is the front of the deque

    /**
     * @Invariants: myQ.size() <= MAX_LENGTH
     * @Correspondents: size = myQ.size()
     *
     */
    private List<Character> myQ;

    public ListDeque(){
        this.myQ = new ArrayList<Character>(IDeque.MAX_LENGTH);
    }

    public void enqueue(Character x) {
        if (this.myQ.size()==IDeque.MAX_LENGTH){
            System.out.println("The ListDeque is full!!");
        }
        else{
            this.myQ.add(x);
        }
    }

    public Character dequeue() {
        if (this.myQ.size()==0){
            System.out.println("Deque is empty!");
            return null;
        }
        else {
            Character front = this.myQ.get(0);
            this.myQ.remove(0);
            return front;
        }
    }

    public void inject(Character x) {
        if (this.myQ.size()==IDeque.MAX_LENGTH){
            System.out.println("The ListDeque is full!!");
        }
        else{
            this.myQ.add(0,x);
        }
    }

    public Character removeLast() {
        if (this.myQ.size()==0){
            System.out.println("Deque is empty!");
            return null;
        }
        else {
            int index= this.myQ.size()-1;
            Character last= this.myQ.get(index);
            this.myQ.remove(index);
            return last;
        }
    }

    public int length() {
        return this.myQ.size();
    }

    public void clear() {
        this.myQ.clear();
    }

}
