
// 3870. Count Commas in Range

class CountCommaInRange3870 {
    public int countCommas(int n) {
        return n < 1000 ? 0 : n - 999;
   }
}
class CountCommaInRange3870 {
    public int countCommas(int n) {
        return Math.max(n - 999, 0);
   }
}
