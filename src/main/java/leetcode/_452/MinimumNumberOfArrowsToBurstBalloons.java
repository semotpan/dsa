package leetcode._452;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        var arrows = 1;
        var strikeAreaStart = points[0][1];

        for (var point : points) {
            if (strikeAreaStart < point[0]) {
                strikeAreaStart = point[1];
                arrows++;
            }
        }

        return arrows;
    }
}
