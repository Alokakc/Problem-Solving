public class Construct_BST_from_Preorder {
    int i=0;
    public TreeNode build(int[] pre, int ubound) {
        if(i==pre.length || pre[i] > ubound) return null;
        TreeNode root = new TreeNode(pre[i++]);
        root.left = build(pre, root.val);
        root.right = build(pre, ubound);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }
}
