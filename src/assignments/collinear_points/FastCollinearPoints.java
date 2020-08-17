package assignments.collinear_points;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
	private ArrayList<LineSegment> segments;

   public FastCollinearPoints(Point[] pointsOriginal)     // finds all line segments containing 4 or more points
   {
	   checkCornerCases(pointsOriginal);
	   Point[] points = Arrays.copyOf(pointsOriginal, pointsOriginal.length);
	   segments = new ArrayList<>();
	   for (int i = 0; i < points.length - 3; i++) {
           Arrays.sort(points, i, points.length);
           Arrays.sort(points, i + 1, points.length, points[i].slopeOrder());

           int countEqual = 2;
           double currentSlope = points[i].slopeTo(points[i + 1]);
           for (int j = i + 2; j < points.length; j++) {
               if (currentSlope == points[i].slopeTo(points[j])) {
                   countEqual++;
               } else {
                   if (countEqual >= 4) {
                       segments.add(new LineSegment(points[i], points[j - 1]));
                   }
                   countEqual = 2;
                   currentSlope = points[i].slopeTo(points[j]);
               }
               if (j == points.length - 1 && countEqual >= 4) {
                   segments.add(new LineSegment(points[i], points[j]));
               }
           }
       }
   }
   public int numberOfSegments()        // the number of line segments
   {
	return segments.size();   
   }
   public LineSegment[] segments()                // the line segments
   {
	   return segments.toArray(new LineSegment[segments.size()]);
   }

   private void checkCornerCases(Point[] points) {
       if (points == null) throw new NullPointerException();

       for (Point p : points) if (p == null) throw new NullPointerException();

       for (int i = 0; i < points.length - 1; i++) {
           for (int j = i + 1; j < points.length; j++) {
               if (points[i].compareTo(points[j]) == 0)
                   throw new IllegalArgumentException();
           }
       }
   }
}