public class LengthOfString {
    public static int lengthOfString(String str) {
        return lengthOfString(str, 0);
    }

    // Time Complexity = O(n)
    // Space complexity = O(n)  
    public static int lengthOfString(String str, int i) {
        if (i == str.length()) {
            return i + 1;
        };
        int length = lengthOfString(str, i + 1);
        return length;
    };
    public static void main(String args[]) { 
        String str = "Shubham1234556";
        System.out.print(lengthOfString(str));
    };
};