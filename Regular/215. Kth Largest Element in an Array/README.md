[215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)

* `Solution1.java` uses quick select, but unnecessarily goes out of the way to use lists for storing values separated by pivots
* `Solution2.java` uses a priority queue for sorting the array
* `Solution3.java` uses Java's built-in `Arrays.sort()` to sort the array
