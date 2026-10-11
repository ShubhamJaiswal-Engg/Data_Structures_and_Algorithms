
// 1297. Maximum Number of Occurrences of a Substring

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        int n = s.length();
        // for count total unique character
        Map<Character, Integer> charMap = new HashMap<>();

        // for count total unique subStrMap
        Map<String, Integer> subStrMap = new HashMap<>();
        
        for(int i = 0; i < minSize; i++) {
            char ch = s.charAt(i);
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }
        // using sliding window concept
        
        int ans = 0;
        // check the first window like every other window
        if (charMap.size() <= maxLetters) {
            String first = s.substring(0, minSize);
            subStrMap.put(first, 1);
            ans = 1;
        }
        for(int i = minSize; i < n; i++) {
            char ch = s.charAt(i);
            char removeChar = s.charAt(i - minSize);
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
            if(charMap.get(removeChar) == 1) {
                charMap.remove(removeChar);
            } else {
                charMap.put(removeChar, charMap.get(removeChar) - 1);
            }
            if(charMap.size() <= maxLetters) {
            String temp = s.substring(i - minSize + 1, i + 1);
            subStrMap.put(temp, subStrMap.getOrDefault(temp, 0) + 1);
            ans = Math.max(ans, subStrMap.get(temp));
          }
        }
        return ans;
    }
}