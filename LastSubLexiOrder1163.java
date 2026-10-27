
// 1163. Last Substring in Lexicographical Order

class LastSubLexiOrder1163 {
    public String lastSubstring(String s) {
        int i = 0, j = 1, k = 0;
        int n = s.length();

        while (j + k < n) {
            char a = s.charAt(i + k);
            char b = s.charAt(j + k);

            if (a == b) {
                k++;
            } else if (a < b) {
                i = Math.max(i + k + 1, j);
                j = i + 1;
                k = 0;
            } else {
                j = j + k + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }
}