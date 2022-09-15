package main

import "fmt"

type DFP struct {
	marked []bool
	edgeTo []int
	source int // source - vertex
}

// Dfp - apply dfs on Graph G, from vertex source, get DFP with stored paths from source vertex to the reached vertices
func Dfp(G *Graph, source int) *DFP {
	var dfs func(v int)

	marked := make([]bool, G.V)
	edgeTo := make([]int, G.V)

	dfs = func(v int) {
		marked[v] = true

		for _, w := range G.Adj(v) {
			if !marked[w] {
				edgeTo[w] = v
				dfs(w)
			}
		}
	}

	dfs(source)

	return &DFP{marked, edgeTo, source}
}

// HashPathTo - get true if there is a path to the vertex v
func (dfp DFP) HashPathTo(v int) bool {
	return dfp.marked[v]
}

// PathTo - get the path from source to the vertex V >> (!!not the shortest)
func (dfp DFP) PathTo(v int) []int {
	if !dfp.HashPathTo(v) {
		return nil
	}

	var path []int
	for x := v; x != dfp.source; x = dfp.edgeTo[x] {
		path = append(path, x)
	}
	path = append(path, dfp.source)

	// reverse slice (LIFO principle)
	for i := len(path)/2 - 1; i >= 0; i-- {
		opp := len(path) - 1 - i
		path[i], path[opp] = path[opp], path[i]
	}

	return path
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

	dfp0 := Dfp(G, 0)

	// 0 -> 2 -> 3 -> 5 (first path that was found)
	fmt.Println(dfp0.PathTo(5))
}
