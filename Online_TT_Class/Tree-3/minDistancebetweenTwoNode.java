
public class minDistancebetweenTwoNode {
    int res = 0;
    public void solve(TreeNode root, int target, int ans) {
        if(root == null) return;
        if(root.val == target) {
            res = ans;
            return;
        }
        solve(root.left, target, ans+1);
        solve(root.right, target, ans+1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null) return null;
        if(root.val == p || root.val == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        if(left!=null) return left;
        return right;
    }
    int findDist(TreeNode root, int a, int b) {
        TreeNode LCS = lowestCommonAncestor(root, a, b);
        solve(LCS, a, 0);
        int ans = res;
        solve(LCS, b, 0);
        ans += res;
        return ans;
    }
}
