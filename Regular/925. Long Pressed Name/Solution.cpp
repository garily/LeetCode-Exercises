class Solution {
public:
    bool isLongPressedName(string name, string typed) {
        if (name == typed) return true;
        char cLast = 0;
        for (char c : name) {
            if (typed.length() == 0) return false;
            if (typed.at(0) == c) {
                typed.erase(0, 1);
                cLast = c;
            }
            else if (typed.at(0) == cLast) {
                while (typed.length() > 0 && typed.at(0) == cLast) typed.erase(0, 1);
                if (typed.length() > 0 && typed.at(0) == c) {
                    typed.erase(0, 1);
                    cLast = c;
                }
                else return false;
            }
            else return false;
        }
        return true;
    }
};
