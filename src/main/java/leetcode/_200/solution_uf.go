package main

import "fmt"

func numIslands(grid [][]byte) int {
	N := len(grid)
	M := len(grid[0])

	uf := NewUF(M, N)

	for i := 0; i < N; i++ {
		for j := 0; j < M; j++ {
			if grid[i][j] == '1' {
				p := i*M + j
				uf.id[p] = p
				uf.count++

				// try to connect prev component on x axe
				x := i - 1
				if x >= 0 && grid[x][j] == '1' {
					q := x*M + j
					uf.Union(p, q)
				}

				// try to connect prev component on y axe
				y := j - 1
				if y >= 0 && grid[i][y] == '1' {
					q := i*M + y
					uf.Union(p, q)
				}
			}

		}
	}

	return uf.Count()
}

type UnionFind struct {
	id    []int
	rank  []int
	count int
}

func NewUF(m int, n int) UnionFind {
	return UnionFind{
		id:    make([]int, n*m),
		rank:  make([]int, n*m),
		count: 0,
	}
}

// find returns an integer component identifier for a given site
func (uf *UnionFind) find(p int) int {
	for p != uf.id[p] {
		p = uf.id[p]
	}
	return p
}

// Count returns the number of components
func (uf *UnionFind) Count() int {
	return uf.count
}

// Union merges two components if the two sites are in different components
func (uf *UnionFind) Union(p int, q int) {
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
	grid := [][]byte{
		{'1', '1', '0', '0', '0'},
		{'1', '1', '0', '0', '0'},
		{'0', '0', '1', '0', '0'},
		{'0', '0', '0', '1', '1'},
	}

	res := numIslands(grid)
	fmt.Println(res)
}
