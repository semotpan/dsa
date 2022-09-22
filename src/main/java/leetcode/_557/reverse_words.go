package main

import "fmt"

func reverseWords(s string) string {
	chars := []byte(s)

	low := 0
	high := len(chars) - 1
	lowNonSpace := 0
	highNonSPace := high

	for low <= high {

		if chars[low] == ' ' {
			reverseSubstring(chars, lowNonSpace, low-1)
			lowNonSpace = low + 1
		}

		if chars[high] == ' ' {
			reverseSubstring(chars, high+1, highNonSPace)
			highNonSPace = high - 1
		}

		low++
		high--
	}

	if lowNonSpace < highNonSPace {
		reverseSubstring(chars, lowNonSpace, highNonSPace)
	}

	return string(chars)
}

func reverseSubstring(chars []byte, low int, high int) {
	i := low
	j := high

	for i < j {
		chars[i], chars[j] = chars[j], chars[i]
		i++
		j--
	}
}

// ***************** Testing *****************
func main() {
	s := "Let's take LeetCode contest"

	fmt.Println(reverseWords(s)) // "s'teL ekat edoCteeL tsetnoc"
}
