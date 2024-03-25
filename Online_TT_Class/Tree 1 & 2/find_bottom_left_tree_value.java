public class find_bottom_left_tree_value {
    
    int maxlvl;
    int val;
    public int findBottomLeftValue(TreeNode root) {
        maxlvl = 0;
        val = root.val;
        goDFS(root, 0);
        return val;
    }

    private void goDFS(TreeNode node, int lvl) {
        if (node == null) return;

        if (maxlvl <= lvl) {
            maxlvl = lvl;
            val = node.val;
        }
        lvl++;
        goDFS(node.right, lvl);
        goDFS(node.left, lvl);
    }

}
