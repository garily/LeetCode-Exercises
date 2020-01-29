class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new ArrayList<>();
        if (numRows < 1) return out;
        out.add(Arrays.asList(1));
        if (numRows < 2) return out;
        out.add(Arrays.asList(1, 1));
        if (numRows < 3) return out;
        List<Integer> prev = out.get(1);
        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                row.add(prev.get(j) + prev.get(j + 1));
            }
            row.add(1);
            out.add(row);
            prev = row;
        }
        return out;
    }
}
