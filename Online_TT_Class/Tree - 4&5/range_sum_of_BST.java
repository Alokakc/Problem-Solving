public class range_sum_of_BST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);
        return root.val<=high&&root.val>=low?root.val+left+right:left+right;
    }
}
