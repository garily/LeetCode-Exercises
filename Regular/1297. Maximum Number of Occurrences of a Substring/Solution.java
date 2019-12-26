class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> occurrence = new HashMap<>();
        int out = 0;
        for (int size = minSize; size <= maxSize; size++) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < size; i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (int j = 0; j + size < s.length(); j++) {
                // System.out.println(Arrays.toString(map.entrySet().toArray()));
                if (map.size() <= maxLetters) {
                    String current = s.substring(j, j + size);
                    occurrence.put(current, occurrence.getOrDefault(current, 0) + 1);
                    // System.out.println(current);
                    // System.out.println(Arrays.toString(occurrence.entrySet().toArray()));
                }
                int first = map.get(s.charAt(j));
                if (first == 1) map.remove(s.charAt(j));
                else map.put(s.charAt(j), first - 1);
                map.put(s.charAt(size + j), map.getOrDefault(s.charAt(size + j), 0) + 1);
            }
            if (map.size() <= maxLetters) {
                String current = s.substring(s.length() - size);
                occurrence.put(current, occurrence.getOrDefault(current, 0) + 1);
            }
        }
        for (int n : occurrence.values()) out = Math.max(n, out);
        return out;
    }
}
