package leetcode._2359;

public class FindClosestNodeToGivenTwoNodes {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        var distNode1 = dist(edges, node1);
        var distNode2 = dist(edges, node2);

        var xNode = -1;
        for (int v = 0, minDist = Integer.MAX_VALUE; v < edges.length; ++v) {
            if (distNode1[v] != 0 && distNode2[v] != 0) {
                var currMaxDist = Integer.max(distNode1[v], distNode2[v]);
                if (minDist > currMaxDist) {
                    minDist = currMaxDist;
                    xNode = v;
                }
            }
        }

        return xNode;
    }

    // distance to the first cycle or end node (-1)
    private int[] dist(int[] edges, int currNode) {
        var marked = new boolean[edges.length];
        var dist = new int[edges.length];

        dist[currNode] = 1;

        // stop if there is a cycle
        while (!marked[currNode]) {
            marked[currNode] = true;
            var next = edges[currNode];
            if (next != -1 && !marked[next]) {
                dist[next] = dist[currNode] + 1;
                currNode = next;
            }
        }

        return dist;
    }
}

class OneStep {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        var distNode1 = dist(edges, node1);
        var marked = new boolean[edges.length];
        var dist = new int[edges.length];
        var curr = node2;
        var xNode = curr;
        dist[curr] = 1;

        // stop if there is a cycle
        while (!marked[curr]) {
            marked[curr] = true;

            var next = edges[curr];

            if (distNode1[curr] != 0 && dist[curr] > distNode1[xNode]) break;

            if (next != -1 && !marked[next]) {
                dist[next] = dist[curr] + 1;
                curr = next;
            }
        }

        return curr;
    }

    // distance to the first cycle or end node (-1)
    private int[] dist(int[] edges, int currNode) {
        var marked = new boolean[edges.length];
        var dist = new int[edges.length];

        dist[currNode] = 1;

        // stop if there is a cycle
        while (!marked[currNode]) {
            marked[currNode] = true;
            var next = edges[currNode];
            if (next != -1 && !marked[next]) {
                dist[next] = dist[currNode] + 1;
                currNode = next;
            }
        }

        return dist;
    }
}
