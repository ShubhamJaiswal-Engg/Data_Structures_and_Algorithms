
// 3498. Reverse Degree of a String

class ReverDegStr3498 {
    public int reverseDegree(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            int idx = ('z' - s.charAt(i) + 1);
            count += (idx * (i + 1));
        }
        return count;
    }
}