public class leftview {
    static int count = 0;
    public static void helper(TreeNode root, int level) {
        if(root == null) return;
        if(count < level) {
            System.out.print(root.val+" ");
            count++;
        }
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
    public static void printLeftView(TreeNode root) {
        helper(root, 1);
    }
}
