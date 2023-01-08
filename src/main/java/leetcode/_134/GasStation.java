package leetcode._134;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        var totalAmount = 0;
        var currentValidAmount = 0;
        var startStation = 0;


        for (int i = 0; i < gas.length; ++i) {
            totalAmount += gas[i] - cost[i];
            currentValidAmount += gas[i] - cost[i];

            if (currentValidAmount < 0) {
                startStation = i + 1;
                currentValidAmount = 0; // reset when current step is invalid
            }
        }

        return totalAmount >= 0 ? startStation : -1;
    }
}
