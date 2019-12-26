class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        if (t.length() == 1) return s.contains(t) ? t : "";
        int[] arr = new int[256];
        int maxStart = 0;
        int minLength = s.length();
        for (int i = 0; i < t.length(); i++) arr[t.charAt(i)]++;
        int count = 0;
        boolean exists = false;
        for (int i = 0, start = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            arr[sc]--;
            if (arr[sc] >= 0) count++;
            while (count == t.length()) {
                exists = true;
                if (minLength > i - start + 1) {
                    minLength = i - start + 1;
                    maxStart = start;
                }
                arr[s.charAt(start)]++;
                if (arr[s.charAt(start)] > 0) count--;
                start++;
            }
        }
        return exists ? s.substring(maxStart, maxStart + minLength) : "";
    }
}
