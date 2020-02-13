[217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)

* `Solution1.java` uses `Arrays.sort()` to sort the given array, then compares if neighboring elements in the sorted array are the same
* `Soltuion2.java` builds a HashSet with all the elements in the given array, then checks if the size of the obtained HashSet is the same as the length of the array
