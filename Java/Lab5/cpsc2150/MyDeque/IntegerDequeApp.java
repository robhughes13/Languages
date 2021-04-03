// Dante Stewart
// Robert Hughes
package cpsc2150.MyDeque;


import java.util.Scanner;
import java.util.*;

public class IntegerDequeApp {

    public static void main(String[] args) {
        IDeque<Integer> q;

        //initializing
        boolean loop = true;
        Scanner input = new Scanner(System.in);
        int userInput = -1;
        while (loop) {
            System.out.println("Enter 1 for array implementation or 2 for List implementation:");
            userInput = input.nextInt();
            if (userInput == 1 || userInput == 2) {
                loop = false;
            }
        }
        if (userInput == 1)
            q = new ArrayDeque<Integer>();
        else
            q = new ListDeque<Integer>();

        String menu = "Select an option:\ni. Add to the end of the deque\nii. Add to the front of the deque\niii. Remove from the front " +
                "of the deque\niv Remove from the end of the deque\nv. Peek at the front of the deque\nvi. Peek at " +
                "the end of the deque\nvii. Insert into a position in the deque\nviii. Remove a value from any " +
                "position in the deque and return it\nix. Peek at a value in any position in the deque\nx. Returns " +
                "the length of the deque\nxi. Clears the deque\nxii. Quit";

        loop = true;
        Integer intPut;
        int position;

        do {
            System.out.println(menu);
            userInput = input.nextInt();

            if (userInput == 1) {
                System.out.println("What integer to enqueue to the end of the Deque?");
                intPut = input.nextInt();
                q.enqueue(intPut);
            } else if (userInput == 2) {
                System.out.println("What integer to inject to the front of the Deque?");
                intPut = input.nextInt();
                q.inject(intPut);
            } else if (userInput == 3) {
                intPut = q.dequeue();
                if (intPut != null) {
                    System.out.print("Integer at the front: ");
                    System.out.print(intPut + "\n");
                }
            } else if (userInput == 4) {
                intPut = q.removeLast();
                if (intPut != null) {
                    System.out.print("Integer at the end: ");
                    System.out.print(intPut + "\n");
                }
            } else if (userInput == 5) {
                intPut = q.peek();
                if (intPut != null) {
                    System.out.print("Peek: ");
                    System.out.print(intPut + "\n");
                }
            } else if (userInput == 6) {
                intPut = q.endOfDeque();
                if (intPut != null) {
                    System.out.print("EndOfDeque: ");
                    System.out.print(intPut + "\n");
                }
            } else if (userInput == 7) {
                boolean tempLoop = true;
                System.out.println("What integer to insert to the Deque?");
                intPut = input.nextInt();

                do {
                    System.out.println("What position to insert in?");
                    position = input.nextInt();
                    if (position > 0 && position <= q.length() + 1)
                        tempLoop = false;
                    else {
                        System.out.println("Not a valid position in the Deque!");
                    }
                } while (tempLoop);

                q.insert(intPut, position);
            } else if (userInput == 8) {
                if (q.length() == 0)
                    System.out.println("Deque is empty!");
                else {
                    boolean tempLoop = true;
                    do {
                        System.out.println("What position to remove from the Deque?");
                        position = input.nextInt();
                        if (position > 0 && position <= q.length())
                            tempLoop = false;
                        else {
                            System.out.println("Not a valid position in the Deque!");
                        }
                    } while (tempLoop);

                    System.out.println(q.remove(position) + " was at position " + position + " in the Deque");
                }
            } else if (userInput == 9) {
                if (q.length() == 0)
                    System.out.println("Deque is empty!");
                else {
                    boolean tempLoop = true;
                    do {
                        System.out.println("What position to get from the Deque?");
                        position = input.nextInt();
                        if (position > 0 && position <= q.length())
                            tempLoop = false;
                        else {
                            System.out.println("Not a valid position in the Deque!");
                        }
                    } while (tempLoop);
                    System.out.println(q.get(position) + " is at position " + position + " in the Deque");
                }
            } else if (userInput == 10) {
                System.out.print("Length of Deque: ");
                System.out.print(q.length() + "\n");
            } else if (userInput == 11) {
                q.clear();
                System.out.println("Deque is now empty!");
            } else if (userInput == 12) {
                loop = false;
            } else {
                System.out.println("Not a valid option!");
            }
            System.out.println("Deque is: ");
            System.out.println(q.toString());
        } while (loop);
    }
}
