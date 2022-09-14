package leetcode._277;

/**
 * Find the Celebrity
 * https://leetcode.com/problems/find-the-celebrity/
 * <p>
 * *Constraints:
 * *  n == graph.length == graph[i].length
 * *  2 <= n <= 100
 * *  graph[i][j] is 0 or 1.
 * *  graph[i][i] == 1
 */
public class FindTheCelebrity {

    static class Relation {
        private byte[][] graph;

        void initGraph(int[][] inGraph) {
            graph = new byte[inGraph.length][inGraph.length];

            for (int i = 0; i < inGraph.length; i++) {
                for (int j = 0; j < inGraph.length; j++) {
                    if (inGraph[i][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        public boolean knows(int a, int b) {
            return graph[a][b] == 1;
        }
    }

    static class Solution extends Relation {
        public int findCelebrity(int n) {

            var candidate = 0;
            for (var p = 0; p < n; p++) {
                if (knows(candidate, p)) {
                    candidate = p;
                }
            }

            if (isCelebrity(candidate, n)) {
                return candidate;
            }

            return -1;
        }

        private boolean isCelebrity(int candidate, int numberOfPeople) {
            for (var p = 0; p < numberOfPeople; p++) {
                if (p == candidate) continue; // skip self check

                if (knows(candidate, p) || !knows(p, candidate)) {
                    return false;
                }
            }

            return true;
        }
    }

}
