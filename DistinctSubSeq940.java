// 940. Distinct Subsequences II

class DistinctSubseq940 {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;
        long dp = 1;              // includes the empty subsequence
        long[] last = new long[26]; // dp value right before ch's previous occurrence

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            long newDp = (2 * dp % MOD - last[idx] + MOD) % MOD;
            last[idx] = dp;  
            dp = newDp;
            
        }

        return (int) ((dp - 1 + MOD) % MOD); // subtract the empty subsequence means ( " " )
    }
}