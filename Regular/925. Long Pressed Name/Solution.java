import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        String p = "";
        int count = 1;
        int i;
        for (i = 1; i < name.length(); i++) {
            if (name.charAt(i - 1) == name.charAt(i)) count ++;
            else {
                p += name.charAt(i - 1) + "{" + count + ",}";
                count = 1;
            }
        }
        p += name.charAt(i - 1) + "{" + count + ",}";
        return Pattern.compile(p).matcher(typed).matches();
    }
}
