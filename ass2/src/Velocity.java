/**
 * @author Nofar Bart
 * ID: 211468343
 * Course: OOP
 * Group: 03
 * Assignment: 2
 * Velocity- Class description:
 * determines the fields and the methods of a velocity.
 */
public class Velocity {
    private double dx;
    private double dy;
    private int frameBegin;
    static final int FRAME_BEGIN_DEFAULT = 0;
    private int frameEnd;
    private static final int FRAME_END_DEFAULT = 200;
    static final int ONE_HUNDRED_EIGHTY = 180;
    /**
     * A constructor for Velocity.
     * @param dx double- dx of velocity.
     * @param dy double- dy of velocity.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
        this.frameBegin = FRAME_BEGIN_DEFAULT;
        this.frameEnd = FRAME_END_DEFAULT;
    }
    /**
     * A constructor for Velocity.
     * @param dx double- dx of velocity.
     * @param dy double- dy of velocity.
     * @param frameBegin int- the edge of the frame for which the balls move in
     *                  (direction change when touching edge).
     * @param frameEnd int- the edge of the frame for which the balls move in
     *                  (direction change when touching edge).
     */
    public Velocity(double dx, double dy, int frameBegin, int frameEnd) {
        this.dx = dx;
        this.dy = dy;
        this.frameBegin = frameBegin;
        this.frameEnd = frameEnd;
    }
    /**
     * @return frameBegin field value of this velocity.
     */
    public double getFrameBegin() {
        return frameBegin;
    }
    /**
     * @return frameEnd field value of this velocity.
     */
    public double getFrameEnd() {
        return frameEnd;
    }
    /**
     * Determines setFrameBegin value.
     * @param setFrameBegin int- the edge of the frame for which the balls move in
     *                   (direction change when touching edge).
     */
    public void setFrameBegin(int setFrameBegin) {
        this.frameBegin = setFrameBegin;
    }
    /**
     * Determines setFrameEnd value.
     * @param setFrameEnd int- the edge of the frame for which the balls move in
     *                        (direction change when touching edge).
     */
    public void setFrameEnd(int setFrameEnd) {
        this.frameEnd = setFrameEnd;
    }
    /**
     * @return dx field value of this velocity.
     */
    public double getDx() {
        return dx;
    }
    /**
     * @return dy field value of this velocity.
     */
    public double getDy() {
        return dy;
    }
    /**
     * Determines dx value.
     * @param setDx double- dx to enter dx field of velocity.
     */
    public void setDx(double setDx) {
        this.dx = setDx;
    }
    /**
     * Determines dy value.
     * @param setDy double- dy to enter dy field of velocity.
     */
    public void setDy(double setDy) {
        this.dy = setDy;
    }
    /**
     * @param angle double- the angle of the ball in degrees.
     * @param speed double- the speed of the ball.
     * @return new velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.sin(angle / ONE_HUNDRED_EIGHTY * Math.PI) * speed;
        double dy = Math.cos(angle / ONE_HUNDRED_EIGHTY * Math.PI) * speed;
        return new Velocity(dx, dy);
    }
    /**
     * @param p Point- the point to update to a new one with speed.
     * Takes a point with position (x,y).
     * @return a new point with position (x+dx, y+dy))
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }
}