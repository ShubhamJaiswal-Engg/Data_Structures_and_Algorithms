
// 3. Longest Substring Without Repeating Characters

class LongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
         HashSet<Character> uniqueSet = new HashSet<>();
         int maxLength = 0;
         int left = 0;
         for(int right = 0; right < s.length(); right++) {
            while(uniqueSet.contains(s.charAt(right))) {
                uniqueSet.remove(s.charAt(left));
                left++;
            }
            uniqueSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
         }
         return maxLength;
    }
}