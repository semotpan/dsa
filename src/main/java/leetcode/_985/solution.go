package main

import "fmt"

func sumEvenAfterQueries(V []int, queries [][]int) []int {
	sum := 0
	for _, v := range V {
		if v&1 == 0 {
			sum += v
		}
	}

	answer := make([]int, len(queries))

	for i := 0; i < len(queries); i++ {
		val := queries[i][0]
		index := queries[i][1]

		if V[index]&1 == 0 {
			sum -= V[index]
		}

		V[index] += val
		if V[index]&1 == 0 {
			sum += V[index]
		}

		answer[i] = sum
	}
	return answer
}

// ***************** Testing *****************
func main() {
	nums := []int{1, 2, 3, 4}
	queries := [][]int{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}}

	fmt.Println(sumEvenAfterQueries(nums, queries))
}
