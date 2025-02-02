package game;

public class GameBoard {
    //Field Variables
    private int rows;
    private int columns;
    public Box[][] boxes;

    public static int redScore;
    public static int blueScore;

    //Constructor
    public GameBoard(int rows, int columns) {
        new Lines(rows, columns, dots);
    }
    //Methods
    public boolean gameOver() {
        return boxes =;
    }

    public Player whoseTurn() {

    }

    public boolean isLineValid(int row1, int column1, int row2, int column2) {
        return ((row1 == row2)&&(column2-column1==1))||((column1==column2)&&(row2-row1==1));
    }

    public void makeMove(int row1, int column1, int row2, int column2) {
        if (isLineValid(row1, column1, row2, column2))

    }

    public String toString() {
        //for loop
            //alternate dots and whores
            //alternate verts and boxes
    }
}
