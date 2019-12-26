class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        if (t.length() == 1) return s.contains(t) ? t : "";
        Map<Character, Integer> tSet = new HashMap<>();
        for (int i = 0; i < t.length() ; i++) {
            char c = t.charAt(i);
            if (s.indexOf(c) < 0) return "";
            tSet.put(c, tSet.getOrDefault(c, 0) + 1);
        }
        Map<Character, LinkedList<Integer>> occr = new HashMap<>();
        for (char c : tSet.keySet()) occr.put(c, new LinkedList<Integer>());
        String out = s;
        boolean full = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tSet.containsKey(c)) {
                LinkedList<Integer> list = occr.get(c);
                if (list.size() == tSet.get(c)) list.remove();
                list.add(i);
                if (!full) {
                    boolean tmp = true;
                    for (char ch : tSet.keySet()) tmp = tmp && tSet.get(ch) == occr.get(ch).size();
                    full = tmp;
                }
            }
            if (full) {
                int minIdx = i;
                for (LinkedList<Integer> list : occr.values()) minIdx = Math.min(minIdx, list.peek());
                if (i - minIdx + 1 < out.length()) out = s.substring(minIdx, i + 1);
            }
        }
        return full ? out : "";
    }
}
