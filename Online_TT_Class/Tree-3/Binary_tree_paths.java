import java.util.ArrayList;
import java.util.List;

public class Binary_tree_paths {
    public void helper(TreeNode root, String path, List<String> ans){
        if(root.left==null && root.right==null) ans.add(path + root.val);
        if(root.left!=null) helper(root.left, path+root.val+"->", ans);
        if(root.right!=null) helper(root.right, path+root.val+"->", ans);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root!=null) helper(root, "", ans);
        return ans;
    }
}
