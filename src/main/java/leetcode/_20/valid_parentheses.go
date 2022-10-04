package main

import "fmt"

func isValid(s string) bool {

	stack := make([]byte, len(s))
	top := 0

	for i := 0; i < len(s); i++ {
		switch s[i] {
		case '{', '[', '(':
			stack[top] = s[i]
			top++
			break
		case '}':
			if top == 0 || stack[top-1] != '{' {
				return false
			}
			top--
			break
		case ']':
			if top == 0 || stack[top-1] != '[' {
				return false
			}
			top--
			break
		case ')':
			if top == 0 || stack[top-1] != '(' {
				return false
			}
			top--
			break
		}
	}

	return top == 0
}

func main() {

	s := "(]"
	fmt.Println(isValid(s))
}
