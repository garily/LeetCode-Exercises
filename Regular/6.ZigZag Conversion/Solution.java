class Solution {
    public String convert(String s, int numRows) {
        int offset = 0;
        int setSize = 2 * numRows - 2;
        String[] rows = new String[numRows];
        
        Arrays.fill(rows, "");
        
        for (int i = 0; setSize > 0 && i < s.length() / setSize + 1; i ++) {
            for (offset = 0; offset < setSize && i * setSize + offset < s.length(); offset ++) {
                if (offset < numRows) rows[offset] += s.charAt(i * setSize + offset);
                else rows[setSize - offset] += s.charAt(i * setSize + offset);
            }
        }
        
        
        return setSize > 0 ? String.join("",rows) : s;
    }
}
