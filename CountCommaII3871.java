
// 3871. Count Commas in Range II

class CountCommaII3871 {
    public long countCommas(long n) {
        long start = 1000;
        long comma = 0;
        while(start <= n) {
            comma += (n - start + 1);
            start *= 1000;
        }
        return comma;
    }
}