public class Solution {
    public static int compress(char[] chars) {
        int n = chars.length;
        int write = 0;
        int i = 0;
        int j = 0;
        while (i < n) {
            int count = 0 ;
            while (j < n && chars[j] == chars[i]) {
            count++;
            j++;
        };
            chars[write++] = chars[i];
            if (count > 1) {
                String s = Integer.toString(count);
                for (int k = 0; k < s.length(); k++) {
                    chars[write++] = s.charAt(k);
                }
            }
            i = j;
        }
        return write;
    }

    public static void main(String[] args) {
        char[] chars = {'a'};
        int len = compress(chars);
        System.out.println(len);
        for (int k = 0; k < len; k++) {
            System.out.print(chars[k]);
            if (k < len - 1) System.out.print(",");
        }
        System.out.println();
    }
}




import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}