package leetcode._133;

import org.junit.jupiter.api.Test;

import java.util.List;

class CloneGraphTest {

    @Test
    void cloning() {

        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        CloneGraph.Node node4 = new CloneGraph.Node(4);

        node1.neighbors.addAll(List.of(node2, node4));
        node2.neighbors.addAll(List.of(node1, node3));
        node3.neighbors.addAll(List.of(node2, node4));
        node4.neighbors.addAll(List.of(node1, node3));

        CloneGraph.Node graph = new CloneGraph.Solution().cloneGraph(node1);
        System.out.println(graph);
    }

    @Test
    void cloning2() {

        CloneGraph.Node node1 = new CloneGraph.Node(1);

        System.out.println(new CloneGraph.Solution().cloneGraph(node1));
    }

    @Test
    void cloning3() {

        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);

        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        System.out.println(new CloneGraph.Solution().cloneGraph(node1));
    }
}