
// 49. Group Anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);              
            String sortStr = String.valueOf(ch);

            if (map.containsKey(sortStr)) {
                map.get(sortStr).add(str);
            } else {
                List<String> s = new ArrayList<>();
                s.add(str);
                map.put(sortStr, s);
            }
        }

        return new ArrayList<>(map.values());
    }
}