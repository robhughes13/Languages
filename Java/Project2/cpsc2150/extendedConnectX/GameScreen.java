// Rob Hughes
// Project 2
// 02/28/2021

package cpsc2150.extendedConnectX;

import java.util.*;

public class GameScreen {

    public static final int NUM_ROWS = 6;
    public static final int NUM_COLS = 9;

    /**
     * @invariant [done if win || tie] and [PlayerX moves>= PlayerO moves]
     */


    /**
     * @post [game is over] and [can restart or quit]
     */
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        boolean playAgain = true;
        int column;

        while (playAgain) {                         // beginning first game/ start of new games
            char turn = 'X';
            boolean win_tie = false;
            IGameBoard gb = new GameBoard();
            System.out.println(gb.toString());

            while (!win_tie) {                      // loop to prompt player to place and check win and tie

                boolean colInput = false;
                do {                                // do-while for input error checking
                    System.out.println("Player " + turn + " , what column do you want to place your marker in?");
                    column = input.nextInt();

                    if (column >= NUM_COLS)
                        System.out.println("Column cannot be greater than 8");
                    else if (column < 0)
                        System.out.println("Column cannot be less than 0");
                    else if (!(gb.checkIfFree(column)))
                        System.out.println("Column is full");
                    else
                        colInput = true;

                } while (!colInput);

                gb.placeToken(turn, column);
                System.out.println(gb.toString());

                if (gb.checkForWin(column)) {           // if else-if to check win and tie
                    System.out.println("Player " + turn + " won!");
                    win_tie = true;
                }
                else if (gb.checkTie()) {
                    System.out.println("It's a tie!");
                    win_tie = true;
                }

                if (turn == 'X')                        // turn swap
                    turn = 'O';
                else
                    turn = 'X';
            }

            boolean valid = false;
            while (!valid) {                            // input error checking too see if play again
                System.out.println("Would you like to play again? Y/N");
                char play = input.next().charAt(0);

                if (play == 'Y' || play=='y')
                    valid = true;
                else if (play == 'N' || play== 'n') {
                    playAgain = false;
                    valid = true;
                }
                else {
                    System.out.println("Not a valid answer!");
                }
            }
        }
    }
}


