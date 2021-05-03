import biuoop.GUI;
/**
 * @author Nofar Bart
 * ID: 211468343
 * Course: OOP
 * Group: 03
 * Assignment: 2
 * MultipleFramesBouncingBallsAnimation- Class description: handles multiple balls animation,
 * with two different frames.
 * Calls MultipleBouncingBallsAnimation.drawBallsAnimation.
 */
public class MultipleFramesBouncingBallsAnimation {
    static final int ZERO = 0;
    static final int FOUR = 4;
    static final int FIFTY = 50;
    static final int ONE_HUNDRED_FIFTY = 150;
    static final int FOUR_HUNDRED_FIFTY = 450;
    static final int SIX_HUNDRED = 600;
    static final int EIGHT_HUNDRED = 800;
    /**
     * @param args strings, later to be transmitted
     * into integer arguments.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("title", EIGHT_HUNDRED, SIX_HUNDRED);
        if (args.length == ZERO || args[ZERO].equals("")) {
            System.out.println("No input");
            return;
        }
        MultipleBouncingBallsAnimation.drawBallsAnimation(FOUR_HUNDRED_FIFTY, FIFTY,
                FOUR_HUNDRED_FIFTY, ONE_HUNDRED_FIFTY, args, gui, FOUR);
    }
}