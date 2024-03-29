import java.util.ArrayList;
import java.util.List;

public class rightview {
    List<Integer> ans = new ArrayList<>();
    public void helper(TreeNode root, int level) {
        if(root == null) return;
        if(ans.size() < level) {
            ans.add(root.val);
        }
        helper(root.right, level+1);
        helper(root.left, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 1);
        return ans;
    }
}
