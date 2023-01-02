package leetcode._295;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindMedianFromDataStreamTest {

    @Test
    void one() {
        var ref = new FindMedianFromDataStream_Heaps();

        ref.addNum(1);
        ref.addNum(2);
        assertThat(ref.findMedian())
                .isEqualTo(1.5D);

        ref.addNum(3);
        assertThat(ref.findMedian())
                .isEqualTo(2.0D);
    }

    @Test
    void two() {
        var ref = new FindMedianFromDataStream_Heaps();

        ref.addNum(6);
        assertThat(ref.findMedian())
                .isEqualTo(6.0D);

        ref.addNum(10);
        assertThat(ref.findMedian())
                .isEqualTo(8.0D);

        ref.addNum(2);
        assertThat(ref.findMedian())
                .isEqualTo(6.0D);

        ref.addNum(6);
        assertThat(ref.findMedian())
                .isEqualTo(6.0D);

        ref.addNum(5);
        assertThat(ref.findMedian())
                .isEqualTo(6.0D);

        ref.addNum(0);
        assertThat(ref.findMedian())
                .isEqualTo(5.5D);

        ref.addNum(6);
        assertThat(ref.findMedian())
                .isEqualTo(6.0D);

        ref.addNum(3);
        assertThat(ref.findMedian())
                .isEqualTo(5.5D);

        ref.addNum(1);
        assertThat(ref.findMedian())
                .isEqualTo(5.0D);

        ref.addNum(0);
        assertThat(ref.findMedian())
                .isEqualTo(4.0D);

        ref.addNum(0);
        assertThat(ref.findMedian())
                .isEqualTo(3.0D);
    }

}

