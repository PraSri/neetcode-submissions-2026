class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int n = gas.length;
        for(int i = 0;i<n;i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost) {
            return -1;
        }
        int startIndex = 0;
        int currFuel = 0;
        for(int i = 0;i<n;i++) {
            currFuel += gas[i] - cost[i];
            if(currFuel < 0) {
                // reset
                startIndex = i+1;
                currFuel = 0;
            }
        }
        return startIndex;
    }
}
