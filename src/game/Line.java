package game;

import java.util.ArrayList;

public class Line {
    //Field variables
    private final Dot first;
    private final Dot second;
    static final String EMPTY = " ";
    static final String HORI_LINE = "-";
    static final String VERT_LINE = "|";
    public static ArrayList<Line> red_lines =  new ArrayList<Line>();
    public static ArrayList<Line> blue_lines =  new ArrayList<Line>();
    public static ArrayList<Box> boxes = new ArrayList<Box>();

    //Constructor
    public Line(Dot first, Dot second) {
        assert ((second.getRow() - first.getRow()) < 2);
        assert ((second.getRow() - first.getRow()) >= 0);
        assert ((second.getColumn() - first.getColumn()) < 2);
        assert ((second.getColumn() - first.getColumn()) >= 0);
        this.first = first;
        this.second = second;
    }

    //Methods
    public Dot getFirst() {
        return first;
    }

    public Dot getSecond() {
        return second;
    }

    public Player getOwner() {
        if (red_lines.contains(this))
            return Player.RED;
        if (blue_lines.contains(this))
            return Player.BLUE;
        else
            return Player.NONE;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public boolean hasOwner() {
        return getOwner() != Player.NONE;
    }

    public void claim(Player owner) {
        if (owner.equals(Player.RED)) {
            red_lines.add(this);

        }
        if (owner.equals(Player.BLUE)) {
            blue_lines.add(this);
        }
    }

    //public void setBox(Box box) {}

    public String toString() {
        if (getOwner() == Player.NONE) {
            return EMPTY;
        }
        else
            if (first.getRow() == second.getRow())
                    return HORI_LINE;
            else if (first.getColumn() == second.getColumn())
                    return VERT_LINE;
            else
                return EMPTY;
    }

    public boolean equals(Object other) {
        if (other instanceof Line) {
            return first.equals(((Line) other).getFirst()) && second.equals(((Line) other).getSecond());
        }
        else {
            return false;
        }
    }
}
