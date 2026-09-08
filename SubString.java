// Contiguous subString

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
        
        char ch = str.charAt(i);
        System.out.println(newStr+ch);
        contiguousSubString(str, i+1, newStr+ch);
       
    }
    public static void main( String args[]) {
        String str = "abcab";
        contiguousSubString(str);
    }
}
