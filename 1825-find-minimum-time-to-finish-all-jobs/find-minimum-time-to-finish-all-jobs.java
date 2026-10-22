class Solution {
    int ans;

    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (jobs[i] < jobs[j]) {
                    int temp = jobs[i];
                    jobs[i] = jobs[j];
                    jobs[j] = temp;
                }
            }
        }

        int[] workers = new int[k];
        ans = Integer.MAX_VALUE;

        backtrack(jobs, workers, 0, k);

        return ans;
    }

    private void backtrack(int[] jobs, int[] workers,
                           int index, int k) {
        if (index == jobs.length) {
            int max = 0;
            for (int time : workers) {
                max = Math.max(max, time);
            }

            ans = Math.min(ans, max);
            return;
        }

        if (maxTime(workers) >= ans) {
            return;
        }

        for (int i = 0; i < k; i++) {
            workers[i] += jobs[index];

            backtrack(jobs, workers, index + 1, k);

            workers[i] -= jobs[index];

            if (workers[i] == 0) {
                break;
            }
        }
    }

    private int maxTime(int[] workers) {
        int max = 0;

        for (int time : workers) {
            max = Math.max(max, time);
        }

        return max;
    }
}
