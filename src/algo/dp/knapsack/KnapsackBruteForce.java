package algo.dp.knapsack;

import java.util.ArrayList;
import java.util.List;

public class KnapsackBruteForce {
    private int[] values;
    private int[] weights;
    private int W;
    private List<Integer> maxBag;
    private int maxV;

    public KnapsackBruteForce(int[] values, int[] weights, int W) {
        this.values = values;
        this.weights = weights;
        this.W = W;
    }

    public List<Integer> backtrack() {
        maxBag = null;
        maxV = 0;

        backtrack(0, 0, 0, new ArrayList<>());
        return maxBag;
    }

    private int backtrack(int pos, int totalV, int totalW, List<Integer> bag) {
        if (pos >= values.length) {
            if (totalV > maxV) {
                maxBag = new ArrayList<>(bag);
                maxV = totalV;
            }
            return totalV;
        }

        int v = 0;
        if (totalW + weights[pos] <= W) {
            bag.add(pos);
            v = backtrack(pos + 1, totalV + values[pos], totalW + weights[pos], bag);
            bag.remove(bag.size() - 1);
        }

        int v1 = backtrack(pos + 1, totalV, totalW, bag);
        return Math.max(v, v1);
    }

    void print(List<Integer> res, long time) {
        int sum = 0;
        for (int i: res) {
            sum += values[i];
        }
        System.out.println("Max value: " + sum + ". " + res);
        System.out.println("Time: " + time + " nano seconds");
    }

    public static void main(String[] args) {
        int[] values = {1, 8, 18, 22, 28};
        int[] weights = {1, 3, 5, 6, 7};
        KnapsackBruteForce knapsack = new KnapsackBruteForce(values, weights, 11);
        System.out.println("Backtrack...");
        long startTime = System.nanoTime();
        List<Integer> res = knapsack.backtrack();
        long endTime = System.nanoTime();
        knapsack.print(res, endTime - startTime);
    }
}
