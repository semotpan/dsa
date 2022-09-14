package leetcode._133;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return "[val: " + val + " : neighbors-size: " + neighbors.stream().map(n -> n.val).toList() + "]";
        }
    }

    static class Solution {

        private final Node[] cache = new Node[101];

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }

            cache[node.val] = new Node(node.val);            // as hash of the node is taken 'node.val'

            for (var w : node.neighbors) {
                if (cache[w.val] == null) {                  // avoid initiated vertices
                    cloneGraph(w);                           // clone every neighbor (recursive)
                }
                cache[node.val].neighbors.add(cache[w.val]); // append neighbors
            }

            return cache[node.val];
        }
    }
}
