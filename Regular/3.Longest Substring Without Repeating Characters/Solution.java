class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int maxLength = 0;
        String subStr = "";
        
        for (int i = 0 ; i < s.length() ; i ++) {
            if   (subStr.lastIndexOf(s.charAt(i)) == -1) {
                subStr = subStr.concat(Character.toString(s.charAt(i)));
            }
            else {
                subStr = subStr.substring(subStr.lastIndexOf(s.charAt(i)) + 1).concat(Character.toString(s.charAt(i)));
            }
            
            if (subStr.length() > maxLength) {
                maxLength = subStr.length();
            }
            
        }
        return maxLength;
    }
}
