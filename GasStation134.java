
// 134. Gas Station

class GasStation134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;   // net gas over the whole circuit
        int tank = 0;    // net gas since the current candidate start
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            if (tank < 0) {
                start = i + 1;  // can't reach throgh i so try with i + 1
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;
    }
}