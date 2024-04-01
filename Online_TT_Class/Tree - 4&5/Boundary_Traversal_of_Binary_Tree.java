import java.util.ArrayList;
import java.util.List;

public class Boundary_Traversal_of_Binary_Tree {
    static List<Integer> ans = new ArrayList<>();
    public static void left(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right==null)  return;
        ans.add(root.val);
        if(root.left != null) left(root.left);
        else left(root.right);
    }
    public static void leaf(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            ans.add(root.val);
            return;
        }
            leaf(root.left);
            leaf(root.right);
    }
    public static void right(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        if(root.right != null) right(root.right);
        else right(root.left);
        ans.add(root.val);
    }
    public static List<Integer> traverseBoundary(TreeNode root){
        ans.add(root.val);
        left(root.left);
        leaf(root);
        right(root.right);
        return ans;
    }
}
