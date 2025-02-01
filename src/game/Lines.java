package game;

public class Lines {
    //Field variables
    private final int rows;
    private final int columns;
    private final Dot[][] dots;

    //Constructor
    public Lines(int rows, int columns, Dot[][] dots) {
        this.rows = rows;
        this.columns = columns;
        this.dots = dots;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                dots = new Dot[i][j];
            }
        }
    }

    //Methods
    public Line getLine(int row1, int column1, int row2, int column2) {
        return ;
    }

    public int size() {
        return 2 * rows * columns - rows - columns;
    }
}
