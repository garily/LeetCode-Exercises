// Complexity Average: NlogN + N^2
// Complexity worst: NlogN + N^2logN
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 2) return new ArrayList<>();
        List<List<Integer>> out = new ArrayList<>();
        Map<Long, Integer> map = new HashMap<>();
        for (int e : nums) map.put(uLong(e), 1 + map.getOrDefault(uLong(e), 0));
        for (Map.Entry<Long, Integer> entryI : map.entrySet()) {
            for (Map.Entry<Long, Integer> entryJ : map.entrySet()) {
                if ((int) entryJ.getKey().longValue() < (int) entryI.getKey().longValue()) continue;
                long k = uLong(-((int) entryI.getKey().longValue() + (int) entryJ.getKey().longValue()));
                if (map.containsKey(k)) {
                    if ((int) k < (int) entryJ.getKey().longValue()) continue;
                    if (entryI.getKey() == k && entryI.getValue() > 2)
                        out.add(ijkList(entryI.getKey().longValue(), entryJ.getKey().longValue(), k));
                    else if (entryI.getKey() == entryJ.getKey() &&
                             entryJ.getKey() != k &&
                             entryI.getValue() > 1)
                        out.add(ijkList(entryI.getKey().longValue(), entryJ.getKey().longValue(), k));
                    else if (entryI.getKey() != k &&
                             entryJ.getKey() == k &&
                             entryJ.getValue() > 1)
                        out.add(ijkList(entryI.getKey().longValue(), entryJ.getKey().longValue(), k));
                    else if ((int) entryI.getKey().longValue() < (int) entryJ.getKey().longValue() &&
                             (int) entryJ.getKey().longValue() < (int) k)
                        out.add(ijkList(entryI.getKey().longValue(), entryJ.getKey().longValue(), k));
                }
            }
        }
        return out;
    }
    
    long uLong(int i) {
        long l = 0x00000000FFFFFFFFl & (long) i;
        return l;
    }
    
    ArrayList<Integer> ijkList(long i, long j, long k) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add((int) i);
        list.add((int) j);
        list.add((int) k);
        return list;
    }
}
