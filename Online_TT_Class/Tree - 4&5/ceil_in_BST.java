public class ceil_in_BST {
    int ans = Integer.MAX_VALUE;
    void solve(TreeNode root, int key) {
        if(root == null) return;
        if(root.val>=key && root.val < ans) {
            ans = root.val;
        }
        solve(root.left, key);
        solve(root.right, key);
    }
    // Function to return the ceil of given number in BST.
    int findCeil(TreeNode root, int key) {
        if (root == null) return -1;
        solve(root, key);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
