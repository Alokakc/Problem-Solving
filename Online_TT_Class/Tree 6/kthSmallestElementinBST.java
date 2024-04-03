public class kthSmallestElementinBST {
    int count=0, ans=0;
    boolean flag = false;
    public void helper(TreeNode root, int k){
        if(root==null) return;
        helper(root.left, k);
        if(flag==true) return;
        count++;
        if(count==k){
            ans = root.val;
            flag=true;
            return;
        }
        helper(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return ans;
    }
}
