package game;

import java.util.ArrayList;

public class Lines {
    //Field variables
    private final int rows;
    private final int columns;
    private Dot[][] dots;
    private static final ArrayList<Line> lines;

    //Make two arrays for storing horizontal lines and vertical lines
    //using the leading

    //Constructor
    public Lines(int rows, int columns, Dot[][] dots) {
        this.rows = rows;
        this.columns = columns;
        this.dots = dots;
        for (int i = 0; i < (rows-1); i++) {
            for (int j = 0; j < columns; j++) {
                lines.add(new Line(dots[i][j], dots[i + 1][j]));
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < (columns-1); j++) {
                lines.add(new Line(dots[i][j], dots[i][j+1]));
            }
        }
    }

    //Methods
    public Line getLine(int row1, int column1, int row2, int column2) {
        if (row1 <= row2 && column1 <= column2)
            return null;
        else
            return null;
    }

    public int size() {
        return 2 * (rows+1) * (columns+1) - (rows+1) - (columns+1);
    }
}
