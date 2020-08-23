class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> out = new ArrayList<>();
        int len = rounds.length;
        if (rounds[0] <= rounds[len - 1]) {
            for (int i = rounds[0]; i <= rounds[len - 1]; i++) out.add(i);
        }
        else {
            for (int i = 1; i <= rounds[len - 1]; i++) out.add(i);
            for (int i = rounds[0]; i <= n; i++) out.add(i);
        }
        return out;
    }
}
