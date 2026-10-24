
// 943. Find the Shortest Superstring

class FindShortSupStr943 {
    public String shortestSuperstring(String[] words) {
        Map<String, String> map = new HashMap<>();
        int n = words.length;
        int unusedWords = 0;
        for(int i = 0; i < n; i++) {
            unusedWords |= 1 << i; // Making every word as unused
        }
        return shortSupStr(words, "", unusedWords, map);
    }
    private String shortSupStr(String[] words, String startWord, int unused, Map<String, String> map) {
        if(unused == 0) {
            return startWord; // base case -> all words have been used
        }

        // create unique key 
        String key = startWord + '|' + unused;

        // if key has already been calculated
        if(map.containsKey(key)) {
            return map.get(key);
        }

        String shortest = null;
        for(int i = 0; i < words.length; i++) {
            if(!isConsumed(unused, i)) {
                String superString = shortSupStr(words, words[i], consume(unused, i), map);
                // append the shortest word with startWord
                String append = overlappedAppend(startWord, superString);

                // keep shortest
                if(shortest == null || append.length() < shortest.length()) {
                    shortest = append;
                }
            }
        }
        // catch the result for this combination
        map.put(key, shortest);
        return shortest;
    }
    // concatenate a and b like a = "bike" and b = "kelit" => "bikelit"
    private String overlappedAppend(String a, String b) {
        for(int i = Math.max(1, a.length() - b.length()); i < a.length(); i++) {
            boolean match = true;
            for(int j = i; j < a.length(); j++) {
                if(a.charAt(j) != b.charAt(j - i)) {
                    match = false;
                    break;
                }
            }
            if(match) {
                return a.substring(0, i) + b;
            }
        }
        // if no matching value appear then
        return a + b;
    }

    // checking is it consumed = 011(3) -> 3 / 2 -> 1 & 1 != 0  
    private boolean isConsumed(int unused, int i) {
        return ((unused >> i) & 1) == 0;
    }
    // making used 3 -> 011 & 100 = 0
    private int consume(int unused, int i) {
        return unused & ~(1 << i);
    }
}