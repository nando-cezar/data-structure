import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
    
    private LineSegment[] mSegments = new LineSegment[0];
    
    public BruteCollinearPoints(Point[] points) {
        // finds all line segments containing 4 points
        if (points == null)
            throw new java.lang.IllegalArgumentException("null argument provided");
        
        Queue<LineSegment> segQueue = new Queue<LineSegment>();
        
        // to find the line segments that are collinear, calculate the slope
        // among themselves 
        for (int p = 0; p < points.length; p++) {
            if (points[p] == null)
                throw new java.lang.IllegalArgumentException("null element provided");
            for (int q = p+1; q < points.length; q++) {
                if (points[q] == null)
                    throw new java.lang.IllegalArgumentException("null element provided");
                if (points[p].compareTo(points[q]) == 0)
                    throw new java.lang.IllegalArgumentException("duplicate element provided");
                for (int r = q+1; r < points.length; r++) {
                    if (points[r] == null)
                        throw new java.lang.IllegalArgumentException("null element provided");
                    for (int s = r+1; s < points.length; s++) {
                        if (points[s] == null)
                            throw new java.lang.IllegalArgumentException("null element provided");
                        double sq = points[p].slopeTo(points[q]);
                        double sr = points[p].slopeTo(points[r]);
                        double ss = points[p].slopeTo(points[s]);
                        
                        if (sq == sr && sq == ss) {
                            // obtain the highest and the lowest point and create a line segment
                            Point[] aPoint = new Point[]{points[p], points[q], points[r], points[s]};
                            Arrays.sort(aPoint);
                            segQueue.enqueue(new LineSegment(aPoint[0], aPoint[3]));
                        }
                    }
                }
            }
        }
        
        if (segQueue.size() > 0) {
            mSegments = new LineSegment[segQueue.size()];
            int i = 0;
            for (LineSegment ls: segQueue) {
                mSegments[i] = ls;
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
        System.out.println("teste");
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
        // Fabio
//        int i = 0;
        for (Point p : points) {
//            p.draw(i);
            p.draw();
//            i++;
        }
        StdDraw.show();
        

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
