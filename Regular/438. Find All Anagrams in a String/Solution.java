class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> out = new ArrayList();
        int sLen = s.length();
        int pLen = p.length();
        if (pLen > sLen) return out;
        int[] pMap = new int[256];
        int[] sMap = new int[256];
        Set<Character> excess = new HashSet();
        for (int i = 0; i < pLen; i++) {
            char ch = p.charAt(i);
            pMap[ch]++;
        }
        int sSize = 0;
        for (int i = 0; i < sLen; i++) {
            char next = s.charAt(i);
            if (i >= pLen) {
                char prev = s.charAt(i - pLen);
                if (prev == next) {
                    if (sSize == pLen && excess.isEmpty()) out.add(i - pLen + 1);
                    continue;
                }
                if (pMap[prev] > 0) {
                    if (sMap[prev] > 0) sMap[prev]--; 
                    sSize--;
                    if (sMap[prev] <= pMap[prev]) excess.remove(prev);
                }
            }
            if (pMap[next] > 0) {
                sMap[next]++;
                sSize++;
                if (sMap[next] > pMap[next]) excess.add(next);
            }
            if (sSize == pLen && excess.isEmpty()) out.add(i - pLen + 1);
        }
        return out;
    }
}
