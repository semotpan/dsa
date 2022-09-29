package main

import "fmt"

func canBeValid(s string, locked string) bool {
	if len(s)&1 == 1 {
		return false
	}

	balance, lckd := 0, 0

	for i := 0; i < len(s); i++ {
		if locked[i] == '1' {
			if s[i] == '(' {
				balance++
				lckd++
			} else {
				balance--
				lckd--
			}
		} else {
			balance++
			lckd--
		}

		if balance < 0 {
			return false
		}

		lckd = max(lckd, 0)
	}

	return lckd == 0
}

func max(a int, b int) int {
	if a < b {
		return b
	}
	return a
}

// ***************** Testing *****************
func main() {
	s := "))()))"
	locked := "010100"

	fmt.Println(canBeValid(s, locked))
}
