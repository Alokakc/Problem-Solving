public class Maximum_Sum_BST_in_Binary_Tree {
    class nodeinfo {
        boolean isBST;
        int min;
        int max;
        int sum;
        public nodeinfo(){}
        public nodeinfo(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    class Solution {
        int ans = Integer.MIN_VALUE;
        public nodeinfo solve(TreeNode root) {
            if(root == null) return new nodeinfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            nodeinfo left = solve(root.left);
            nodeinfo right = solve(root.right);
            nodeinfo nroot = new nodeinfo();
            nroot.isBST = left.isBST && right.isBST && root.val>left.max && root.val<right.min;
            nroot.min = Math.min(root.val, left.min);
            nroot.max = Math.max(root.val, right.max);
            nroot.sum = nroot.isBST ? left.sum+right.sum+root.val : Math.max(left.sum,right.sum);
            ans = Math.max(ans, nroot.sum);
            return nroot;
        }
        public int maxSumBST(TreeNode root) {
            solve(root);
            return ans<0?0:ans;
        }
    }
}
