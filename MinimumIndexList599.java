
// 599. Minimum Index Sum of Two Lists

// Time Complexity :- O(n2)
class MinimumIndexList599 {
    public String[] findRestaurant(String[] list1, String[] list2) {

        ArrayList<String> answer = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list1.length; i++) {
            for(int j = 0; j < list2.length; j++) {
                if(list1[i].equals(list2[j])) {
                    min = Math.min(min, i + j);
                    if(min == (i + j)) {
                        answer.add(list1[i]);
                        break;
                    }
                }
            }
        }
        String [] ans = new String[answer.size()];
        int n = answer.size();
        for(int i = 0; i < n; i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}

// Optimized Approach
// Time Complexity :- O(n2)

class MinimumIndexList599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> index = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < list1.length; i++) {
            index.put(list1[i], i);
        }
        for(int i = 0; i < list2.length; i++) {
            if(index.containsKey(list2[i])) {
                int idx = index.get(list2[i]);
                int sum = i + idx;
                if(sum < min) {
                    min = sum;
                    answer.clear();
                    answer.add(list2[i]);
                    
                } else if( min == sum) {
                    answer.add(list2[i]);
                }
            }
        }
        
        return answer.toArray(new String[0]);
    }
}