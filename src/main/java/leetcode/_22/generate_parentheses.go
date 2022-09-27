package main

import "fmt"

func generateParenthesis(N int) []string {

	res := make([]string, 0)
	curr := make([]byte, N*2)

	var generate = func(int, int, int) {}
	generate = func(open int, close int, index int) {
		if open == N && close == N {
			res = append(res, string(curr))
		}

		if open < N {
			curr[index] = '('
			generate(open+1, close, index+1)
		}

		if close < open {
			curr[index] = ')'
			generate(open, close+1, index+1)
		}
	}

	generate(0, 0, 0)

	return res
}

// ***************** Testing *****************
func main() {
	fmt.Println(generateParenthesis(3))
}
