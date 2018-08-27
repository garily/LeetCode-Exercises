import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
class Solution {
    public String longestPalindrome(String s) {
        int[] palingdromeLength = new int[s.length()];
        int[] allSameLength = new int[s.length()];
        int maxLength = 0;
        int indexOfMaxLength = 0;

        //odd base case
        for (int i = 0; i < s.length(); i ++) {
            palingdromeLength[i] = 1;
            allSameLength[i] = 1;
            if (maxLength < 1) {
                maxLength = 1;
                indexOfMaxLength = i;
            }
        }

        //even base case
        for (int i = 0; i < s.length() - 1; i ++) {
            if ( s.charAt(i) == s.charAt(i + 1)) {
                palingdromeLength[i] = 2;
                allSameLength[i] = 2;
                if (maxLength < 2) {
                    maxLength = 2;
                    indexOfMaxLength = i;
                }
            }
        }

        int maxLengthOld = maxLength;
        
        int count = 0;
        int cycle = 0;
        //loop
        while(maxLength < s.length()) {
            for (int index = 0; index < s.length(); index ++) {
                if (allSameLength[index] == maxLengthOld
                        && index + palingdromeLength[index] < s.length()
                        && s.charAt(index) == s.charAt(index + palingdromeLength[index])) {
                    palingdromeLength[index] += 1;
                    allSameLength[index] += 1;
                    if (maxLength < palingdromeLength[index]) {
                        maxLength = palingdromeLength[index];
                        indexOfMaxLength = index;
                    }
                }
                if (index == 0 || index + palingdromeLength[index] == s.length())
                    continue;
                
            //System.out.println("allSameLength[4] = " + allSameLength[4]);
                if (s.charAt(index - 1) == s.charAt(index + palingdromeLength[index])) {
                    palingdromeLength[index - 1] = palingdromeLength[index] + 2;
                    if (s.charAt(index - 1) == s.charAt(index) && allSameLength[index] >= maxLengthOld) allSameLength[index - 1] += 2;
                    //System.out.println(s.substring(index, index + palingdromeLength[index]));
                    if (maxLength < palingdromeLength[index - 1]) {
                        maxLength = palingdromeLength[index - 1];
                        indexOfMaxLength = index - 1;
                    }
                }
                //if (s.substring(index, index + ) == "ooo") System.out.println("index of ooo = " + index);
            }
            //System.out.println("maxLengthOld = " + maxLengthOld);
            //System.out.println("maxLength = " + maxLength);
            //count++;
            if (maxLengthOld == maxLength) {
                count ++;
                if (count == 2) break;
            }
            else {
                maxLengthOld = maxLength;
                count = 0;
            }
        }

        return s.substring(indexOfMaxLength, indexOfMaxLength + maxLength);
    }
}
