/**
 * @author Nofar Bart
 * ID: 211468343
 * Course: OOP
 * Group: 03
 * Assignment: 2
 * Line- Class description:
 * determines the fields and the methods of a line.
 * */
public class Line {
    private final Point start;
    private final Point end;
    private final double length;
    static final int ZERO = 0;
    static final int MINUS_ONE = -1;
    /**
     * A constructor for Line.
     * @param start Point- the beginning point of the line from user.
     * @param end Point- the end point of the line from user.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.length = findLength();
    }
    /**
     * A constructor for Line.
     * @param x1 double- the x field of beginning point of the line from user.
     * @param y1 double- the y field of beginning point of the line from user.
     * @param x2 double- the x field of end point of the line from user.
     * @param y2 double- the y field of end point of the line from user.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.length = findLength();
    }
    /**
     * @return length field value of a line.
     */
    public double length() {
        return this.length;
    }
    /**
     * Calculates middle point using start and end points.
     * @return middle point value of a line.
     */
    public Point middle() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }
    /**
     * @return start (point) field value of a line.
     */
    public Point start() {
        return this.start;
    }
    /**
     * @return end (point) field value of a line.
     */
    public Point end() {
        return this.end;
    }
    /**
     * Finds the length of a line.
     * @return length value.
     */
    public double findLength() {
       return (Math.sqrt(Math.pow(this.end.getY() - this.start.getY(), 2)
               + Math.pow(this.end.getX() - this.start.getX(), 2)));
    }
    /**
     * Finds the incline of a line.
     * @return incline value.
     */
    public double incline() {
        if (this.end.getX() - this.start.getX() == ZERO) {
            return ZERO;
        }
        return (end.getY() - start.getY()) / (end.getX() - start.getX());
    }
    /**
     * Finds the intersection with y of a line.
     * @return intersection with y of the line.
     * if the intersection is indeterminable (no intersection),
     * returns -1.
     */
    public double intersectionWithY() {
        double incline = incline();
        if (this.end.getX() - this.start.getX() == ZERO && this.end.getY() - this.start.getY() != ZERO) {
            return MINUS_ONE;
        }
        return (this.start.getY() - (incline * this.start.getX()));
    }
    /**
     * Finds the intersection with y of a line.
     * @param other Line- another line to compare with.
     * @return boolean expression-
     * if the lines intersect or overlap returns true,
     * else returns false.
     */
    public boolean isIntersecting(Line other) {
        if (overlapping(other)) {
            return true;
        }
        Point check = intersectionWith(other);
        return check != null;
    }
    /**
     * Finds if two lines overlap.
     * @param other Line- another line to compare with.
     * @return boolean expression-
     * if the lines overlap- have the same incline and coincide returns true,
     * else returns false.
     */
    public boolean overlapping(Line other) {
        double intersectionWithY1 = intersectionWithY();
        double intersectionWithY2 = other.intersectionWithY();
        if (intersectionWithY1 == MINUS_ONE && intersectionWithY2 == MINUS_ONE) {
            return (this.start.getY() <= other.end.getY() && this.end.getY() >= other.end.getY());
        }
        if (incline() == other.incline()
                && (intersectionWithY1 == intersectionWithY2)) {
            if (this.start.getX() <= other.end.getX() && this.end.getX() >= other.end.getX()) {
                return true;
            } else if (other.start.getX() <= this.end.getX() && other.end.getX() >= this.end.getX()) {
                return true;
            } else if (other.end.getX() <= this.start.getX() && other.end.getX() >= this.end.getX()) {
                return true;
            } else if (this.end.getX() <= other.end.getX() && this.start.getX() >= other.start.getX()) {
                return true;
            } else if (other.end.getX() <= this.end.getX() && other.start.getX() >= this.start.getX()) {
                return true;
            } else {
                return this.end.getX() >= other.end.getX() && this.start.getX() <= other.start.getX();
            }
        }
        return false;
    }
    /**
     * Finds the intersection point between two lines.
     * @param other Line- another line to compare with.
     * @return Point-
     * if the lines intersect but don't overlap returns the point,
     * else returns null.
     */
    public Point intersectionWith(Line other) {
        if (!this.overlapping(other) && (this.start.equals(other.end) || this.start.equals(other.start))) {
            return this.start;
        }
        if (!this.overlapping(other) && (this.end.equals(other.start) || (this.end.equals(other.end)))) {
            return this.end;
        }
        double incline1 = incline();
        double incline2 = other.incline();
        double intersectionWithY1 = intersectionWithY();
        double intersectionWithY2 = other.intersectionWithY();
        if ((incline1 - incline2 == ZERO && (intersectionWithY1 != MINUS_ONE && intersectionWithY2 != MINUS_ONE))
                || (intersectionWithY1 == MINUS_ONE && intersectionWithY2 == MINUS_ONE)) {
            return null;
        }
        double xSolution = (intersectionWithY2 - intersectionWithY1) / (incline1 - incline2);
        double ySolution = incline1 * xSolution + intersectionWithY1;
        if (intersectionWithY1 == MINUS_ONE && intersectionWithY2 != MINUS_ONE) {
            xSolution = this.start.getX();
            ySolution = incline2 * xSolution + intersectionWithY2;
        }
        if (intersectionWithY1 != MINUS_ONE && intersectionWithY2 == MINUS_ONE) {
            xSolution = other.start.getX();
            ySolution = incline1 * xSolution + intersectionWithY1;
        }

        if (xSolution < ZERO || ySolution < ZERO) {
            return null;
        }
        Point newPoint = new Point(xSolution, ySolution);
        if (((ySolution >= this.start.getY() && ySolution <= this.end.getY())
                || (ySolution <= this.start.getY() && ySolution >= this.end.getY()))
               && ((ySolution >= other.start.getY() && ySolution <= other.end.getY())
                || (ySolution <= other.start.getY() && ySolution >= other.end.getY()))) {
            return newPoint;
        }
        return null;
    }
    /**
     * Finds if two lines are equal.
     * @param other Line- another line to compare with.
     * @return boolean expression-
     * if the lines overlap and have the same length,
     * else returns false.
     */
    public boolean equals(Line other) {
        return overlapping(other) && this.length == other.length;
    }
}
