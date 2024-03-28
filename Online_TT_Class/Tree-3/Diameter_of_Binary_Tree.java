public class Diameter_of_Binary_Tree {
    int ans = 0;
    public int findHeight(TreeNode root) {
        if(root==null) return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        ans = Math.max(ans, left+right);
        return Math.max(left, right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        findHeight(root);
        return ans;
    }
}
