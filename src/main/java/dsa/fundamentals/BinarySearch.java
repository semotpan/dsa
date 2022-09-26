package dsa.fundamentals;

public final class BinarySearch {

    public static int rank(int key, int[] a) {

        for (int low = 0, high = a.length - 1; low <= high; ) {
            var mid = (low + high) >>> 1;

            if (a[mid] < key)
                low = mid + 1;
            else if (a[mid] > key)
                high = mid - 1;
            else
                return mid;
        }

        return -1;
    }
}
