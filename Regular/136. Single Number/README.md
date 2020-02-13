[136. Single Number](https://leetcode.com/problems/single-number/)

* Solution1.java uses HashSet, and every element is subject to at most one insertion into the set and one removal from the set. The single number will remain in the set after traversal through the given array.
* Solution2.java uses XOR, the underlying principle being `0 ^ A == A` and `A ^ B ^ B == A`
