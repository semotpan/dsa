package main

import "fmt"

type UnionFind struct {
	id    []int
	count int
}

// NewUF create a new UnionFind value, N - represents number of vertices
func NewUF(N int) UnionFind {

	id := make([]int, N)
	for i := 0; i < N; i++ {
		id[i] = i
	}

	return UnionFind{id, N}
}

// Find returns an integer component identifier for a given site
func (uf *UnionFind) Find(p int) int {
	for p != uf.id[p] {
		p = uf.id[p]
	}
	return p
}

// Connected determines whether two sites are in the same component
func (uf *UnionFind) Connected(p int, q int) bool {
	return uf.Find(p) == uf.Find(q)
}

// Count returns the number of components
func (uf *UnionFind) Count() int {
	return uf.count
}

// Union merges two components if the two sites are in different components
func (uf *UnionFind) Union(p int, q int) {
	pId := uf.Find(p)
	qId := uf.Find(q)

	// Nothing to do if p and q are already in the same component.
	if pId == qId {
		return
	}

	// Rename p’s component to q’s name.
	for i := 0; i < len(uf.id); i++ {
		if uf.id[i] == pId {
			uf.id[i] = qId
		}
	}

	uf.count--
}

// ***************** Testing *****************
func main() {
	N := 10

	pairs := [][]int{
		{4, 3}, {3, 8}, {6, 5},
		{9, 4}, {2, 1}, {8, 9},
		{5, 0}, {7, 2}, {6, 1},
		{1, 0}, {6, 7},
	}

	uf := NewUF(N)

	for i := 0; i < len(pairs); i++ {
		uf.Union(pairs[i][0], pairs[i][1])
	}

	fmt.Println(uf.id)
	fmt.Println(uf.count)
}
