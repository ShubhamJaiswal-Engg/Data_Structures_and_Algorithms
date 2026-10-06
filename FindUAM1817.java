
// 1817. Finding the Users Active Minutes

class FindUAM1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> track = new HashMap<>();
         
         for(int log[] : logs) {
            if(!track.containsKey(log[0])) {
                track.put(log[0], new HashSet<>());
            }
            track.get(log[0]).add(log[1]);
         }

         int ans[] = new int[k];
         for(int id : track.keySet()){
            int uam = track.get(id).size();
            // uam = uam - 1 because in question 1-Indexed array is mentioned
            ans[uam - 1]++;
         }

         return ans;
    }
}