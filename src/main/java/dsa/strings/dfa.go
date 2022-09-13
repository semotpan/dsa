package main

import "fmt"

type DFA struct {
	pat string
	dfa [][]int
}

func newDFA(pat string) DFA {
	R := 256
	M := len(pat)

	dfa := make([][]int, R)
	for i := range dfa {
		dfa[i] = make([]int, M)
	}

	X := 0
	dfa[pat[0]][0] = 1
	for j := 1; j < M; j++ {
		// Compute DFA
		for c := 0; c < R; c++ {
			dfa[c][j] = dfa[c][X] // Copy mismatch cases.
		}
		dfa[pat[j]][j] = j + 1 // Set match case.
		X = dfa[pat[j]][X]     // Update restart state.
	}

	return DFA{pat, dfa}
}

// search return -1 if pattern is not present in text or the start index of pattern
// in text
func (dfa *DFA) search(txt string) int {
	// Simulate operation of DFA on txt.
	N := len(txt)
	M := len(dfa.pat)

	i := 0
	j := 0

	for ; i < N && j < M; i++ {
		j = dfa.dfa[txt[i]][j]
	}

	if j == M {
		return i - M // found (hit end of pattern)
	}

	return -1 // not found
}

// ***************** Testing *****************
func main() {
	text := "ABABACRAASDTDASCVABABACAAREVSDGTVABABACA"
	pat := "ABABACA"

	dfa := newDFA(pat)
	index := dfa.search(text)
	fmt.Println(index)
}
