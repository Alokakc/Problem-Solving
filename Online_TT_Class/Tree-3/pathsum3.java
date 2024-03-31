import java.util.LinkedList;
import java.util.Queue;

public class pathsum3 {
    int res = 0;
    public void solve(TreeNode root, long count, long targetSum) {
        if(root == null) return;
        count += root.val;
        if(count==targetSum) {
            res++;
        }
        solve(root.left, count, targetSum);
        solve(root.right, count, targetSum);
        count -= root.val;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.remove();
            solve(temp, 0, targetSum);
            ans += res;
            res = 0;
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
        }
        return ans;
    }
}
