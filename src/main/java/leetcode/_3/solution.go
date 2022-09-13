package main

import "fmt"

func lengthOfLongestSubstring(s string) int {
	offsets := make([]int, 128)

	longest := 0
	low := 0

	for i := 0; i < len(s); i++ {
		low = max(low, offsets[s[i]])
		longest = max(longest, i-low+1)
		offsets[s[i]] = i + 1
	}

	return longest
}

func max(a int, b int) int {
	if a > b {
		return a
	}

	return b
}

// ***************** Testing *****************
func main() {
	s := "abcabcbb"
	size := lengthOfLongestSubstring(s)
	fmt.Println(size)
}
