package game;
/*
* Author:Group 5
* */
public class GameBoard {
    //Field Variables
    private final int rows;
    private final int columns;
    public Lines lines;
    public Box[][] boxes;
    public Dot[][] dots;
    public static int movesMade;
    public static int redScore = 0;
    public static int blueScore = 0;
    public static int totalScore = 0;
    public Player playerTurn;

    //Constructor
    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.dots = new Dot[rows+1][columns+1]; //Creates all the dots
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= columns; j++) {
                dots[i][j] = new Dot(i, j);
            }
        }
        this.lines = new Lines(rows, columns, dots); //Using dots, creates all liens
        this.boxes = new Box[rows][columns]; //Using lines, creates all boxes
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boxes[i][j] = new Box(i,j,lines); //Creates the box, then updates each line's boxes array
                boxes[i][j].getLeftLine().setBox(boxes[i][j]);
                boxes[i][j].getRightLine().setBox(boxes[i][j]);
                boxes[i][j].getTopLine().setBox(boxes[i][j]);
                boxes[i][j].getBottomLine().setBox(boxes[i][j]);
            }
        }
        playerTurn = Player.RED;
    }
    //Methods
    public boolean gameOver() {
        return movesMade != lines.size();
    }

    public Player whoseTurn() {
        return playerTurn;
    }

    public boolean isLineValid(int row1, int column1, int row2, int column2) {
        return ((row1 == row2)&&(column2-column1==1))||((column1==column2)&&(row2-row1==1));
    }

    public void makeMove(int row1, int column1, int row2, int column2) {
        if (isLineValid(row1, column1, row2, column2)) {
            lines.getLine(row1, column1, row2, column2).claim(playerTurn);
            movesMade++;
            if (totalScore == redScore+blueScore) { //if score hasn't changed after a move, change player
                if (playerTurn == Player.BLUE) {
                    playerTurn = Player.RED;
                }
                else if (playerTurn == Player.RED) {
                    playerTurn = Player.BLUE;
                }
            } else {
                totalScore = redScore + blueScore; //otherwise update totalScore and continue without change
            }
        }

    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i <= rows; i++) {
                for (int j=0; j<=columns; j++) {
                    str.append(dots[i][j]);
                    if (j != columns)
                        str.append(lines.getLine(i, j, i, j + 1).toString());
                }
                str.append("\n");
                if (i != rows) {
                    for (int k = 0; k <= columns; k++) {
                        str.append(lines.getLine(i, k, i + 1, k).toString());
                        if (k != columns)
                            str.append(boxes[i][k]);
                    }
                    str.append("\n");
                }
            }
        str.append("\n");
        str.append("Turn:" + playerTurn.getLabel() + ", Red Score: " + redScore + ", Blue Score: "
                + blueScore + ", Moves: " + movesMade + "\n" );
        return str.toString();
    }
}
