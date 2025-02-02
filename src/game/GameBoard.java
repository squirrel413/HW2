package game;

public class GameBoard {
    //Field Variables
    private int rows;
    private int columns;
    public Lines lines;
    public Box[][] boxes;

    public static int redScore;
    public static int blueScore;

    //Constructor
    public GameBoard(int rows, int columns) {
        Dot[][] dots = new Dot[rows][columns];
            for (int i = 0; i <= rows; i++) {
                for (int j = 0; j <= columns; j++) {
                    dots[i][j] = new Dot(i, j);
                }
            }
        Lines lines = new Lines(rows, columns, dots);
    }
    //Methods
    public boolean gameOver() {
        return false;
    }

    //public Player whoseTurn() {}

    public boolean isLineValid(int row1, int column1, int row2, int column2) {
        return ((row1 == row2)&&(column2-column1==1))||((column1==column2)&&(row2-row1==1));
    }

    public void makeMove(int row1, int column1, int row2, int column2) {
        if (isLineValid(row1, column1, row2, column2))
            lines.getLine(row1, column1,row2,column2);
    }

    //public String toString() {
        //for loop
            //alternate dots and whores
            //alternate verts and boxes
    //}
}
