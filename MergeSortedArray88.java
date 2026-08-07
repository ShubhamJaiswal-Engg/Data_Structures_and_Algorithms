// 88. Merge Sorted Array

class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       // last real element in nums1
        int j = n - 1;       // last element in nums2
        int k = m + n - 1;   // last position in nums1 (the write pointer)

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // if nums2 still has leftover elements, copy them in
        // (if nums1 has leftovers, they're already in place — no work needed)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}