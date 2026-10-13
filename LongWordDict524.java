
// 524. Longest Word in Dictionary through Deleting

class LongWordDict524 {

    private boolean isSequence(String s , String word) {
        int left = 0;
        for(int right = 0; right < s.length() && left < word.length(); right++) {
            if(s.charAt(right) == word.charAt(left)) {
                left++;
            }
        }
        return left == word.length();
    }
    public String findLongestWord(String s, List<String> dictionary) {
        
        String maxStr = "";
        for( String word : dictionary) {
            if(isSequence(s, word)) {
                if(word.length() > maxStr.length() || (word.length() == maxStr.length() && word.compareTo(maxStr) < 0)) {
                    maxStr = word;
                }
            }
        }
        return maxStr;
    }
}