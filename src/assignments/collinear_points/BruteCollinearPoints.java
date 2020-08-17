package assignments.collinear_points;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
	
	private ArrayList<LineSegment> segments;
	
	public BruteCollinearPoints(Point[] pointsOriginal)    // finds all line segments containing 4 points
	{
		int N = pointsOriginal.length;
		Point[] points = Arrays.copyOf(pointsOriginal, N);
        Arrays.sort(points);
        
        checkCornerCases(points);
        
		segments = new ArrayList<>();
		for(int i = 0; i < N - 3; i ++ ) {
			for(int j = i+1; j<N -2 ; j++) {
				for(int k = j+1; k<N -1 ; k++) {
					for(int l = k+1; l<N; l++) {
						if(points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]) && points[i].slopeTo(points[k]) == points[i].slopeTo(points[l])) {
							segments.add(new LineSegment(points[i], points[l]));
						}
					}
				}
			}
		}
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
	
	public int numberOfSegments()        // the number of line segments
	{
		return segments.size();
	}
	public LineSegment[] segments()                // the line segments
	{
		return segments.toArray(new LineSegment[segments.size()]);
	}
}
