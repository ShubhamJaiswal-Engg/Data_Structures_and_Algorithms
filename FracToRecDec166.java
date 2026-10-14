
// 166. Fraction to Recurring Decimal

class FracToRecDec166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0 ) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if((numerator < 0) ^ (denominator < 0)) sb.append("-");

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        sb.append(num / den);
        long rem = num % den;
        if(rem == 0) return sb.toString();

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(rem != 0) {
            if(map.containsKey(rem)) {
                sb.insert(map.get(rem), "(");
                sb.append(")");
                break;
            }
            map.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / den);
            rem = rem % den;
        } 
    return sb.toString();
    }
}