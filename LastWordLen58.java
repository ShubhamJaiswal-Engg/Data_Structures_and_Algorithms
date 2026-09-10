
// 58. Length of Last Word

// Approach 1

class LastWordLen58 {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        // skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        int count = 0;
        // count letters of last word
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }
}

// Approach 2

class LastWordLen58 {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for(int j = s.length() - 1; j >= 0; j--) {
            if(s.charAt(j) != ' ') {
                count++;
            } else {
                if(count > 0) {
                    return count;
                }
            }
        }
        return count;
    }
}