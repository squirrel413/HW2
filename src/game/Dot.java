package game;

public class Dot {
    //Field variables
    private final int row;
    private final int column;
    public static final String DOT = ".";

    //Constructor
    public Dot (int row, int column) {
        this.row = row;
        this.column = column;
    }

    //Methods
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String toString() {
        return DOT;
    }

    public boolean equals(Object other) {
        if (other instanceof Dot) {
            return row == ((Dot) other).row && column == ((Dot) other).column;
        }
    }
}
