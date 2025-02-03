package game;
/*
* Author:Group 5
* */
import java.util.Scanner;

public class DotsAndBoxes {
    //Constants
    static int ROWS = 4;
    static int COLUMNS = 4;

    //Field Variables
    public final int rows;
    public final int columns;
    static final String PROMPT = "> ";
    private static boolean play = true;
    public static GameBoard board;

    //Constructor
    public DotsAndBoxes(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        board = new GameBoard(rows, columns);
    }

    //Methods
    public static void play() {
        new DotsAndBoxes(ROWS, COLUMNS);
        Scanner sc = new Scanner(System.in);
        while (play) {
            System.out.print(board.toString());

            System.out.print(PROMPT);
            String move = sc.nextLine();
            if (move.equals("q"))
                play = false;
            else {
                int row1 = Integer.parseInt(move.split(" ")[0]);
                int column1 = Integer.parseInt(move.split(" ")[1]);
                int row2 = Integer.parseInt(move.split(" ")[2]);
                int column2 = Integer.parseInt(move.split(" ")[3]);
                board.makeMove(row1, column1, row2, column2);

            }
        }
    }

    public static void main(String[] args) {
        DotsAndBoxes.play();
    }
}
