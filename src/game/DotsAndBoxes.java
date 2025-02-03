package game;
import java.util.Scanner;

public class DotsAndBoxes {
    //Constants
    static int ROWS = 4;
    static int COLUMNS = 4;

    //Field Variables
    public final int rows;
    public final int columns;
    static final String PROMPT = "> ";

    //Constructor
    public DotsAndBoxes(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        GameBoard board = new GameBoard(rows, columns);
    }

    //Methods
    public static void play() {
        new DotsAndBoxes(ROWS, COLUMNS);
    }

    public static void main(String[] args) {
        DotsAndBoxes.play();
    }
}
