class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> out = new ArrayList<>();
        List<String> row = new ArrayList<>();
        int wordLen = 0;
        for (String word: words) {
            if (wordLen + row.size() /*number of single spaces*/ + word.length() > maxWidth) {
                // enough words for current row
                int nSpace = row.size() - 1;
                int availSpace = maxWidth - wordLen;
                StringBuilder sb = new StringBuilder();
                if (nSpace == 0) { // single word row
                    sb.append(row.get(0));
                    while (availSpace-- > 0) sb.append(' ');
                }
                else { // at least two words in row
                    int baseSpaceLen = (int) Math.floor(availSpace / nSpace);
                    StringBuilder baseSb = new StringBuilder();
                    while (baseSpaceLen-- > 0) baseSb.append(' ');
                    String baseSpace = baseSb.toString();
                    int extraSpaceCt = availSpace % nSpace;
                    for (int i = 0; i < row.size() - 1; i++) {
                        sb.append(row.get(i));
                        sb.append(baseSpace);
                        if (extraSpaceCt-- > 0) sb.append(' ');
                    }
                    // append last word without trailing spaces
                    sb.append(row.get(row.size() - 1));
                }
                out.add(sb.toString());
                row = new ArrayList<>();
                wordLen = 0;
            }
             // not enough words for current row
            row.add(word);
            wordLen += word.length();
        }
        // last row
        if (row.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < row.size() - 1; i++) {
                sb.append(row.get(i));
                sb.append(' ');
            }
            sb.append(row.get(row.size() - 1));
            while (sb.length() < maxWidth) sb.append(' ');
            out.add(sb.toString());
        }
        return out;
    }
}
