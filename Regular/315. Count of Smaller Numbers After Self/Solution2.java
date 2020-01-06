class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        list.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            list.add(insertBST(root, nums[i]));
        }
        Collections.reverse(list);
        return list;
    }
    
    private int insertBST(TreeNode root, int num) {
        int total = 0;
        while (true) {
            if (num <= root.val) {
                root.count++;
                if (root.left != null) {
                    root = root.left;
                }
                else {
                    root.left = new TreeNode(num);
                    break;
                }
            }
            else {
                total += root.count;
                if (root.right != null) {
                    root = root.right;
                }
                else {
                    root.right = new TreeNode(num);
                    break;
                }
            }
        }
        return total;
    }
    
    private class TreeNode {
        TreeNode left, right;
        int val, count = 1;
        public TreeNode(int val) { this.val = val; }
    }
}
