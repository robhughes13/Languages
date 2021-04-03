// Rob Hughes
// Project 2
// 02/28/2021

package cpsc2150.extendedConnectX;

import java.util.*;

/**
 *
 * @invariants BOARD_ROWS>rows>=0 and NUM_TO_WIN< BOARD_ROWS
 * and BOARD_COLUMNS>columns>=0 and NUM_TO_WIN< BOARD_COLUMNS
 *
 * Correspondence numberofrows = BOARD_ROWS
 * Correspondence numberofcolumns = BOARD_COLUMNS
 * Correspondence self = gb[0...BOARD_ROWS-1][0...BOARD_COLUMNS-1]
 */

public class GameBoard extends AbsGameBoard implements IGameBoard {

    private char[][] gb;

    /**
     *
     * @post [board 2D array s completed with blank chars filling
     *
     */
    public GameBoard() {
        gb = new char[BOARD_ROWS][BOARD_COLUMNS];           // making board 2-D array

        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS; j++) {       // filling with blank chars
                gb[i][j] = ' '; }
        }
    }

    public void placeToken(char p, int c) {
        char empty;
        int count = -1;

        do{
            count++;                                        // do-while to find what position in col is empty
            empty = gb[count][c];
        }while (empty != ' ');

        gb[count][c] = p;
    }


    public char whatsAtPos(BoardPosition pos){
        return gb[pos.getRow()][pos.getColumn()];
    }

    public int getNumRows(){
        return BOARD_ROWS;
    }

    public int getNumColumns(){
        return BOARD_COLUMNS;
    }

    public int getNumToWin(){
        return NUM_TO_WIN;
    }
}




