import java.util.HashSet;
import java.util.Set;

public class Two_Sum_IV_Input_is_a_BST {
    boolean helper(Set<Integer> s,TreeNode root,int k) {
        if(root==null) return false;
        if(s.contains(k-root.val)) return true;
        s.add(root.val);
        return helper(s,root.left,k) || helper(s,root.right,k);
    }
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> s = new HashSet<>();
        return helper(s, root, k);
    }
}
