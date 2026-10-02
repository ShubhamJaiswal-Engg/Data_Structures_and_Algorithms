


class PalinPartit131 {
    public boolean palindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public void helper(String s, List<String> list, List<List<String>> ans) {
        if (s.length() == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i + 1);
            if (palindrome(prefix)) {
                list.add(prefix);
                helper(s.substring(i + 1), list, ans);
                list.remove(list.size() - 1); 
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        helper(s, new ArrayList<>(), ans);
        return ans;
    }
}