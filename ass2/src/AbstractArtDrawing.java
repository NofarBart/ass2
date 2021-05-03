import biuoop.GUI;
import biuoop.DrawSurface;
import java.util.Random;
import java.awt.Color;
/**
 * @author Nofar Bart
 * ID: 211468343
 * Course: OOP
 * Group: 03
 * Assignment: 2
 * AbstractArtDrawing- Class description:
 * Creates random lines and finds their middle (marks in blue)
 * and their intersections with other lines (marks in red).
 */
public class AbstractArtDrawing {
    static final int ZERO = 0;
    static final int ONE = 1;
    static final int THREE = 3;
    static final int TEN = 10;
    static final int THREE_HUNDRED = 300;
    static final int FOUR_HUNDRED = 400;
    /**
     * drawRandomLines() method- Creates random lines (from random points)
     * and finds their middle and their intersections with other lines.
     * Paints points accordingly.
     * Calls methods of other classes.
     */
    public static void drawRandomLines() {
        Line[] lines = new Line[TEN];
        // Creates a random-number generator
        Random rand = new Random();
        // Creates a window with the title "Draw Random Lines"
        // which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("Draw Random Lines", FOUR_HUNDRED, THREE_HUNDRED);
        DrawSurface d = gui.getDrawSurface();
        for (int i = ZERO; i < TEN; ++i) {
            int x1 = rand.nextInt(FOUR_HUNDRED) + ONE; // get integer in range 1-400
            int y1 = rand.nextInt(THREE_HUNDRED) + ONE; // get integer in range 1-300
            int x2 = rand.nextInt(FOUR_HUNDRED) + ONE; // get integer in range 1-400
            int y2 = rand.nextInt(THREE_HUNDRED) + ONE; // get integer in range 1-300
            Line newLine = new Line(x1, y1, x2, y2);
            // Enters the new line to an array.
            lines[i] = newLine;
            // Draws lines and points mentioned in the description of class.
            d.setColor(Color.BLACK);
            d.drawLine(x1, y1, x2, y2);
            d.setColor(Color.BLUE);
            Point newPoint = lines[i].middle();
            d.fillCircle((int) newPoint.getX(), (int) newPoint.getY(), THREE);
        }
        d.setColor(Color.RED);
        for (int i = ZERO; i < TEN; i++) {
            for (int j = i + ONE; j < TEN; j++) {
                Point newPoint = lines[i].intersectionWith(lines[j]);
                if (newPoint != null) {
                    d.fillCircle((int) newPoint.getX(), (int) newPoint.getY(), THREE);
                }
            }
        }
        gui.show(d);
    }
    /**
     * @param args strings, calls drawRandomLines().
     */
    public static void main(String[] args) {
        drawRandomLines();
    }
}