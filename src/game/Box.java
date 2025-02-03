package game;
/*
* Author:Group 5
* */

public class Box {

    // Field Variables
    private final int row;
    private final int column;
    private final Lines lines;
    private Player owner;

    //Constructor
    public Box(int row, int column, Lines lines) {
        this.row = row;
        this.column = column;
        this.lines = lines;
        this.owner = Player.NONE;
    }

    //Methods
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Player getOwner() {
        return this.owner;
    }

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

    public void claim(Player owner){
        if (!(getBottomLine().getOwner() == (Player.NONE)
        || getRightLine().getOwner() == (Player.NONE)
        || getLeftLine().getOwner() == (Player.NONE)
        || getTopLine().getOwner() == (Player.NONE))) {
            this.owner = owner;
        }
    }

    public String toString() {
        if (getOwner() ==  Player.RED)
            return "R";
        if (getOwner() ==  Player.BLUE)
            return "B";
        else
            return " ";
    }

    public boolean equals(Object other){
        if (other instanceof Box)
            return row == ((Box) other).getRow() && column == ((Box) other).getColumn();
        else
            return false;
    }
}
