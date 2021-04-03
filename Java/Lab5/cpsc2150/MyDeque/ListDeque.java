// Dante Stewart
// Robert Hughes
package cpsc2150.MyDeque;

import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class ListDeque<T> extends AbsDeque<T> implements IDeque<T> {

    // this time store the deque in a list
    // myQ.get(0) is the front of the deque

    /**
     * @Invariants: myQ.size() <= MAX_LENGTH
     * @Correspondents: size = myQ.size()
     *
     */
    private List<T> myQ;

    public ListDeque(){
        this.myQ = new ArrayList<T>(IDeque.MAX_LENGTH);
    }

    public void enqueue(T value) {
        if (this.myQ.size()==IDeque.MAX_LENGTH){
            System.out.println("The ListDeque is full!!");
        }
        else{
            this.myQ.add(value);
        }
    }

    public T dequeue() {
        if (this.myQ.size()==0){
            System.out.println("Deque is empty!");
            return null;
        }
        else {
            T front = this.myQ.get(0);
            this.myQ.remove(0);
            return front;
        }
    }

    public void inject(T value) {
        if (this.myQ.size()==IDeque.MAX_LENGTH){
            System.out.println("The ListDeque is full!!");
        }
        else{
            this.myQ.add(0,value);
        }
    }

    public T removeLast() {
        if (this.myQ.size()==0){
            System.out.println("Deque is empty!");
            return null;
        }
        else {
            int index= this.myQ.size()-1;
            T last= this.myQ.get(index);
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
