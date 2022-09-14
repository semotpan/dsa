package main

import "fmt"

var graph [][]int

func knows(a int, b int) bool {
	return graph[a][b] == 1
}

func solution(knows func(a int, b int) bool) func(n int) int {
	return func(n int) int {

		candidate := 0
		for p := 0; p < n; p++ {
			if knows(candidate, p) {
				candidate = p
			}
		}

		// check if candidate is a celebrity
		for p := 0; p < n; p++ {
			if candidate == p {
				continue
			} // skip self checking

			if knows(candidate, p) || !knows(p, candidate) {
				return -1
			}
		}

		return candidate
	}
}

// ***************** Testing *****************
func main() {
	graph = [][]int{
		{1, 1, 0},
		{0, 1, 0},
		{1, 1, 1},
	}

	celebrity := solution(knows)(3)

	if celebrity != 1 {
		panic(fmt.Sprintf("Expected: 1, Actual: %d", celebrity))
	}

}
