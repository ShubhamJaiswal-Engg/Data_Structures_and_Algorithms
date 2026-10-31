
// 6. Zigzag Conversion

class ZigZagConversion6 {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()) return s;

        StringBuilder sb = new StringBuilder();

        // multiplying by 2 because of Up and Down
        int cycle = 2 * (numRows - 1);

        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < s.length(); j += cycle) {
                sb.append(s.charAt(j));

                // diagonal string
                int diag = (j - i) + (cycle - i);
                if(i != 0 && i != numRows - 1 && diag < s.length())
                sb.append(s.charAt(diag));
            }
        }
        return sb.toString();
    }
}