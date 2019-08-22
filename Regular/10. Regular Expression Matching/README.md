[10. Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/)

- `Solution.java`: near-brute-force recursion solution, dfs-style finite-state-machine, resource-consuming (time complexity O(pLen<sup>sLen</sup>, space complexity O(pLen + sLen))
- `Solution2.java`: self-recursion, modified based on official LeetCode Solution (time complexity O(2<sup>sLen + pLen / 2</sup>), space complexity: O(2<sup>sLen + pLen / 2</sup>)
- `Solution3.java`: recursion with dynamic programming, modified based on official LeetCode solution (time complexity O(T * P), space complexity O(T * P))
