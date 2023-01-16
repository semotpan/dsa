package leetcode._62;

public class UniquePaths {

    /**
     * Dynamic Programming (0ms, 38.8MB)
     */
    public int uniquePaths(int m, int n) {
        int[][] grid = initGrid(m, n);

        for (var y = 1; y < m; y++) {
            for (var x = 1; x < n; ++x) {
                grid[y][x] = (grid[y - 1][x] + grid[y][x - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }

    private int[][] initGrid(int m, int n) {
        var grid = new int[m][n];

        for (var y = 0; y < m; y++) {
            grid[y][0] = 1;
        }

        for (var x = 0; x < n; x++) {
            grid[0][x] = 1;
        }

        return grid;
    }

    /**
     * backtracking solution - Time Limit Exceed
     */
    private int endY, endX;
    private int count;

    int back(int m, int n) {
        this.endY = m - 1;
        this.endX = n - 1;
        dfs(0, 0);
        return count;
    }

    private void dfs(int y, int x) {
        if (y == endY && x == endX) {
            count++;
            return;
        }

        if (y + 1 <= endY) {
            dfs(y + 1, x);
        }

        if (x + 1 <= endX) {
            dfs(y, x + 1);
        }
    }
}
