
public class Binary_Tree_to_CDLL {
    boolean flag = false;
    TreeNode head = null, prev = null;
    void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        if(!flag) {
            head = root;
            flag = true;
        }
        if(prev != null) prev.right = root;
        root.left = prev;
        prev = root;
        inOrder(root.right);
    }
    //Function to convert binary tree into circular doubly linked list.
    TreeNode bTreeToClist(TreeNode root)
    {
        inOrder(root);
        head.left = prev;
        prev.right = head;
        return head;
    }
}
