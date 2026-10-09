
// 911. Online Election

class TopVotedCandidate {
    int[] lead;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int n = persons.length;
        lead = new int[n + 1];

        // Count votes per person
        int countVote[] = new int[n + 1];
        int leader = persons[0];

        for (int i = 0; i < n; i++) {
            int p = persons[i];
            countVote[p]++;                      

            // if vote tie
            if (countVote[p] >= countVote[leader]) {
                // recent leader
                leader = p;
            }
            lead[i] = leader;
        }
    }
    
    public int q(int t) {
        int low = 0, high = times.length - 1;

        while(low < high) {
        int mid = low + (high - low + 1) / 2;// upper bounds // (low + high) / 2 (normal) 
            if(times[mid] <= t) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return lead[low];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */