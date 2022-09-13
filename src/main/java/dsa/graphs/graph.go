package graphs

import (
	"bytes"
	"fmt"
)

type Graph struct {
	V   int
	E   int
	adj [][]int
}

func newGraph(V int) Graph {
	adj := make([][]int, V)
	for i := range adj {
		adj[i] = make([]int, 0)
	}

	return Graph{
		V:   V,
		E:   0,
		adj: adj,
	}
}

func (G *Graph) AddEdge(v int, w int) {
	G.adj[v] = append(G.adj[v], w)
	G.adj[w] = append(G.adj[w], v)
	G.E++
}

func (G *Graph) Adj(v int) []int {
	return G.adj[v]
}

func (G *Graph) Degree(v int) int {
	return len(G.adj[v])
}

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

func (G *Graph) AvgDegree() int {
	return 2 * G.E / G.V
}

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

func (G Graph) ToString() string {
	var b bytes.Buffer
	b.WriteString(fmt.Sprintf("{%d vertices, %d edges' adj=[", G.V, G.E))

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

	G := newGraph(V)

	for _, edge := range edges {
		G.AddEdge(edge[0], edge[1])
	}

	fmt.Println(G.ToString())
}
