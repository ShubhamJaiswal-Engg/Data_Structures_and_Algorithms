public class SubString {
    public static void contiguousSubString(String str) {
         contiguousSubString(str, 0, "");
         return;
    }

    public static void contiguousSubString( String str, int i, String newStr) {
        if (i == str.length()) {
            str.substring(1);
            return;
        }
        // if (str.charAt(i) == str.charAt(i+1)) {
        //     count++;
        // }
        char ch = str.charAt(i);
        System.out.println(newStr+ch);
        contiguousSubString(str, i+1, newStr+ch);
        // if (i == str.length()) {
        // newStr.substring(1);
        // }
        // contiguousSubString(str, i+1, newStr+ch);
        // contiguousSubString(str, i+1, newStr);
        
    }
    public static void main( String args[]) {
        String str = "abcab";
        contiguousSubString(str);
    }
}