package algo.dp.knapsack;

import java.util.Arrays;

public class KnapsackTopDownDp {
    public int knapsack(int[] values, int[] weights, int W) {
        int[][] memo = new int[values.length + 1][W + 1];
        for (int[] m: memo) {
            Arrays.fill(m, -1);
        }

        return topDownDp(values, weights, W, 0, 0, 0, memo);
    }

    private int topDownDp(int[] values, int[] weights, int W, int i, int currW, int currVal, int[][] memo) {
        if (i == values.length || currW == W) {
            return currVal;
        } else if (memo[i][currW] != -1) {
            return memo[i][currW];
        }

        int pick = 0;
        if (currW + weights[i] <= W) {
            pick = topDownDp(values, weights, W, i + 1, currW + weights[i], currVal + values[i], memo);
        }

        int notPick = topDownDp(values, weights, W,i + 1, currW, currVal, memo);

        memo[i][currW] = Math.max(pick, notPick);
        return memo[i][currW];
    }

    public static void main(String[] args) {
        int[] values = {1, 8, 18, 22, 28};
        int[] weights = {1, 3, 5, 6, 7};

        KnapsackTopDownDp knapsack = new KnapsackTopDownDp();
        long startTime = System.nanoTime();
        int v = knapsack.knapsack(values, weights, 11);
        long endTime = System.nanoTime();
        System.out.println("Max value: " + v + ". Time: " + (endTime - startTime));
    }
}
