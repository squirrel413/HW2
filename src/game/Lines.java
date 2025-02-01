package game;

public class Lines {
    //Field variables
    private final int rows;
    private final int columns;
    private Dot[][] dots;

    //Constructor
    public Lines(int rows, int columns, Dot[][] dots) {
        this.rows = rows;
        this.columns = columns;
        this.dots = dots;
    }

    //Methods
    public Line getLine(int row1, int column1, int row2, int column2) {
        if (row1 <= row2 && column1 <= column2)
            return new Line(new Dot(row1,column1), new Dot(row2,column2));
        else
            return null;
    }

    public int size() {
        return 2 * (rows+1) * (columns+1) - (rows+1) - (columns+1);
    }
}
