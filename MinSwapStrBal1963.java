
// 1963. Minimum Number of Swaps to Make the String Balanced

class MinSwapStrBal1963 {
    public int minSwaps(String s) {

        int size = 0;
        for(char ch : s.toCharArray()) {
            if(ch =='[') {
                size++;
            } else if (size > 0) {
                // if single pair bracket
                
                size--;
            }
        }
        return (size + 1) / 2; // by 2 means opening and closing length brackets is n / 2
    }
}