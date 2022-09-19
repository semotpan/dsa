package leetcode._4;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return new BinarySearch(nums1, nums2).result();
    }

    static class BinarySearch {
        private final int[] big;
        private final int[] small;
        private final int median;
        private double result;

        // small array indexes
        private int low, high, midIndex;


        BinarySearch(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                big = nums1;
                small = nums2;
            } else {
                big = nums2;
                small = nums1;
            }

            median = (big.length + small.length + 1) >>> 1;
            high = small.length;

            run();
        }

        private void run() {
            while (low <= high) {
                midIndex = (low + high) >>> 1;

                // check highest and lowest values && ensure the highest-previous and lowest-next are in consecutive order
                if (isSequenceOrdered()) {
                    computeResult();
                    break;
                }

                if (isOnFirstHalf()) {
                    high = midIndex - 1;  // go left (on smaller table)
                    continue;
                }

                low = midIndex + 1; // go right (on smaller table)
            }
        }

        private boolean isSequenceOrdered() {
            // if (previousSmall <= currentBig && previousBig <= currentSmall)
            // small[midIndex - 1] <= big[median - midIndex] && big[median-midIndex-1]<= small[midIndex]
            return safeLow(small, midIndex - 1) <= safeHigh(big, median - midIndex) &&
                    safeLow(big, median - midIndex - 1) <= safeHigh(small, midIndex);
        }

        private void computeResult() {
            var previousMax = Integer.max(safeLow(small, midIndex - 1), safeLow(big, median - midIndex - 1));
            var currentMin = Integer.min(safeHigh(small, midIndex), safeHigh(big, median - midIndex));

            if (((big.length + small.length) & 1) == 1)
                result = previousMax;
            else
                result = (previousMax + currentMin) / 2.0D;
        }

        private int safeLow(int[] arr, int index) {
            return index < 0 ? Integer.MIN_VALUE : arr[index];
        }

        private int safeHigh(int[] arr, int index) {
            return index >= arr.length ? Integer.MAX_VALUE : arr[index];
        }

        private boolean isOnFirstHalf() {
            return safeLow(small, midIndex - 1) > safeLow(big, median - midIndex - 1);
        }

        public double result() {
            return result;
        }
    }
}
