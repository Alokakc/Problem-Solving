import java.util.ArrayList;
import java.util.List;

public class path_sum_2 {
    List<List<Integer>> ans = new ArrayList<>();
    public void helper(TreeNode root, int sum, int targetSum, List<Integer> hold){
        if(root == null) return;
        sum += root.val;
        hold.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == targetSum) ans.add(hold);
            return;
        }
        helper(root.left, sum, targetSum, new ArrayList<>(hold));
        helper(root.right, sum, targetSum, new ArrayList<>(hold));
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return ans;
        helper(root, 0, targetSum, new ArrayList<>());
        return ans;
    }
}
