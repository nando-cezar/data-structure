/******************************************************************************
 *  Compilation:  javac Point.java
 *  Execution:    java Point
 *  Dependencies: none
 *  
 *  An immutable data type for points in the plane.
 *  For use on Coursera, Algorithms Part I programming assignment.
 *
 ******************************************************************************/

import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

//    public final Comparator<Point> slopeComparator = new SlopeOrder();
    /**
     * Initializes a new point.
     *
     * @param  x the <em>x</em>-coordinate of the point
     * @param  y the <em>y</em>-coordinate of the point
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    private class SlopeOrder implements Comparator<Point> {

        public int compare(Point o1, Point o2) {
            if (o1 == null || o2 == null)
                throw new java.lang.NullPointerException("null argument not allowed");
            double s1 = slopeTo(o1);
            double s2 = slopeTo(o2);
            if (s1 < s2)
                return -1;
            else if (s1 > s2)
                return 1;
//            return o1.compareTo(o2);
            return 0;
        }
        
    }
    
    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // FAbio
//    public void draw(int i) {
//        /* DO NOT MODIFY */
//        StdDraw.point(x, y);
//        StdDraw.setPenColor(StdDraw.RED);
//        StdDraw.circle(x, y, 100);
//        StdDraw.text(x+200, y+200, "" + i);
//        StdDraw.setPenColor(StdDraw.BLACK);
//    }

    // Fabio
//    public void drawTo(Point that, int i) {
//        /* DO NOT MODIFY */
//        StdDraw.line(this.x, this.y, that.x, that.y);
//        StdDraw.text(that.x+500, that.y+500, String.format("%d: %.2f", i, this.slopeTo(that)));
//    }
    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns the slope between this point and the specified point.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *
     * @param  that the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that) {
        
        if (this.x == that.x && this.y == that.y)
            return Double.NEGATIVE_INFINITY;
        
        // horizontal line segment
        if (this.y == that.y)
            return +0.0;
        
        // vertical line segment
        if (this.x == that.x)
            return Double.POSITIVE_INFINITY;
        
        return ((double) that.y - (double) this.y)/((double) that.x - (double) this.x);
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param  that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     *         point (x0 = x1 and y0 = y1);
     *         a negative integer if this point is less than the argument
     *         point; and a positive integer if this point is greater than the
     *         argument point
     */
    public int compareTo(Point that) {
        if (this.y > that.y)
            return 1;
        else if (this.y < that.y)
            return -1;
        else
            if (this.x > that.x)
                return 1;
            else if (this.x < that.x)
                return -1;
            else return 0;

    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
        return new SlopeOrder(); // this.slopeComparator;
    }

    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        
        Point pt11 = new Point(1, 1);
        Point pt12 = new Point(1, 2);
        Point pt22 = new Point(2, 2);
        Point pt21 = new Point(2, 1);
        Point pt11b = new Point(1, 1);
        
        System.out.println(pt11.compareTo(pt11b));
        System.out.println(pt12.compareTo(pt22));
        System.out.println(pt21.compareTo(pt22));
        System.out.println(pt12.compareTo(pt21));
        
        System.out.println(pt11.slopeTo(pt22));
        Point pt10 = new Point(1, 0);
        System.out.println(pt10.slopeTo(pt21));
    }
}
