// Rob Hughes
// Project 2
// 02/28/2021

package cpsc2150.extendedConnectX;

public abstract class AbsGameBoard implements IGameBoard {


    /**
     * @return String representation of game board
     */
    @Override
    public String toString() {
        String boardString= "|";

        for(int i=0; i<BOARD_COLUMNS;i++)
            boardString+= i + "|";

        for(int i=5; i>-1; i--){
            boardString+="\n|";
            for(int j=0; j<BOARD_COLUMNS; j++){
                String loopString= String.valueOf(whatsAtPos(new BoardPosition(i,j)));
                boardString+= loopString+ "|";
            }
        }

        return boardString;
    }
}
