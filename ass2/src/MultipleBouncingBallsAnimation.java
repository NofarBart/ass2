import biuoop.GUI;
import java.awt.Color;
import java.util.Random;
/**
 * @author Nofar Bart
 * ID: 211468343
 * Course: OOP
 * Group: 03
 * Assignment: 2
 * MultipleBouncingBallsAnimation- Class description: handles multiple balls animation.
 * Uses an array of balls. Calls MultipleBalls.drawAnimation.
 */
public class MultipleBouncingBallsAnimation {
    static final int ZERO = 0;
    static final int ONE = 1;
    static final int TWO = 2;
    static final int THREE = 3;
    static final int FIFTY = 50;
    static final int TWO_HUNDRED = 200;
    static final int TWO_HUNDRED_FIFTY_FIVE = 255;
    /**
     * randomColor() method- Generates a random color.
     * @return new color.
     */
    public static java.awt.Color randomColor() {
        Random rand = new Random();
        return new java.awt.Color(rand.nextInt(TWO_HUNDRED_FIFTY_FIVE) + ONE,
                rand.nextInt(TWO_HUNDRED_FIFTY_FIVE) + ONE, rand.nextInt(TWO_HUNDRED_FIFTY_FIVE) + ONE);
    }
    /**
     * drawBallsAnimation method- Creates an array of balls, refers to illegal inputs.
     * Sets random location to a ball-
     * if the ball's beginning point is out of frame- changes location
     * until the ball is in frame limits.
     * Sets random color using randomColor() and sets velocity according to the ball's size.
     * Uses Ball and Gui classes methods and fields.
     * @param size1 int- size of frame- addition to begin1.
     * @param begin1 int- size of frame- beginning of frame.
     * @param size2 int- size of second frame- addition to begin2.
     * @param begin2 int- size of second frame- beginning of frame.
     * @param args String[]- arguments of balls sizes, given by user- later to be transmitted
     * into integer arguments.
     * @param gui GUI- a window to draw in.
     * @param task int- number of task- according to the mission-
     * determines whether to paint rectangles on the surface.
     */
    public static void drawBallsAnimation(int size1, int begin1, int begin2, int size2,
                                          String[] args, GUI gui, int task) {
        Ball[] array = new Ball[args.length];
        Random rand = new Random();
        int x, y;
        for (int i = ZERO; i < args.length; i++) {
            if (Integer.parseInt(args[i]) <= ZERO) {
                System.out.println("illegal values");
                return;
            }
            boolean flag = i < args.length - args.length / TWO;
            if (flag) {
                if (Integer.parseInt(args[i]) * TWO > size1) {
                    System.out.println("Size of ball is too big");
                    return;
                }
                x = rand.nextInt(size1) + begin1 + Integer.parseInt(args[i]); // get integer in range 1-200
                y = rand.nextInt(size1) + begin1 + Integer.parseInt(args[i]); // get integer in range 1-200
                while (x + Integer.parseInt(args[i]) > size1 + begin1) {
                    x -= ONE;
                }
                while (x + Integer.parseInt(args[i]) < begin1) {
                    x += ONE;
                }
                while (y + Integer.parseInt(args[i]) > size1 + begin1) {
                    y -= ONE;
                }
                while (y + Integer.parseInt(args[i]) < begin1) {
                    y += ONE;
                }
            } else {
                if (Integer.parseInt(args[i]) * TWO > size2) {
                    System.out.println("Size of ball is too big");
                    return;
                }
                x = rand.nextInt(size2) + begin2 + Integer.parseInt(args[i]); // get integer in range 1-200
                y = rand.nextInt(size2) + begin2 + Integer.parseInt(args[i]); // get integer in range 1-200
                while (x + Integer.parseInt(args[i]) > size2 + begin2) {
                    x -= ONE;
                }
                while (x + Integer.parseInt(args[i]) < begin2) {
                    x += ONE;
                }
                while (y + Integer.parseInt(args[i]) > size2 + begin2) {
                    y -= ONE;
                }
                while (y + Integer.parseInt(args[i]) < begin2) {
                    y += ONE;
                }

            }
            Color color = randomColor();
            Point newPoint = new Point(x, y);
            Ball newBall = new Ball(newPoint, Integer.parseInt(args[i]), color);
            Velocity v;
            if (newBall.getSize() < FIFTY) {
                if (flag) {
                    v = new Velocity((double) FIFTY / newBall.getSize(), (double) FIFTY / newBall.getSize(),
                            begin1, begin1 + size1);
                } else {
                    v = new Velocity((double) FIFTY / newBall.getSize(),
                            (double) FIFTY / newBall.getSize(), begin2, begin2 + size2);
                }
            } else {
                if (flag) {
                    v = new Velocity(ONE, ONE, begin1, begin1 + size1);
                } else {
                    v = new Velocity(ONE, ONE, begin2, begin2 + size2);
                }
            }
            newBall.setVelocity(v);
            array[i] = newBall;
        }
        MultipleBalls.drawAnimation(array, args.length, gui, task);
    }
    /**
     * @param args strings, later to be transmitted
     * into integer arguments.
     */
    public static void main(String[] args) {
        if (args.length == ZERO || args[ZERO].equals("")) {
            System.out.println("No input");
            return;
        }
        GUI gui = new GUI("Animation", TWO_HUNDRED, TWO_HUNDRED);
        drawBallsAnimation(TWO_HUNDRED, ONE, ONE, TWO_HUNDRED, args, gui, THREE);
    }
}
