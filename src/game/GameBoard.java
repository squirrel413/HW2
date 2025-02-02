package game;

public class GameBoard {
    //Field Variables
    public Lines lines;
    public Box[][] boxes;
    public Dot[][] dots;
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
        Box[][] boxes = new Box[rows][columns];
            for (int i = 0; i <= rows; i++) {
                for (int j = 0; j <= columns; j++) {
                    boxes[i][j] = new Box(i,j,lines);
                    boxes[i][j].getLeftLine().setBox(boxes[i][j]);
                    boxes[i][j].getRightLine().setBox(boxes[i][j]);
                    boxes[i][j].getTopLine().setBox(boxes[i][j]);
                    boxes[i][j].getBottomLine().setBox(boxes[i][j]);
                }
            }
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
        //if (isLineValid(row1, column1, row2, column2))
            //lines.getLine(row1, column1,row2,column2).claim();
    }

    public String toString() {
        StringBuilder gameBoard = new StringBuilder();
        for (int i = 0; i <= boxes.length; i++)
            for (int j = 0; j <= boxes.length; j++) {
                gameBoard.append(dots[i][j]);
                gameBoard.append(lines.getLine(i, j, i, j + 1));
            }
            //alternate dots and hori
            //alternate verts and boxes
        return gameBoard.toString();
    }
}
