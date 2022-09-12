package main

import "fmt"

func shortestPalindrome(s string) string {
	rev := reverse(s)
	offset := lspOffset(s + "#" + rev)
	return rev[:len(s)-offset] + s
}

// lspOffset - the longest prefix which is also a suffix (length of palindrome)
func lspOffset(pat string) int {
	M := len(pat)
	lps := make([]int, M)

	pref := 0
	for i := 1; i < M; i++ {
		for pref > 0 && pat[pref] != pat[i] {
			pref = lps[pref-1]
		}

		if pat[pref] == pat[i] {
			pref++
		}

		lps[i] = pref
	}

	return lps[M-1]
}

func reverse(str string) string {
	low := 0
	high := len(str) - 1
	chs := []byte(str)

	for low < high {
		tmp := chs[low]
		chs[low] = chs[high]
		chs[high] = tmp
		low++
		high--
	}
	return string(chs)
}

// ***************** Testing *****************
func main() {
	s := "aacecaaa"
	fmt.Println(shortestPalindrome(s))
}
