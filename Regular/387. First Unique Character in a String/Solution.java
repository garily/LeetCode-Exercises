class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (count[ch - 'a'] == 0) list.add(ch);
            count[ch - 'a']++;
        }
        
        for (char ch : list) {
            if (count[ch - 'a'] == 1) return s.indexOf(ch);
        }
        return -1;
    }
}
