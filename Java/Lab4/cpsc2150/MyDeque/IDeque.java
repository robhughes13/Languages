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
    public interface IDeque {
        public static final int MAX_LENGTH = 100;

        /** Adds x to the end of the deque
         * @pre size < MAX_LENGTH
         * @param x - Character added
         * @post size = #size +1
         */
        public void enqueue(Character x);

        /** removes and returns the Character at the front of the deque
         * @pre size > 0
         * @return Character
         * @post size = #size -1 and character added to the front of the deque
         */
        public Character dequeue();

        /** Adds x to the front of the deque
         *@pre size < MAX_LENGTH
         * @param x - whatever character is in the variable x
         *@post size = #size +1
         */
        public void inject(Character x);

        /** removes and returns the Character at the end of the deque
         * @pre size > 0
         * @return Character
         * @post size = #size -1 and character added to the front of the deque
         */
        public Character removeLast();

        /** returns the number of Characters in the deque
         * @return int
         * @post returns size
         */
        public int length();

        /**
         *@post size = 0
         */
        public void clear();

        /**
         * @pre |deque| > 0
         * @return character
         * @post returns the character that is placed at the beginning of the deque
         *       deque = #deque
         */
        default Character peek(){
            if(length()==0){
                System.out.println("Deque is empty!");
                return null;
            }
            else {
                Character letter = dequeue();
                inject(letter);
                return letter;
            }
        }

        /**
         * @pre |deque| > 0
         * @return character
         * @post returns the character that is at the end of the deque
         *       deque = #deque
         */
        default Character endOfDeque() {
            if (length() == 0) {
                System.out.println("Deque is empty!");
                return null;
            }
            else {
                Character letter = removeLast();
                enqueue(letter);
                return letter;
            }
        }

        /**
         * @pre 1 <= pos <= Z and |deque| < 0
         * @param c - the character that is being placed in position pos
         * @param pos - the position the character is being added to
         * @post deque = character c added at position pos in #deque
         */
        default void insert(Character c, int pos){
            pos-=1;
            if (pos==0)
                inject(c);
            else{
                Character storage[]= new Character[pos];
                for (int i=pos; i> 0; i--){
                    storage[i-1]= dequeue();
                }
                inject(c);
                for(int i=0;i< storage.length;i++){
                    inject(storage[i]);
                }
            }
        }

        /**
         * @pre 1 <= pos <= Z and |deque| > 0
         * @return character
         * @param pos - the position of the character
         * @post returns the character at pos
         *       deque = character at position pos removed from #deque
         */
        default Character remove (int pos){
            pos-=1;
            Character storage[]= new Character[pos];
            for (int i=pos; i> 0; i--){
                storage[i-1]= dequeue();
            }
            Character letter= dequeue();
            for(int i=0;i< storage.length;i++){
                inject(storage[i]);
            }
            return letter;
        }


        /**
         * @pre 1 <= pos <= Z and |deque| > 0
         * @return character
         * @param pos - the character at position pos
         * @post returns the character at position pos
         *       deque = #deque
         */
        default Character get(int pos){
            pos-=1;
            Character storage[]= new Character[pos];
            for (int i=pos; i> 0; i--){
                storage[i-1]= dequeue();
            }
            Character letter= dequeue();
            inject(letter);
            for(int i=0;i< storage.length;i++){
                inject(storage[i]);
            }
            return letter;
        }
    }
