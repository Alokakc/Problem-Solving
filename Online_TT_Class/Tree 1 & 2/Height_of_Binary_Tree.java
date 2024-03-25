public class Height_of_Binary_Tree {
    public static int heightOfBinaryTree(TreeNode root) {
        // Write your code here.
        if(root == null) return 0;
        int left = heightOfBinaryTree(root.left);
        int right = heightOfBinaryTree(root.right);
        return Math.max(left, right)+1;
    }
}
