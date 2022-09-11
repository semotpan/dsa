package main

import "fmt"

func numIslands2(m int, n int, positions [][]int) []int {
	uf := NewUF(m, n, positions)
	return uf.Counts()
}

type UnionFind struct {
	N      int
	M      int
	id     []int
	rank   []int
	counts []int
	count  int
}

// NewUF create a new UnionFind
func NewUF(m int, n int, positions [][]int) UnionFind {

	id := make([]int, m*n)
	for i := range id {
		id[i] = -1
	}

	uf := UnionFind{
		N:      n,
		M:      m,
		id:     id,
		rank:   make([]int, m*n),
		counts: []int{},
		count:  0,
	}

	for _, position := range positions {
		x := position[0]
		y := position[1]
		p := x*n + y

		// skip if already processed
		if uf.id[p] != -1 {
			uf.appendCount()
			continue
		}

		uf.id[p] = p
		uf.count++

		uf.tryUnion(x-1, y, p) // try to connect prev component on x axe
		uf.tryUnion(x+1, y, p) // try to connect next component on x axe
		uf.tryUnion(x, y-1, p) // try to connect prev component on y axe
		uf.tryUnion(x, y+1, p) // try to connect next component on y axe

		uf.appendCount()
	}

	return uf
}

func (uf *UnionFind) tryUnion(x int, y int, p int) {
	q := x*uf.N + y
	if x >= 0 && y >= 0 && x < uf.M && y < uf.N && uf.id[q] != -1 {
		uf.union(p, q)
	}
}

func (uf *UnionFind) appendCount() {
	uf.counts = append(uf.counts, uf.count)
}

// find returns an integer component identifier for a given site
func (uf *UnionFind) find(p int) int {
	for p != uf.id[p] {
		p = uf.id[p]
	}
	return p
}

// Counts returns the number of components
func (uf *UnionFind) Counts() []int {
	return uf.counts
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
