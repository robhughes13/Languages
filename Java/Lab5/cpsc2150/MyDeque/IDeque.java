// Dante Stewart
// Robert Hughes
package cpsc2150.MyDeque;

import java.util.*;

    /**
     * initialization ensures: deque is empty
     * @defines
     *  Size: Z
     *
     * A deque containing characters.
     * deque is a data structure a double-ended queue that allows you
     * to insert and remove from both ends.
     * constraints: deque.length <= MAX_LENGTH
     */
    public interface IDeque<T> {
        public static final int MAX_LENGTH = 100;

        /** Adds value to the end of the deque
         * @pre size < MAX_LENGTH
         * @param value - T added
         * @post size = #size +1
         */
        public void enqueue(T value);

        /** removes and returns the T at the front of the deque
         * @pre size > 0
         * @return T
         * @post size = #size -1 and T added to the front of the deque
         */
        public T dequeue();

        /** Adds value to the front of the deque
         *@pre size < MAX_LENGTH
         * @param value - whatever T is in the variable x
         *@post size = #size +1
         */
        public void inject(T value);

        /** removes and returns the T at the end of the deque
         * @pre size > 0
         * @return T
         * @post size = #size -1 and T added to the front of the deque
         */
        public T removeLast();

        /** returns the number of T in the deque
         * @return Integer
         * @post returns size
         */
        public int length();

        /**
         *@post size = 0
         */
        public void clear();

        /**
         * @pre |deque| > 0
         * @return T
         * @post returns the T that is placed at the beginning of the deque
         *       deque = #deque
         */
        default T peek(){
            if(length()==0){
                System.out.println("Deque is empty!");
                return null;
            }
            else {
                T value = dequeue();
                inject(value);
                return value;
            }
        }

        /**
         * @pre |deque| > 0
         * @return T
         * @post returns the T that is at the end of the deque
         *       deque = #deque
         */
        default T endOfDeque() {
            if (length() == 0) {
                System.out.println("Deque is empty!");
                return null;
            }
            else {
                T value = removeLast();
                enqueue(value);
                return value;
            }
        }

        /**
         * @pre 1 <= pos <= Z and |deque| < 0
         * @param value - the T that is being placed in position pos
         * @param pos - the position the T is being added to
         * @post deque = T value added at position pos in #deque
         */
        default void insert(T value, Integer pos){
            pos-=1;
            if (pos==0)
                inject(value);
            else{
                T storage[]= (T[]) new Object[pos];
                for (int i=pos; i> 0; i--){
                    storage[i-1]= dequeue();
                }
                inject(value);
                for(int i=0;i< storage.length;i++){
                    inject(storage[i]);
                }
            }
        }

        /**
         * @pre 1 <= pos <= Z and |deque| > 0
         * @return T
         * @param pos - the position of the T
         * @post returns the T at pos
         *       deque = T at position pos removed from #deque
         */
        default T remove (Integer pos){
            pos-=1;
            T storage[]= (T[]) new Object[pos];
            for (int i=pos; i> 0; i--){
                storage[i-1]= dequeue();
            }
            T value= dequeue();
            for(int i=0;i< storage.length;i++){
                inject(storage[i]);
            }
            return value;
        }


        /**
         * @pre 1 <= pos <= Z and |deque| > 0
         * @return T
         * @param pos - the T at position pos
         * @post returns the T at position pos
         *       deque = #deque
         */
        default T get(Integer pos){
            pos-=1;
            T storage[]= (T[]) new Object[pos];
            for (int i=pos; i> 0; i--){
                storage[i-1]= dequeue();
            }
            T value= dequeue();
            inject(value);
            for(int i=0;i< storage.length;i++){
                inject(storage[i]);
            }
            return value;
        }



    }
