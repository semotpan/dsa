package leetcode._909;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        return new BSF(board).distance();
    }
}

record Coordinate(int x, int y) {}

class BSF {

    private final int[][] board;
    private final Coordinate[] orderedBoard;
    private final int[] dist;
    private final int NSquare;

    BSF(int[][] board) {
        this.NSquare = board.length * board.length;
        this.board = board;
        this.orderedBoard = new Coordinate[NSquare + 1];

        this.dist = new int[NSquare + 1];
        Arrays.fill(this.dist, -1);

        orderBorder();
        bfs();
    }

    private void orderBorder() {
        // order snake coordinates from top-left to bottom-right
        var N = board.length;
        for (int x = N - 1, cell = 1; x >= 0; x--) {
            for (int y = 0; y < N; y++)
                orderedBoard[cell++] = new Coordinate(x, y);

            if (--x < 0) break;

            for (int y = N - 1; y >= 0; y--)
                orderedBoard[cell++] = new Coordinate(x, y);
        }
    }

    private void bfs() {

        var queue = new ArrayDeque<Integer>();
        var currStep = 1;
        queue.add(currStep);

        dist[currStep] = 0;

        while (!queue.isEmpty()) {
            currStep = queue.poll();

            if (dist[NSquare] != -1 && dist[currStep] >= dist[NSquare])
                continue;

            var end = Integer.min(currStep + 6, NSquare);
            for (int next = currStep + 1; next <= end; ++next) {
                var nextStep = next;

                if (board[orderedBoard[next].x()][orderedBoard[next].y()] != -1)
                    nextStep = board[orderedBoard[next].x()][orderedBoard[next].y()];

                if (dist[nextStep] == -1) {
                    dist[nextStep] = dist[currStep] + 1;
                    queue.add(nextStep);
                }
            }
        }
    }

    public int distance() {
        return dist[NSquare];
    }
}
