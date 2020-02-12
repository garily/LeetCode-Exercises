class Solution {
    public int maxJumps(int[] arr, int d) {
        if (d < 1 || arr == null || arr.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> arr[a] - arr[b]);
        for (int i = 0; i < arr.length; i++) pq.offer(i);
        int max = 1;
        int[] maxFrom = new int[arr.length];
        while (!pq.isEmpty()) {
            int n = pq.poll();
            maxJumpsFrom(arr, d, n, maxFrom);
            if (maxFrom[n] > max) max = maxFrom[n];
        }
        return max;
    }
    
    private void maxJumpsFrom(int[] arr, int d, int index, int[] maxFrom) {
        int min = Math.max(0, index - d);
        int max = Math.min(arr.length - 1, index + d);
        // System.out.println(min + ", " + max + ", index: " + index);
        maxFrom[index] = 1;
        for (int i = index - 1; i >= min && arr[i] < arr[index]; i--) {
            maxFrom[index] = Math.max(maxFrom[index], maxFrom[i] + 1);
        }
        for (int i = index + 1; i <= max && arr[i] < arr[index]; i++) {
            maxFrom[index] = Math.max(maxFrom[index], maxFrom[i] + 1);
        }
        // System.out.println(maxFrom[index]);
    }
}
