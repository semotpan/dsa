package leetcode._980;

public class UniquePathsIII {

    private int startX, startY;
    private int nonObstacles;
    private int pathCount;
    private int[][] grid;


    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        init();
        back(startX, startY, nonObstacles);
        return pathCount;
    }

    private void back(int x, int y, int remain) {
        if (isEnd(x, y) && remain == 1) {
            pathCount++;
            return;
        }

        var temp = grid[x][y];
        grid[x][y] = -3;
        remain--;

        if (isInGrid(x + 1, y) && canWalk(x + 1, y)) {
            back(x + 1, y, remain);
        }

        if (isInGrid(x - 1, y) && canWalk(x - 1, y)) {
            back(x - 1, y, remain);
        }

        if (isInGrid(x, y + 1) && canWalk(x, y + 1)) {
            back(x, y + 1, remain);
        }

        if (isInGrid(x, y - 1) && canWalk(x, y - 1)) {
            back(x, y - 1, remain);
        }

        grid[x][y] = temp;
    }

    private boolean isInGrid(int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[x].length;
    }

    private boolean canWalk(int x, int y) {
        return grid[x][y] >= 0;
    }

    private boolean isEnd(int x, int y) {
        return grid[x][y] == 2;
    }

    private void init() {
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[i].length; j++) {
                if (grid[i][j] >= 0) {
                    nonObstacles++;
                }

                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }
    }
}
