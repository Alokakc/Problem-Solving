public class LCS_of_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val) return root;
        if(root.val>p.val && root.val<q.val) return root;
        if(root.val<p.val && root.val>q.val) return root;
        if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right, p, q);
        if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left, p, q);
        return null;
    }
}