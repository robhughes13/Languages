// Rob Hughes
// Project 2
// 02/28/2021

package cpsc2150.extendedConnectX;
/**
 *
 * GameBoard is abstractly a 2 dimensional board of characters.
 *
 * Initialization ensures:
 *      GameBoard is made of characters and is size BOARD_ROWS x BOARD_COLUMNS
 *
 * Defines:
 *      rows: Z
 *      columns: Z
 * Constraints:
 *      rows<BOARD_ROWS
 *      columns<BOARD_COLUMNS
 *
 */
public interface IGameBoard {

    int BOARD_COLUMNS= 9;
    int BOARD_ROWS= 6;
    int NUM_TO_WIN= 5;


    /**
     *
     * Checks if column has a space free for a piece
     *
     * @param c the column desired to place the piece
     *
     * @return boolean true if column has space for token
     *
     * @post [space is free or not free]
     *
     */
    default boolean checkIfFree(int c){
        char free= this.whatsAtPos(new BoardPosition(5,c));
        return free==' ';
    }


    /**
     * Checks if there is a win on the board
     *
     * @pre [at least 5 moves from one player]
     *
     * @param c the column desired to place the piece
     *
     * @return boolean true if 5 of the same tokens line up
     *
     * @post [know if there is a win or no win]
     *
     */
    default boolean checkForWin(int c){
        int iterator=BOARD_ROWS;

        while((this.whatsAtPos(new BoardPosition(iterator,c)))==' '){   // loop finding the last piece placed
            iterator--;
        }

        BoardPosition param= new BoardPosition(iterator,c);

        boolean hWin= this.checkHorizWin(param,this.whatsAtPos(param));
        boolean vWin= this.checkVertWin(param,this.whatsAtPos(param));      // checking specific win types
        boolean dWin= this.checkDiagWin(param,this.whatsAtPos(param));

        return (hWin || vWin || dWin);
    }


    /**
     * Checks if there is a tie
     *
     * @return boolean true if 5 of the same tokens line up
     *
     * @post [know if there is a tie or no tie]
     */
    default boolean checkTie(){
        int empty=0;

        for(int i=0; i<BOARD_COLUMNS; i++){         // loop to see if whole top row is full
            if((this.whatsAtPos(new BoardPosition(BOARD_ROWS-1,i)))==' ')
                empty++;
        }
        return empty== 0;
    }

    /**
     * Checks if a player is at a certain position
     *
     * @pre [pos!= null]
     *
     * @post [player is or isn't at pos]
     *
     * @return (player token at pos)
     *
     * @param player the token type
     * @param pos the BoardPosition object
     */
    default boolean isPlayerAtPos(BoardPosition pos, char player){
        return (this.whatsAtPos(pos)== player);
    }


    /**
     * Checks if there is a horizontal win on the board
     *
     * @pre [at least 5 moves from one player]
     *
     * @post [win or no win determined]
     *
     * @param pos the BoardPosition Object
     * @param p type of token
     */
    default boolean checkHorizWin(BoardPosition pos, char p){
        int row = pos.getRow();
        int column = 0;
        int count = 0;

        while (count < NUM_TO_WIN && column < BOARD_COLUMNS) {      // loop checking if 5 horizontal pieces in
            if (whatsAtPos(new BoardPosition(row, column)) == p) {  // a row are the same piece type
                count++;
                column++;
            }
            else {
                count = 0;
                column++;
            }

        }
        return count==NUM_TO_WIN;
    }


    /**
     * Checks if there is a vertical win on the board
     *
     * @pre [at least 5 moves from one player]
     *
     * @post [win or no win determined]
     *
     * @param pos the BoardPosition Object
     * @param p type of token
     */
    default boolean checkVertWin(BoardPosition pos, char p) {
        int column = pos.getColumn();
        int row = 0;
        int count = 0;

        while (count < NUM_TO_WIN && row < BOARD_ROWS) {            // loop checking if 5 vert pieces in
            if (whatsAtPos(new BoardPosition(row, column)) == p) {  // a row are the same piece type
                count++;
                row++;}
            else {
                count = 0;
                row++;}

        }
        return (count==NUM_TO_WIN);
    }


    /**
     * Checks if there is a diagonal win on the board
     *
     * @pre [at least 5 moves from one player]
     *
     * @post [win or no win determined]
     *
     * @param pos the BoardPosition object
     * @param p type of token
     */
    default boolean checkDiagWin(BoardPosition pos, char p){
        int row= pos.getRow();
        int column= pos.getColumn();

        // right diagonal
        int count1=0;
        while(row!=0 && column!=0 ) {       // finding bottom left of diagonal from last piece placed
            row--;
            column--;
        }
        while(row!=BOARD_ROWS && column!=BOARD_COLUMNS && count1<NUM_TO_WIN) {   // counting if 5 pieces in a row
            if ((this.whatsAtPos(new BoardPosition(row, column))) == p) {        // of same type in diagonal
                count1++;
                row++;
                column++;}
            else{
                count1 = 0;
                row++;
                column++; }
        }

        // left diagonal
        row = pos.getRow();
        column = pos.getColumn();

        int count2=0;
        while(row!=0 && column!=BOARD_COLUMNS-1) {     // finding bottom right of diagonal from last piece placed
            row--;
            column++;
        }
        while(row!=BOARD_ROWS && column!=-1 && count2<NUM_TO_WIN) {
            if ((this.whatsAtPos(new BoardPosition(row, column))) == p) {   // counting if 5 pieces in a row
                count2++;                                                   // of same type in diagonal
                row++;
                column--;}
            else{
                count2 = 0;
                row++;
                column--; }
        }

        return (count1==NUM_TO_WIN || count2==NUM_TO_WIN);
    }


    /**
     * Sees what is at a certain position on the board
     *
     * @pre [position isn't null]
     *
     * @post [character at position is determined]
     *
     * @param pos the BoardPosition object
     * @return char of token type
     *
     */
    char whatsAtPos(BoardPosition pos);


    /**
     * Places a token in the respected column
     *
     * @pre [column c has room]
     *
     * @post [token placed in that column]
     *
     * @param p the token type
     * @param c the desired column to place token
     */
    void placeToken(char p, int c);

    /**
     *
     * @return number of rows in board
     */
    int getNumRows();

    /**
     *
     * @return number of columns in board
     */
    int getNumColumns();

    /**
     *
     * @return number of pieces of same type in a rwo needed to win
     */
    int getNumToWin();
}
