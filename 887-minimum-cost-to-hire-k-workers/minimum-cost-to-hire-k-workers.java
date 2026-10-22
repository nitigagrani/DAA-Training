
import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] workers = new Integer[n];

        for (int i = 0; i < n; i++) {
            workers[i] = i;
        }

        Arrays.sort(workers, (a, b) ->
            Double.compare(
                (double) wage[a] / quality[a],
                (double) wage[b] / quality[b]
            )
        );

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        int totalQuality = 0;
        double minCost = Double.MAX_VALUE;

        for (int i : workers) {
            maxHeap.offer(quality[i]);
            totalQuality += quality[i];

            if (maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                double ratio = (double) wage[i] / quality[i];
                double cost = totalQuality * ratio;
                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }
}
