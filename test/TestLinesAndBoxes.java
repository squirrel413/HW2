package test;

import game.Box;
import game.Dot;
import game.Line;
import game.Lines;
import game.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a unit test once the Line and Box classes have been implemented.  The
 * main thing it tests is the lines that are associated with a box, and
 * when claiming a line that the boxes associated with the line are also
 * correctly claimed.
 *
 * @author RIT CS
 */
public class TestLinesAndBoxes {
    /** 2 rows */
    private final static int ROWS = 2;
    /** 3 columns */
    private final static int COLUMNS = 3;
    /** the collection of lines */
    private Lines lines;
    /** the collection of dots */
    private Dot[][] dots;

    @Before
    public void init() {
        // create the dots
        this.dots = new Dot[ROWS+1][COLUMNS+1];
        for (int row=0; row<=ROWS; ++row) {
            for (int column=0; column<=COLUMNS; ++column) {
                this.dots[row][column] = new Dot(row, column);
            }
        }

        // create the lines
        this.lines = new Lines(ROWS, COLUMNS, this.dots);
    }

    @Test
    public void testBoxAndLines() {
        Box box1 = new Box(1, 1, this.lines);
        assertEquals(new Line(new Dot(1, 1), new Dot(1, 2)), box1.getTopLine());
        assertEquals(new Line(new Dot(1, 2), new Dot(2, 2)), box1.getRightLine());
        assertEquals(new Line(new Dot(2, 1), new Dot(2, 2)), box1.getBottomLine());
        assertEquals(new Line(new Dot(1, 1), new Dot(2, 1)), box1.getLeftLine());
    }


    @Test
    public void claimBox() {
        Box box1 = new Box(0, 0, this.lines);
        box1.getTopLine().claim(Player.RED);
        assertEquals(Player.NONE, box1.getOwner());
        box1.getRightLine().claim(Player.BLUE);
        assertEquals(Player.NONE, box1.getOwner());
        box1.getBottomLine().claim(Player.RED);
        assertEquals(Player.NONE, box1.getOwner());
        box1.getLeftLine().claim(Player.RED);
        assertEquals(Player.RED, box1.getOwner());
    }

    @Test
    public void claimBoxes() {
        Box box1 = new Box(1, 1, this.lines);
        Box box2 = new Box(1, 2, this.lines);
        box1.getLeftLine().claim(Player.RED);
        assertEquals(Player.NONE, box1.getOwner());
        assertEquals(Player.NONE, box2.getOwner());
        box1.getTopLine().claim(Player.BLUE);
        assertEquals(Player.NONE, box1.getOwner());
        assertEquals(Player.NONE, box2.getOwner());
        box2.getTopLine().claim(Player.RED);
        assertEquals(Player.NONE, box1.getOwner());
        assertEquals(Player.NONE, box2.getOwner());
        box2.getRightLine().claim(Player.BLUE);
        assertEquals(Player.NONE, box1.getOwner());
        assertEquals(Player.NONE, box2.getOwner());
        box2.getBottomLine().claim(Player.RED);
        assertEquals(Player.NONE, box1.getOwner());
        assertEquals(Player.NONE, box2.getOwner());
        box1.getBottomLine().claim(Player.BLUE);
        assertEquals(Player.NONE, box1.getOwner());
        assertEquals(Player.NONE, box2.getOwner());
        box2.getLeftLine().claim(Player.BLUE);
        assertEquals(Player.BLUE, box1.getOwner());
        assertEquals(Player.BLUE, box2.getOwner());
    }
}
