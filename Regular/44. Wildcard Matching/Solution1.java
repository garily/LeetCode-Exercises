class Solution {
    public boolean isMatch(String s, String p) {
        // System.out.println("p: " + p + ", s: " + s);
        if (p.length() == 0) return s.length() == 0;
        if (p.equals("?")) return s.length() == 1;
        if (p.equals("*")) return true;
        if (p.length() == 1) return s.equals(p);
        if (s.length() == 0) {
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '*') return false;
            }
            return true;
        }
        
        if (p.charAt(0) == '?') {
            // System.out.println(1);
            return isMatch(s.substring(1), p.substring(1));
        }
        else if (p.charAt(0) == '*') {
            // System.out.println(2);
            // trim continuous asterisks
            while (p.length() > 1 && p.charAt(1) == '*') p = p.substring(1);
            for (int i = 0; i <= s.length(); i++) {
                if (isMatch(s.substring(i), p.substring(1))) return true;
            }
            return false;
        }
        else { // p begins with an alphabet
            // System.out.println(3);
            if (p.charAt(0) == s.charAt(0)) return isMatch(s.substring(1), p.substring(1));
            else return false;
        }
    }
}
