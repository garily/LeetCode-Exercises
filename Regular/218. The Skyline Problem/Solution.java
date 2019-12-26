class Solution {
    // credit given to https://leetcode.com/problems/the-skyline-problem/discuss/423869/Java-or-Simple-or-Heap
    private class Point {
        int x, y;
        boolean isStart;
        public Point(int x, int y, boolean isStart) {
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int L = 0, R = 1, H = 2;
        List<List<Integer>> out = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) return out;
        List<Point> points = new ArrayList<>();
        for (int[] building : buildings) {
            points.add(new Point(building[L], building[H], true));
            points.add(new Point(building[R], building[H], false));
        }
        
        Collections.sort(points, (a, b) -> {
            if (a.x != b.x) {
                return a.x - b.x;
            }
            else {
                if (a.isStart && !b.isStart) {
                    return -1;
                }
                else if (!a.isStart && b.isStart) {
                    return 1;
                }
                else if (a.isStart && b.isStart) {
                    return b.y - a.y;
                }
                else return a.y - b.y;
            }
        });
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a); // max on top
        heap.add(0);
        for (Point p : points) {
            if (p.isStart) {
                if (p.y > heap.peek()) {
                    out.add(Arrays.asList(p.x, p.y));
                }
                heap.add(p.y);
            }
            else {
                int peak = heap.peek();
                heap.remove(p.y);
                if (peak > heap.peek()) {
                    out.add(Arrays.asList(p.x, heap.peek()));
                }
            }
        }
        return out;
    }
}
