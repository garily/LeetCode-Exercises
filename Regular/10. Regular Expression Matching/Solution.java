class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        if (p.length() == 1) return p.equals(".") ? s.length() == 1 : s.equals(p);
        String pNew = new String(p);
        for (int i = 0; i < pNew.length(); i++) {
            if (i - 2 >= 0 && i + 1 < pNew.length()) {
                if ((pNew.charAt(i - 2) == pNew.charAt(i) || pNew.charAt(i - 2) == '.' || pNew.charAt(i) == '.') &&
                    pNew.charAt(i - 1) == pNew.charAt(i + 1) &&
                    pNew.charAt(i - 1) == '*') {
                    String pNew1 = pNew.substring(0, i - 2);
                    String pNew2;
                    
                    if (pNew.charAt(i - 2) == '.' || pNew.charAt(i) == '.') {
                        pNew2 = ".*";
                    }
                    else {
                        pNew2 = pNew.substring(i - 2, i);
                    }
                    
                    String pNew3 = (i + 2 < pNew.length()) ? pNew.substring(i + 2) : "";
                    pNew = pNew1 + pNew2 + pNew3;
                    i = 0;
                }
            }
        }
        return dfsFsm(s.toCharArray(), pNew.toCharArray(), 0, 0);
    }
    
    private boolean dfsFsm(char[] s, char[] p, int sIndex, int pIndex) {
        
        boolean hasWildcard = false;
        if (pIndex + 1 < p.length && p[pIndex + 1] == '*') hasWildcard = true;
        
        if (sIndex == s.length && pIndex == p.length) {
            return true;
        }
        else if (sIndex < s.length && pIndex == p.length) {
            // if p reaches the end
            return false;
        }
        else if (sIndex == s.length) {
            // if s reaches the end, but p has not
            // if the current p[pIndex] has a following asterisk / wildcard
            return hasWildcard && dfsFsm(s, p, sIndex, pIndex + 2);
        }
        
        boolean result = false;
        
        if (hasWildcard) {
            if (p[pIndex] != '.') {
                // try zero match first
                result = dfsFsm(s, p, sIndex, pIndex + 2);
                 // zero match unsuccessful, try 1+ matches
                for (int si = sIndex; si < s.length && s[si] == p[pIndex] && !result; si++) {
                    result = dfsFsm(s, p, si + 1, pIndex + 2);
                }
            }
            else { // p[pIndex] == '.'
                // try zero match first
                result = dfsFsm(s, p, sIndex, pIndex + 2);
                // zero match unsuccessful, try 1+ matches
                for (int si = sIndex; si < s.length && !result; si++) {
                    result = dfsFsm(s, p, si + 1, pIndex);
                    if (!result) { // 1+ matches a part of s, try using the rest of p to match the rest of s
                        result = dfsFsm(s, p, si + 1, pIndex + 2);
                    }
                }
            }
            return result;
        }
        else {
            if (p[pIndex] == '.' || s[sIndex] == p[pIndex]) {
                return dfsFsm(s, p, sIndex + 1, pIndex + 1);
            }
            else { // p[pIndex] == '[a-z]' && s[sIndex] != p[pIndex]
                return false;
            }
        }
    }
}
