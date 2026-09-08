
// 821. Shortest Distance to a Character

class ShortestDistance821 {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int result[] = new int[n];
        int prev = Integer.MIN_VALUE / 2; //Without this / 2, it will also work (It is basically here for Avoid OverFlow)

        // Left to right: distance from nearest c on the left
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == c) prev = i;
            result[i] = i - prev;
        }

         // Right to left: distance from nearest c on the left
        prev = Integer.MAX_VALUE / 2;
        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == c) prev = i;
            result[i] = Math.min(result[i], prev - i);
        }
        return result;
    }
}