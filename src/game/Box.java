package game;

import java.util.ArrayList;

public class Box {

    // Field Variables
    private final int row;
    private final int column;
    private final Lines lines;
    public ArrayList<Box> red_boxes = new ArrayList<Box>();
    public ArrayList<Box> blue_boxes = new ArrayList<Box>();

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
        if (red_boxes.contains(this)){
            return Player.RED;
        }
        if (blue_boxes.contains(this)){
            return Player.BLUE;
        }
        else return Player.NONE;
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
        if (!(getBottomLine().getOwner().equals(Player.NONE)
        || getRightLine().getOwner().equals(Player.NONE)
        || getLeftLine().getOwner().equals(Player.NONE)
        || getTopLine().getOwner().equals(Player.NONE))) {
            if (owner == Player.RED) {
                red_boxes.add(this);
            }
            if (owner == Player.BLUE) {
                blue_boxes.add(this);
            }
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
