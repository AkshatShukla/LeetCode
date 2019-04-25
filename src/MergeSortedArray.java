public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        1) First we are initializing i = m-1 (because only till m elements are there rest is initialized with zero) otherwise if we start from i=0 then we need to do so many comparisons,Similarly j = n-1,k=m+n-1;

        2) While(i>=0 && j>=0)
        3) we are checking that if(nums1[i]>nums2[j]) then put nums1[k--] = nums1[i--]; this is because we
        looping from end and since given in question that this array are sorted so at last greatest element will be there so we are putting the greatest element at last and so on.

        Time Complexity:  O(N)
        Space complexity: O(1)
         */
        int i = m-1, j = n-1, k = m+n-1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {  // if first nums1 element finishes and the second one nums2 element remains
            nums1[j] = nums2[j--];
        }
        while (i >= 0) { // if first nums1 element remains and the second one nums2 element finishes
            nums1[i] = nums1[i--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0}, nums2 = new int[]{2,5,6};
        int m = 3,  n = 3;
        merge(nums1, m, nums2, n);
        for (int x:nums1) {
            System.out.println(x);
        }
    }
}
