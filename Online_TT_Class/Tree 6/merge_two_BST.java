import java.util.List;
import java.util.ArrayList;
public class merge_two_BST {
    public void inOrder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
    
    public List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> ans = new ArrayList<>();
        int i=0, j=0;
        while(i<l1.size() && j<l2.size()) {
            if(l1.get(i) < l2.get(j)) {
                ans.add(l1.get(i++));
            }
            else {
                ans.add(l2.get(j++));
            }
        }
        while(i<l1.size()) ans.add(l1.get(i++));
        while(j<l2.size()) ans.add(l2.get(j++));
        return ans;
    }
    
    public List<Integer> merge(TreeNode root1,TreeNode root2)
    {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        inOrder(root1, l1);
        inOrder(root2, l2);
        return merge(l1, l2);
    }
}
