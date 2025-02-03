package game;

public class GameBoard {
    //Field Variables
    private int rows;
    private int columns;
    public Lines lines;
    public Box[][] boxes;
    public Dot[][] dots;
    public static int movesMade;
    public static int redScore;
    public static int blueScore;
    public Player playerTurn;

    //Constructor
    public GameBoard(int rows, int columns) {
        Dot[][] dots = new Dot[rows][columns]; //Creates all the dots
            for (int i = 0; i <= rows; i++) {
                for (int j = 0; j <= columns; j++) {
                    dots[i][j] = new Dot(i, j);
                }
            }
        Lines lines = new Lines(rows, columns, dots); //Using dots, creates all liens
        Box[][] boxes = new Box[rows][columns]; //Using lines, creates all boxes
            for (int i = 0; i <= rows; i++) {
                for (int j = 0; j <= columns; j++) {
                    boxes[i][j] = new Box(i,j,lines); //Creates the box, then updates each line's boxes array
                    boxes[i][j].getLeftLine().setBox(boxes[i][j]);
                    boxes[i][j].getRightLine().setBox(boxes[i][j]);
                    boxes[i][j].getTopLine().setBox(boxes[i][j]);
                    boxes[i][j].getBottomLine().setBox(boxes[i][j]);
                }
            }
    }
    //Methods
    public boolean gameOver() {
        return movesMade == lines.size();
    }

    public Player whoseTurn() {
        return playerTurn;
    }

    public boolean isLineValid(int row1, int column1, int row2, int column2) {
        return ((row1 == row2)&&(column2-column1==1))||((column1==column2)&&(row2-row1==1));
    }

    public void makeMove(int row1, int column1, int row2, int column2) {
        if (isLineValid(row1, column1, row2, column2))
            lines.getLine(row1, column1, row2, column2).claim(playerTurn);
    }

    public String toString() {
        StringBuilder gameBoard = new StringBuilder();
        for (int i = 0; i <= rows; i++)
            for (int j = 0; j <= columns; j++) {
                gameBoard.append(dots[i][j]);
                gameBoard.append(lines.getLine(i, j, i, j + 1));
            }
            //alternate dots and hori
            //alternate verts and boxes
        return gameBoard.toString();
    }
}
