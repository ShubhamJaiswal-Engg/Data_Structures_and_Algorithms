
// 3550. Smallest Index With Digit Sum Equal to Index

class SmallIdxWithSumIDX3550 {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i], s = 0;
            while (x > 0) {
                s += x % 10;
                x /= 10;
            }
            if (s == i) return i;
        }
        return -1;
    }
}