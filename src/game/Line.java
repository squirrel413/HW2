package game;

import java.util.ArrayList;

public class Line {
    //Constants
    static final String EMPTY = " ";
    static final String HORI_LINE = "-";
    static final String VERT_LINE = "|";

    //Field variables
    private final Dot first;
    private final Dot second;
    private Player owner;
    private static final ArrayList<Box> boxes = new ArrayList<>();

    //Constructor
    public Line(Dot first, Dot second) {
        assert ((second.getRow() - first.getRow()) < 2);
        assert ((second.getRow() - first.getRow()) >= 0);
        assert ((second.getColumn() - first.getColumn()) < 2);
        assert ((second.getColumn() - first.getColumn()) >= 0);
        this.first = first;
        this.second = second;
        this.owner = Player.NONE;
    }

    //Methods
    public Dot getFirst() {
        return first;
    }

    public Dot getSecond() {
        return second;
    }

    public Player getOwner() {
        return this.owner;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void setBox(Box box) {
        boxes.add(box);
    }

    public boolean hasOwner() {
        return getOwner() != Player.NONE;
    }

    public void claim(Player owner) {
        this.owner = owner;
        for (int i=0; i<boxes.size(); i++)
            getBoxes().get(i).claim(owner);
    }

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
