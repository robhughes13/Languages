// Rob Hughes
// Project 2
// 02/28/2021

package cpsc2150.extendedConnectX;

public class BoardPosition {

    /**
     * @invariant 0 <=row<=5 and 0<=column<=8
     */

    private int row;

    private int column;


    /**
     * @pre 0 <=row<=5 and 0<=column<=8
     *
     * @post row=r and column=c
     *
     */
    BoardPosition(int r, int c){
        this.row= r;
        this.column= c;
    }


    /**
     * @post getRow= row
     *
     *
     * @return int of row value
     */
    public int getRow(){
        return row;
    }



    /**
     * @post getColumn= column
     *
     *
     * @return int of column value
     */
    public int getColumn(){
        return column;
    }



    /**
     * @post [equality of two BoardPositions are determined]
     *
     * @return boolean true if this= o
     */
    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof BoardPosition))
            return false;
        BoardPosition newBp= (BoardPosition) o;
        return (getRow()== newBp.row && getColumn()== newBp.column);
    }



    /**
     *
     *
     * @post [string representation of row,column]
     *
     * @return String of row,column
     */
    @Override
    public String toString(){
        String pos= row +","+column;
        return pos;
    }
}
