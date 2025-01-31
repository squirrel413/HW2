package game;

public class Lines {
    //Field variables
    private int rows;
    private int columns;
    private Dot[][] dots;

    //Constructor
    public Lines(int rows, int columns, Dot[][] dots) {
        this.rows = rows;
        this.columns = columns;
        this.dots = dots;
    }

    //Methods
    public Line getLine(int row1, int column1, int row2, int column2) {
        return null;
    }

    public int size() {
        return 2 * rows * columns - rows - columns;
    }
}
