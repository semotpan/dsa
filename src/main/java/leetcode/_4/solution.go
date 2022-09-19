package main

import (
	"fmt"
	"math"
)

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	small, big := orderByLen(nums1, nums2)

	bs := BS{big, small, (len(nums1) + len(nums2) + 1) >> 1, 0}

	low := 0
	high := len(small)

	for low <= high {
		bs.midIndex = (low + high) >> 1

		if bs.isSequenceOrdered() {
			break
		}

		if bs.isOnFirstHalf() {
			high = bs.midIndex - 1
			continue
		}

		low = bs.midIndex + 1
	}

	return bs.result()
}

type BS struct {
	big      []int
	small    []int
	median   int
	midIndex int
}

func orderByLen(nums1 []int, nums2 []int) (small []int, big []int) {
	if len(nums1) > len(nums2) {
		return nums2, nums1
	}

	return nums1, nums2
}

func (bs *BS) isSequenceOrdered() bool {
	return safeLow(bs.small, bs.midIndex-1) <= safeHigh(bs.big, bs.median-bs.midIndex) &&
		safeLow(bs.big, bs.median-bs.midIndex-1) <= safeHigh(bs.small, bs.midIndex)

}

func (bs *BS) isOnFirstHalf() bool {
	return safeLow(bs.small, bs.midIndex-1) > safeLow(bs.big, bs.median-bs.midIndex-1)
}

func (bs *BS) result() float64 {
	prevMax := max(safeLow(bs.small, bs.midIndex-1), safeLow(bs.big, bs.median-bs.midIndex-1))

	if ((len(bs.small) + len(bs.big)) & 1) == 1 {
		return float64(prevMax)
	}

	currMin := min(safeHigh(bs.small, bs.midIndex), safeHigh(bs.big, bs.median-bs.midIndex))

	return (float64(prevMax) + float64(currMin)) / 2
}

func safeLow(arr []int, i int) int {
	if len(arr) == 0 || i < 0 {
		return math.MinInt32
	}

	return arr[i]
}

func safeHigh(arr []int, i int) int {
	if i >= len(arr) {
		return math.MaxInt32
	}

	return arr[i]
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}

// ***************** Testing *****************

func main() {
	//nums1 := []int{1, 2, 7, 20, 30}
	//nums2 := []int{3, 4, 8, 10, 12}

	//nums1 := []int{1, 2}
	//nums2 := []int{3, 4}

	nums1 := []int{}
	nums2 := []int{1}

	result := findMedianSortedArrays(nums1, nums2)
	fmt.Println(result)
}
