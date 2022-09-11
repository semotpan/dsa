package main

import "fmt"

type UnionFindRank struct {
	id    []int
	rank  []int
	count int
}

// NewUFR create a new UnionFindRank value, N - represents number of vertices
func NewUFR(N int) UnionFindRank {

	id := make([]int, N)
	for i := 0; i < N; i++ {
		id[i] = i
	}

	return UnionFindRank{
		id:    id,
		rank:  make([]int, N),
		count: N,
	}
}

// Find returns an integer component identifier for a given site
func (uf *UnionFindRank) Find(p int) int {
	for p != uf.id[p] {
		p = uf.id[p]
	}
	return p
}

// Connected determines whether two sites are in the same component
func (uf *UnionFindRank) Connected(p int, q int) bool {
	return uf.Find(p) == uf.Find(q)
}

// Count returns the number of components
func (uf *UnionFindRank) Count() int {
	return uf.count
}

// Union merges two components if the two sites are in different components
func (uf *UnionFindRank) Union(p int, q int) {
	pId := uf.Find(p)
	qId := uf.Find(q)

	// Nothing to do if p and q are already in the same component.
	if pId == qId {
		return
	}

	// Rename component to the highest rank's name between components.
	if uf.rank[pId] > uf.rank[qId] {
		uf.id[qId] = pId
	} else if uf.rank[pId] < uf.rank[qId] {
		uf.id[pId] = qId
	} else {
		uf.id[qId] = pId
		uf.rank[pId] += 1
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

	uf := NewUFR(N)

	for i := 0; i < len(pairs); i++ {
		uf.Union(pairs[i][0], pairs[i][1])
	}

	fmt.Println(uf.id)
	fmt.Println(uf.count)
}
