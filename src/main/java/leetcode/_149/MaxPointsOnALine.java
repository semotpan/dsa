package leetcode._149;

import java.util.HashMap;

public class MaxPointsOnALine {
    private int[][] points;

    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }

        this.points = points;

        var maxPoints = 0;
        for (var x = 0; x < points.length - 1; ++x) {
            maxPoints = Integer.max(maxPoints, subMax(x));
        }
        return maxPoints;
    }

    private int subMax(int beggingIndex) {
        var slopes = new HashMap<Double, Integer>(points.length - beggingIndex + 2, 1.0F);
        int max = 0, x1 = points[beggingIndex][0], y1 = points[beggingIndex][1];

        for (var y = beggingIndex + 1; y < points.length; ++y) {
            int x2 = points[y][0], y2 = points[y][1];
            var slope = slope(x1, y1, x2, y2);
            var pointsCount = slopes.getOrDefault(slope, 0) + 1;
            slopes.put(slope, pointsCount);
            max = Integer.max(max, pointsCount + 1);
        }

        return max;
    }

    private Double slope(int x1, int y1, int x2, int y2) {
        if (x1 == x2) { // Horizontal Line (x - constant)
            return 10007.0; // max than 10^4 (bucket for horizontal)
        }

        if (y1 == y2) { // Vertical Line (y - constant)
            return 0.0;  // bucket for horizontal
        }

        return (double) (y1 - y2) / (double) (x1 - x2);
    }

    public int maxPointsTriangleArea(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }

        var max = 2;
        for (int x = 0; x < points.length - 2; x++) {
            for (int y = x + 1; y < points.length - 1; y++) {
                var maxLine = 2;
                for (int z = y + 1; z < points.length; z++) {
                    if (areCollinear(points[x], points[y], points[z])) {
                        maxLine++;
                    }
                }
                max = Integer.max(max, maxLine);
            }
        }

        return max;
    }

    private boolean areCollinear(int[] x, int[] y, int[] z) {
        int xx = x[0], xy = x[1];
        int yx = y[0], yy = y[1];
        int zx = z[0], zy = z[1];
        return 0.5 * (xx * (yy - zy) + yx * (zy - xy) + zx * (xy - yy)) == 0;
    }
}
