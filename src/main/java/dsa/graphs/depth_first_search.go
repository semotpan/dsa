package main

import "fmt"

type DFS struct {
	Marked []bool
	Count  int
}

// Dfs - apply dfs algorithm for given Graph, from source vertex
// return the DFS with Count (number of reached vertices) and Marked array (visited vertices marked as true)
func Dfs(G *Graph, source int) *DFS {
	var dfs func(v int)

	marked := make([]bool, G.V)
	count := 0

	dfs = func(v int) {
		marked[v] = true
		count++

		for _, w := range G.Adj(v) {
			if !marked[w] {
				dfs(w)
			}
		}
	}

	dfs(source)

	return &DFS{marked, count}
}

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

	dfs0 := Dfs(G, 0)
	fmt.Println(dfs0.Count)
	fmt.Println(dfs0.Marked[5])

	dfs1 := Dfs(G, 1)
	fmt.Println(dfs1.Count)
	fmt.Println(dfs1.Marked[5])
}
