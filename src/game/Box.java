package game;

public class Box {

    // Field Variables
    private final int row;
    private final int column;
    private final Lines lines;

    //Constructor
    public Box(int row, int column, Lines lines) {
        this.row = row;
        this.column = column;
        this.lines = lines;
    }

    //Methods
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    //public Player getOwner() {}

    public Line getTopLine() {
        return lines.getLine(row, column, row,column+1);
    }

    public Line getRightLine() {
        return lines.getLine(row, column+1, row+1, column+1);
    }

    public Line getBottomLine() {
        return lines.getLine(row+1, column, row+1, column+1);
    }

    public Line getLeftLine() {
        return lines.getLine(row, column, row+1, column);
    }

    //public void claim(Player owner){}

    //public String toString() {}

    public boolean equals(Object other){
        if (other instanceof Box)
            return row == ((Box) other).row && column == ((Box) other).column && lines == ((Box) other).lines;
        else
            return false;
    }
}
