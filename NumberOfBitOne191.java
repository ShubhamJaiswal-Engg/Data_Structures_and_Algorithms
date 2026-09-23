
// 191. Number of 1 Bits

// First Approach
class NumberOfBitOne191 {
    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0) {
            int rem = n % 2;
            if(rem == 1) {
                count++;
            }
            n = n / 2;
        }
        return count;
    }
}

public class NumberOfBitOne191.java {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1; // unsigned shift, treats n as unsigned 32-bit
        }
        return count;
    }
}