package main

import "fmt"

type Node struct {
	Val       int
	Neighbors []*Node
}

func cloneGraph(node *Node) *Node {
	if node == nil {
		return nil
	}

	cache := make([]*Node, 101)

	var clone func(node *Node) *Node

	clone = func(node *Node) *Node {
		cache[node.Val] = &Node{Val: node.Val} // as hash of the node is taken 'node.val'

		for _, w := range node.Neighbors {
			if cache[w.Val] == nil { // avoid initiated vertices
				clone(w) // clone every neighbor (recursive)
			}
			cache[node.Val].Neighbors = append(cache[node.Val].Neighbors, cache[w.Val]) // append neighbors
		}

		return cache[node.Val]
	}

	return clone(node)
}

// ***************** Testing *****************

func main() {

	//node1 := &Node{Val: 1}
	//node2 := &Node{Val: 2}
	//node3 := &Node{Val: 3}
	//node4 := &Node{Val: 4}
	//
	//node1.Neighbors = append(node1.Neighbors, node2, node4)
	//node2.Neighbors = append(node2.Neighbors, node1, node3)
	//node3.Neighbors = append(node3.Neighbors, node2, node4)
	//node4.Neighbors = append(node4.Neighbors, node1, node3)

	node1 := &Node{Val: 1}
	node2 := &Node{Val: 2}

	node1.Neighbors = append(node1.Neighbors, node2)
	node2.Neighbors = append(node2.Neighbors, node1)

	graph := cloneGraph(node2)
	fmt.Println(graph.Val)
	fmt.Println(graph.Neighbors)
}
