
// 14. Longest Common Prefix

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int freq = 0; // how many strings pass through this node
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        TrieNode root = new TrieNode();

        // Insert every string into the trie, bumping freq along the path
        for (String s : strs) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
                curr.freq++;
            }
        }

        // Walk down the trie along strs[0], as long as every string agreed
        StringBuilder sb = new StringBuilder();
        TrieNode curr = root;
        for (int i = 0; i < strs[0].length(); i++) {
            int idx = strs[0].charAt(i) - 'a';
            TrieNode next = curr.children[idx];
            if (next != null && next.freq == strs.length) {
                sb.append(strs[0].charAt(i));
                curr = next;
            } else {
                break; // divergence point reached
            }
        }

        return sb.toString();
    }
}