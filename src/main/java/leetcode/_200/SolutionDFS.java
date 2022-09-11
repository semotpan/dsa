package leetcode._200;

// https://leetcode.com/problems/number-of-islands/

public class SolutionDFS {

    public int numIslands(char[][] grid) {
        var dfs = new DFS(grid);
        var count = 0;
        for (var i = 0; i < dfs.R; i++) {
            for (var j = 0; j < dfs.C; j++) {
                if (grid[i][j] == '1') {
                    dfs.fill(i, j);
                    count++;
                }
            }
        }

        return count;
    }
}

class DFS {

    private final int[] dirX = new int[]{-1, 0, 0, 1};
    private final int[] dirY = new int[]{0, -1, 1, 0};
    private final char[][] grid;
    final int R; // number of rows
    final int C; // number of columns


    DFS(char[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
    }

    void fill(int x, int y) {
        grid[x][y] = '0';

        for (var i = 0; i < 4; i++) {
            var xx = x + dirX[i];
            var yy = y + dirY[i];
            if (inBorder(xx, yy) && grid[xx][yy] == '1') {
                fill(xx, yy);
            }
        }
    }

    private boolean inBorder(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
