import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
    
    private LineSegment[] mSegments = new LineSegment[0];
    
//    public void printSlopes(Point[] points, Point p) {
//        StdDraw.clear();
//        p.draw(0);
//        for (int i = 1; i < points.length; i++) {
//            points[i].draw();
//            p.drawTo(points[i], i);
//        }
//        StdDraw.show();
//    }
    
    public FastCollinearPoints(Point[] points) {
        if (points == null)
            throw new java.lang.IllegalArgumentException("null argument provided");
        for (int i = 0; i < points.length; i++)
            if (points[i] == null)
                throw new java.lang.IllegalArgumentException("null element provided");
            
        /*
         * Think of p as the origin.
         * For each other point q, determine the slope it makes with p.
         * Sort the points according to the slopes they makes with p.
         * Check if any 3 (or more) adjacent points in the sorted order have equal slopes with respect to p. 
         * If so, these points, together with p, are collinear.
         * apply this method to n points at
         */
        Queue<Point[]> segQueue = new Queue<Point[]>();
        Arrays.sort(points);
        Point[] points2 = points.clone();
        
        for (Point p : points) {
//            System.out.println("--> Sorting for point p = ".concat(p.toString()));
            Arrays.sort(points2, p.slopeOrder()); // hope Arrays.sort is stable
//            printSlopes(points2, p);
            double slope = 0;
            int index = 0;
            for (int i = 0; i < points2.length; i++) {
                if (i == 0) {
                    slope = p.slopeTo(points2[i]); // will always be -Infinity
                    continue;
                }
                if (points2[i].compareTo(p) == 0)
                    throw new java.lang.IllegalArgumentException("duplicated element provided");
                double slopeAux = p.slopeTo(points2[i]);
                if (slopeAux != slope || (i == points2.length-1)) {
                    if (i == points2.length-1 && slope == slopeAux) i++;
                    if (index == 0 || i-index < 3) {
                        slope = slopeAux;
                        index = i;
                    } else {
                        Point[] segPoints = new Point[1+i-index];
                        segPoints[0] = p;
                        int segPointsIndex = 1;
                        for (int j = index; j < i; j++) {
                            segPoints[segPointsIndex] = points2[j];
                            segPointsIndex++;
                        }
                        Arrays.sort(segPoints);
                        if (segQueue.size() == 0)
                            segQueue.enqueue(segPoints);
                        else {
                            Queue<Point[]> segQueueAux = new Queue<Point[]>();
                            boolean inserted = false;
                            for (Point[] ap : segQueue) {
                                double apSlope = ap[0].slopeTo(ap[1]);
                                if (slope < apSlope) {
                                    if (!inserted)
                                        segQueueAux.enqueue(segPoints);
                                    inserted = true;
                                    segQueueAux.enqueue(ap);
                                }
                                if (slope > apSlope)
                                    segQueueAux.enqueue(ap);
                                if (slope == apSlope) {
                                    // same slope but different segments?
                                    if (ap[0].compareTo(segPoints[0]) != 0)
                                        segQueueAux.enqueue(ap);
                                    else {
                                        segQueueAux.enqueue(segPoints);
                                        inserted = true;
                                    }
                                }
                            }
                            if (!inserted)
                                segQueueAux.enqueue(segPoints);
                            segQueue = segQueueAux;
                        }
//                        break;
                        index = i;
                    }
                }
            }
        }
        if (segQueue.size() > 0) {
            mSegments = new LineSegment[segQueue.size()];
            int i = 0;
            for (Point[] ap: segQueue) {
                mSegments[i] = new LineSegment(ap[0], ap[ap.length-1]);
                i++;
            }
        }
    }   
    
    public int numberOfSegments() {
        // the number of line segments
        if (mSegments == null) return 0;
        return mSegments.length;
    }
    
    public LineSegment[] segments() {
        return mSegments.clone();
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        Arrays.sort(points);
        // Fabio
//        int i = 0;
        for (Point p : points) {
//            p.draw(i);
            p.draw();
//            i++;
        }
        StdDraw.show();
        

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        StdDraw.clear();
        // Fabio
//      int i = 0;
//      for (Point p : points) {
//          p.draw(i);
////          p.draw();
//          i++;
//      }
//      StdDraw.show();
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
