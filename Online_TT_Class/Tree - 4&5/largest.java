class Nodeinfo {
    boolean isBST;
    int minElement;
    int maxElement;
    int size;
    public Nodeinfo(){}
    public Nodeinfo(boolean isBST, int minElement, int maxElement, int size) {
        this.isBST = isBST;
        this.minElement = minElement;
        this.maxElement = maxElement;
        this.size = size;
    }
}

class largest{
    static Nodeinfo solve(TreeNode root) {
        if(root == null) {
            return new Nodeinfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Nodeinfo left = solve(root.left);
        Nodeinfo right = solve(root.right);
        Nodeinfo newRoot = new Nodeinfo();
        newRoot.isBST = left.isBST&&right.isBST&&root.val>left.maxElement&&root.val<right.minElement;
        newRoot.minElement = Math.min(left.minElement, root.val);
        newRoot.maxElement = Math.max(right.maxElement, root.val);
        newRoot.size = newRoot.isBST?left.size+right.size+1:Math.max(left.size, right.size);
        return newRoot;
    }
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(TreeNode root)
    {
        // Write your code here
        return solve(root).size;
    }
    
}