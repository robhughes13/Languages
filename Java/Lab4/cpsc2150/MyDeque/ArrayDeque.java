// Dante Stewart
// Robert Hughes
package cpsc2150.MyDeque;

import java.util.*;

public class ArrayDeque extends AbsDeque implements IDeque {

    /**
     * @invariants: myLength <= MAX_LENGTH
     * @constraints: size = myLength
     */
    // where the data is stored. myQ[0] is the front of the deque
    private Character[] myQ;

    // tracks how many items in the deque
    // also used to find the end of the deque
    private int myLength;

    public ArrayDeque(){
        this.myQ= new Character[IDeque.MAX_LENGTH];
        this.myLength=0;
    }

    public void enqueue(Character x) {
        if(this.myLength==100){
            System.out.println("The ArrayDeque is full!");
        }
        else if (this.myLength==0){
            this.myQ[0]= x;
            this.myLength++;
        }
        else{
            this.myQ[this.myLength]= x;
            this.myLength++;
        }
    }

    public Character dequeue() {
        if (this.myLength==0){
            System.out.println("Deque is empty!");
            return null;
        }

            Character front= this.myQ[0];
            this.myQ[0]= null;

            for (int i=1;i<this.myLength; i++){
                this.myQ[i-1]= this.myQ[i];
                this.myQ[i]=null;
            }

            this.myLength--;
            return front;
    }


    public void inject(Character x) {
        if(this.myLength==IDeque.MAX_LENGTH){
            System.out.println("The ArrayDeque is full!");
        }
        else if (this.myQ[0]==null){
            this.myQ[0]= x;
            this.myLength++;
        }
        else{
            for (int i=this.myLength; i>0; i--){
                this.myQ[i]=this.myQ[i-1];
                this.myQ[i-1]= null;
            }
            this.myQ[0]= x;
            this.myLength++;
        }
    }

    public Character removeLast() {
        if (this.myLength==0){
            System.out.println("Deque is empty!");
            return null;
        }
        else{
            Character last= this.myQ[this.myLength-1];
            this.myQ[this.myLength-1]= null;
            this.myLength--;
            return last;
        }
    }

    public int length() {
        return this.myLength;
    }

    public void clear() {
        for (int i=0; i<this.myLength; i++){
            this.myQ[i]= null;
        }
        this.myLength=0;
    }
}

