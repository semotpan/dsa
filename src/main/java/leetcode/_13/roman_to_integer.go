package main

import "fmt"

var alphabet = map[byte]int{
	'I': 1,
	'V': 5,
	'X': 10,
	'L': 50,
	'C': 100,
	'D': 500,
	'M': 1000,
}

func romanToInt(s string) int {
	stack := make([]int, 10)
	N := 0
	sum := 0

	for i := 0; i < len(s); i++ {
		stack[N] = alphabet[s[i]] // stack push
		N++

		for (i+1) < len(s) && stack[N-1] < alphabet[s[i+1]] { // peek stack top -> (stack[N-1])
			i++
			stack[N] = alphabet[s[i]]
			N++
		}

		N--
		curr := stack[N] // stack pop

		for N > 0 {
			N--
			curr -= stack[N]
		}

		sum += curr
	}

	return sum
}

// ***************** Testing *****************
func main() {
	s := "MCMXCIV"
	fmt.Println(romanToInt(s)) // rez: 1994
}
