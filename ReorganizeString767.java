
// 767. Reorganize String



class Solution {
    public String reorganizeString(String s) {
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a'] = charCounts[c - 'a'] + 1;
        }

        // max heap with char, freq
        var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        
        // PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] > 0) {
                pq.offer(new int[] {i + 'a', charCounts[i]});
            }
        }

        StringBuilder str = new StringBuilder();
        int[] block = pq.poll();
        str.append((char) block[0]);
        block[1]--;

        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            str.append((char) next[0]);
            next[1]--;
            if (block[1] > 0) {
                pq.offer(block);
            }
            block = next;
        }

        // If the last character still has leftovers, it can't be arranged
        if (block[1] > 0) {
            return "";
        }
        return str.toString();
    }
}