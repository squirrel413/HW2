package game;

public class Box {

    // Field Variables
    private int row;
    private int column;
    private Lines lines;

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

    public Player getOwner() {
        return null;
    }

    public Line getTopLine() {

    }

    public Line getRightLine() {

    }

    public Line getBottomLine() {

    }

    public Line getLeftLine() {

    }

    public void claim(Player owner){

    }

    public String toString() {

    }

    public boolean equals(Object other){
        if (other instanceof Box)
            return row == ((Box) other).row && column == ((Box) other).column && lines == ((Box) other).lines;
    }
}
