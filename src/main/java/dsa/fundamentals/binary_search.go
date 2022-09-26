package main

import "fmt"

func BinarySearch(key int, a []int) int {
	low := 0
	high := len(a) - 1
	for low <= high {
		mid := (low + high) >> 1

		if a[mid] > key {
			high = mid - 1
		} else if a[mid] < key {
			low = mid + 1
		} else {
			return mid
		}
	}

	return -1
}

// ***************** Testing *****************
func main() {
	a := []int{1, 5, 7, 9, 10}
	key := 5

	fmt.Println(BinarySearch(key, a))
	key = 2
	fmt.Println(BinarySearch(key, a))
}
