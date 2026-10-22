
import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); 
            events.add(new int[]{b[1], b[2]});  
        }

        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<Integer> heap =
            new PriorityQueue<>(Collections.reverseOrder());
        heap.offer(0);

        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        List<List<Integer>> result = new ArrayList<>();
        int prevHeight = 0;

        for (int[] event : events) {
            int x = event[0];
            int h = event[1];

            if (h < 0) {
                int height = -h;
                heap.offer(height);
                count.put(height, count.getOrDefault(height, 0) + 1);
            } else {
                count.put(h, count.get(h) - 1);
            }

            while (!heap.isEmpty()
                    && count.getOrDefault(heap.peek(), 0) == 0) {
                heap.poll();
            }

            int currHeight = heap.peek();

            if (currHeight != prevHeight) {
                result.add(Arrays.asList(x, currHeight));
                prevHeight = currHeight;
            }
        }

        return result;
    }
}
