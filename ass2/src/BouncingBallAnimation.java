import biuoop.DrawSurface;
import biuoop.GUI;
/**
 * @author Nofar Bart
 * ID: 211468343
 * Course: OOP
 * Group: 03
 * Assignment: 2
 * BouncingBallAnimation- Class description: handles a one ball animation.
 * Gets parameters of speed and place (of the ball) from user.
 */
public class BouncingBallAnimation {
    static final int ZERO = 0;
    static final int ONE = 1;
    static final int TWO = 2;
    static final int THREE = 3;
    static final int FOUR = 4;
    static final int TWENTY = 20;
    static final int THIRTY = 30;
    static final int TWO_HUNDRED = 200;
    /**
     * drawAnimation method- Creates a ball in wanted speed and place.
     * If the ball's beginning point is out of frame- changes to location
     * until the ball is in frame limits.
     * draws a moving ball.
     * Uses Ball and Gui classes methods and fields.
     * @param dx double- dx of velocity.
     * @param dy double- dy of velocity.
     * @param start Point- the center of the ball from the user.
     */
    static void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("title", TWO_HUNDRED, TWO_HUNDRED);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
         //If the ball's beginning point is out of frame- changes to location
         //until the ball is in frame limits.
        while (start.getX() + THIRTY > TWO_HUNDRED) {
             start.setX(start.getX() - ONE);
        }
        while (start.getX() - THIRTY < ONE) {
             start.setX(start.getX() + ONE);
        }
        while (start.getY() + THIRTY > TWO_HUNDRED) {
            start.setY(start.getY() - ONE);
        }
        while (start.getY() - THIRTY < ONE) {
              start.setY(start.getY() + ONE);
        }
        // Sets a new ball.
        Ball ball = new Ball(start.getX(), start.getY(), THIRTY, java.awt.Color.BLACK);
        ball.setVelocity(dx, dy);
        ball.getVelocity().setFrameBegin(ZERO);
        ball.getVelocity().setFrameEnd(TWO_HUNDRED);
        // Animation of the ball.
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(TWENTY);  // wait for 5ZERO milliseconds.
        }
    }
    /**
     * The main checks number of arguments, saves them and sends
     * to drawAnimation method.
     * @param args strings, later to be transmitted
     * into integer arguments.
     */
    public static void main(String[] args) {
        if (args.length != FOUR) {
            System.out.println("Invalid input");
            /*
             * @return Prints in case of wrong number of
             * arguments and returns.
             */
            return;
        }
        Point newPoint = new Point(Double.parseDouble(args[ZERO]), Double.parseDouble(args[ONE]));
        double dx = Double.parseDouble(args[TWO]);
        double dy = Double.parseDouble(args[THREE]);
        drawAnimation(newPoint, dx, dy);
    }
}