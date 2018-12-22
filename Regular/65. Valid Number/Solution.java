class Solution {
    public boolean isNumber(String s) {
        while (s.length() > 0 && s.charAt(0) == ' ') s = s.substring(1);
        while (s.length() > 0 && s.charAt(s.length() - 1) == ' ') s = s.substring(0, s.length() - 1);
        if (s.length() > 0 && (s.charAt(0) == '-' || s.charAt(0) == '+')) s = s.substring(1);
        if (s.length() == 0) return false;
        int eIndex = s.indexOf('e');
        if (eIndex == 0 || eIndex == s.length() - 1) return false;
        if (eIndex > 0) {
            if (eIndex < s.length() - 1 && (s.charAt(eIndex + 1) == '+' || s.charAt(eIndex + 1) == '-'))
                return pureNumber(s.substring(0, eIndex), true) && pureNumber(s.substring(eIndex + 2), false);
            return pureNumber(s.substring(0, eIndex), true) && pureNumber(s.substring(eIndex + 1), false);
        }
        return pureNumber(s, true);
    }
    
    private boolean pureNumber(String s, boolean allowFractional) {
        if (s.length() == 0) return false;
        if (allowFractional) {
            if (s.equals(".")) return false;
            int dotIndex = s.indexOf('.');
            if (dotIndex < 0) return pureNumber(s, false);
            return pureNumber(s.substring(0, dotIndex) + s.substring(dotIndex + 1), false);
        }
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') return false;
        }
        return true;
    }
}
