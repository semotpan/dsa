package main

import "fmt"

type KMP struct {
	lps []int
	pat string
}

// newInstance get an instance of KMP with preprocessed pattern
func newInstance(pat string) KMP {
	lps := make([]int, len(pat))
	pref := 0

	for i := 1; i < len(pat); i++ {
		for pref > 0 && pat[i] != pat[pref] {
			pref = lps[pref-1]
		}

		if pat[i] == pat[pref] {
			pref++
		}

		lps[i] = pref
	}

	return KMP{lps, pat}
}

// Search - function returns all indexes where pattern was matched
func (kmp *KMP) Search(text string) []int {

	N := len(text)
	M := len(kmp.pat)
	pref := 0

	var indexes []int

	for i := 0; i < N; i++ {

		for pref > 0 && text[i] != kmp.pat[pref] {
			pref = kmp.lps[pref-1]
		}

		if text[i] == kmp.pat[pref] {
			pref++
		}

		if pref == M {
			indexes = append(indexes, (i+1)-M)
			pref = kmp.lps[pref-1]
		}
	}

	return indexes
}

// ***************** Testing *****************
func main() {
	pattern := "ABCABC"
	text := "ABCABCDEFFSCABCABCPOPABCABQPABCABCATC"

	kmp := newInstance(pattern)
	indexes := kmp.Search(text)
	fmt.Println(indexes)
}
