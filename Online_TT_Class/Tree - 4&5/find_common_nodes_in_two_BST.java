import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class find_common_nodes_in_two_BST {
    public static void inOrder(TreeNode root, Set<Integer> set) {
        if(root == null) return;
        inOrder(root.left, set);
        set.add(root.val);
        inOrder(root.right, set);
    }
    
    public static void solve(TreeNode root, ArrayList<Integer> ans, Set<Integer> set) {
        if(root == null) return;
        solve(root.left, ans, set);
        if(set.contains(root.val)) ans.add(root.val);
        solve(root.right, ans, set);
    }
    //Function to find the nodes that are common in both BST.
	public static ArrayList<Integer> findCommon(TreeNode root1,TreeNode root2)
    {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root1, set);
        solve(root2, ans, set);
        return ans;
    }
}
