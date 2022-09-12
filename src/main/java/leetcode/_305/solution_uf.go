package main

import "fmt"

func numIslands2(m int, n int, positions [][]int) []int {
	uf := newUF(m, n)

	for _, position := range positions {
		uf.Add(position[0], position[1])
	}

	return uf.Snapshots()
}

type UnionFind struct {
	N         int
	M         int
	id        []int
	rank      []int
	snapshots []int
	count     int
}

func newUF(m int, n int) UnionFind {
	id := make([]int, m*n)
	for i := range id {
		id[i] = -1
	}

	return UnionFind{
		N:         n,
		M:         m,
		id:        id,
		rank:      make([]int, m*n),
		snapshots: []int{},
		count:     0,
	}
}

// Add adds a new component from coordinates position(x, y)
func (uf *UnionFind) Add(x int, y int) {
	p := x*uf.N + y // count p

	//skip if already processed
	if uf.id[p] != -1 {
		// snapshot current state
		uf.snapshots = append(uf.snapshots, uf.count)
		return
	}

	uf.id[p] = p
	uf.count++

	uf.tryUnion(x-1, y, p) // try to connect prev component on x axe
	uf.tryUnion(x+1, y, p) // try to connect next component on x axe
	uf.tryUnion(x, y-1, p) // try to connect prev component on y axe
	uf.tryUnion(x, y+1, p) // try to connect next component on y axe

	// snapshot after processing
	uf.snapshots = append(uf.snapshots, uf.count)
}

// tryUnion if the conditions are met the p and q are united
func (uf *UnionFind) tryUnion(x int, y int, p int) {
	q := x*uf.N + y
	if x >= 0 && y >= 0 && x < uf.M && y < uf.N && uf.id[q] != -1 {
		uf.union(p, q)
	}
}

// find returns an integer component identifier for a given site
func (uf *UnionFind) find(p int) int {
	for p != uf.id[p] {
		p = uf.id[p]
	}
	return p
}

// Snapshots returns all count snapshots
func (uf *UnionFind) Snapshots() []int {
	return uf.snapshots
}

// union merges two components if the two sites are in different components
func (uf *UnionFind) union(p int, q int) {
	pId := uf.find(p)
	qId := uf.find(q)

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
	m := 3
	n := 3
	positions := [][]int{{0, 0}, {0, 1}, {1, 2}, {2, 1}}

	res := numIslands2(m, n, positions)
	fmt.Println(res)
}
