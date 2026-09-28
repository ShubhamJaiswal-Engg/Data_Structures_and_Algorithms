
// 1614. Maximum Nesting Depth of the Parentheses

class MaximumNestedParen1614 {
    public int maxDepth(String s) {
        int count = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                ans = Math.max(ans, count);
            } else if (c == ')') {
                count--;
            }
        }
        return ans;
    }
}