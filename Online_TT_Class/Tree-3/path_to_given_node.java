public class path_to_given_node {
    ArrayList<Integer> ans;
    public void helper(TreeNode root, int b, ArrayList<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        if(root.val == b) {
            ans = new ArrayList(list);
        }
        helper(root.left, b, list);
        helper(root.right, b, list);
        list.remove(list.size()-1);
    }
    public ArrayList<Integer> solve(TreeNode root, int b) {
        helper(root, b, new ArrayList());
        return ans;
    }
}
