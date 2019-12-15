class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() != B.length() || A.length() < 2 || B.length() < 2) return false;
        int i, j;
        Set alphabet = new HashSet<Character>();
        for (i = 0; i < A.length() && A.charAt(i) == B.charAt(i); i++) {
            alphabet.add(A.charAt(i));
        }
        if (i == A.length()) return alphabet.size() < A.length(); // i.e., A.equals(B), check if A contains duplicate characters (swappable to form B)
        for (j = i + 1; j < A.length() && A.charAt(j) == B.charAt(j); j++);
        String tmp = A.substring(0, i) + A.charAt(j) + A.substring(i + 1, j) + A.charAt(i) + A.substring(j + 1);
        return B.equals(tmp);
    }
}
