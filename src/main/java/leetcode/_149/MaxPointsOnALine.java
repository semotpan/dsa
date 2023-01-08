package leetcode._149;

import java.util.HashMap;

public class MaxPointsOnALine {
    private int[][] points;

    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }

        this.points = points;

        var max = 0;
        for (var x = 0; x < points.length - 1; ++x) {
            max = Integer.max(max, maxAt(points[x], x + 1));
        }

        return max;
    }

    private int maxAt(int[] x, int y) {
        var slopes = new HashMap<Double, Integer>(points.length - y + 1, 1.0F);
        var maxLine = 0;
        for (; y < points.length; ++y) {
            var slope = slope(x[0], x[1], points[y][0], points[y][1]);
            var value = slopes.getOrDefault(slope, 0) + 1;
            slopes.put(slope, value);
            maxLine = Integer.max(maxLine, value + 1);
        }

        return maxLine;
    }

    private Double slope(int xx, int xy, int yx, int yy) {
        if (xx == yx) {
            return Double.MAX_VALUE;
        }

        if (xy == yy) {
            return 0.0;
        }

        return (double) (xy - yy) / (double) (xx - yx);
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
