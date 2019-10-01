public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] A, int[] B) {
        //if A length is greater then switch them so that A is smaller than B.
        if (A.length > B.length) {
            return findMedianSortedArrays(B, A);
        }
        int x = A.length;
        int y = B.length;

        int low = 0;
        int high = x; // take the shorter of the two inputs

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // Handle Edge case
            // if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            // if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : A[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : A[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : B[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : B[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even
                // length combined array size or get max of left for odd length combined array size.

                if ((x + y) % 2 == 0) {
                    // even length of combined array
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    // odd length of combined array
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else {
                //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }
        return -1;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums3[idx] = nums1[i];
                i++;
                idx++;
            } else {
                nums3[idx] = nums2[j];
                j++;
                idx++;
            }
        }

        while (i < nums1.length) {
            nums3[idx] = nums1[i];
            i++;
            idx++;
        }

        while (j < nums2.length) {
            nums3[idx] = nums2[j];
            j++;
            idx++;
        }

        int len = nums3.length;

        if (len % 2 != 0) {
            int mid = len / 2;
            return nums3[mid];
        } else {
            int mid = len / 2;
            return (nums3[mid] + nums3[mid - 1]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 3};
        int[] array2 = new int[]{2};
        System.out.println(findMedianSortedArrays(array1, array2));
        System.out.println(findMedianSortedArrays2(array1, array2));
    }
}
