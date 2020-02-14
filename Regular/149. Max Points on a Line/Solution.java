class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 3) return points.length;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Map<Integer, Integer>> slopes = new HashMap();
            int x0 = points[i][0];
            int y0 = points[i][1];
            int slopeMax = 0;
            int same = 1;
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - x0;
                int dy = points[j][1] - y0;
                if (dx == 0 && dy == 0) {
                    same++;
                    continue;
                }
                int divisor = gcd(dx, dy);
                if (divisor != 0) {
                    dx /= divisor;
                    dy /= divisor;
                }
                Map<Integer, Integer> dxMap = slopes.getOrDefault(dx, new HashMap());
                dxMap.put(dy, dxMap.getOrDefault(dy, 0) + 1);
                slopes.put(dx, dxMap);
                slopeMax = Math.max(dxMap.get(dy), slopeMax);
            }
            max = Math.max(max, same + slopeMax);
        }
        return max;
    }
    

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
