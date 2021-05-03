/**
 * @author Nofar Bart
 * ID: 211468343
 * Course: OOP
 * Group: 03
 * Assignment: 2
 * Point- Class description:
 * determines the fields and the methods of a Point.
 */
public class Point {
    static final int MINUS_FIVE = -5;
    static final int TWO = 2;
    static final int TEN = 10;
    static final double EPSILON = Math.pow(TEN, MINUS_FIVE);
    private double x;
    private double y;
    /**
     * A constructor for Point.
     * @param x double- the x value of point.
     * @param y double- the y value of point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Finds the distance between two points.
     * @param other Point- another point to find the distance with the current point.
     * @return the distance of this point to the other point
     */
    public double distance(Point other) {
        double xValue = Math.abs(other.x - this.x);
        double yValue = Math.abs(other.y - this.y);
        return Math.sqrt(Math.pow(xValue, TWO) + Math.pow(yValue, TWO));
    }
    /**
     * Checks whether two points are equal.
     * @param other Point- another point to compare to.
     * @return true is the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return Math.abs(other.x - this.x) < EPSILON && Math.abs(other.y - this.y) < EPSILON;
    }
    /**
     * @return x field value of this point.
     */
    public double getX() {
        return this.x;
    }
    /**
     * @return y field value of this point.
     */
    public double getY() {
        return this.y;
    }
    /**
     * Determines x value.
     * @param xValue double- x parameter of a point.
     **/
    public void setX(double xValue) {
        this.x = xValue;
    }
    /**
     * Determines y value.
     * @param yValue double- y parameter of a point.
     */
    public void setY(double yValue) {
        this.y = yValue;
    }
}
