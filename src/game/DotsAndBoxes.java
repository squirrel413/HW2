package game;
/*
* Author:Group 5
* */
import java.util.Scanner;

public class DotsAndBoxes {
    //Constants
    static int ROWS = 1;
    static int COLUMNS = 2;

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
            System.out.print(board.toString()); //Shows current board
            System.out.print(PROMPT);
            String move = sc.nextLine();
            if (move.equals("q")) //quits game
                play = false;
            else {
                //Reads input and passes instructions
                int row1 = Integer.parseInt(move.split(" ")[0]);
                int column1 = Integer.parseInt(move.split(" ")[1]);
                int row2 = Integer.parseInt(move.split(" ")[2]);
                int column2 = Integer.parseInt(move.split(" ")[3]);
                board.makeMove(row1, column1, row2, column2);
            }
            play = board.gameOver();
        } //After game ends return results
        System.out.println(board.toString());
        if (GameBoard.redScore > GameBoard.blueScore) {
            System.out.println("Red Wins!");
        } else if (GameBoard.blueScore > GameBoard.redScore) {
            System.out.println("Blue Wins!");
        } else if (GameBoard.redScore == GameBoard.blueScore) {
            System.out.println("Tie!");
        }
        System.out.println("Thanks for playing!");
    }

    public static void main(String[] args) {
        DotsAndBoxes.play();
    }
}
