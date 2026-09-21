
// 409. Longest Palindrome

class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        int count = 0;

        HashSet<Character> uniChar = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!uniChar.contains(ch)) {
                uniChar.add(ch);
            } else {
                count += 2;
                uniChar.remove(ch);
            }
        };

        return uniChar.size() == 0 ? count : count + 1;
    }
}