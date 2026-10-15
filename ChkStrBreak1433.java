
// 1433. Check If a String Can Break Another String

class ChkStrBreak1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        boolean isS1Breaks = true;
        boolean isS2Breaks = true;
        for(int i = 0; i < n; i++) {
            if(s1Arr[i] < s2Arr[i]) {
                isS1Breaks = false;
            }
            if(s1Arr[i] > s2Arr[i]) {
                isS2Breaks = false;
            }
        }

        return isS1Breaks || isS2Breaks;
    }
}