package game;

import java.util.ArrayList;

public class Lines {
    //Field variables
    private int rows;
    private int columns;
    private Dot[][] dots;
    private static Line[][] hori;
    private static Line[][] verti;

    //Make two arrays for storing horizontal lines and vertical lines
    //using the leading

    //Constructor
    public Lines(int rows, int columns, Dot[][] dots) {
        this.rows = rows;
        this.columns = columns;
        this.dots = dots;
        hori = new Line[rows+1][columns];
        verti = new Line[rows][columns+1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= columns; j++) {
                verti[i][j] = (new Line(dots[i][j], dots[i + 1][j]));
            }
        }
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i <= rows; i++) {
                hori[i][j] = (new Line(dots[i][j], dots[i][j+1]));
            }
        }
    }

    //Methods
    public Line getLine(int row1, int column1, int row2, int column2) {
        if (row1 <= row2 && column1 <= column2) {
            if (column1 == column2) {
                return verti[row1][column1];
            }
            else if (row1 == row2) {
                return hori[row1][column1];
            }
            else
                return null;
        }
        else
            return null;
    }

    public int size() {
        return 2 * (rows+1) * (columns+1) - (rows+1) - (columns+1);
    }
}
