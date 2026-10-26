
// 1220. Count Vowels Permutation

class CntVowelPerm1220 {
    public int countVowelPermutation(int n) {
        final int mod = 1_000_000_007;
        long a = 1, e = 1, i = 1, o = 1, u = 1;

        for (int len = 2; len <= n; len++) {
            long newA = (e + i + u) % mod;
            long newE = (a + i) % mod;
            long newI = (e + o) % mod;
            long newO = i;
            long newU = (i + o) % mod;

            a = newA;
            e = newE;
            i = newI;
            o = newO;
            u = newU;
        }

        return (int) ((a + e + i + o + u) % mod);
    }
}