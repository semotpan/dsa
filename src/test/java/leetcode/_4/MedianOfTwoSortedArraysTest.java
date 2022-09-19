package leetcode._4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MedianOfTwoSortedArraysTest {

    @Test
    void test1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        assertThat(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2))
                .isEqualTo(2.0D);
    }

    @Test
    void test2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        assertThat(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2))
                .isEqualTo(2.5D);
    }

    @Test
    void test3() {
        int[] nums1 = {1, 2, 7, 20};
        int[] nums2 = {3, 4, 8, 10, 12};
        // 1, 2, 3, 4, 7, 8, 10, 12, 20

        assertThat(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2))
                .isEqualTo(7.0D);
    }

    @Test
    void test4() {
        int[] nums1 = {1, 2, 7, 20};
        int[] nums2 = {3, 4, 8, 10};
        // 1, 2, 3, 4, 7, 8, 10, 20

        assertThat(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2))
                .isEqualTo(5.5D);
    }

    @Test
    void test5() {
        int[] nums1 = {1, 2, 7, 10};
        int[] nums2 = {3, 4, 8, 20};
        // 1, 2, 3, 4, 7, 8, 10, 20

        assertThat(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2))
                .isEqualTo(5.5D);
    }

    @Test
    void test6() {
        int[] nums1 = {1, 2, 7};
        int[] nums2 = {3, 4, 8, 20};
        // 1, 2, 3, 4, 7, 8, 20

        assertThat(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2))
                .isEqualTo(4.0D);
    }

    @Test
    void test7() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3};
        // 1, 2, 3, 4, 7, 8, 20

        assertThat(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2))
                .isEqualTo(2.0D);
    }

    @Test
    void test8() {
        int[] nums1 = {1, 1, 1, 1};
        int[] nums2 = {9, 9, 32};
        // 1, 1, 1, 1, 9, 9, 32

        assertThat(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2))
                .isEqualTo(1.0D);
    }

    @Test
    void test9() {
        int[] nums1 = {};
        int[] nums2 = {9};
        // 1, 1, 1, 1, 9, 9, 32

        assertThat(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2))
                .isEqualTo(9.0D);
    }
}
