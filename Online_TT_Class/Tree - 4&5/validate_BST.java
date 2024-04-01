
public class validate_BST {
    public boolean solve(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        boolean left = solve(root.left, min, root.val);
        boolean right = solve(root.right, root.val, max);
        return left && right;
    }
    public boolean isValidBST(TreeNode root) {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}