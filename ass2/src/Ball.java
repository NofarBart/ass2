import biuoop.DrawSurface;
/**
 * @author Nofar Bart
 * ID: 211468343
 * Course: OOP
 * Group: 03
 * Assignment: 2
 * Ball- Class description:
 * determines the fields and the methods of a ball.
 * */
public class Ball {
    private Point center;
    private final int radius;
    private final java.awt.Color color;
    private Velocity velocity;
    /**
     * A constructor for Ball.
     * @param center Point- the center of the ball from user.
     * @param r int- the radius of the ball from user.
     * @param color java.awt.Color- the color of the ball from user.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = new Point(center.getX(), center.getY());
        this.radius = r;
        this.color = color;
    }
    /**
     * A constructor for Ball.
     * @param x double- the x value of center point of the ball from user.
     * @param y double- the y value of center point of the ball from user.
     * @param r int- the radius of the ball from user.
     * @param color java.awt.Color- the color of the ball from user.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
    }
    /**
     * @return x field value of a ball.
     */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * @return y field value of a ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }
    /**
     * @return radius field value of a ball.
     */
    public int getSize() {
        return this.radius;
    }
    /**
     * @return color field value of a ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }
    /**
    * draws the ball on the given DrawSurface.
    * @param surface DrawSurface- the surface of the ball given by function.
    **/
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.radius);
    }
    /**
     * Determines velocity value.
     * @param v Velocity- the velocity of the ball given by function.
     **/
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }
    /**
     * Determines velocity value.
     * @param dx double- dx of velocity.
     * @param dy double- dy of velocity.
     **/
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }
    /**
     * @return velocity field value of a ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }
    /**
     * Changes location of ball if ball reaches limits of frame.
     * (The coordinates get the opposite direction.
     * Calls applyToPoint function in order to change ball's location.
     **/
    public void moveOneStep() {
        if (this.velocity == null) {
            return;
        }
        if (this.center.getX() + this.radius > this.velocity.getFrameEnd() - this.velocity.getDx()) {
            this.velocity.setDx(-this.velocity.getDx());
        }
        if (this.center.getX() - this.radius < this.velocity.getFrameBegin() - this.velocity.getDx()) {
            this.velocity.setDx(-this.velocity.getDx());
        }
        if (this.center.getY() + this.radius > this.velocity.getFrameEnd() - this.velocity.getDy()) {
            this.velocity.setDy(-this.velocity.getDy());
        }
        if (this.center.getY() - this.radius < this.velocity.getFrameBegin() - this.velocity.getDy()) {
            this.velocity.setDy(-this.velocity.getDy());
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }
}
