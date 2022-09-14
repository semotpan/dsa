package main

import (
	"bytes"
	"fmt"
)

//Graph - Adjacency-list undirected Graph representation
type Graph struct {
	V   int
	E   int
	adj [][]int
}

// NewGraph - build a new Graph
func NewGraph(V int) *Graph {
	adj := make([][]int, V)
	for i := range adj {
		adj[i] = make([]int, 0)
	}

	return &Graph{V, 0, adj}
}

// AddEdge - add an edge (undirected) for both vertices, and count the edge
func (G *Graph) AddEdge(v int, w int) {
	G.adj[v] = append(G.adj[v], w)
	G.adj[w] = append(G.adj[w], v)
	G.E++
}

// Adj - get adjacent vertices for given vertex v
func (G *Graph) Adj(v int) []int {
	return G.adj[v]
}

// Degree - gets out degree number of edges
func (G *Graph) Degree(v int) int {
	return len(G.adj[v])
}

// MaxDegree - gets maximum number of out-degree edges
func (G *Graph) MaxDegree() int {
	max := 0
	for v := 0; v < G.V; v++ {
		degree := G.Degree(v)
		if max < degree {
			max = degree
		}
	}

	return max
}

// AvgDegree - gets average of out-degree edges of the Graph
func (G *Graph) AvgDegree() int {
	return 2 * G.E / G.V
}

// NumberOfSelfLoops - gets number of self loops
func (G *Graph) NumberOfSelfLoops() int {
	count := 0
	for v := 0; v < G.V; v++ {
		for _, w := range G.Adj(v) {
			if v == w {
				count++
			}
		}
	}

	return count / 2 // each edge counted twice
}

// ToString - gets string representation of the Graph
func (G Graph) ToString() string {
	var b bytes.Buffer
	b.WriteString(fmt.Sprintf("{'%d vertices, %d edges' adj=[", G.V, G.E))

	for v := 0; v < G.V; v++ {
		b.WriteString(fmt.Sprintf("[%d: ", v))

		for _, w := range G.Adj(v) {
			b.WriteString(fmt.Sprintf("%d ", w))
		}
		b.WriteString("]")
	}
	b.WriteString("]}")

	return b.String()
}

// ***************** Testing *****************
func main() {
	V := 6
	edges := [][]int{
		{0, 2},
		{0, 1},
		{0, 5},
		{1, 2},
		{2, 3},
		{2, 4},
		{3, 4},
		{3, 5},
	}

	G := NewGraph(V)

	for _, edge := range edges {
		G.AddEdge(edge[0], edge[1])
	}

	fmt.Println(G.ToString())
	fmt.Println(G.NumberOfSelfLoops())
}
