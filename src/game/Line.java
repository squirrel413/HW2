package game;

import java.util.ArrayList;

public class Line {
    //Field variables
    private final Dot first;
    private final Dot second;
    static final String EMPTY = "";
    static final String HORI_LINE = "-";
    static final String VERT_LINE = "|";

    //Constructor
    public Line(Dot first, Dot second) {
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

    //public Player getOwner() {}

    //public ArrayList<Box> getBoxes() {}

    //public boolean hasOwner() {}

    //public void claim(Player owner) {}

    //public void setBox(Box box) {}

    public String toString() {
        if (first.getRow() == second.getRow())
                return HORI_LINE;
        else if (first.getColumn() == second.getColumn())
                return VERT_LINE;
        else
            return EMPTY;
    }

    public boolean equals(Object other) {
        if (other instanceof Line) {
            return first == ((Line) other).getFirst() && second == ((Line) other).getSecond();
        }
        else {
            return false;
        }
    }
}
