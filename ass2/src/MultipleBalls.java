import biuoop.GUI;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author Nofar Bart
 * ID: 211468343
 * Course: OOP
 * Group: 03
 * Assignment: 2
 * MultipleBalls- Class description: handles multiple balls animation.
 * Uses an array of balls, and moves all.
 * According to the mission- decides whether to paint rectangles on the surface.
 */
public class MultipleBalls {
    static final int ZERO = 0;
    static final int FOUR = 4;
    static final int TEN = 10;
    static final int FIFTY = 50;
    static final int ONE_HUNDRED_FIFTY = 150;
    static final int FOUR_HUNDRED_FIFTY = 450;
    /**
     * drawAnimation method- draws moving balls according to given array.
     * If needed, paints rectangles on the surface.
     * Uses Ball and Gui classes methods and fields.
     * @param balls Ball[]- an array of balls to animate.
     * @param size int- size of given array.
     * @param gui GUI- a window to draw in.
     * @param task int- number of task- according to the mission-
     * determines whether to paint rectangles on the surface.
     */
    public static void drawAnimation(Ball[] balls, int size, GUI gui, int task) {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        while (true) {
            if (balls == null) {
                return;
            }
            DrawSurface d = gui.getDrawSurface();
            if (task == FOUR) {
                d.setColor(Color.GRAY);
                d.fillRectangle(FIFTY, FIFTY, FOUR_HUNDRED_FIFTY, FOUR_HUNDRED_FIFTY);
                d.setColor(Color.YELLOW);
                d.fillRectangle(FOUR_HUNDRED_FIFTY, FOUR_HUNDRED_FIFTY, ONE_HUNDRED_FIFTY, ONE_HUNDRED_FIFTY);
            }
            for (int i = ZERO; i < size; i++) {
                balls[i].moveOneStep();
                balls[i].drawOn(d);
                sleeper.sleepFor(TEN);
            } // wait for 10 milliseconds.
            gui.show(d);
        }
    }
}