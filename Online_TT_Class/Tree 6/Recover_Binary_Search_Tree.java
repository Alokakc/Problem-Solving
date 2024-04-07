public class Recover_Binary_Search_Tree {
    TreeNode first, middle, last, prev;
    public void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        if(prev != null && root.val < prev.val) {
            if(first == null) {
                first = prev;
                middle = root;
            } 
            else {
                last = root;
            }
        }
        prev = root;
        inOrder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inOrder(root);
        if(last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}
